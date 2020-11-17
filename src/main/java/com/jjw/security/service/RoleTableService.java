package com.jjw.security.service;

import com.jjw.security.entity.RoleTable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ange
 * @since 2020-11-16
 */
public interface RoleTableService extends IService<RoleTable> {
    /**
     * 根据id查询角色信息
     * @param id
     * @return
     */
    RoleTable selectById(String id);
}
