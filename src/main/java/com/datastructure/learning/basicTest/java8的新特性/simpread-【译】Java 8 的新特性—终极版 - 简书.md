---
title: java8新特性-终极版
date: 2020-06-09 11:28:00
tags: 实战
categories: 实战
# java8新特性-终极版
---
> 本文由 [简悦 SimpRead](http://ksria.com/simpread/) 转码， 原文地址 https://www.jianshu.com/p/5b800057f2d8

> 声明：本文翻译自 [Java 8 Features Tutorial – The ULTIMATE Guide](https://links.jianshu.com/go?to=https%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F05%2Fjava-8-features-tutorial.html)，翻译过程中发现并发编程网已经有同学翻译过了：[Java 8 特性 – 终极手册](https://links.jianshu.com/go?to=http%3A%2F%2Fifeve.com%2Fjava-8-features-tutorial%2F)，我还是坚持自己翻译了一版（写作驱动学习，加深印象），有些地方参考了该同学的。

![][img-0]

Java 8

**前言：** Java 8 已经发布很久了，很多报道表明 Java 8 是一次重大的版本升级。在 Java Code Geeks 上已经有很多介绍 Java 8 新特性的文章，例如 [Playing with Java 8 – Lambdas and Concurrency](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F04%2Fplaying-with-java-8-lambdas-and-concurrency.html)、[Java 8 Date Time API Tutorial : LocalDateTime](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F04%2Fjava-8-date-time-api-tutorial-localdatetime.html) 和 [Abstract Class Versus Interface in the JDK 8 Era](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F04%2Fabstract-class-versus-interface-in-the-jdk-8-era.html)。本文还参考了一些其他资料，例如：[15 Must Read Java 8 Tutorials](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F04%2F15-must-read-java-8-tutorials.html) 和 [The Dark Side of Java 8](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F04%2Fjava-8-friday-the-dark-side-of-java-8.html)。本文综合了上述资料，整理成一份关于 Java 8 新特性的参考教材，希望你有所收获。

毫无疑问，[Java 8](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.oracle.com%2Ftechnetwork%2Fjava%2Fjavase%2F8train-relnotes-latest-2153846.html) 是 Java 自 Java 5（发布于 2004 年）之后的最重要的版本。这个版本包含语言、编译器、库、工具和 JVM 等方面的十多个新特性。在本文中我们将学习这些新特性，并用实际的例子说明在什么场景下适合使用。

这个教程包含 Java 开发者经常面对的几类问题：

*   语言
*   编译器
*   库
*   工具
*   运行时（JVM）

Java 8 是 Java 的一个重大版本，有人认为，虽然这些新特性领 Java 开发人员十分期待，但同时也需要花不少精力去学习。在这一小节中，我们将介绍 Java 8 的大部分新特性。

2.1 Lambda 表达式和函数式接口
--------------------

Lambda 表达式（也称为闭包）是 Java 8 中最大和最令人期待的语言改变。它允许我们将函数当成参数传递给某个方法，或者把代码本身当作数据处理：[函数式开发者](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F03%2Ffunctional-programming-with-java-8-lambda-expressions-monads.html)非常熟悉这些概念。很多 JVM 平台上的语言（Groovy、[Scala](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2Ftutorials%2Fscala-tutorials%2F) 等）从诞生之日就支持 Lambda 表达式，但是 Java 开发者没有选择，只能使用匿名内部类代替 Lambda 表达式。

Lambda 的设计耗费了很多时间和很大的社区力量，最终找到一种折中的实现方案，可以实现简洁而紧凑的语言结构。最简单的 Lambda 表达式可由逗号分隔的参数列表、**->** 符号和语句块组成，例如：

```
Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println( e ) );
```

在上面这个代码中的参数 **e** 的类型是由编译器推理得出的，你也可以显式指定该参数的类型，例如：

```
Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );
```

如果 Lambda 表达式需要更复杂的语句块，则可以使用花括号将该语句块括起来，类似于 Java 中的函数体，例如：

```
Arrays.asList( "a", "b", "d" ).forEach( e -> {
    System.out.print( e );
    System.out.print( e );
} );
```

Lambda 表达式可以引用类成员和局部变量（会将这些变量隐式得转换成 **final** 的），例如下列两个代码块的效果完全相同：

```
String separator = ",";
Arrays.asList( "a", "b", "d" ).forEach( 
    ( String e ) -> System.out.print( e + separator ) );
```

和

```
final String separator = ",";
Arrays.asList( "a", "b", "d" ).forEach( 
    ( String e ) -> System.out.print( e + separator ) );
```

Lambda 表达式有返回值，返回值的类型也由编译器推理得出。如果 Lambda 表达式中的语句块只有一行，则可以不用使用 **return** 语句，下列两个代码片段效果相同：

```
Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
```

和

```
Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
    int result = e1.compareTo( e2 );
    return result;
} );
```

Lambda 的设计者们为了让现有的功能与 Lambda 表达式良好兼容，考虑了很多方法，于是产生了**[函数接口](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2013%2F03%2Fintroduction-to-functional-interfaces-a-concept-recreated-in-java-8.html)**这个概念。函数接口指的是只有一个函数的接口，这样的接口可以隐式转换为 Lambda 表达式。**java.lang.Runnable** 和 **java.util.concurrent.Callable** 是函数式接口的最佳例子。在实践中，函数式接口非常脆弱：只要某个开发者在该接口中添加一个函数，则该接口就不再是函数式接口进而导致编译失败。为了克服这种代码层面的脆弱性，并显式说明某个接口是函数式接口，Java 8 提供了一个特殊的注解 **@FunctionalInterface**（Java 库中的所有相关接口都已经带有这个注解了），举个简单的函数式接口的定义：

```
@FunctionalInterface
public interface Functional {
    void method();
}
```

不过有一点需要注意，[默认方法和静态方法](https://links.jianshu.com/go?to=https%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F05%2Fjava-8-features-tutorial.html%23Interface_Default)不会破坏函数式接口的定义，因此如下的代码是合法的。

```
@FunctionalInterface
public interface FunctionalDefaultMethods {
    void method();
        
    default void defaultMethod() {            
    }        
}
```

Lambda 表达式作为 Java 8 的最大卖点，它有潜力吸引更多的开发者加入到 JVM 平台，并在纯 Java 编程中使用函数式编程的概念。如果你需要了解更多 Lambda 表达式的细节，可以参考[官方文档](https://links.jianshu.com/go?to=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2Ftutorial%2Fjava%2FjavaOO%2Flambdaexpressions.html)。

2.2 接口的默认方法和静态方法
----------------

Java 8 使用两个新概念扩展了接口的含义：默认方法和静态方法。默认方法使得接口有点类似 traits，不过要实现的目标不一样。默认方法使得开发者可以在 不破坏二进制兼容性的前提下，往现存接口中添加新的方法，即不强制那些实现了该接口的类也同时实现这个新加的方法。

默认方法和抽象方法之间的区别在于抽象方法需要实现，而默认方法不需要。接口提供的默认方法会被接口的实现类继承或者覆写，例子代码如下：

```
private interface Defaulable {
    
    
    default String notRequired() { 
        return "Default implementation"; 
    }        
}
        
private static class DefaultableImpl implements Defaulable {
}
    
private static class OverridableImpl implements Defaulable {
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}
```

**Defaulable** 接口使用关键字 **default** 定义了一个默认方法 **notRequired()**。**DefaultableImpl** 类实现了这个接口，同时默认继承了这个接口中的默认方法；**OverridableImpl** 类也实现了这个接口，但覆写了该接口的默认方法，并提供了一个不同的实现。

Java 8 带来的另一个有趣的特性是在接口中可以定义静态方法，例子代码如下：

```
private interface DefaulableFactory {
    
    static Defaulable create( Supplier< Defaulable > supplier ) {
        return supplier.get();
    }
}
```

下面的代码片段整合了默认方法和静态方法的使用场景：

```
public static void main( String[] args ) {
    Defaulable defaulable = DefaulableFactory.create( DefaultableImpl::new );
    System.out.println( defaulable.notRequired() );
        
    defaulable = DefaulableFactory.create( OverridableImpl::new );
    System.out.println( defaulable.notRequired() );
}
```

这段代码的输出结果如下：

```
Default implementation
Overridden implementation
```

由于 JVM 上的默认方法的实现在字节码层面提供了支持，因此效率非常高。默认方法允许在不打破现有继承体系的基础上改进接口。该特性在官方库中的应用是：给 **java.util.Collection** 接口添加新方法，如 **stream()**、**parallelStream()**、**forEach()** 和 **removeIf()** 等等。

尽管默认方法有这么多好处，但在实际开发中应该谨慎使用：在复杂的继承体系中，默认方法可能引起歧义和编译错误。如果你想了解更多细节，可以参考[官方文档](https://links.jianshu.com/go?to=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2Ftutorial%2Fjava%2FIandI%2Fdefaultmethods.html)。

2.3 方法引用
--------

方法引用使得开发者可以直接引用现存的方法、Java 类的构造方法或者实例对象。方法引用和 Lambda 表达式配合使用，使得 java 类的构造方法看起来紧凑而简洁，没有很多复杂的模板代码。

西门的例子中，**Car** 类是不同方法引用的例子，可以帮助读者区分四种类型的方法引用。

```
public static class Car {
    public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }              
        
    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }
        
    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }
        
    public void repair() {   
        System.out.println( "Repaired " + this.toString() );
    }
}
```

第一种方法引用的类型是构造器引用，语法是 **Class::new**，或者更一般的形式：**Class<T>::new**。注意：这个构造器没有参数。

```
final Car car = Car.create( Car::new );
final List< Car > cars = Arrays.asList( car );
```

第二种方法引用的类型是静态方法引用，语法是 **Class::static_method**。注意：这个方法接受一个 Car 类型的参数。

```
cars.forEach( Car::collide );
```

第三种方法引用的类型是某个类的成员方法的引用，语法是 **Class::method**，注意，这个方法没有定义入参：

```
cars.forEach( Car::repair );
```

第四种方法引用的类型是某个实例对象的成员方法的引用，语法是 **instance::method**。注意：这个方法接受一个 Car 类型的参数：

```
final Car police = Car.create( Car::new );
cars.forEach( police::follow );
```

运行上述例子，可以在控制台看到如下输出（Car 实例可能不同）：

```
Collided com.javacodegeeks.java8.method.references.MethodReferences$Car@7a81197d
Repaired com.javacodegeeks.java8.method.references.MethodReferences$Car@7a81197d
Following the com.javacodegeeks.java8.method.references.MethodReferences$Car@7a81197d
```

如果想了解和学习更详细的内容，可以参考[官方文档](https://links.jianshu.com/go?to=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2Ftutorial%2Fjava%2FjavaOO%2Fmethodreferences.html)

2.4 重复注解
--------

自从 Java 5 中引入[注解](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2012%2F08%2Fjava-annotations-explored-explained.html)以来，这个特性开始变得非常流行，并在各个框架和项目中被广泛使用。不过，注解有一个很大的限制是：在同一个地方不能多次使用同一个注解。Java 8 打破了这个限制，引入了重复注解的概念，允许在同一个地方多次使用同一个注解。

在 Java 8 中使用 **@Repeatable** 注解定义重复注解，实际上，这并不是语言层面的改进，而是编译器做的一个 trick，底层的技术仍然相同。可以利用下面的代码说明：

```
package com.javacodegeeks.java8.repeatable.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepeatingAnnotations {
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }
    
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    };
    
    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {        
    }
    
    public static void main(String[] args) {
        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
    }
}
```

正如我们所见，这里的 **Filter** 类使用 @Repeatable(Filters.class) 注解修饰，而 **Filters** 是存放 **Filter** 注解的容器，编译器尽量对开发者屏蔽这些细节。这样，**Filterable** 接口可以用两个 **Filter** 注解注释（这里并没有提到任何关于 Filters 的信息）。

另外，反射 API 提供了一个新的方法：**getAnnotationsByType()**，可以返回某个类型的重复注解，例如`Filterable.class.getAnnoation(Filters.class)`将返回两个 Filter 实例，输出到控制台的内容如下所示：

如果你希望了解更多内容，可以参考[官方文档](https://links.jianshu.com/go?to=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2Ftutorial%2Fjava%2Fannotations%2Frepeating.html)。

2.5 更好的类型推断
-----------

Java 8 编译器在类型推断方面有很大的提升，在很多场景下编译器可以推导出某个参数的数据类型，从而使得代码更为简洁。例子代码如下：

```
package com.javacodegeeks.java8.type.inference;

public class Value< T > {
    public static< T > T defaultValue() { 
        return null; 
    }
    
    public T getOrDefault( T value, T defaultValue ) {
        return ( value != null ) ? value : defaultValue;
    }
}
```

下列代码是 **Value<String>** 类型的应用：

```
package com.javacodegeeks.java8.type.inference;

public class TypeInference {
    public static void main(String[] args) {
        final Value< String > value = new Value<>();
        value.getOrDefault( "22", Value.defaultValue() );
    }
}
```

参数 **Value.defaultValue()** 的类型由编译器推导得出，不需要显式指明。在 Java 7 中这段代码会有编译错误，除非使用`Value.<String>defaultValue()`。

2.6 拓宽注解的应用场景
-------------

Java 8 拓宽了注解的应用场景。现在，注解几乎可以使用在任何元素上：局部变量、接口类型、超类和接口实现类，甚至可以用在函数的异常定义上。下面是一些例子：

```
package com.javacodegeeks.java8.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

public class Annotations {
    @Retention( RetentionPolicy.RUNTIME )
    @Target( { ElementType.TYPE_USE, ElementType.TYPE_PARAMETER } )
    public @interface NonEmpty {        
    }
        
    public static class Holder< @NonEmpty T > extends @NonEmpty Object {
        public void method() throws @NonEmpty Exception {           
        }
    }
        
    @SuppressWarnings( "unused" )
    public static void main(String[] args) {
        final Holder< String > holder = new @NonEmpty Holder< String >();       
        @NonEmpty Collection< @NonEmpty String > strings = new ArrayList<>();       
    }
}
```

**ElementType.TYPE_USER** 和 **ElementType.TYPE_PARAMETER** 是 Java 8 新增的两个注解，用于描述注解的使用场景。Java 语言也做了对应的改变，以识别这些新增的注解。

3.1 参数名称
--------

为了在运行时获得 Java 程序中方法的参数名称，老一辈的 Java 程序员必须使用不同方法，例如 [Paranamer liberary](https://links.jianshu.com/go?to=https%3A%2F%2Fgithub.com%2Fpaul-hammant%2Fparanamer)。Java 8 终于将这个特性规范化，在语言层面（使用反射 API 和 **Parameter.getName() 方法**）和字节码层面（使用新的 **javac** 编译器以及 **-parameters** 参数）提供支持。

```
package com.javacodegeeks.java8.parameter.names;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterNames {
    public static void main(String[] args) throws Exception {
        Method method = ParameterNames.class.getMethod( "main", String[].class );
        for( final Parameter parameter: method.getParameters() ) {
            System.out.println( "Parameter: " + parameter.getName() );
        }
    }
}
```

在 Java 8 中这个特性是默认关闭的，因此如果不带 **-parameters** 参数编译上述代码并运行，则会输出如下结果：

如果带 **-parameters** 参数，则会输出如下结果（正确的结果）：

如果你使用 Maven 进行项目管理，则可以在 **maven-compiler-plugin** 编译器的配置项中配置 **-parameters** 参数：

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.1</version>
    <configuration>
        <compilerArgument>-parameters</compilerArgument>
        <source>1.8</source>
        <target>1.8</target>
    </configuration>
</plugin>
```

Java 8 增加了很多新的工具类（date/time 类），并扩展了现存的工具类，以支持现代的并发编程、函数式编程等。

4.1 Optional
------------

Java 应用中最常见的 bug 就是[空值异常](https://links.jianshu.com/go?to=http%3A%2F%2Fexamples.javacodegeeks.com%2Fjava-basics%2Fexceptions%2Fjava-lang-nullpointerexception-how-to-handle-null-pointer-exception%2F)。在 Java 8 之前，[Google Guava](https://links.jianshu.com/go?to=http%3A%2F%2Fcode.google.com%2Fp%2Fguava-libraries%2F) 引入了 **Optionals** 类来解决 **NullPointerException**，从而避免源码被各种 **null** 检查污染，以便开发者写出更加整洁的代码。Java 8 也将 **Optional** 加入了官方库。

**Optional** 仅仅是一个容易：存放 T 类型的值或者 null。它提供了一些有用的接口来避免显式的 null 检查，可以参考 [Java 8 官方文档](https://links.jianshu.com/go?to=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F8%2Fdocs%2Fapi%2F)了解更多细节。

接下来看一点使用 **Optional** 的例子：可能为空的值或者某个类型的值：

```
Optional< String > fullName = Optional.ofNullable( null );
System.out.println( "Full Name is set? " + fullName.isPresent() );        
System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) ); 
System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
```

如果 **Optional** 实例持有一个非空值，则 **isPresent()** 方法返回 true，否则返回 false；**orElseGet()** 方法，**Optional** 实例持有 null，则可以接受一个 lambda 表达式生成的默认值；**map()** 方法可以将现有的 **Opetional** 实例的值转换成新的值；**orElse()** 方法与 **orElseGet()** 方法类似，但是在持有 null 的时候返回传入的默认值。

上述代码的输出结果如下：

```
Full Name is set? false
Full Name: [none]
Hey Stranger!
```

再看下另一个简单的例子：

```
Optional< String > firstName = Optional.of( "Tom" );
System.out.println( "First Name is set? " + firstName.isPresent() );        
System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) ); 
System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
System.out.println();
```

这个例子的输出是：

```
First Name is set? true
First Name: Tom
Hey Tom!
```

如果想了解更多的细节，请参考[官方文档](https://links.jianshu.com/go?to=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F8%2Fdocs%2Fapi%2Fjava%2Futil%2FOptional.html)。

4.2 Streams
-----------

新增的 [Stream API](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F05%2Fthe-effects-of-programming-with-java-8-streams-on-algorithm-performance.html)（java.util.stream）将生成环境的函数式编程引入了 Java 库中。这是目前为止最大的一次对 Java 库的完善，以便开发者能够写出更加有效、更加简洁和紧凑的代码。

Stream API 极大得简化了集合操作（后面我们会看到不止是集合），首先看下这个叫 Task 的类：

```
public class Streams  {
    private enum Status {
        OPEN, CLOSED
    };
    
    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }
        
        public Integer getPoints() {
            return points;
        }
        
        public Status getStatus() {
            return status;
        }
        
        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }
}
```

Task 类有一个分数（或伪复杂度）的概念，另外还有两种状态：OPEN 或者 CLOSED。现在假设有一个 task 集合：

```
final Collection< Task > tasks = Arrays.asList(
    new Task( Status.OPEN, 5 ),
    new Task( Status.OPEN, 13 ),
    new Task( Status.CLOSED, 8 ) 
);
```

首先看一个问题：在这个 task 集合中一共有多少个 OPEN 状态的点？在 Java 8 之前，要解决这个问题，则需要使用 **foreach** 循环遍历 task 集合；但是在 Java 8 中可以利用 steams 解决：包括一系列元素的列表，并且支持顺序和并行处理。

```
final long totalPointsOfOpenTasks = tasks
    .stream()
    .filter( task -> task.getStatus() == Status.OPEN )
    .mapToInt( Task::getPoints )
    .sum();
        
System.out.println( "Total points: " + totalPointsOfOpenTasks );
```

运行这个方法的控制台输出是：

这里有很多知识点值得说。首先，tasks 集合被转换成 steam 表示；其次，在 steam 上的 **filter** 操作会过滤掉所有 CLOSED 的 task；第三，**mapToInt** 操作基于每个 task 实例的 **Task::getPoints** 方法将 task 流转换成 Integer 集合；最后，通过 **sum** 方法计算总和，得出最后的结果。

在学习下一个例子之前，还需要记住一些 steams（[点此更多细节](https://links.jianshu.com/go?to=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F8%2Fdocs%2Fapi%2Fjava%2Futil%2Fstream%2Fpackage-summary.html%23StreamOps)）的知识点。Steam 之上的操作可分为中间操作和晚期操作。

中间操作会返回一个新的 steam——执行一个中间操作（例如 **filter**）并不会执行实际的过滤操作，而是创建一个新的 steam，并将原 steam 中符合条件的元素放入新创建的 steam。

晚期操作（例如 **forEach** 或者 **sum**），会遍历 steam 并得出结果或者附带结果；在执行晚期操作之后，steam 处理线已经处理完毕，就不能使用了。在几乎所有情况下，晚期操作都是立刻对 steam 进行遍历。

steam 的另一个价值是创造性地支持并行处理（parallel processing）。对于上述的 tasks 集合，我们可以用下面的代码计算所有任务的点数之和：

```
final double totalPoints = tasks
   .stream()
   .parallel()
   .map( task -> task.getPoints() ) 
   .reduce( 0, Integer::sum );
    
System.out.println( "Total points (all tasks): " + totalPoints );
```

这里我们使用 **parallel** 方法并行处理所有的 task，并使用 **reduce** 方法计算最终的结果。控制台输出如下：

```
Total points（all tasks）: 26.0
```

对于一个集合，经常需要根据某些条件对其中的元素分组。利用 steam 提供的 API 可以很快完成这类任务，代码如下：

```
final Map< Status, List< Task > > map = tasks
    .stream()
    .collect( Collectors.groupingBy( Task::getStatus ) );
System.out.println( map );
```

控制台的输出如下：

```
{CLOSED=[[CLOSED, 8]], OPEN=[[OPEN, 5], [OPEN, 13]]}
```

最后一个关于 tasks 集合的例子问题是：如何计算集合中每个任务的点数在集合中所占的比重，具体处理的代码如下：

```
final Collection< String > result = tasks
    .stream()                                        
    .mapToInt( Task::getPoints )                     
    .asLongStream()                                  
    .mapToDouble( points -> points / totalPoints )   
    .boxed()                                         
    .mapToLong( weigth -> ( long )( weigth * 100 ) ) 
    .mapToObj( percentage -> percentage + "%" )      
    .collect( Collectors.toList() );                 
        
System.out.println( result );
```

控制台输出结果如下：

最后，正如之前所说，Steam API 不仅可以作用于 Java 集合，传统的 IO 操作（从文件或者网络一行一行得读取数据）可以受益于 steam 处理，这里有一个小例子：

```
final Path path = new File( filename ).toPath();
try( Stream< String > lines = Files.lines( path, StandardCharsets.UTF_8 ) ) {
    lines.onClose( () -> System.out.println("Done!") ).forEach( System.out::println );
}
```

Stream 的方法 **onClose** 返回一个等价的有额外句柄的 Stream，当 Stream 的 close（）方法被调用的时候这个句柄会被执行。Stream API、Lambda 表达式还有接口默认方法和静态方法支持的方法引用，是 Java 8 对软件开发的现代范式的响应。

4.3 Date/Time API(JSR 310)
--------------------------

Java 8 引入了[新的 Date-Time API(JSR 310)](https://links.jianshu.com/go?to=https%3A%2F%2Fjcp.org%2Fen%2Fjsr%2Fdetail%3Fid%3D310) 来改进时间、日期的处理。时间和日期的管理一直是最令 Java 开发者痛苦的问题。**java.util.Date** 和后来的 **java.util.Calendar** 一直没有解决这个问题（甚至令开发者更加迷茫）。

因为上面这些原因，诞生了第三方库 [Joda-Time](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.joda.org%2Fjoda-time%2F)，可以替代 Java 的时间管理 API。Java 8 中新的时间和日期管理 API 深受 Joda-Time 影响，并吸收了很多 Joda-Time 的精华。新的 java.time 包包含了所有关于日期、时间、时区、Instant（跟日期类似但是精确到纳秒）、duration（持续时间）和时钟操作的类。新设计的 API 认真考虑了这些类的不变性（从 java.util.Calendar 吸取的教训），如果某个实例需要修改，则返回一个新的对象。

我们接下来看看 java.time 包中的关键类和各自的使用例子。首先，**Clock** 类使用时区来返回当前的纳秒时间和日期。**Clock** 可以替代 **System.currentTimeMillis()** 和 **TimeZone.getDefault()**。

```
final Clock clock = Clock.systemUTC();
System.out.println( clock.instant() );
System.out.println( clock.millis() );
```

这个例子的输出结果是：

```
2014-04-12T15:19:29.282Z
```

第二，关注下 **LocalDate** 和 **LocalTime** 类。**LocalDate** 仅仅包含 ISO-8601 日历系统中的日期部分；**LocalTime** 则仅仅包含该日历系统中的时间部分。这两个类的对象都可以使用 Clock 对象构建得到。

```
final LocalDate date = LocalDate.now();
final LocalDate dateFromClock = LocalDate.now( clock );
        
System.out.println( date );
System.out.println( dateFromClock );
        

final LocalTime time = LocalTime.now();
final LocalTime timeFromClock = LocalTime.now( clock );
        
System.out.println( time );
System.out.println( timeFromClock );
```

上述例子的输出结果如下：

```
2014-04-12
2014-04-12
11:25:54.568
15:25:54.568
```

**LocalDateTime** 类包含了 LocalDate 和 LocalTime 的信息，但是不包含 ISO-8601 日历系统中的时区信息。这里有一些[关于 LocalDate 和 LocalTime 的例子](https://links.jianshu.com/go?to=https%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F04%2Fjava-8-date-time-api-tutorial-localdatetime.html)：

```
final LocalDateTime datetime = LocalDateTime.now();
final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );
        
System.out.println( datetime );
System.out.println( datetimeFromClock );
```

上述这个例子的输出结果如下：

```
2014-04-12T11:37:52.309
2014-04-12T15:37:52.309
```

如果你需要特定时区的 data/time 信息，则可以使用 **ZoneDateTime**，它保存有 ISO-8601 日期系统的日期和时间，而且有时区信息。下面是一些使用不同时区的例子：

```
final ZonedDateTime zonedDatetime = ZonedDateTime.now();
final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );
        
