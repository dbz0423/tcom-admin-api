package top.zhu.tcomadminapi.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.zhu.tcomadminapi.model.dto.ExamItemInfoDTO;
import top.zhu.tcomadminapi.model.entity.QuizPaper;

import java.util.List;

@Mapper
public interface PaperConvert {
    PaperConvert INSTANCE = Mappers.getMapper(PaperConvert.class);

    ExamItemInfoDTO convert(QuizPaper quizPaper);

    QuizPaper convert(ExamItemInfoDTO examItemInfoDTO);

    List<ExamItemInfoDTO> convert(List<QuizPaper> quizPapers);
}
