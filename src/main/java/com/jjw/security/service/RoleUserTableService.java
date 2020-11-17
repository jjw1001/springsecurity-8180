package com.jjw.security.service;

import com.jjw.security.entity.RoleUserTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ange
 * @since 2020-11-16
 */
public interface RoleUserTableService extends IService<RoleUserTable> {
    /**
     * 根据用户id查询用户角色的集合
     * @param userId
     * @return
     */
    List<RoleUserTable> listByUserId(String userId);
}
