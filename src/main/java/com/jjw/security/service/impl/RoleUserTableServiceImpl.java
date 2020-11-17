package com.jjw.security.service.impl;

import com.jjw.security.entity.RoleUserTable;
import com.jjw.security.mapper.RoleUserTableMapper;
import com.jjw.security.service.RoleUserTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ange
 * @since 2020-11-16
 */
@Service
public class RoleUserTableServiceImpl extends ServiceImpl<RoleUserTableMapper, RoleUserTable> implements RoleUserTableService {

    /**
     * 根据用户id查询用户角色的集合
     *
     * @param userId
     * @return
     */
    @Override
    public List<RoleUserTable> listByUserId(String userId) {
        return this.baseMapper.listByUserId(userId);
    }
}
