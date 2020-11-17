package com.jjw.security.mapper;

import com.jjw.security.entity.RoleUserTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ange
 * @since 2020-11-16
 */
public interface RoleUserTableMapper extends BaseMapper<RoleUserTable> {
    /**
     * 根据用户id查询用户角色的集合
     * @param userId
     * @return
     */
    @Select("SELECT * FROM sys_role_user_table WHERE user_id = #{userId}")
    List<RoleUserTable> listByUserId(String userId);
}
