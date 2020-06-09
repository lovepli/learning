package com.datastructure.learning.basicTest.异步请求和调用;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author: lipan
 * @date: 2020/6/9
 * @description: SpringBoot 中异步调用的使用
 */
@Slf4j
@Controller
@RequestMapping("/app")
public class EmailController {
  // 获取ApplicationContext对象方式有多种,这种最简单,其它的大家自行了解一下
  @Autowired private ApplicationContext applicationContext;

  @RequestMapping(value = "/email/asyncCall", method = GET)
  @ResponseBody
  public Map<String, Object> asyncCall() {
    Map<String, Object> resMap = new HashMap<String, Object>();
    try {
      // 这样调用同类下的异步方法是不起作用的
      // this.testAsyncTask();
      // 通过上下文获取自己的代理对象调用异步方法
      EmailController emailController =
          (EmailController) applicationContext.getBean(EmailController.class);
      emailController.testAsyncTask();
      resMap.put("code", 200);
    } catch (Exception e) {
      resMap.put("code", 400);
      log.error("error!", e);
    }
    return resMap;
  }


  // 注意一定是public,且是非static方法
  @Async
  public void testAsyncTask() throws InterruptedException {
    Thread.sleep(10000);
    System.out.println("异步任务执行完成！");
  }

  /**
   * 1、介绍
   *
   * <p>异步请求的处理。除了异步请求，一般上我们用的比较多的应该是异步调用。通常在开发过程中，会遇到一个方法是和实际业务无关的，没有紧密性的。
   * 比如记录日志信息等业务。这个时候正常就是启一个新线程去做一些业务处理，让主线程异步的执行其他业务。
   */

  /**
   * 2、使用方式（基于 spring 下）
   *
   * <p>需要在启动类加入 @EnableAsync 使异步调用 @Async 注解生效
   *
   * <p>在需要异步执行的方法上加入此注解即可 @Async("threadPool"),threadPool 为自定义线程池
   *
   * <p>代码略。。。就俩标签，自己试一把就可以了
   */

  /**
   * 3、注意事项
   *
   * <p>在默认情况下，未设置 TaskExecutor 时，默认是使用 SimpleAsyncTaskExecutor
   * 这个线程池，但此线程不是真正意义上的线程池，因为线程不重用，每次调用都会创建一个新的线程。可通过控制台日志输出可以看出，每次输出线程名都是递增的。所以最好我们来自定义一个线程池。
   *
   * <p>调用的异步方法，不能为同一个类的方法（包括同一个类的内部类），简单来说，因为 Spring
   * 在启动扫描时会为其创建一个代理类，而同类调用时，还是调用本身的代理类的，所以和平常调用是一样的。
   *
   * <p>其他的注解如 @Cache 等也是一样的道理，说白了，就是 Spring 的代理机制造成的。所以在开发中，最好把异步服务单独抽出一个类来管理。下面会重点讲述。
   */

  /**
   * 4、什么情况下会导致 @Async 异步方法会失效？
   *
   * <p>a. 调用同一个类下注有 @Async 异步方法：在 spring 中像 @Async 和 @Transactional、cache 等注解本质使用的是动态代理，其实 Spring
   * 容器在初始化的时候 Spring 容器会将含有 AOP 注解的类对象 “替换”
   * 为代理对象（简单这么理解），那么注解失效的原因就很明显了，就是因为调用方法的是对象本身而不是代理对象，因为没有经过 Spring 容器，那么解决方法也会沿着这个思路来解决。
   *
   * <p>b. 调用的是静态 (static) 方法
   *
   * <p>c. 调用 (private) 私有化方法
   */

  /**
   * 5、解决 4 中问题 1 的方式（其它 2,3 两个问题自己注意下就可以了）
   *
   * <p>将要异步执行的方法单独抽取成一个类，原理就是当你把执行异步的方法单独抽取成一个类的时候，这个类肯定是被 Spring 管理的，其他 Spring
   * 组件需要调用的时候肯定会注入进去，这时候实际上注入进去的就是代理类了。
   *
   * <p>其实我们的注入对象都是从 Spring 容器中给当前 Spring 组件进行成员变量的赋值，由于某些类使用了 AOP 注解，那么实际上在 Spring
   * 容器中实际存在的是它的代理对象。那么我们就可以通过上下文获取自己的代理对象调用异步方法。
   */
}