System.out.println( zonedDatetime );
System.out.println( zonedDatetimeFromClock );
System.out.println( zonedDatetimeFromZone );
```

这个例子的输出结果是：

```
2014-04-12T11:47:01.017-04:00[America/New_York]
2014-04-12T15:47:01.017Z
2014-04-12T08:47:01.017-07:00[America/Los_Angeles]
```

最后看下 **Duration** 类，它持有的时间精确到秒和纳秒。这使得我们可以很容易得计算两个日期之间的不同，例子代码如下：

```
final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );

final Duration duration = Duration.between( from, to );
System.out.println( "Duration in days: " + duration.toDays() );
System.out.println( "Duration in hours: " + duration.toHours() );
```

这个例子用于计算 2014 年 4 月 16 日和 2015 年 4 月 16 日之间的天数和小时数，输出结果如下：

```
Duration in days: 365
Duration in hours: 8783
```

对于 Java 8 的新日期时间的总体印象还是比较积极的，一部分是因为 Joda-Time 的积极影响，另一部分是因为官方终于听取了开发人员的需求。如果希望了解更多细节，可以参考[官方文档](https://links.jianshu.com/go?to=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2Ftutorial%2Fdatetime%2Findex.html)。

4.4 Nashorn JavaScript 引擎
-------------------------

Java 8 提供了新的 [Nashorn JavaScript 引擎](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F02%2Fjava-8-compiling-lambda-expressions-in-the-new-nashorn-js-engine.html)，使得我们可以在 JVM 上开发和运行 JS 应用。Nashorn JavaScript 引擎是 javax.script.ScriptEngine 的另一个实现版本，这类 Script 引擎遵循相同的规则，允许 Java 和 JavaScript 交互使用，例子代码如下：

```
ScriptEngineManager manager = new ScriptEngineManager();
ScriptEngine engine = manager.getEngineByName( "JavaScript" );
        
