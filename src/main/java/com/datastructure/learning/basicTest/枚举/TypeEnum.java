package com.datastructure.learning.basicTest.枚举;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description:
 */
public enum TypeEnum {
    VIDEO(1, "视频"), AUDIO(2, "音频"), TEXT(3, "文本"), IMAGE(4, "图像");

    int value;
    String name;

    /**
     * 如果要为每个枚举值指定属性，则在枚举中必须声明一个参数为属性对应类型的构造方法（不能是public）。
     * 否则编译器将给出The constructor TypeEnum(int, String) is undefined的错误
     */
    TypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    //遍历
    public static TypeEnum getByValue(int value) {
        for (TypeEnum typeEnum : TypeEnum.values()) {
            if (typeEnum.value == value) {
                return typeEnum;
            }
        }
        throw new IllegalArgumentException("No element matches " + value);
    }

    public static void main(String[] args) {
        TypeEnum type = TypeEnum.TEXT;
        System.out.println(type.getValue() + "----" + type.getName());//3---文本
    }
}

/**
 * 常见的枚举内置方法：
 * int compareTo(E o) //比较此枚举与指定对象的顺序。
 * Class<E> getDeclaringClass() //返回与此枚举常量的枚举类型相对应的 Class 对象。
 * String name() // 返回此枚举常量的名称，在其枚举声明中对其进行声明。
 * int ordinal() //返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）。
 * String toString()//返回枚举常量的名称，它包含在声明中。
 * static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) //返回带指定名称的指定枚举类型的枚举常量。
 * static T[] values()//返回该枚举的所有值。
 * <p>
 * 在JDK5中新引入的枚举完美地解决了之前通过常量来表示离散量所带来的问题，大大加强了程序的可读性、易用性和可维护性，并且在此基础之上又进行了扩展，
 * 使之可以像类一样去使用，更是为Java对离散量的表示上升了一个台阶。因此，如果在Java中需要表示诸如颜色、方式、类别、状态等等数目有限、形式离散、表达又极为明确的量，
 * 应当尽量舍弃常量表示的做法，而将枚举作为首要的选择。
 * <p>
 * 在JDK5中新引入的枚举完美地解决了之前通过常量来表示离散量所带来的问题，大大加强了程序的可读性、易用性和可维护性，并且在此基础之上又进行了扩展，
 * 使之可以像类一样去使用，更是为Java对离散量的表示上升了一个台阶。因此，如果在Java中需要表示诸如颜色、方式、类别、状态等等数目有限、形式离散、表达又极为明确的量，
 * 应当尽量舍弃常量表示的做法，而将枚举作为首要的选择。
 * <p>
 * 在JDK5中新引入的枚举完美地解决了之前通过常量来表示离散量所带来的问题，大大加强了程序的可读性、易用性和可维护性，并且在此基础之上又进行了扩展，
 * 使之可以像类一样去使用，更是为Java对离散量的表示上升了一个台阶。因此，如果在Java中需要表示诸如颜色、方式、类别、状态等等数目有限、形式离散、表达又极为明确的量，
 * 应当尽量舍弃常量表示的做法，而将枚举作为首要的选择。
 * <p>
 * 在JDK5中新引入的枚举完美地解决了之前通过常量来表示离散量所带来的问题，大大加强了程序的可读性、易用性和可维护性，并且在此基础之上又进行了扩展，
 * 使之可以像类一样去使用，更是为Java对离散量的表示上升了一个台阶。因此，如果在Java中需要表示诸如颜色、方式、类别、状态等等数目有限、形式离散、表达又极为明确的量，
 * 应当尽量舍弃常量表示的做法，而将枚举作为首要的选择。
 * <p>
 * 在JDK5中新引入的枚举完美地解决了之前通过常量来表示离散量所带来的问题，大大加强了程序的可读性、易用性和可维护性，并且在此基础之上又进行了扩展，
 * 使之可以像类一样去使用，更是为Java对离散量的表示上升了一个台阶。因此，如果在Java中需要表示诸如颜色、方式、类别、状态等等数目有限、形式离散、表达又极为明确的量，
 * 应当尽量舍弃常量表示的做法，而将枚举作为首要的选择。
 * <p>
 * 在JDK5中新引入的枚举完美地解决了之前通过常量来表示离散量所带来的问题，大大加强了程序的可读性、易用性和可维护性，并且在此基础之上又进行了扩展，
 * 使之可以像类一样去使用，更是为Java对离散量的表示上升了一个台阶。因此，如果在Java中需要表示诸如颜色、方式、类别、状态等等数目有限、形式离散、表达又极为明确的量，
 * 应当尽量舍弃常量表示的做法，而将枚举作为首要的选择。
 */

/**
 * 在JDK5中新引入的枚举完美地解决了之前通过常量来表示离散量所带来的问题，大大加强了程序的可读性、易用性和可维护性，并且在此基础之上又进行了扩展，
 * 使之可以像类一样去使用，更是为Java对离散量的表示上升了一个台阶。因此，如果在Java中需要表示诸如颜色、方式、类别、状态等等数目有限、形式离散、表达又极为明确的量，
 * 应当尽量舍弃常量表示的做法，而将枚举作为首要的选择。
 */
