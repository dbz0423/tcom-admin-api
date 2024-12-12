package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.common.exception.ServerException;
import top.zhu.tcomadminapi.common.model.BaseServiceImpl;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.mapper.ManagerMapper;
import top.zhu.tcomadminapi.model.entity.Manager;
import top.zhu.tcomadminapi.model.query.ManagerQuery;
import top.zhu.tcomadminapi.model.vo.ManagerVO;
import top.zhu.tcomadminapi.security.user.ManagerDetail;
import top.zhu.tcomadminapi.service.ManagerService;

import java.util.List;

@Service
@AllArgsConstructor
public class ManagerServiceImpl extends BaseServiceImpl<ManagerMapper, Manager> implements ManagerService {

    @Override
    public PageResult<ManagerVO> page(ManagerQuery query) {
        Page<ManagerVO> page = new Page<>(query.getPage() , query.getLimit());
        List<ManagerVO> list = baseMapper.getManagerPage(page , query);
        return new PageResult<>(list, page.getTotal());
    }

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
        managerVO.setAccount(manager.getUsername());
        managerVO.setIsEnabled(manager.getIsEnabled());
        return managerVO;
    }
}