System.out.println( engine.getClass().getName() );
System.out.println( "Result:" + engine.eval( "function f() { return 1; }; f() + 1;" ) );
```

这个代码的输出结果如下：

```
jdk.nashorn.api.scripting.NashornScriptEngine
Result: 2
```

4.5 Base64
----------

[对 Base64 编码的支持](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2014%2F04%2Fbase64-in-java-8-its-not-too-late-to-join-in-the-fun.html)已经被加入到 Java 8 官方库中，这样不需要使用第三方库就可以进行 Base64 编码，例子代码如下：

```
package com.javacodegeeks.java8.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64s {
    public static void main(String[] args) {
        final String text = "Base64 finally in Java 8!";
        
        final String encoded = Base64
            .getEncoder()
            .encodeToString( text.getBytes( StandardCharsets.UTF_8 ) );
        System.out.println( encoded );
        
        final String decoded = new String( 
            Base64.getDecoder().decode( encoded ),
            StandardCharsets.UTF_8 );
        System.out.println( decoded );
    }
}
```

这个例子的输出结果如下：

```
QmFzZTY0IGZpbmFsbHkgaW4gSmF2YSA4IQ==
Base64 finally in Java 8!
```

新的 Base64API 也支持 URL 和 MINE 的编码解码。  
(__Base64._getUrlEncoder_()** / __Base64._getUrlDecoder_()**, __Base64._getMimeEncoder_()** / __Base64._getMimeDecoder_()**)。

4.6 并行数组
--------

Java8 版本新增了很多新的方法，用于支持并行数组处理。最重要的方法是 **parallelSort()**，可以显著加快多核机器上的数组排序。下面的例子论证了 **parallexXxx** 系列的方法：

```
package com.javacodegeeks.java8.parallel.arrays;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ParallelArrays {
    public static void main( String[] args ) {
        long[] arrayOfLong = new long [ 20000 ];        
        
        Arrays.parallelSetAll( arrayOfLong, 
            index -> ThreadLocalRandom.current().nextInt( 1000000 ) );
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
            i -> System.out.print( i + " " ) );
        System.out.println();
        
        Arrays.parallelSort( arrayOfLong );     
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
            i -> System.out.print( i + " " ) );
        System.out.println();
    }
}
```

上述这些代码使用 **parallelSetAll()** 方法生成 20000 个随机数，然后使用 **parallelSort()** 方法进行排序。这个程序会输出乱序数组和排序数组的前 10 个元素。上述例子的代码输出的结果是：

```
Unsorted: 591217 891976 443951 424479 766825 351964 242997 642839 119108 552378 
Sorted: 39 220 263 268 325 607 655 678 723 793
```

4.7 并发性
-------

基于新增的 lambda 表达式和 steam 特性，为 Java 8 中为 **java.util.concurrent.ConcurrentHashMap** 类添加了新的方法来支持聚焦操作；另外，也为 **java.util.concurrentForkJoinPool** 类添加了新的方法来支持通用线程池操作（更多内容可以参考[我们的并发编程课程](https://links.jianshu.com/go?to=http%3A%2F%2Facademy.javacodegeeks.com%2Fcourse%2Fjava-concurrency-essentials%2F)）。

Java 8 还添加了新的 **java.util.concurrent.locks.StampedLock** 类，用于支持基于容量的锁——该锁有三个模型用于支持读写操作（可以把这个锁当做是 **java.util.concurrent.locks.ReadWriteLock** 的替代者）。

在 **java.util.concurrent.atomic** 包中也新增了不少工具类，列举如下：

*   DoubleAccumulator
*   DoubleAdder
*   LongAccumulator
*   LongAdder

Java 8 提供了一些新的命令行工具，这部分会讲解一些对开发者最有用的工具。

5.1 Nashorn 引擎：jjs
------------------

**jjs** 是一个基于标准 Nashorn 引擎的命令行工具，可以接受 js 源码并执行。例如，我们写一个 **func.js** 文件，内容如下：

```
function f() { 
     return 1; 
}; 

