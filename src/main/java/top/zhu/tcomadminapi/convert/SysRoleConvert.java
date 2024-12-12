package top.zhu.tcomadminapi.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.zhu.tcomadminapi.model.entity.SysRole;
import top.zhu.tcomadminapi.model.vo.SysRoleVO;

import java.util.List;

@Mapper
public interface SysRoleConvert {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRoleVO convert(SysRole entity);

    SysRole convert(SysRoleVO vo);

    List<SysRoleVO> convertList(List<SysRole> list);

}
