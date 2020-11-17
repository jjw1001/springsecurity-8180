package com.jjw.security.mapper;

import com.jjw.security.entity.UserTable;
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
public interface UserTableMapper extends BaseMapper<UserTable> {
    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    @Select("SELECT * FROM sys_user_table WHERE user_id = #{id}")
    UserTable selectById(String id);

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    @Select("SELECT * FROM sys_user_table WHERE user_name = #{name}")
    UserTable selectByName(String name);

}
