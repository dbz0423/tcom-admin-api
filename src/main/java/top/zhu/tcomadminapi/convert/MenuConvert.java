package top.zhu.tcomadminapi.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.zhu.tcomadminapi.model.entity.Menu;
import top.zhu.tcomadminapi.model.vo.MenuVO;

import java.util.List;

@Mapper
public interface MenuConvert {
    MenuConvert INSTANCE = Mappers.getMapper(MenuConvert.class);

    Menu convert(MenuVO vo);

    MenuVO convert(Menu entity);

    List<MenuVO> convertList(List<Menu> list);

}
