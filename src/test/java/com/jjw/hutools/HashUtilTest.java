package com.jjw.hutools;

import cn.hutool.core.util.HashUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jijiawei
 * @Description TODO
 * @date 2020/11/17 9:06
 */
@SpringBootTest
public class HashUtilTest {
    @Test
    public void testHashUtil1(){
        int hah = HashUtil.additiveHash("25", 3);
        System.out.println(hah);
    }
}
