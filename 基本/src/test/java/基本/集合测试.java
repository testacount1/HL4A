package 基本;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import 放课后乐园部.收集.集合;

public class 集合测试 {

    @Test
    public void 添加() {
        集合 测试集 = new 集合();
        测试集.添加(1);
        assertEquals(1, 测试集.数量());
    }

}