print( f() + 1 );
```

可以在命令行中执行这个命令：`jjs func.js`，控制台输出结果是：

如果需要了解细节，可以参考[官方文档](https://links.jianshu.com/go?to=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F8%2Fdocs%2Ftechnotes%2Ftools%2Funix%2Fjjs.html)。

5.2 类依赖分析器：jdeps
----------------

**jdeps** 是一个相当棒的命令行工具，它可以展示包层级和类层级的 Java 类依赖关系，它以**.class** 文件、目录或者 Jar 文件为输入，然后会把依赖关系输出到控制台。

我们可以利用 jedps 分析下 Spring Framework 库，为了让结果少一点，仅仅分析一个 JAR 文件：**org.springframework.core-3.0.5.RELEASE.jar**。

```
jdeps org.springframework.core-3.0.5.RELEASE.jar
```

这个命令会输出很多结果，我们仅看下其中的一部分：依赖关系按照包分组，如果在 classpath 上找不到依赖，则显示 "not found".

```
org.springframework.core-3.0.5.RELEASE.jar -> C:\Program Files\Java\jdk1.8.0\jre\lib\rt.jar
   org.springframework.core (org.springframework.core-3.0.5.RELEASE.jar)
      -> java.io                                            
      -> java.lang                                          
      -> java.lang.annotation                               
      -> java.lang.ref                                      
      -> java.lang.reflect                                  
      -> java.util                                          
      -> java.util.concurrent                               
      -> org.apache.commons.logging                         not found
      -> org.springframework.asm                            not found
      -> org.springframework.asm.commons                    not found
   org.springframework.core.annotation (org.springframework.core-3.0.5.RELEASE.jar)
      -> java.lang                                          
      -> java.lang.annotation                               
      -> java.lang.reflect                                  
      -> java.util
