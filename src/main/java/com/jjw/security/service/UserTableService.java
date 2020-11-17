package com.jjw.security.service;

import com.jjw.security.entity.UserTable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ange
 * @since 2020-11-16
 */
public interface UserTableService extends IService<UserTable> {
    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    UserTable selectById(String id);

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    UserTable selectByName(String name);
}
