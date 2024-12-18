package top.zhu.tcomadminapi.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.zhu.tcomadminapi.model.entity.User;
import top.zhu.tcomadminapi.model.vo.UserVO;

import java.util.List;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    User convert(UserVO userVO);

    UserVO convert(User entity);

    List<UserVO> convertList(List<User> list);
}
