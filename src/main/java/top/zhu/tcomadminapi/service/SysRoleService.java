package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.model.entity.SysRole;
import top.zhu.tcomadminapi.model.query.SysRoleQuery;
import top.zhu.tcomadminapi.model.vo.SysRoleVO;

import java.util.List;

public interface SysRoleService extends IService<SysRole> {
    PageResult<SysRoleVO> page(SysRoleQuery query);

    List<SysRoleVO> getList(SysRoleQuery query);

    void save(SysRoleVO vo);

    void update(SysRoleVO vo);

    void delete(List<Integer> idList);
}
