package top.zhu.tcomadminapi.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.zhu.tcomadminapi.model.entity.Manager;
import top.zhu.tcomadminapi.model.vo.ManagerVO;
import top.zhu.tcomadminapi.security.user.ManagerDetail;

import java.util.List;

@Mapper
public interface ManagerConvert {
    ManagerConvert INSTANCE = Mappers.getMapper(ManagerConvert.class);

    Manager convert(ManagerVO vo);

    ManagerDetail convertDetail(Manager entity);

    List<ManagerVO> convertList(List<Manager> list);
}
