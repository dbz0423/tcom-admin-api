package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.zhu.tcomadminapi.model.dto.QuizDTO;
import top.zhu.tcomadminapi.model.entity.Quiz;

import java.util.List;

public interface QuizMapper extends BaseMapper<Quiz> {

}