```

更多的细节可以参考[官方文档](https://links.jianshu.com/go?to=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F8%2Fdocs%2Ftechnotes%2Ftools%2Funix%2Fjdeps.html)。

使用 **[Metaspace](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.javacodegeeks.com%2F2013%2F02%2Fjava-8-from-permgen-to-metaspace.html)**（[JEP 122](https://links.jianshu.com/go?to=http%3A%2F%2Fopenjdk.java.net%2Fjeps%2F122)）代替持久代（**PermGen** space）。在 JVM 参数方面，使用 **-XX:MetaSpaceSize** 和 **-XX:MaxMetaspaceSize** 代替原来的 **-XX:PermSize** 和 **-XX:MaxPermSize**。

通过为开发者提供很多能够提高生产力的特性，Java 8 使得 Java 平台前进了一大步。现在还不太适合将 Java 8 应用在生产系统中，但是在之后的几个月中 Java 8 的应用率一定会逐步提高（PS: 原文时间是 2014 年 5 月 9 日，现在在很多公司 Java 8 已经成为主流，我司由于体量太大，现在也在一点点上 Java 8，虽然慢但是好歹在升级了）。作为开发者，现在应该学习一些 Java 8 的知识，为升级做好准备。

关于 Spring：对于企业级开发，我们也应该关注 Spring 社区对 Java 8 的支持，可以参考这篇文章——[Spring 4 支持的 Java 8 新特性一览](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.infoq.com%2Fcn%2Farticles%2Fspring-4-java-8)

*   [What’s New in JDK 8](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.oracle.com%2Ftechnetwork%2Fjava%2Fjavase%2F8-whats-new-2157071.html)
*   [The Java Tutorials](https://links.jianshu.com/go?to=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2Ftutorial%2F)
*   [WildFly 8, JDK 8, NetBeans 8, Java EE](https://links.jianshu.com/go?to=http%3A%2F%2Fblog.arungupta.me%2F2014%2F03%2Fwildfly8-jdk8-netbeans8-javaee7-excellent-combo-enterprise-java%2F)
*   [Java 8 Tutorial](https://links.jianshu.com/go?to=http%3A%2F%2Fwinterbe.com%2Fposts%2F2014%2F03%2F16%2Fjava-8-tutorial%2F)
*   [JDK 8 Command-line Static Dependency Checker](https://links.jianshu.com/go?to=http%3A%2F%2Fmarxsoftware.blogspot.ca%2F2014%2F03%2Fjdeps.html)
*   [The Illuminating Javadoc of JDK](https://links.jianshu.com/go?to=http%3A%2F%2Fmarxsoftware.blogspot.ca%2F2014%2F03%2Filluminating-javadoc-of-jdk-8.html)
*   [The Dark Side of Java 8](https://links.jianshu.com/go?to=http%3A%2F%2Fblog.jooq.org%2F2014%2F04%2F04%2Fjava-8-friday-the-dark-side-of-java-8%2F)
*   [Installing Java™ 8 Support in Eclipse Kepler SR2](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.eclipse.org%2Fdownloads%2Fjava8%2F)
*   [Java 8](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.baeldung.com%2Fjava8)
*   [Oracle Nashorn. A Next-Generation JavaScript Engine for the JVM](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.oracle.com%2Ftechnetwork%2Farticles%2Fjava%2Fjf14-nashorn-2126515.html)

本号专注于后端技术、JVM 问题排查和优化、Java 面试题、个人成长和自我管理等主题，为读者提供一线开发者的工作和成长经验，期待你能在这里有所收获。

![][img-1]

javaadu

[img-0]:data:image/jpeg;base64,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

[img-1]:data:image/jpeg;base64,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