package top.zhu.tcomadminapi.mapper;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import top.zhu.tcomadminapi.model.entity.Manager;
import top.zhu.tcomadminapi.model.query.ManagerQuery;
import top.zhu.tcomadminapi.model.query.SysRoleQuery;
import top.zhu.tcomadminapi.model.vo.ManagerVO;

import java.util.List;

public interface ManagerMapper extends BaseMapper<Manager> {

    default Manager getManagerByAccount(String account) {
        return this.selectOne(new LambdaQueryWrapper<Manager>().eq(Manager::getAccount, account));
    }

    List<ManagerVO> getManagerPage(Page<ManagerVO> page , @Param("query") ManagerQuery query);
}
