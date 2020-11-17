package com.jjw.security.service.auth;

import com.jjw.security.entity.RoleTable;
import com.jjw.security.entity.RoleUserTable;
import com.jjw.security.entity.UserTable;
import com.jjw.security.service.RoleTableService;
import com.jjw.security.service.RoleUserTableService;
import com.jjw.security.service.UserTableService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author jijiawei
 * @Description 重写登录方法
 * @date 2020/11/16 11:36
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserTableService userTableService;
    @Resource
    private RoleTableService roleTableService;
    @Resource
    private RoleUserTableService roleUserTableService;
    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)){
            throw new RuntimeException("用户名不能为空");
        }
        //如果不为空。根据用户名查询用户
        UserTable userTable = userTableService.selectByName(username);
        if (userTable == null){
            throw new UsernameNotFoundException(String.format("%s这个人不存在",username));
        }
        //如果存在，查询该用户具有的角色
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //根据用户id查询集合
        List<RoleUserTable> roles = roleUserTableService.listByUserId(userTable.getUserId());
        roles.forEach(role ->{
            RoleTable roleTable = roleTableService.selectById(role.getRoleId());
            authorities.add(new SimpleGrantedAuthority(roleTable.getRoleName()));
        });
        return new User(userTable.getUserName(),userTable.getPassWord(),authorities);
    }
}
