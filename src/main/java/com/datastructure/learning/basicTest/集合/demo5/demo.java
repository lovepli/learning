package com.datastructure.learning.basicTest.集合.demo5;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description: 要对集合更新操作时， ArrayList 和 LinkedList 哪个更适合？
 */
public class demo {

    /**
     *要对集合更新操作时， ArrayList 和 LinkedList 哪个更适合？
     *
     * 1.ArrayList 是实现了基于动态数组的数据结构， LinkedList 基于链表的数据结构。
     * 2.如果集合数据是对于集合随机访问 get 和 set， ArrayList 绝对优于 LinkedList，因为 LinkedList 要移动指针。
     * 3.如果集合数据是对于集合新增和删除操作 add 和 remove， LinedList 比较占优势，因为 ArrayList 要移动数
     * 据。
     * ArrayList 和 LinkedList 是两个集合类，用于存储一系列的对象引用(references)。例如我们可以用 ArrayList 来
     * 存储一系列的 String 或者 Integer。那 么 ArrayList 和 LinkedList 在性能上有什么差别呢？什么时候应该用 ArrayList
     * 什么时候又该用 LinkedList 呢？
     * 一． 时间复杂度
     * 首先一点关键的是， ArrayList 的内部实现是基于基础的对象数组的，因此，它使用 get 方法访问列表中的任意一
     * 个元素时(random access)，它的速度要比 LinkedList 快。 LinkedList 中的 get 方法是按照顺序从列表的一端开始检
     * 查，直到另外一端。对 LinkedList 而言，访问列表中的某个指定元素没有更快的方法了
     *
     * 假设我们有一个很大的列表，它里面的元素已经排好序了，这个列表可能是 ArrayList 类型的也可能是 LinkedList
     * 类型的，现在我们对这个列表来进行二分查找(binary search)，比较列表是 ArrayList 和 LinkedList 时的查询速度，
     * 看下面的程序：
     *
     * 得到的输出是：
     * 1. ArrayList 消耗时间： 15
     * 2. LinkedList 消耗时间： 2596
     * 这个结果不是固定的，但是基本上 ArrayList 的时间要明显小于 LinkedList 的时间。因此在这种情况下不宜用
     * LinkedList。二分查找法使用的随机访问(random access)策略，而 LinkedList 是不支持快速的随机访问的。对一个
     * LinkedList 做随机访问所消耗的时间与这个 list 的大小是成比例的。而相应的，在 ArrayList 中进行随机访问所消耗的
     * 时间是固定的。
     * 这是否表明 ArrayList 总是比 LinkedList 性能要好呢？这并不一定，在某些情况下 LinkedList 的表现要优于
     * ArrayList，有些算法在 LinkedList 中实现 时效率更高。比方说，利用 Collections.reverse 方法对列表进行反转时，
     * 其性能就要好些。看这样一个例子，加入我们有一个列表，要对其进行大量的插入和删除操作，在这种情况下 LinkedList
     * 就是一个较好的选择。请看如下一个极端的例子，我们重复的在一个列表的开端插入一个元素：
     *
     * 这时我的输出结果是
     * 1. ArrayList 耗时： 2463
     * 2. LinkedList 耗时： 15
     * 二． 空间复杂度
     * 在 LinkedList 中有一个私有的内部类，定义如下：
     *     private static class Entry {
     *     Object element;
     *      Entry next;
     *      Entry previous;
     *      }
     *
     *  每个 Entry 对象 reference 列表 中的一个元素，同时还有在 LinkedList 中它的上一个元素和下一个元素。一个
     * 有 1000 个元素的 LinkedList 对象将有 1000 个链接在一起 的 Entry 对象，每个对象都对应于列表中的一个元素。
     * 这样的话，在一个 LinkedList 结构中将有一个很大的空间开销，因为它要存储这 1000 个 Entity 对象的相关信息。
     * ArrayList 使用一个内置的数组来存 储元素，这个数组的起始容量是 10.当数组需要增长时，新的容量按如下公
     * 式获得：新容量=(旧容量*3)/2+1，也就是说每一次容量大概会增长 50%。 这就意味着，如果你有一个包含大量元
     * 素的 ArrayList 对象，那么最终将有很大的空间会被浪费掉，这个浪费是由 ArrayList 的工作方式本身造成 的。如果
     * 没有足够的空间来存放新的元素，数组将不得不被重新进行分配以便能够增加新的元素。对数组进行重新分配，将会
     * 导致性能急剧下降。如果我们知道一个 ArrayList 将会有多少个元素，我们可以通过构造方法来指定容量。我们还可
     * 以通过 trimToSize 方法在 ArrayList 分配完毕之后去掉浪 费掉的空间。
     * 三．总结
     * ArrayList 和 LinkedList 在性能上各有优缺点，都有各自所适用的地方，总的说来可以描述如下：
     * 1．对 ArrayList 和 LinkedList 而言，在列表末尾增加一个元素所花的开销都是固定的。对 ArrayList 而言，主
     * 要是在内部数组中增加一项，指向所添加的元素，偶 尔可能会导致对数组重新进行分配；而对 LinkedList 而言，这
     * 个开销是统一的，分配一个内部 Entry 对象。
     * 2．在 ArrayList 的中间插入或删除一个元素意味着这个列表中剩余的元素都会被移动；而在 LinkedList 的中间
     * 插入或删除一个元素的开销是固定的。
     * 3． LinkedList 不支持高效的随机元素访问。
     * 4． ArrayList 的空间浪费主要体现在在 list 列表的结尾预留一定的容量空间，而 LinkedList 的空间花费则体现在
     * 它的每一个元素都需要消耗相当的空间
     * 可以这样说：当操作是在一列数据的后面添加数据而不是在前面或中间,并且需要随机地访问其中的元素时,使用
     * ArrayList 会提供比较好的性能；当你的操作是在一列数据的前面或中间添加或删除数据,并且按照顺序访问其中的元
     * 素时,就应该使用 LinkedList 了。
     */
}
