package com.jjw.hutools;

import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jijiawei
 * @Description TODO
 * @date 2020/11/16 17:23
 */
@SpringBootTest
public class StrUtilTest {
    @Test
    public void testStrUtil1(){
        String[] s = {" hhg  ","","hai zei"};
        boolean b1 = StrUtil.hasBlank(s);//--true
        boolean b2 = StrUtil.hasEmpty(s);//--true
    }
    @Test
    public void testStrUtil2(){
        String fileName = "pretty_gir.jpg";
        String s1 = StrUtil.removePrefix(fileName,"pretty_");
        String s2 = StrUtil.removeSuffix(fileName, ".jpg");//pretty_gir
    }
    @Test
    public void testStrUtil3(){
        String str = "abcdefgh";
        String strSub1 = StrUtil.sub(str, 2, 3); //strSub1 -> c
        String strSub2 = StrUtil.sub(str, 2, -3); //strSub2 -> cde
        String strSub3 = StrUtil.sub(str, 3, 2); //strSub2 -> c
    }
    @Test
    public void testStrUtil4(){
        String str = "abcdefgh";
        String str1 = StrUtil.str(str);
        byte[] bytes = StrUtil.bytes(str, "utf-8");
    }
    @Test
    public void testStrUtil5(){
        String template = "{}爱{}";
        String str = StrUtil.format(template, "我", "你"); //str -> 我爱你，就像老鼠爱大米
    }


}
