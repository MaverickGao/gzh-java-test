package com.gzh.gzhjavatest.dataStructureAndAlgorithm.linkedList;

import java.util.Objects;

/**
 * 单向链表实现
 *
 * @author 高智恒
 */
public class SinglyLinkedListDemo<T> {

    /**
     * 链表的结点
     */
    private class Node {
        // 当前链表数据结点
        T data;

        // 下一结点指针
        Node next;

        // 结点的构造函数
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 头结点
     */
    private Node head = null;

    /**
     * 结点个数
     */
    private int size = 0;

    /**
     * 向链表中添加结点
     * 单向链表每次插入，都要先从头结点向后开始查找，找到末尾插入
     *
     * @param element 添加的元素
     */
    public void add(T element) {
        // 先创建结点，每次下结点指针都为null
        Node node = new Node(element, null);
        // 如果头节点为空，说明当前插入的是头结点
        if (Objects.isNull(this.head)) {
            this.head = node;
        } else {
            // 否则，需要找到最后一个结点，将这个结点的下结点指针，链接到当前结点
            Node endNode = getEndNode();
            endNode.next = node;
        }
        // 链表中元素+1
        this.size++;
    }

    /**
     * 遍历链表，得到末尾的结点
     *
     * @return 末尾的结点
     */
    private Node getEndNode() {
        // 结点遍历都是从头结点开始的
        Node tempNode = this.head;
        while (Objects.nonNull(tempNode)) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    /**
     * 得到链表中元素的个数
     *
     * @return 链表中元素的个数
     */
    public int Size() {
        return this.size;
    }

    /**
     * 得到指定位置的元素
     *
     * @param index 指定位置
     * @return 指定位置的元素
     */
    public T get(int index) throws Exception {
        // 判断 指定位置是否超限，如果超限需要报警
        checkIndex(index);
        // 仍然是从头开始遍历
        Node tempNode = this.head;
        for (int i = 0; i <= index; i++) {
            tempNode = tempNode.next;
        }
        // 如果刚初始完链表，还没有插入元素，说明元素中是空
        // 而且没有超限，所以返回null
        if (Objects.isNull(tempNode)) {
            return null;
        }
        return tempNode.data;
    }

    /**
     * 更新指定位置的元素
     *
     * @param index   指定位置
     * @param element 元素
     */
    public void update(int index, T element) throws Exception {
        // 判断 指定位置是否超限，如果超限需要报警
        checkIndex(index);
        // 如果当前链表还没有插入过元素，那么就不让他更新，报错
        if (Objects.isNull(this.head)) {
            throw new Exception("当前链表中不存在元素，请先插入一个");
        }
        // 循环到指定元素，替换即可
        Node tempNode = this.head;
        for (int i = 0; i <= index; i++) {
            tempNode = tempNode.next;
        }
        tempNode.data = element;
    }

    /**
     * 删除指定位置元素
     *
     * @param index 指定位置
     */
    private void remove(int index) throws Exception {
        // 判断 指定位置是否超限，如果超限需要报警
        checkIndex(index);
        // 如果当前链表还没有插入过元素，那么就不让他删除，报错
        if (Objects.isNull(this.head)) {
            throw new Exception("当前链表中不存在元素，请先插入一个");
        }
        // 元素删除总共有三种情况：
        // 第一种，删除头元素，那么只需要把头结点的下节点指针设为null，将下一结点设为头结点即可
        if (index == 0) {
            Node tempNode = this.head;
            this.head = tempNode.next;
            this.size--;
            return;
        }
        // 第二种，删除尾元素，那么就把倒数第二个元素的下一结点设置为空即可
        if (index == this.size - 1) {
            Node tempNode = this.head;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            this.size--;
            return;
        }
        // 第三种，中间删除，需要将指定位置的前一结点和后一结点连接起来
        Node tempNode = this.head;
        for (int i = 0; i < index -1; i++) {
            tempNode = tempNode.next;
        }
        Node indexNode =  tempNode.next;
        tempNode.next = indexNode.next;
        this.size--;
    }

    /**
     * 越界校验
     *
     * @param index 指定位置
     */
    private void checkIndex(int index) throws Exception {
        // 判断 指定位置是否超限，如果超限需要报警
        if (index < 0 || index > this.size) {
            throw new Exception("链表超限");
        }
    }
}
