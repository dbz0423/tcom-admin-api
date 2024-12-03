package top.zhu.tcomadminapi.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.User;
import top.zhu.tcomadminapi.mapper.ManagerMapper;
import top.zhu.tcomadminapi.model.entity.Manager;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ManagerMapper managerMapper;  // 负责查询数据库的 Mapper

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询数据库中的用户信息
        Manager manager = managerMapper.selectOne(
                new QueryWrapper<Manager>().eq("account", username)
        );

        // 如果用户不存在，抛出 UsernameNotFoundException
        if (manager == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        // 将数据库中的用户信息转换成 UserDetails 对象
        return User.builder()
                .username(manager.getAccount())      // 设置用户名
                .password(manager.getPassword())      // 设置密码
                .roles(manager.getLevel())            // 设置角色（可以根据需要修改）
                .disabled(manager.getIsEnabled() == 0)  // 用户是否禁用（假设 0 表示禁用，1 表示启用）
                .build();
    }
}
