package com.jjw.auth;

import com.jjw.security.service.auth.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author jijiawei
 * @Description TODO
 * @date 2020/11/16 14:16
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final int TOKEN_VALIDITY_SECONDS = 60;
    /**
     * 重写认证流程
     */
    @Resource
    private UserDetailsServiceImpl userDetailsService;
    /**
     * 密码加密方式
     */
    @Resource
    private PasswordEncoder passwordEncoder;
    /**
     * springboot已经默认配置了数据源
     */
    @Resource
    private DataSource dataSource;
    /**
     * 自定义的记住我
     */
    @Resource
    private PersistentTokenRepository tokenRepository;
    /**
     * 数据库中的密码加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        //使用hash的加密方式 -- 同时也加盐了
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置自动登录的实例
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        // 如果token表不存在，使用下面语句可以初始化该表；若存在，请注释掉这条语句，否则会报错。
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //改用我们刚重写的认证流程
        //spring security明确规定数据库中的密码必须是加密的
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置哪些文件夹不被拦截,一般是对静态资源文件放行
        web.ignoring().antMatchers("/css/**","/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //设置HTTP的认证方式
        http.authorizeRequests()
                // 如果有允许匿名的url，填在下面
//                .antMatchers().permitAll()
                .anyRequest().authenticated()
                .and()
                // 设置登陆页
                .formLogin().loginPage("/login")
                // 设置登陆成功页
                .defaultSuccessUrl("/").permitAll()
                // 登录失败Url
                .failureUrl("/login/error")
                // 自定义登陆用户名和密码参数，默认为username和password
//                .usernameParameter("username")
//                .passwordParameter("password")
                .and()
                .logout().permitAll()
                .and()
                //实现自动登录（记住我的功能）
                .rememberMe()
                //使用JDBC数据库的方式存取cookie -- 观察可以看出数据库表中自动添加数据
                .tokenRepository(tokenRepository)
                .tokenValiditySeconds(TOKEN_VALIDITY_SECONDS)
                .userDetailsService(userDetailsService);
        // 关闭CSRF跨域
        http.csrf().disable();
    }
}
