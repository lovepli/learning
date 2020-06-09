package com.datastructure.learning.basicTest.异步请求和调用;

import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: lipan
 * @date: 2020/6/9
 * @description:
 */
@Service
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class EmailService {

    @Autowired
    private ApplicationContext applicationContext;

    @Async
    public void testSyncTask() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("异步任务执行完成！");
    }
    public void asyncCallTwo() throws InterruptedException {
        //this.testSyncTask();
//        EmailService emailService = (EmailService)applicationContext.getBean(EmailService.class);
//        emailService.testSyncTask();
        boolean isAop = AopUtils.isAopProxy(EmailController.class);//是否是代理对象；
        boolean isCglib = AopUtils.isCglibProxy(EmailController.class);  //是否是CGLIB方式的代理对象；
        boolean isJdk = AopUtils.isJdkDynamicProxy(EmailController.class);  //是否是JDK动态代理方式的代理对象；
        //以下才是重点!!!
        EmailService emailService = (EmailService)applicationContext.getBean(EmailService.class);
        EmailService proxy = (EmailService) AopContext.currentProxy();
        System.out.println(emailService == proxy ? true : false);
        proxy.testSyncTask();
        System.out.println("end!!!");
    }
}

/**
 * 6、开启 cglib 代理，手动获取 Spring 代理类, 从而调用同类下的异步方法。
 *
 * <p>首先，在启动类上加上 @EnableAspectJAutoProxy(exposeProxy = true) 注解。
 *
 * <p>代码实现，如下：
 */

/**
 * 三、异步请求与异步调用的区别 两者的使用场景不同，异步请求用来解决并发请求对服务器造成的压力，从而提高对请求的吞吐量；而异步调用是用来做一些非主线流程且不需要实时计算和响应的任务，比如同步日志到
 * kafka 中做日志分析等。
 *
 * <p>异步请求是会一直等待 response 相应的，需要返回结果给客户端的；而异步调用我们往往会马上返回给客户端响应，完成这次整个的请求，至于异步调用的任务后台自己慢慢跑就行，客户端不会关心。
 */
