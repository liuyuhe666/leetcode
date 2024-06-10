# LeetCode 常用数据结构总结（Java 版）

🐳 总结一下刷 LeetCode 时，常用到的数据结构

## 数组

用来存储固定大小的同类型元素

创建数组

```java
int[] arr1 = {1, 2, 3, 4, 5};
int[] arr2 = new int[5];
```

遍历数组

```java
for (int i = 0; i < arr.length; i++) {
    int val = arr[i];
}
```

```java
for (int v : arr) {
    // For-Each 遍历
}
```

Arrays 类

`java.util.Arrays` 类提供了一些操作数组的静态方法

- 给数组赋值：fill 方法
- 对数组排序：sort 方法
- 比较数组：equals 方法
- 查找数组元素：通过 binarySearch 方法能对排序好的数组进行二分查找

```java
public static void main(String[] args) {
    int[] arr1 = new int[10];
    int[] arr2 = new int[10];
    // 数组赋值
    Arrays.fill(arr1, 1);
    Arrays.fill(arr2, 2);
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    // 数组比较
    boolean flag = Arrays.equals(arr1, arr2);
    System.out.println(flag);
    // 数组排序
    int[] arr = {5, 4, 3, 2, 1};
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    // 二分查找
    int res = Arrays.binarySearch(arr, 2);
    System.out.println(res);
}
```



## ArrayList

ArrayList 是一个可以动态修改的数组，和普通数组的区别就是它没有固定大小的限制。

添加元素

```java
// 添加元素
List<String> strList = new ArrayList<>();
strList.add("s1");
strList.add("s2");
strList.add("s3");
```



访问元素

```java
// 访问元素
System.out.println(strList.get(1)); // 第二个元素
System.out.println(strList.get(2)); // 第三个元素
```



修改元素

```java
// 修改元素
strList.set(2, "ss3");
System.out.println(strList.get(2));
```



删除元素

```java
// 删除元素
strList.remove(0);
System.out.println(strList);
```



遍历

```java
// 遍历
for (int i = 0; i < strList.size(); i++) {
    System.out.println(strList.get(i));
}
for (String str : strList) {
    System.out.println(str);
}
```



排序

```java
// 排序
ArrayList<String> sites = new ArrayList<>();
sites.add("taobao");
sites.add("wiki");
sites.add("runoob");
sites.add("weibo");
sites.add("google");
Collections.sort(sites);  // 字母排序
for (String i : sites) {
    System.out.println(i);
}
```

TODO: 阅读 ArrayList 类的源码

## LinkedList

与 ArrayList 相比，LinkedList 的增加和删除效率更高

创建链表

```java
// 创建链表
LinkedList<String> list = new LinkedList<>();
list.add("a");
list.add("b");
list.add("c");
list.add("d");
System.out.println(list);
```



开头添加元素

```java
// 开头添加元素
list.addFirst("e");
System.out.println(list);
```



开头删除元素

```java
// 开头删除元素
list.removeFirst();
System.out.println(list);
```



获取开头元素

```java
// 获取开头元素
String val = list.getFirst();
System.out.println(val);
```



结尾添加元素

```java
// 结尾添加元素
list.addLast("f");
System.out.println(list);
```



结尾删除元素

```java
// 结尾删除元素
list.removeFirst();
System.out.println(list);
```



获取结尾元素

```java
// 获取结尾元素
val = list.getLast();
System.out.println(val);
```

TODO: 阅读 LinkedList 类的源码

## TreeSet

TreeSet 是一种特殊类型的集合，它通过红黑树数据结构实现了有序的、唯一的元素存储

创建与初始化

```java
TreeSet<String> treeSet = new TreeSet<>();
```



添加元素

```java
// 添加元素
treeSet.add("A");
treeSet.add("B");
treeSet.add("Y");
treeSet.add("X");
System.out.println(treeSet);
```



查询元素

```java
// 查询元素
String first = treeSet.first();
System.out.println(first);
String last = treeSet.last();
System.out.println(last);
```



删除元素

```java
// 删除元素
treeSet.remove("X");
System.out.println(treeSet);
```



判断元素是否存在

```java
// 判断是否存在某个元素
boolean res = treeSet.contains("X");
System.out.println(res);
res = treeSet.contains("A");
System.out.println(res);
```

TODO: 阅读 TreeSet 类的源码

## TreeMap

TreeMap 底层是基于红黑树实现，该映射根据其键的自然顺序进行排序，或根据创建映射时提供的 Comparator 进行排序

添加元素

```java
TreeMap<String, Integer> map = new TreeMap<>();
map.put("a", 1);
map.put("b", 2);
map.put("c", 3);
System.out.println(map);
```



访问元素

```java
// 获取元素
int val = map.get("a");
System.out.println(val);
val = map.getOrDefault("d", 4);
System.out.println(val);
```



删除元素

```java
// 删除元素
val = map.remove("a");
System.out.println(val);
```

TODO: 阅读 TreeMap 类的源码

