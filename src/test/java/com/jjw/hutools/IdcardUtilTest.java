package com.jjw.hutools;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import netscape.javascript.JSUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jijiawei
 * @Description TODO
 * @date 2020/11/17 9:32
 */
@SpringBootTest
public class IdcardUtilTest {
    private static final String ID_18 = "46003219941001629X";
    @Test
    public void testIdcardUtil1(){
        boolean validCard = IdcardUtil.isValidCard(ID_18);
        int ageByIdCard = IdcardUtil.getAgeByIdCard(ID_18);
        String provinceByIdCard = IdcardUtil.getProvinceByIdCard(ID_18);
    }
}
