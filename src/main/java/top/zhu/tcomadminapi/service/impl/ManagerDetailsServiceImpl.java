package top.zhu.tcomadminapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.convert.ManagerConvert;
import top.zhu.tcomadminapi.enums.AccountStatusEnum;
import top.zhu.tcomadminapi.model.entity.Manager;
import top.zhu.tcomadminapi.security.user.ManagerDetail;
import top.zhu.tcomadminapi.service.ManagerDetailsService;


@Service
@AllArgsConstructor
public class ManagerDetailsServiceImpl implements ManagerDetailsService {


    @Override
    public UserDetails getManagerDetails(Manager manager) {
        // 转换成UserDetail对象
        ManagerDetail managerDetail = ManagerConvert.INSTANCE.convertDetail(manager);

        // 账号不可用
        if (manager.getIsEnabled() == AccountStatusEnum.DISABLE.getValue()) {
            managerDetail.setIsEnabled(AccountStatusEnum.DISABLE.getValue());
        }

        // 用户权限列表
//        Set<String> authoritySet = sysMenuService.getManagerAuthority(managerDetail);
//        managerDetail.setAuthoritySet(authoritySet);

        return managerDetail;
    }
}
