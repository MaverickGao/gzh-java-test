package com.gzh.gzhjavatest.dataStructureAndAlgorithm;

import com.gzh.gzhjavatest.dataStructureAndAlgorithm.array.ArrayListDemo;
import com.gzh.gzhjavatest.dataStructureAndAlgorithm.linkedList.SinglyLinkedListDemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 数据结构 测试入口
 *
 * @author 高智恒
 */
public class DataStructureTest {

    private static final Logger log = LogManager.getLogger(DataStructureTest.class);

    public static void main(String[] args) throws Exception {
        // 动态数组实现测试
        // testArrayListDemo();
        // 单向链表实现测试
        testSinglyLinkedListDemo();
    }

    /**
     * 动态数组实现测试入口
     */
    public static void testArrayListDemo() {
        ArrayListDemo<String> listDemo = new ArrayListDemo<>();
        listDemo.add("高智恒");
        listDemo.add("布拉不拉");
        listDemo.add("布拉不拉2");
        listDemo.add("布拉不拉3");
        listDemo.add("布拉不拉4");
        listDemo.add("布拉不拉5");
        listDemo.add("布拉不拉6");
        listDemo.add("布拉不拉7");
        listDemo.add("布拉不拉8");
        listDemo.add("布拉不拉9");
        listDemo.add("布拉不拉10");
        listDemo.set(2, "66666");
        listDemo.get(5);
        log.info("数组中元素个数：{}", listDemo.size());
    }

    /**
     * 测试单向链表
     */
    public static void testSinglyLinkedListDemo() throws Exception {
        SinglyLinkedListDemo<String> listDemo = new SinglyLinkedListDemo<>();
        listDemo.add("高智恒");
        listDemo.add("布拉不拉");
        listDemo.add("布拉不拉2");
        listDemo.add("布拉不拉3");
        listDemo.add("布拉不拉4");
        listDemo.add("布拉不拉5");
        listDemo.add("布拉不拉6");
        listDemo.add("布拉不拉7");
        listDemo.add("布拉不拉8");
        listDemo.add("布拉不拉9");
        listDemo.add("布拉不拉10");
        listDemo.update(5, "666");
        listDemo.remove(7);
        for (int i = 0; i < listDemo.Size(); i++) {
            log.info("第" + i + "结点的元素：" + listDemo.get(i));
        }
    }
}
