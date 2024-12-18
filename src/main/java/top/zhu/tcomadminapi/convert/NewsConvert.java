package top.zhu.tcomadminapi.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.zhu.tcomadminapi.model.entity.Manager;
import top.zhu.tcomadminapi.model.entity.News;
import top.zhu.tcomadminapi.model.vo.ManagerVO;
import top.zhu.tcomadminapi.model.vo.NewsVO;
import top.zhu.tcomadminapi.security.user.ManagerDetail;

import java.util.List;

@Mapper
public interface NewsConvert {
    NewsConvert INSTANCE = Mappers.getMapper(NewsConvert.class);

    News convert(NewsVO vo);

    NewsVO convert(News news);

}
