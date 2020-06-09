> 本文由 [简悦 SimpRead](http://ksria.com/simpread/) 转码， 原文地址 https://www.cnblogs.com/zhangyinhua/p/11551392.html

### 一、使用 Optional 引言

#### 1.1、代码问题引出

在写程序的时候一般都遇到过 `NullPointerException`，所以经常会对程序进行非空的判断：

```
User user = getUserById(id);
if (user != null) {
    String username = user.getUsername();
    System.out.println("Username is: " + username); // 使用 username
}
```

为了解决这种尴尬的处境，JDK 终于在 Java8 的时候加入了 `Optional` 类，查看 `Optional` 的 javadoc 介绍：

```
A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value.
```

这是一个可以包含或者不包含非 `null` 值的容器。如果值存在则 `isPresent()`方法会返回 `true`，调用 `get()` 方法会返回该对象。

#### 1.2、解决进阶

我们假设 `getUserById` 已经是个客观存在的不能改变的方法，那么利用 `isPresent` 和 `get` 两个方法，我们现在能写出下面的代码：

```
Optional<User> user = Optional.ofNullable(getUserById(id));
if (user.isPresent()) {
    String username = user.get().getUsername();
    System.out.println("Username is: " + username); // 使用 username
}
```

好像看着代码是优美了点, 但是事实上这与之前判断 `null` 值的代码没有本质的区别，反而用 `Optional` 去封装 _value_，增加了代码量。所以我们来看看 `Optional` 还提供了哪些方法，让我们更好的（以正确的姿势）使用 `Optional`。

### 二、Optional 三个静态构造方法

**1）概述：**

JDK 提供三个静态方法来构造一个 `Optional`：

1.  Optional.of(T value)
    
    ```
    public static <T> Optional<T> of(T value) {
            return new Optional<>(value);
        }
    ```
    
    该方法通过一个非 `null` 的 _value_ 来构造一个 `Optional`，返回的 `Optional` 包含了 _value_ 这个值。对于该方法，传入的参数一定不能为 `null`，否则便会抛出 `NullPointerException`。
    
2.  Optional.ofNullable(T value)
    
    ```
    public static <T> Optional<T> ofNullable(T value) {
            return value == null ? empty() : of(value);
        }
    ```
    
    该方法和 `of` 方法的区别在于，传入的参数可以为 `null` —— 但是前面 javadoc 不是说 `Optional` 只能包含非 `null` 值吗？我们可以看看 `ofNullable` 方法的源码。
    
    原来该方法会判断传入的参数是否为 `null`，如果为 `null` 的话，返回的就是 `Optional.empty()`。
    
3.  Optional.empty()
    
    ```
    public static<T> Optional<T> empty() {
            @SuppressWarnings("unchecked")
            Optional<T> t = (Optional<T>) EMPTY;
            return t;
        }
    ```
    
    该方法用来构造一个空的 `Optional`，即该 `Optional` 中不包含值 —— 其实底层实现还是 **如果 Optional 中的 value 为 null 则该 Optional 为不包含值的状态**，然后在 API 层面将 `Optional` 表现的不能包含 `null`值，使得 `Optional` 只存在 **包含值** 和 **不包含值** 两种状态。
    

**2）分析：**

前面 javadoc 也有提到，`Optional` 的 `isPresent()` 方法用来判断是否包含值，`get()` 用来获取 `Optional` 包含的值 —— **值得注意的是，如果值不存在，即在一个 Optional.empty 上调用 get() 方法的话，将会抛出 NoSuchElementException 异常**。

**3）总结：**

1）Optional.of(obj): 它要求传入的 obj 不能是 null 值的, 否则还没开始进入角色就倒在了 NullPointerException 异常上了.  
2）Optional.ofNullable(obj): 它以一种智能的, 宽容的方式来构造一个 Optional 实例. 来者不拒, 传 null 进到就得到 Optional.empty(), 非 null 就调用 Optional.of(obj).  
那是不是我们只要用 Optional.ofNullable(obj) 一劳永逸, 以不变应二变的方式来构造 Optional 实例就行了呢? 那也未必, 否则 Optional.of(obj) 何必如此暴露呢, 私有则可。

### 三、Optional 常用方法详解

#### 3.1、Optional 常用方法概述

1.  Optional.of(T t)
    
    将指定值用 Optional 封装之后返回，如果该值为 null，则抛出一个 NullPointerException 异常。
    
2.  Optional.empty()
    
    创建一个空的 Optional 实例。
    
3.  Optional.ofNullable(T t)
    
    将指定值用 Optional 封装之后返回，如果该值为 null，则返回一个空的 Optional 对象。
    
4.  isPresent
    
    如果值存在返回 true, 否则返回 false
    
5.  ifPresent
    
    如果 Optional 实例有值则为其调用 consumer , 否则不做处理。  
    要理解 ifPresent 方法，首先需要了解 Consumer 类。简答地说，Consumer 类包含一个抽象方法。该抽象方法对传入的值进行处理，但没有返回值。 Java8 支持不用接口直接通过 lambda 表达式传入参数。  
    如果 Optional 实例有值，调用 ifPresent() 可以接受接口段或 lambda 表达式。
    
6.  Optional.get()
    
    如果该值存在，将该值用 Optional 封装返回，否则抛出一个 NoSuchElementException 异常。
    
7.  orElse(T t)
    
    如果调用对象包含值，返回该值，否则返回 t。
    
8.  orElseGet(Supplier s)
    
    如果调用对象包含值，返回该值，否则返回 s 获取的值。
    
9.  orElseThrow()
    
    它会在对象为空的时候抛出异常。
    
10.  map(Function f)
    
    如果值存在，就对该值执行提供的 mapping 函数调用。
    
11.  flatMap(Function mapper)
    
    如果值存在，就对该值执行提供的 mapping 函数调用，返回一个 Optional 类型的值，否则就返回一个空的 Optional 对象。
    

#### 3.2、Optional 常用方法详解

##### 3.2.1、ifPresent

```
public void ifPresent(Consumer<? super T> consumer) {
        if (value != null)
            consumer.accept(value);
    }
```

如果 `Optional` 中有值，则对该值调用 `consumer.accept`，否则什么也不做。  
所以对于引言上的例子，我们可以修改为：

```
Optional<User> user = Optional.ofNullable(getUserById(id));
user.ifPresent(u -> System.out.println("Username is: " + u.getUsername()));
```

##### 3.2.2、orElse

```
public T orElse(T other) {
        return value != null ? value : other;
    }
```

如果 `Optional` 中有值则将其返回，否则返回 `orElse` 方法传入的参数。

```
User user = Optional
        .ofNullable(getUserById(id))
        .orElse(new User(0, "Unknown"));
        
System.out.println("Username is: " + user.getUsername());
```

##### 3.2.3、orElseGet

```
public T orElseGet(Supplier<? extends T> other) {
        return value != null ? value : other.get();
    }
```

`orElseGet` 与 `orElse` 方法的区别在于，`orElseGet` 方法传入的参数为一个 `Supplier` 接口的实现 —— 当 `Optional` 中有值的时候，返回值；当 `Optional` 中没有值的时候，返回从该 `Supplier` 获得的值。

```
User user = Optional
        .ofNullable(getUserById(id))
        .orElseGet(() -> new User(0, "Unknown"));
        
System.out.println("Username is: " + user.getUsername());
```

##### 3.2.4、orElseThrow

```
public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (value != null) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }
```

`orElseThrow` 与 `orElse` 方法的区别在于，`orElseThrow` 方法当 `Optional` 中有值的时候，返回值；没有值的时候会抛出异常，抛出的异常由传入的 _exceptionSupplier_ 提供。

举例说明：

​ 在 SpringMVC 的控制器中，我们可以配置统一处理各种异常。查询某个实体时，如果数据库中有对应的记录便返回该记录，否则就可以抛出 `EntityNotFoundException` ，处理 `EntityNotFoundException` 的方法中我们就给客户端返回 Http 状态码 404 和异常对应的信息 —— `orElseThrow` 完美的适用于这种场景。

```
@RequestMapping("/{id}")
public User getUser(@PathVariable Integer id) {
    Optional<User> user = userService.getUserById(id);
    return user.orElseThrow(() -> new EntityNotFoundException("id 为 " + id + " 的用户不存在"));
}

@ExceptionHandler(EntityNotFoundException.class)
public ResponseEntity<String> handleException(EntityNotFoundException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
}
```

##### 3.2.5、map

```
public<U> Optional<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent())
            return empty();
        else {
            return Optional.ofNullable(mapper.apply(value));
        }
    }
```

如果当前 `Optional` 为 `Optional.empty`，则依旧返回 `Optional.empty`；否则返回一个新的 `Optional`，该 `Optional` 包含的是：函数 _mapper_ 在以 _value_ 作为输入时的输出值。

```
String username = Optional.ofNullable(getUserById(id))
                        .map(user -> user.getUsername())
                        .orElse("Unknown")
                        .ifPresent(name -> System.out.println("Username is: " + name));
```

而且我们可以多次使用 `map` 操作：

```
Optional<String> username = Optional.ofNullable(getUserById(id))
                                .map(user -> user.getUsername())
                                .map(name -> name.toLowerCase())
                                .map(name -> name.replace('_', ' '))
                                .orElse("Unknown")
                                .ifPresent(name -> System.out.println("Username is: " + name));
```

##### 3.2.6、flatMap

```
public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent())
            return empty();
        else {
            return Objects.requireNonNull(mapper.apply(value));
        }
    }
```

`flatMap` 方法与 `map` 方法的区别在于，`map` 方法参数中的函数 `mapper` 输出的是值，然后 `map` 方法会使用 `Optional.ofNullable` 将其包装为 `Optional`；而 `flatMap` 要求参数中的函数 `mapper` 输出的就是 `Optional`。

```
Optional<String> username = Optional.ofNullable(getUserById(id))
                                .flatMap(user -> Optional.of(user.getUsername()))
                                .flatMap(name -> Optional.of(name.toLowerCase()))
                                .orElse("Unknown")
                                .ifPresent(name -> System.out.println("Username is: " + name));
```

##### 3.2.7、filter

```
public Optional<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (!isPresent())
            return this;
        else
            return predicate.test(value) ? this : empty();
    }
```

`filter` 方法接受一个 `Predicate` 来对 `Optional` 中包含的值进行过滤，如果包含的值满足条件，那么还是返回这个 `Optional`；否则返回 `Optional.empty`。

```
Optional<String> username = Optional.ofNullable(getUserById(id))
                                .filter(user -> user.getId() < 10)
                                .map(user -> user.getUsername());
                                .orElse("Unknown")
                                .ifPresent(name -> System.out.println("Username is: " + name));
```

### 四、Optional 使用示例

#### 4.1、使用展示一

当 user.isPresent() 为真, 获得它关联的 orders 的映射集合, 为假则返回一个空集合时, 我们用上面的 orElse, orElseGet 方法都乏力时, 那原本就是 map 函数的责任, 我们可以这样一行：

```
return user.map(u -> u.getOrders()).orElse(Collections.emptyList())
 
//上面避免了我们类似 Java 8 之前的做法
if(user.isPresent()) {
  return user.get().getOrders();
} else {
  return Collections.emptyList();
}
```

map 是可能无限级联的, 比如再深一层, 获得用户名的大写形式：

```
return user.map(u -> u.getUsername())
           .map(name -> name.toUpperCase())
           .orElse(null);
```

以前的做法：

```
User user = .....
if(user != null) {
  String name = user.getUsername();
  if(name != null) {
    return name.toUpperCase();
  } else {
    return null;
  }
} else {
  return null;
}
```

filter() : 如果有值并且满足条件返回包含该值的 Optional，否则返回空 Optional。

```
Optional<String> longName = name.filter((value) -> value.length() > 6);  
System.out.println(longName.orElse("The name is less than 6 characters"));
```