package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.model.entity.Manager;
import top.zhu.tcomadminapi.model.query.ManagerQuery;
import top.zhu.tcomadminapi.model.vo.ManagerVO;
import top.zhu.tcomadminapi.security.user.ManagerDetail;

import java.util.List;

public interface ManagerService extends IService<Manager> {
    /**
     * 管理员列表
     *
     * @param query
     * @return
     */
    PageResult<ManagerVO> page(ManagerQuery query);

    ManagerVO getManagerInfo(ManagerDetail manager);
}
