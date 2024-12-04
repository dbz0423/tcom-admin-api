package top.zhu.tcomadminapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.ManagerMapper;
import top.zhu.tcomadminapi.model.entity.Manager;
import top.zhu.tcomadminapi.service.ManagerService;

import java.util.List;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerMapper managerMapper;

    @Override
    public List<Manager> getManagerInfo() {
        return managerMapper.selectAllManagers();
    }
}
