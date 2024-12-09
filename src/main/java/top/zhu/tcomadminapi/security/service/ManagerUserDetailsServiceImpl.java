package top.zhu.tcomadminapi.security.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.ManagerMapper;
import top.zhu.tcomadminapi.model.entity.Manager;
import top.zhu.tcomadminapi.service.ManagerDetailsService;

@Service
@AllArgsConstructor
public class ManagerUserDetailsServiceImpl implements UserDetailsService {
    private final ManagerDetailsService managerDetailsService;
    private final ManagerMapper managerMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerMapper.getManagerByAccount(username);
        if (manager == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return managerDetailsService.getManagerDetails(manager);
    }

}
