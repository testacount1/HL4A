package 基本;

import static com.github.program_in_chinese.junit4_in_chinese.断言.相等;

import org.junit.runner.RunWith;

import com.github.program_in_chinese.junit4_in_chinese.测试;
import com.github.program_in_chinese.junit4_in_chinese.运行器;

import 放课后乐园部.收集.集合;

@RunWith(运行器.class)
public class 集合测试 {

    @测试
    public void 添加() {
        集合<Integer> 测试集 = new 集合<>();
        测试集.添加(1);
        相等(1, 测试集.数量());
    }

}