## HashSet

- HashSet 是基于 HashMap 来实现的，是一个不允许有重复元素的集合
- HashSet 允许有 null 值
- HashSet 是无序的
- HashSet 线程不安全
- HashSet 实现了 Set 接口

添加元素

```java
// 添加元素
HashSet<Integer> set = new HashSet<>();
set.add(1);
set.add(2);
set.add(3);
System.out.println(set);
```



判断元素是否存在

```java
// 判断元素是否存在
System.out.println(set.contains(1));
System.out.println(set.contains(6));
```



删除元素

```java
// 删除元素
set.remove(2);
System.out.println(set);
```



遍历

```java
// 遍历
for (Integer i : set) {
    System.out.println(i);
}
```

TODO: 阅读 HashSet 类的源码

## HashMap

- HashMap 是一个散列表，它存储的内容是键值对映射
- HashMap 实现了 Map 接口
- HashMap 是无序的

添加元素

```java
// 添加元素
HashMap<Integer, String> map = new HashMap<>();
map.put(1, "one");
map.put(2, "two");
map.put(3, "three");
System.out.println(map);
```



访问元素

```java
// 访问元素
System.out.println(map.get(1));
System.out.println(map.getOrDefault(5, "five"));
```



删除元素

```java
// 删除元素
System.out.println(map.remove(2));
System.out.println(map);
```



遍历

```java
// 遍历
for (Integer key : map.keySet()) {
    System.out.println(key + ":" + map.get(key));
}
for (String value : map.values()) {
    System.out.println(value);
}
```

TODO: 阅读 HashMap 类的源码

## PriorityQueue

PriorityQueue 类提供了堆数据结构的功能，它实现了 Queue 接口

创建 PriorityQueue

```java
// 创建优先队列
PriorityQueue<Integer> pq = new PriorityQueue<>();
```



添加元素

```java
// 添加元素
pq.add(4);
pq.add(2);
pq.add(1);
System.out.println(pq);
```



访问元素

```java
// 使用 peek() 方法
int num = pq.peek();
System.out.println(num);
```



删除元素

```java
// 删除元素
num = pq.poll();
System.out.println(num);
System.out.println(pq);
```

TODO: 阅读 PriorityQueue 类的源码

## Queue

Queue 是 Java 中实现队列的接口

常用方法：

- `add()` 将指定的元素插入队列，成功返回 true，否则将引发异常
- `offer()` 将指定元素插入队列，成功返回 true，否则返回 false
- `element()` 返回队列的开头，如果队列为空，则引发异常
- `peek()` 返回队列的开头，如果队列为空，则返回 null
- `remove()` 返回并删除队列的头部，如果队列为空，则引发异常
- `poll()` 返回并删除队列的开头，如果队列为空，则返回 null



## Deque

Deque 接口提供了双端队列的功能。它继承了 Queue 接口

实现 Deque 的类

- ArrayDeque
- LinkedList

由于Deque继承了Queue接口，因此它继承了Queue接口的所有方法。

除了Queue接口中可用的方法之外，Deque界面还包括以下方法：

- `addFirst()`  在双端队列的开头添加指定的元素。如果双端队列已满，则引发异常。
- `addLast()`  在双端队列的末尾添加指定的元素。如果双端队列已满，则引发异常。
- `offerFirst()`  在双端队列的开头添加指定的元素。如果双端队列已满，则返回false。
- `offerLast()`  在双端队列的末尾添加指定的元素。如果双端队列已满，则返回false。
- `getFirst()`  返回双端队列的第一个元素。如果双端队列为空，则引发异常。
- `getLast()`  返回双端队列的最后一个元素。如果双端队列为空，则引发异常。
- `peekFirst()`  返回双端队列的第一个元素。如果双端队列为空，则返回null。
- `peekLast()`  返回双端队列的最后一个元素。如果双端队列为空，则返回null。
- `removeFirst()`  返回并删除双端队列的第一个元素。如果双端队列为空，则引发异常。
- `removeLast()`  返回并删除双端队列的最后一个元素。如果双端队列为空，则引发异常。
- `pollFirst()`  返回并删除双端队列的第一个元素。如果双端队列为空，则返回null。
- `pollLast()`  返回并删除双端队列的最后一个元素。如果双端队列为空，则返回null。

## Stack

Java  Collections 框架的 Stack 类提供了栈的实现

但是，建议使用 Deque 而不是 Stack

因为 Stack 的方法是同步的

以下是 Deque 接口提供的用于实现栈的方法：

- `push()`  在双端队列的开头添加元素
- `pop()` 从双端队列的开头删除元素
- `peek()`  从双端队列的开头返回一个元素

## 参考资料

- [Java 8 文档](https://docs.oracle.com/javase/8/docs/api/)
- [Java 教程 | 菜鸟教程 (runoob.com)](https://www.runoob.com/java/java-tutorial.html)
- [菜鸟教程 - 做更好的自己！ (cainiaojc.com)](https://www.cainiaojc.com/)
