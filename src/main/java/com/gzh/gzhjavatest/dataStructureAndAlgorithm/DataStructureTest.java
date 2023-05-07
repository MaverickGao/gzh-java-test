package com.gzh.gzhjavatest.dataStructureAndAlgorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 数据结构 测试入口
 *
 * @author 高智恒
 */
public class DataStructureTest {

    private static final Logger log = LogManager.getLogger(DataStructureTest.class);

    public static void main(String[] args) {
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
}
