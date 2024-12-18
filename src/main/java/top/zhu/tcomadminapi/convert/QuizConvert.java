package top.zhu.tcomadminapi.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.zhu.tcomadminapi.model.dto.QuizDTO;
import top.zhu.tcomadminapi.model.entity.IndexCategory;
import top.zhu.tcomadminapi.model.entity.Quiz;
import top.zhu.tcomadminapi.model.vo.IndexCategoryVO;

import java.util.List;

@Mapper
public interface QuizConvert {

    QuizConvert INSTANCE = Mappers.getMapper(QuizConvert.class);

    Quiz convert(QuizDTO dto);

    QuizDTO convert(Quiz quiz);

    List<QuizDTO> convertList(List<Quiz> quizList);

}
