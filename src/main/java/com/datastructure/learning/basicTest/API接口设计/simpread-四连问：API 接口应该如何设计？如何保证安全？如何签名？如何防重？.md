> 本文由 [简悦 SimpRead](http://ksria.com/simpread/) 转码， 原文地址 https://mp.weixin.qq.com/s/jFaBFgpceE-mJzubjEH8sg

![][img-0]

来源：cnblogs.com/jurendage/p/12653865.html

在实际的业务中，难免会跟第三方系统进行数据的交互与传递，那么如何保证数据在传输过程中的安全呢（防窃取）？除了 https 的协议之外，能不能加上通用的一套算法以及规范来保证传输的安全性呢？  

下面我们就来讨论下常用的一些 API 设计的安全方法，可能不一定是最好的，有更牛逼的实现方式，但是这篇是我自己的经验分享.

**一、token 简介**

Token：访问令牌 access token, 用于接口中, 用于标识接口调用者的身份、凭证，减少用户名和密码的传输次数。一般情况下客户端 (接口调用方) 需要先向服务器端申请一个接口调用的账号，服务器会给出一个 appId 和一个 key, key 用于参数签名使用，注意 key 保存到客户端，需要做一些安全处理，防止泄露。

Token 的值一般是 UUID，服务端生成 Token 后需要将 token 做为 key，将一些和 token 关联的信息作为 value 保存到缓存服务器中 (redis)，当一个请求过来后，服务器就去缓存服务器中查询这个 Token 是否存在，存在则调用接口，不存在返回接口错误，一般通过拦截器或者过滤器来实现，Token 分为两种：

*   API Token(接口令牌): 用于访问不需要用户登录的接口，如登录、注册、一些基本数据的获取等。获取接口令牌需要拿 appId、timestamp 和 sign 来换，sign = 加密 (timestamp+key)
    
*   USER Token(用户令牌): 用于访问需要用户登录之后的接口，如：获取我的基本信息、保存、修改、删除等操作。获取用户令牌需要拿用户名和密码来换
    

关于 Token 的时效性：token 可以是一次性的、也可以在一段时间范围内是有效的，具体使用哪种看业务需要。

一般情况下接口最好使用 https 协议，如果使用 http 协议，Token 机制只是一种减少被黑的可能性，其实只能防君子不能防小人。

一般 token、timestamp 和 sign 三个参数会在接口中会同时作为参数传递，每个参数都有各自的用途。

**二、timestamp 简介**

timestamp: 时间戳，是客户端调用接口时对应的当前时间戳，时间戳用于防止 DoS 攻击。

当黑客劫持了请求的 url 去 DoS 攻击，每次调用接口时接口都会判断服务器当前系统时间和接口中传的的 timestamp 的差值，如果这个差值超过某个设置的时间 (假如 5 分钟)，那么这个请求将被拦截掉，如果在设置的超时时间范围内，是不能阻止 DoS 攻击的。timestamp 机制只能减轻 DoS 攻击的时间，缩短攻击时间。如果黑客修改了时间戳的值可通过 sign 签名机制来处理。  

DoS

DoS 是 Denial of Service 的简称，即拒绝服务，造成 DoS 的攻击行为被称为 DoS 攻击，其目的是使计算机或网络无法提供正常的服务。最常见的 DoS 攻击有计算机网络带宽攻击和连通性攻击。

DoS 攻击是指故意的攻击网络协议实现的缺陷或直接通过野蛮手段残忍地耗尽被攻击对象的资源，目的是让目标计算机或网络无法提供正常的服务或资源访问，使目标系统服务系统停止响应甚至崩溃，而在此攻击中并不包括侵入目标服务器或目标网络设备。这些服务资源包括网络带宽，文件系统空间容量，开放的进程或者允许的连接。这种攻击会导致资源的匮乏，无论计算机的处理速度多快、内存容量多大、网络带宽的速度多快都无法避免这种攻击带来的后果。

*   Pingflood: 该攻击在短时间内向目的主机发送大量 ping 包，造成网络堵塞或主机资源耗尽。
    
      
    
*   Synflood: 该攻击以多个随机的源主机地址向目的主机发送 SYN 包，而在收到目的主机的 SYN ACK 后并不回应，这样，目的主机就为这些源主机建立了大量的连接队列，而且由于没有收到 ACK 一直维护着这些队列，造成了资源的大量消耗而不能向正常请求提供服务。
    
      
    
*   Smurf：该攻击向一个子网的广播地址发一个带有特定请求（如 ICMP 回应请求）的包，并且将源地址伪装成想要攻击的主机地址。子网上所有主机都回应广播包请求而向被攻击主机发包，使该主机受到攻击。
    
      
    
*   Land-based：攻击者将一个包的源地址和目的地址都设置为目标主机的地址，然后将该包通过 IP 欺骗的方式发送给被攻击主机，这种包可以造成被攻击主机因试图与自己建立连接而陷入死循环，从而很大程度地降低了系统性能。
    
      
    
*   Ping of Death：根据 TCP/IP 的规范，一个包的长度最大为 65536 字节。尽管一个包的长度不能超过 65536 字节，但是一个包分成的多个片段的叠加却能做到。当一个主机收到了长度大于 65536 字节的包时，就是受到了 Ping of Death 攻击，该攻击会造成主机的宕机。
    
      
    
*   Teardrop：IP 数据包在网络传递时，数据包可以分成更小的片段。攻击者可以通过发送两段（或者更多）数据包来实现 TearDrop 攻击。第一个包的偏移量为 0，长度为 N，第二个包的偏移量小于 N。为了合并这些数据段，TCP/IP 堆栈会分配超乎寻常的巨大资源，从而造成系统资源的缺乏甚至机器的重新启动。
    
      
    
*   PingSweep：使用 ICMP Echo 轮询多个主机。
    

**三、sign 简介**

nonce：随机值，是客户端随机生成的值，作为参数传递过来，随机值的目的是增加 sign 签名的多变性。随机值一般是数字和字母的组合，6 位长度，随机值的组成和长度没有固定规则。

sign: 一般用于参数签名，防止参数被非法篡改，最常见的是修改金额等重要敏感参数， sign 的值一般是将所有非空参数按照升续排序然后 + token+key+timestamp+nonce(随机数) 拼接在一起，然后使用某种加密算法进行加密，作为接口中的一个参数 sign 来传递，也可以将 sign 放到请求头中。

接口在网络传输过程中如果被黑客挟持，并修改其中的参数值，然后再继续调用接口，虽然参数的值被修改了，但是因为黑客不知道 sign 是如何计算出来的，不知道 sign 都有哪些值构成，不知道以怎样的顺序拼接在一起的，最重要的是不知道签名字符串中的 key 是什么，所以黑客可以篡改参数的值，但没法修改 sign 的值，当服务器调用接口前会按照 sign 的规则重新计算出 sign 的值然后和接口传递的 sign 参数的值做比较，如果相等表示参数值没有被篡改，如果不等，表示参数被非法篡改了，就不执行接口了。

**四、防止重复提交**  

对于一些重要的操作需要防止客户端重复提交的 (如非幂等性重要操作)，具体办法是当请求第一次提交时将 sign 作为 key 保存到 redis，并设置超时时间，超时时间和 Timestamp 中设置的差值相同。

当同一个请求第二次访问时会先检测 redis 是否存在该 sign，如果存在则证明重复提交了，接口就不再继续调用了。如果 sign 在缓存服务器中因过期时间到了，而被删除了，此时当这个 url 再次请求服务器时，因 token 的过期时间和 sign 的过期时间一直，sign 过期也意味着 token 过期，那样同样的 url 再访问服务器会因 token 错误会被拦截掉，这就是为什么 sign 和 token 的过期时间要保持一致的原因。拒绝重复调用机制确保 URL 被别人截获了也无法使用（如抓取数据）。

对于哪些接口需要防止重复提交可以自定义个注解来标记。

注意：所有的安全措施都用上的话有时候难免太过复杂，在实际项目中需要根据自身情况作出裁剪，比如可以只使用签名机制就可以保证信息不会被篡改，或者定向提供服务的时候只用 Token 机制就可以了。如何裁剪，全看项目实际情况和对接口安全性的要求。

**五、使用流程**

1. 接口调用方 (客户端) 向接口提供方 (服务器) 申请接口调用账号，申请成功后，接口提供方会给接口调用方一个 appId 和一个 key 参数

2. 客户端携带参数 appId、timestamp、sign 去调用服务器端的 API token，其中 sign = 加密 (appId + timestamp + key)

3. 客户端拿着 api_token 去访问不需要登录就能访问的接口

4. 当访问用户需要登录的接口时，客户端跳转到登录页面，通过用户名和密码调用登录接口，登录接口会返回一个 usertoken, 客户端拿着 usertoken 去访问需要登录才能访问的接口

sign 的作用是防止参数被篡改，客户端调用服务端时需要传递 sign 参数，服务器响应客户端时也可以返回一个 sign 用于客户度校验返回的值是否被非法篡改了。客户端传的 sign 和服务器端响应的 sign 算法可能会不同。

**六、示例代码**

1. dependency

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>2.9.0</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

2. RedisConfiguration

```
@Configuration
public class RedisConfiguration {
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }
    /**
     * 支持存储对象
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(){
        RedisTemplate<String, String> redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
```

3. TokenController

```
@Slf4j
@RestController
@RequestMapping("/api/token")
public class TokenController {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * API Token
     *
     * @param sign
     * @return
     */
    @PostMapping("/api_token")
    public ApiResponse<AccessToken> apiToken(String appId, @RequestHeader("timestamp") String timestamp, @RequestHeader("sign") String sign) {
        Assert.isTrue(!StringUtils.isEmpty(appId) && !StringUtils.isEmpty(timestamp) && !StringUtils.isEmpty(sign), "参数错误");
        long reqeustInterval = System.currentTimeMillis() - Long.valueOf(timestamp);
        Assert.isTrue(reqeustInterval < 5 * 60 * 1000, "请求过期，请重新请求");
        // 1. 根据appId查询数据库获取appSecret
        AppInfo appInfo = new AppInfo("1", "12345678954556");
        // 2. 校验签名
        String signString = timestamp + appId + appInfo.getKey();
        String signature = MD5Util.encode(signString);
        log.info(signature);
        Assert.isTrue(signature.equals(sign), "签名错误");
        // 3. 如果正确生成一个token保存到redis中，如果错误返回错误信息
        AccessToken accessToken = this.saveToken(0, appInfo, null);
        return ApiResponse.success(accessToken);
    }
    @NotRepeatSubmit(5000)
    @PostMapping("user_token")
    public ApiResponse<UserInfo> userToken(String username, String password) {
        // 根据用户名查询密码, 并比较密码(密码可以RSA加密一下)
        UserInfo userInfo = new UserInfo(username, "81255cb0dca1a5f304328a70ac85dcbd", "111111");
        String pwd = password + userInfo.getSalt();
        String passwordMD5 = MD5Util.encode(pwd);
        Assert.isTrue(passwordMD5.equals(userInfo.getPassword()), "密码错误");
        // 2. 保存Token
        AppInfo appInfo = new AppInfo("1", "12345678954556");
        AccessToken accessToken = this.saveToken(1, appInfo, userInfo);
        userInfo.setAccessToken(accessToken);
        return ApiResponse.success(userInfo);
    }
    private AccessToken saveToken(int tokenType, AppInfo appInfo,  UserInfo userInfo) {
        String token = UUID.randomUUID().toString();
        // token有效期为2小时
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, 7200);
        Date expireTime = calendar.getTime();
        // 4. 保存token
        ValueOperations<String, TokenInfo> operations = redisTemplate.opsForValue();
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setTokenType(tokenType);
        tokenInfo.setAppInfo(appInfo);
        if (tokenType == 1) {
            tokenInfo.setUserInfo(userInfo);
        }
        operations.set(token, tokenInfo, 7200, TimeUnit.SECONDS);
        AccessToken accessToken = new AccessToken(token, expireTime);
        return accessToken;
    }
    public static void main(String[] args) {
        long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
        String signString = timestamp + "1" + "12345678954556";
        String sign = MD5Util.encode(signString);
        System.out.println(sign);
        System.out.println("-------------------");
        signString = "password=123456&user;
        sign = MD5Util.encode(signString);
        System.out.println(sign);
    }
}
```

4. WebMvcConfiguration

```
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    private static final String[] excludePathPatterns  = {"/api/token/api_token"};
    @Autowired
    private TokenInterceptor tokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns(excludePathPatterns);
    }
}
5. TokenInterceptor
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     *
     * @param request
     * @param response
     * @param handler 访问的目标方法
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String timestamp = request.getHeader("timestamp");
        // 随机字符串
        String nonce = request.getHeader("nonce");
        String sign = request.getHeader("sign");
        Assert.isTrue(!StringUtils.isEmpty(token) && !StringUtils.isEmpty(timestamp) && !StringUtils.isEmpty(sign), "参数错误");
        // 获取超时时间
        NotRepeatSubmit notRepeatSubmit = ApiUtil.getNotRepeatSubmit(handler);
        long expireTime = notRepeatSubmit == null ? 5 * 60 * 1000 : notRepeatSubmit.value();
        // 2. 请求时间间隔
        long reqeustInterval = System.currentTimeMillis() - Long.valueOf(timestamp);
        Assert.isTrue(reqeustInterval < expireTime, "请求超时，请重新请求");
        // 3. 校验Token是否存在
        ValueOperations<String, TokenInfo> tokenRedis = redisTemplate.opsForValue();
        TokenInfo tokenInfo = tokenRedis.get(token);
        Assert.notNull(tokenInfo, "token错误");
        // 4. 校验签名(将所有的参数加进来，防止别人篡改参数) 所有参数看参数名升续排序拼接成url
        // 请求参数 + token + timestamp + nonce
        String signString = ApiUtil.concatSignString(request) + tokenInfo.getAppInfo().getKey() + token + timestamp + nonce;
        String signature = MD5Util.encode(signString);
        boolean flag = signature.equals(sign);
        Assert.isTrue(flag, "签名错误");
        // 5. 拒绝重复调用(第一次访问时存储，过期时间和请求超时时间保持一致), 只有标注不允许重复提交注解的才会校验
        if (notRepeatSubmit != null) {
            ValueOperations<String, Integer> signRedis = redisTemplate.opsForValue();
            boolean exists = redisTemplate.hasKey(sign);
            Assert.isTrue(!exists, "请勿重复提交");
            signRedis.set(sign, 0, expireTime, TimeUnit.MILLISECONDS);
        }
        return super.preHandle(request, response, handler);
    }
}
```

6. MD5Util ----MD5 工具类，加密生成数字签名

```
public class MD5Util {
    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));
        return resultSb.toString();
    }
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
    public static String encode(String origin) {
        return encode(origin, "UTF-8");
    }
    public static String encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }
}
```

7. @NotRepeatSubmit   ----- 自定义注解，防止重复提交。

```
/**
 * 禁止重复提交
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotRepeatSubmit {
    /** 过期时间，单位毫秒 **/
    long value() default 5000;
}
```

8. AccessToken

```
@Data
@AllArgsConstructor
public class AccessToken {
    /** token */
    private String token;
    /** 失效时间 */
    private Date expireTime;
}
```

9. AppInfo

```
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppInfo {
    /** App id */
    private String appId;
    /** API 秘钥 */
    private String key;
}
```

10. TokenInfo

```
@Data
public class TokenInfo {
    /** token类型: api:0 、user:1 */
    private Integer tokenType;
    /** App 信息 */
    private AppInfo appInfo;
    /** 用户其他数据 */
    private UserInfo userInfo;
}
```

11. UserInfo

```
@Data
public class UserInfo {
    /** 用户名 */
    private String username;
    /** 手机号 */
    private String mobile;
    /** 邮箱 */
    private String email;
    /** 密码 */
    private String password;
    /** 盐 */
    private String salt;
    private AccessToken accessToken;
    public UserInfo(String username, String password, String salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;
    }
} 
```

12. ApiCodeEnum

```
/**
 * 错误码code可以使用纯数字,使用不同区间标识一类错误，也可以使用纯字符，也可以使用前缀+编号
 *
 * 错误码：ERR + 编号
 *
 * 可以使用日志级别的前缀作为错误类型区分 Info(I) Error(E) Warning(W)
 *
 * 或者以业务模块 + 错误号
 *
 * TODO 错误码设计
 *
 * Alipay 用了两个code，两个msg(https://docs.open.alipay.com/api_1/alipay.trade.pay)
 */
public enum ApiCodeEnum {
    SUCCESS("10000", "success"),
    UNKNOW_ERROR("ERR0001","未知错误"),
    PARAMETER_ERROR("ERR0002","参数错误"),
    TOKEN_EXPIRE("ERR0003","认证过期"),
    REQUEST_TIMEOUT("ERR0004","请求超时"),
    SIGN_ERROR("ERR0005","签名错误"),
    REPEAT_SUBMIT("ERR0006","请不要频繁操作"),
    ;
    /** 代码 */
    private String code;
    /** 结果 */
    private String msg;
    ApiCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
```

13. ApiResult

```
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {
    /** 代码 */
    private String code;
    /** 结果 */
    private String msg;
}
```

14. ApiUtil  ------- 这个参考支付宝加密的算法写的. 我直接 Copy 过来了。

```
public class ApiUtil {
    /**
     * 按参数名升续拼接参数
     * @param request
     * @return
     */
    public static String concatSignString(HttpServletRequest request) {
        Map<String, String> paramterMap = new HashMap<>();
        request.getParameterMap().forEach((key, value) -> paramterMap.put(key, value[0]));
        // 按照key升续排序，然后拼接参数
        Set<String> keySet = paramterMap.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            // 或略掉的字段
            if (k.equals("sign")) {
                continue;
            }
            if (paramterMap.get(k).trim().length() > 0) {
                // 参数值为空，则不参与签名
                sb.append(k).append("=").append(paramterMap.get(k).trim()).append("&");
            }
        }
        return sb.toString();
    }
    public static String concatSignString(Map<String, String> map) {
        Map<String, String> paramterMap = new HashMap<>();
        map.forEach((key, value) -> paramterMap.put(key, value));
        // 按照key升续排序，然后拼接参数
        Set<String> keySet = paramterMap.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (paramterMap.get(k).trim().length() > 0) {
                // 参数值为空，则不参与签名
                sb.append(k).append("=").append(paramterMap.get(k).trim()).append("&");
            }
        }
        return sb.toString();
    }
    /**
     * 获取方法上的@NotRepeatSubmit注解
     * @param handler
     * @return
     */
    public static NotRepeatSubmit getNotRepeatSubmit(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            NotRepeatSubmit annotation = method.getAnnotation(NotRepeatSubmit.class);
            return annotation;
        }
        return null;
    }
}
```

15. ApiResponse

```
@Data
@Slf4j
public class ApiResponse<T> {
    /** 结果 */
    private ApiResult result;
    /** 数据 */
    private T data;
    /** 签名 */
    private String sign;
    public static <T> ApiResponse success(T data) {
        return response(ApiCodeEnum.SUCCESS.getCode(), ApiCodeEnum.SUCCESS.getMsg(), data);
    }
    public static ApiResponse error(String code, String msg) {
        return response(code, msg, null);
    }
    public static <T> ApiResponse response(String code, String msg, T data) {
        ApiResult result = new ApiResult(code, msg);
        ApiResponse response = new ApiResponse();
        response.setResult(result);
        response.setData(data);
        String sign = signData(data);
        response.setSign(sign);
        return response;
    }
    private static <T> String signData(T data) {
        // TODO 查询key
        String key = "12345678954556";
        Map<String, String> responseMap = null;
        try {
            responseMap = getFields(data);
        } catch (IllegalAccessException e) {
            return null;
        }
        String urlComponent = ApiUtil.concatSignString(responseMap);
        String signature = urlComponent + "key=" + key;
        String sign = MD5Util.encode(signature);
        return sign;
    }
    /**
     * @param data 反射的对象,获取对象的字段名和值
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Map<String, String> getFields(Object data) throws IllegalAccessException, IllegalArgumentException {
        if (data == null) return null;
        Map<String, String> map = new HashMap<>();
        Field[] fields = data.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(data);
            if (field.get(data) != null) {
                map.put(name, value.toString());
            }
        }
        return map;
    }
}
```

**七、ThreadLocal**

ThreadLocal 是线程内的全局上下文。就是在单个线程中，方法之间共享的内存，每个方法都可以从该上下文中获取值和修改值。

实际案例：

在调用 api 时都会传一个 token 参数，通常会写一个拦截器来校验 token 是否合法，我们可以通过 token 找到对应的用户信息 (User)，如果 token 合法，然后将用户信息存储到 ThreadLocal 中，这样无论是在 controller、service、dao 的哪一层都能访问到该用户的信息。作用类似于 Web 中的 request 作用域。

传统方式我们要在方法中访问某个变量，可以通过传参的形式往方法中传参，如果多个方法都要使用那么每个方法都要传参；如果使用 ThreadLocal 所有方法就不需要传该参数了，每个方法都可以通过 ThreadLocal 来访问该值。

*   ThreadLocalUtil.set("key", value); 保存值
    
*   T value = ThreadLocalUtil.get("key"); 获取值
    

ThreadLocalUtil

```
public class ThreadLocalUtil<T> {
    private static final ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>(4);
        }
    };
    public static Map<String, Object> getThreadLocal(){
        return threadLocal.get();
    }
    public static <T> T get(String key) {
        Map map = (Map)threadLocal.get();
        return (T)map.get(key);
    }
    public static <T> T get(String key,T defaultValue) {
        Map map = (Map)threadLocal.get();
        return (T)map.get(key) == null ? defaultValue : (T)map.get(key);
    }
    public static void set(String key, Object value) {
        Map map = (Map)threadLocal.get();
        map.put(key, value);
    }
    public static void set(Map<String, Object> keyValueMap) {
        Map map = (Map)threadLocal.get();
        map.putAll(keyValueMap);
    }
    public static void remove() {
        threadLocal.remove();
    }
    public static <T> Map<String,T> fetchVarsByPrefix(String prefix) {
        Map<String,T> vars = new HashMap<>();
        if( prefix == null ){
            return vars;
        }
        Map map = (Map)threadLocal.get();
        Set<Map.Entry> set = map.entrySet();
        for( Map.Entry entry : set){
            Object key = entry.getKey();
            if( key instanceof String ){
                if( ((String) key).startsWith(prefix) ){
                    vars.put((String)key,(T)entry.getValue());
                }
            }
        }
        return vars;
    }
    public static <T> T remove(String key) {
        Map map = (Map)threadLocal.get();
        return (T)map.remove(key);
    }
    public static void clear(String prefix) {
        if( prefix == null ){
            return;
        }
        Map map = (Map)threadLocal.get();
        Set<Map.Entry> set = map.entrySet();
        List<String> removeKeys = new ArrayList<>();
        for( Map.Entry entry : set ){
            Object key = entry.getKey();
            if( key instanceof String ){
                if( ((String) key).startsWith(prefix) ){
                    removeKeys.add((String)key);
                }
            }
        }
        for( String key : removeKeys ){
            map.remove(key);
        }
    }
}
```

总结: 这个是目前第三方数据接口交互过程中常用的一些参数与使用示例，希望对大家有点帮助。

当然如果为了保证更加的安全，可以加上 RSA,RSA2，AES 等等加密方式，保证了数据的更加的安全，但是唯一的缺点是加密与解密比较耗费 CPU 的资源。

**END**

**Java 团长**

专注于 Java 干货分享

![][img-1]

扫描上方二维码获取更多 Java 干货

[img-0]:data:image/png;base64,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

[img-1]:data:image/jpeg;base64,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