package com.gzh.gzhjavatest.dataStructureAndAlgorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 数据结构和算法-实现自定义动态数组
 *
 * @author 高智恒
 */
public class ArrayListDemo<T> {

    private static final Logger log = LogManager.getLogger(ArrayListDemo.class);

    /**
     * 默认数组长度为10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 默认数组
     */
    private T[] elements;

    /**
     * 数组中元素个数
     */
    private int size;

    /**
     * 构造动态数组时，实际就是默认初始化一个数组
     */
    public ArrayListDemo() {
        // 不指定数组长度的话，默认长度为10
        this(DEFAULT_CAPACITY);
    }

    /**
     * 指定数组长度的构建
     *
     * @param initialCapacity 指定长度
     */
    public ArrayListDemo(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("初始化数组的长度必须为正整数");
        }
        // 如果初始化长度小于默认值，就创建默认长度
        if (initialCapacity <= DEFAULT_CAPACITY) {
            initialCapacity = DEFAULT_CAPACITY;
        }
        this.elements = (T[]) new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * 获取数组中元素的个数
     *
     * @return 数组中元素个数
     */
    public int size() {
        // 直接返回数组中元素个数即可
        return this.size;
    }

    /**
     * 添加数组元素
     *
     * @param element 待添加元素
     */
    public void add(T element) {
        // 如果数组长度已经满了，需要扩容
        if (elements.length == this.size) {
            resize();
        }
        elements[size++] = element;
        log.info("索引位置：{}，添加一个元素：{}", this.size - 1, element);
    }

    /**
     * 获取指定索引的元素
     *
     * @param index 索引
     * @return 索引位置的元素
     */
    public T get(int index) {
        // 判断指定索引是否越界
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        log.info("指定索引：{}的元素为{}", index, this.elements[index]);
        return this.elements[index];
    }

    /**
     * 更新元素
     *
     * @param index   索引
     * @param element 更新的元素
     */
    public void set(int index, T element) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        log.info("更新索引位置：{}的元素：{}，为{}", index, get(index), element);
        this.elements[index] = element;
    }

    /**
     * 数组扩容，默认长度 ×2
     */
    private void resize() {
        int newCapacity = this.elements.length * 2;
        T[] newElements = (T[]) new Object[newCapacity];
        log.info("数组扩容，现在长度为{}，原数组hashCode：{}，新数组hashCode：{}", newCapacity, newElements.hashCode(), this.elements.hashCode());
        // 从源数组中复制一个范围内的元素到目标数组的指定位置
        System.arraycopy(this.elements, 0, newElements, 0, this.size);
        this.elements = newElements;
    }
}
