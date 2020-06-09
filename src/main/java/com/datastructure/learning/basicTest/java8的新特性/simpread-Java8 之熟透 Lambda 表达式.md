> 本文由 [简悦 SimpRead](http://ksria.com/simpread/) 转码， 原文地址 https://www.cnblogs.com/zhangyinhua/p/11558510.html

### 一、Lambda 简述

#### 1.1、Lambda 概述

​ **Lambda 表达式**可以理解为简洁地表示可传递的匿名函数的一种方式：它没有名称，但它有参数列表、函数主体、返回类型，可能还有一个可以抛出的异常列表。

*   **匿名**：它不像普通方法那样有一个明确的名称；
*   **函数**：Lambda 表达式是函数是因为它不像方法那样属于某个特定的类，但和方法一样，Lambda 有参数列表、函数主体、返回类型，还可能有可以抛出的异常列表；
*   **传递**：Lambda 表达式可以作为参数传递给方法或存储在变量中；
*   **简洁**：无需像匿名类那样写很多模板代码；

So That:

*   lambada 表达式实质上是一个匿名方法，但该方法并非独立执行，而是用于**实现由函数式接口定义的唯一抽象方法**
*   使用 lambda 表达式时，会创建实现了函数式接口的一个匿名类实例
*   可以将 lambda 表达式视为一个对象，可以将其作为参数传递

#### 1.2、Lambda 简介

Lambda 表达式是一个**匿名函数**（对于 Java 而言并不很准确，但这里我们不纠结这个问题）。简单来说，这是一种**没有声明的方法，即没有访问修饰符，返回值声明和名称**。

Java 中的 Lambda 表达式通常使用语法是 `(argument) -> (body)`:

```
(arg1, arg2...) -> { body }
(type1 arg1, type2 arg2...) -> { body }
```

Lambda 表达式举例:

```
(int a, int b) -> {  return a + b; }
() -> System.out.println("Hello World");
(String s) -> { System.out.println(s); }
() -> 42
() -> { return 3.1415 };
```

#### 1.3、Lambda 表达式组成与结构

##### 1.3.1、Lambda 表达式组成

Lambda 表达式由参数列表、箭头和 Lambda 主体组成。

```
(Apple o1, Apple o2) -> Integer.valueOf(o1.getWeight()).compareTo(Integer.valueOf(o2.getWeight()))
```

1.  **参数列表：**这里采用了 Comparator 中 compareTo 方法的参数；
2.  **箭头：**箭头把参数列表和 Lambda 主体分开；
3.  **Lambda 主体：**表达式就是 Lambda 的返回值；

##### 1.3.2、Lambda 表达式结构

**1）Lambda 表达式的结构**

*   Lambda 表达式可以具有零个，一个或多个参数。
*   可以显式声明参数的类型，也可以由编译器自动从上下文推断参数的类型。例如 `(int a)` 与刚才相同 `(a)`。
*   参数用小括号括起来，用逗号分隔。例如 `(a, b)` 或 `(int a, int b)` 或 `(String a, int b, float c)`。
*   空括号用于表示一组空的参数。例如 `() -> 42`。
*   当有且仅有一个参数时，如果不显式指明类型，则不必使用小括号。例如 `a -> return a*a`。
*   Lambda 表达式的正文可以包含零条，一条或多条语句。
*   如果 Lambda 表达式的正文只有一条语句，则大括号可不用写，且表达式的返回值类型要与匿名函数的返回类型相同。
*   如果 Lambda 表达式的正文有一条以上的语句必须包含在大括号（代码块）中，且表达式的返回值类型要与匿名函数的返回类型相同。

**2）有效 Lambda 表达式举例**

```
表达式具有一个 String 类型的参数并返回一个 int。 Lambda 没有 return 语句，因为已经隐含的 return，可以显示调用 return。
```

**3）Lambda 表达式的使用举例**

```
(List list) -> list.isEmpty()
```

### 二、使用 Lambda 表达式

#### 2.1、函数式接口

**函数式接口**就是只定义一个抽象方法的接口，比如 Java API 中的 Predicate、Comparator 和 Runnable 等。

```
public interface Predicate<T> {
    boolean test(T t);
}
public interface Comparator<T> {
    int compare(T o1, T o2);
}
public interface Runnable {
    void run();
}
```

函数式接口作用是什么？

Lambda 表达式允许你直接以内联的形式为函数式接口的抽象方法提供实现，并把整个表达式作为函数式接口的实例（具体说来，是函数式接口一个具体实现 的实例）。你用匿名内部类也可以完成同样的事情，只不过比较笨拙：需要提供一个实现，然后 再直接内联将它实例化。

下面的代码是有效的，因为 Runnable 是一个只定义了一个抽象方法 run 的函数式接口：

```
//使用Lambda
Runnable r1 = () -> System.out.println("Hello World 1");

//匿名类
Runnable r2 = new Runnable(){ 
    public void run(){ 
        System.out.println("Hello World 2"); 
    } 
};

public static void process(Runnable r){ 
    r.run(); 
} 

process(r1); //打印 "Hello World 1"
process(r2); //打印 "Hello World 2"
//利用直接传递的 Lambda 打印 "Hello World 3"
process(() -> System.out.println("Hello World 3"));
```

#### 2.2、通过示例感受 Lambda

1）之前做法

```
Comparator<Apple> byWeight = new Comparator<Apple>() {
public int compare(Apple a1, Apple a2){
return a1.getWeight().compareTo(a2.getWeight());
}
};
```

2）现在做法

```
Comparator<Apple> byWeight =
(Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
```

3）再通过一个明显的实例

```
public static void rawUseMethod(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        for (String str : names){
            System.out.println(str);
        }
    }

    public static void useLambda1(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names,(String a,String b) -> {
            return a.compareTo(b);
        });
        for (String str : names){
            System.out.println(str);
        }
    }

    public static void useLambda2(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
         Collections.sort(names,(String a,String b) -> a.compareTo(b));
        for (String str : names){
            System.out.println(str);
        }
    }

    public static void useLambda3(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.sort((String a,String b) -> a.compareTo(b));
        //当然也可以直接去掉参数类型，直接推导出来即可
        names.sort((a,b) -> a.compareTo(b));
        for (String str : names){
            System.out.println(str);
        }
    }
```

#### 2.3、Lambda 语法规则

![][img-0]  
Lambda 表达式有三个部分：  
1） 参数列表  
这里它采用了 Comparator 中 compare 方法的参数，两个 Apple。  
2）箭头  
箭头 -> 把参数列表与 Lambda 主体分隔开。  
3）Lambda 主体  
比较两个 Apple 的重量。表达式就是 Lambda 的返回值了。

为了进一步说明，下面给出了 Java 8 中五个有效的 Lambda 表达式的例子。  
![][img-1]

| 布尔表达式 | (List list) -> list.isEmpty() |
| --- | --- |
| 创建对象 | () -> new Apple(10) |
| 消费一个对象 | (Apple a) -> { System.out.println(a.getWeight()); } |
| 从一个对象中选择 / 抽取 | (String s) -> s.length() |
| 组合两个值 | (int a, int b) -> a * b |
| 比较两个对象 | (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()) |

### 三、Functional 接口（函数式接口）

#### 3.1、概述

"函数式接口" 是指仅仅只包含一个抽象方法的接口, 每一个函数式接口类型的 lambda 表达式都自动被匹配到这个抽象方法。因为 默认方法 不算抽象方法, 所以你也可以给你的函数式接口添加默认方法。

我们可以将 lambda 表达式当作任意只包含一个抽象方法的接口类型, 为了确保你的接口确实是达到这个要求的, 可以接口上添加 @FunctionalInterface 注解, 编译器如果发现你标注了这个注解的接口有多于一个抽象方法的时候会报错的。

#### 3.2、举例说明

1）定义函数式接口

```
//这个注解不加也可以,加上只是为了让编译器检查
	@FunctionalInterface
	interface Action{
		public void run();

		default void doSomething(){
			System.out.println("doSomething..");
		}
	}
	//这个注解不加也可以,加上只是为了让编译器检查
	@FunctionalInterface
	interface Work<T,V>{
		public V doWork(T t);
	}
```

2）使用

```
public class LambdaTest2 {
	
		public static void main(String[] args) {
			
			//原来的内部类实现方式
			test(new Action(){
				@Override
				public void run() {
					System.out.println("run..");
				}
			});
			
			//lambda表达式方法
			test(()->System.out.println("run"));

			
			//也可以先创建对象
			Action a = ()->System.out.println("run...");
			System.out.println(a.getClass());
			test(a);

			//接口中有泛型也可以,只关注方法的参数和返回值
			Work<String,Integer> w = (v)->v.length();
			run(w);

			run((v)->v.length());

			//如果参数只有一个,那么还可以这样简写: 去掉小括号
			//注意代码就一句,作为返回值的话不用写return
			run(v->v.length());
			
			//有多句代码,就需要写{}了,并且需要写return
			run(v->{
				System.out.println("doWork..");
				return v.length();
			});

			//观察下面代码是什么意思
			run(v->1);
			
		}

		public static void test(Action a){
			a.run();
			a.doSomething();
		}
		
		public static void run(Work<String,Integer> a){
			int i = a.doWork("hello");
			System.out.println(i);
		}
		
	}
```

**注意：**

lambda 表达式无法访问接口的默认方法, lambda 表达式只能去匹配对应接口中的唯一抽象方法。

相当于 lambda 表达式只是对抽象方法的实现, 并没有创建接口的实现类对象, 因为我们只是想使用这个抽象方法的实现。

[img-0]:data:image/jpeg;base64,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

[img-1]:data:image/jpeg;base64,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