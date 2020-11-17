package com.jjw.security.mapper;

import com.jjw.security.entity.RoleTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ange
 * @since 2020-11-16
 */
public interface RoleTableMapper extends BaseMapper<RoleTable> {
    /**
     * 根据id查询角色信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM sys_role_table WHERE role_id = #{id}")
    RoleTable selectById(String id);
}
