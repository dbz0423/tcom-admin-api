package top.zhu.tcomadminapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.common.exception.ServerException;
import top.zhu.tcomadminapi.common.model.BaseServiceImpl;
import top.zhu.tcomadminapi.mapper.ManagerMapper;
import top.zhu.tcomadminapi.model.entity.Manager;
import top.zhu.tcomadminapi.model.vo.ManagerVO;
import top.zhu.tcomadminapi.security.user.ManagerDetail;
import top.zhu.tcomadminapi.service.ManagerService;

import java.util.List;

@Service
@AllArgsConstructor
public class ManagerServiceImpl extends BaseServiceImpl<ManagerMapper, Manager> implements ManagerService {

    @Override
    public ManagerVO getManagerInfo(ManagerDetail manager) {
        ManagerVO managerVO = new ManagerVO();
        System.out.println(">>>>>>getInfo" + manager.getPkId());
        Manager managerAnother = baseMapper.selectById(manager.getPkId());
        if (managerAnother == null) {
            throw new ServerException("管理员不存在");
        }
        managerVO.setPkId(managerAnother.getPkId());
        managerVO.setAvatar(managerAnother.getAvatar());
        managerVO.setUsername(manager.getUsername());
        managerVO.setIsEnabled(manager.getIsEnabled());
        return managerVO;
    }
}
