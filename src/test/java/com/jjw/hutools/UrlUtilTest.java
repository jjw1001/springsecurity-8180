package com.jjw.hutools;

import cn.hutool.core.util.URLUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

/**
 * @author jijiawei
 * @Description TODO
 * @date 2020/11/17 9:20
 */
@SpringBootTest
public class UrlUtilTest {
    @Test
    public void testUrlUtil1(){
        String url  = "www.hutool.cn//aaa/\\bbb?a=1&b=2";
        // 结果为：http://www.hutool.cn/aaa/bbb?a=1&b=2
        String normalize = URLUtil.normalize(url);
    }
    @Test
    public void testUrlUtil2(){
        String body = "366466 - 副本.jpg";
// 结果为：366466%20-%20%E5%89%AF%E6%9C%AC.jpg
        String encode = URLUtil.encode(body);
        System.out.println(encode);
    }
}
