package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import top.zhu.tcomadminapi.model.entity.SysRole;
import top.zhu.tcomadminapi.model.query.SysRoleQuery;
import top.zhu.tcomadminapi.model.vo.SysRoleVO;

import java.util.List;


public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRoleVO> getRolePage(Page<SysRoleVO> page, @Param("query") SysRoleQuery query);

}
