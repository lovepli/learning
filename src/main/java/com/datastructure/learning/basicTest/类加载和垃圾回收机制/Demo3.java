package com.datastructure.learning.basicTest.类加载和垃圾回收机制;

/**
 * @author: lipan
 * @date: 2020-04-27
 * @description:  spring相关
 */
public class Demo3 {

    /**
     * BeanFactory 与 AppliacationContext 有什么区别
     *
     * 1. BeanFactory
     * 基础类型的 IOC 容器，提供完成的 IOC 服务支持。如果没有特殊指定，默认采用延迟初始化策略。相对来说，容
     * 器启动初期速度较快，所需资源有限。
     * 2.ApplicationContext
     * ApplicationContext 是在 BeanFactory 的基础上构建，是相对比较高级的容器实现，除了 BeanFactory 的所有
     * 支持外， ApplicationContext 还提供了事件发布、国际化支持等功能。 ApplicationContext 管理的对象，在容器启动
     * 后默认全部初始化并且绑定完成。
     */

    /**
     * Spring 支持的几种 bean 的作用域。
     * Spring 框架支持以下五种 bean 的作用域：
     * singleton : bean 在每个 Spring ioc 容器中只有一个实例。
     * prototype：一个 bean 的定义可以有多个实例。
     * request：每次 http 请求都会创建一个 bean，该作用域仅在基于 web 的 Spring ApplicationContext 情形下有
     * 效。
     * session ： 在 一 个 HTTP Session 中 ， 一 个 bean 定 义 对 应 一 个 实 例 。 该 作 用 域 仅 在 基 于 web 的
     * Spring ApplicationContext 情形下有效。
     * global-session：在一个全局的 HTTP Session 中，一个 bean 定义对应一个实例。该作用域仅在基于 web 的
     * Spring ApplicationContext 情形下有效。
     */
}
