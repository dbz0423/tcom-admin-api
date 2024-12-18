package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.zhu.tcomadminapi.model.entity.ExamineDetail;

@Mapper
public interface ExamineDetailRepository extends BaseMapper<ExamineDetail> {

    @Delete("DELETE FROM t_examination_detail WHERE question_id = #{questionId}")
    int deleteByQuestionId(@Param("questionId") Integer questionId);
}
