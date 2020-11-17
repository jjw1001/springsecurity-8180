package com.jjw.hutools;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jijiawei
 * @Description 项目的编码为utf-8
 * @date 2020/11/16 17:53
 */
@SpringBootTest
public class HexUtilTest {
    @Test
    public void testHexUtil1(){
        String str = "我是一个字符串";
        String hex = HexUtil.encodeHexStr(str, CharsetUtil.CHARSET_UTF_8);
        //hex是：
        //e68891e698afe4b880e4b8aae5ad97e7aca6e4b8b2
        String decodedStr = HexUtil.decodeHexStr(hex);
        //解码后与str相同
        System.out.println(hex);
        System.out.println(decodedStr);
    }

}
