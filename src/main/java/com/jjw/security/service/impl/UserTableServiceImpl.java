package com.jjw.security.service.impl;

import com.jjw.security.entity.UserTable;
import com.jjw.security.mapper.UserTableMapper;
import com.jjw.security.service.UserTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ange
 * @since 2020-11-16
 */
@Service
public class UserTableServiceImpl extends ServiceImpl<UserTableMapper, UserTable> implements UserTableService {

    /**
     * 根据用户id查询用户
     *
     * @param id
     * @return
     */
    @Override
    public UserTable selectById(String id) {
        return this.baseMapper.selectById(id);
    }

    /**
     * 根据用户名查询用户
     *
     * @param name
     * @return
     */
    @Override
    public UserTable selectByName(String name) {
        return this.baseMapper.selectByName(name);
    }
}
