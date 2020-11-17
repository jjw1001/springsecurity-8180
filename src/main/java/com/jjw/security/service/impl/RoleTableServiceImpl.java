package com.jjw.security.service.impl;

import com.jjw.security.entity.RoleTable;
import com.jjw.security.mapper.RoleTableMapper;
import com.jjw.security.service.RoleTableService;
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
public class RoleTableServiceImpl extends ServiceImpl<RoleTableMapper, RoleTable> implements RoleTableService {

    /**
     * 根据id查询角色信息
     *
     * @param id
     * @return
     */
    @Override
    public RoleTable selectById(String id) {
        return this.baseMapper.selectById(id);
    }
}
