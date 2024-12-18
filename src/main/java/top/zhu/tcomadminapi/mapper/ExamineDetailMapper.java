package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.zhu.tcomadminapi.model.entity.QuestionBank;

import java.util.List;

public interface ExamineDetailMapper extends BaseMapper<QuestionBank> {

    /**
     * 根据练习ID查询对应的题库表信息
     * @param examinationId 练习概览表的pkId
     * @return 题库表列表
     */
    @Select("SELECT qb.pk_id, qb.type, qb.content_id, qb.option_type, qb.question, qb.answer, qb.create_time, qb.update_time " +
            "FROM t_examination_detail ed " +
            "JOIN t_question_bank qb ON ed.question_id = qb.pk_id " +
            "WHERE ed.content_id = #{examinationId}")
    List<QuestionBank> selectQuestionsByExaminationId(@Param("examinationId") Integer examinationId);

    /**
     * 查询未被绑定到任何练习的空余题目
     */
    @Select("""
        SELECT qb.*
        FROM t_question_bank qb
        LEFT JOIN t_examination_detail ed
        ON qb.pk_id = ed.question_id
        WHERE ed.question_id IS NULL
    """)
    List<QuestionBank> selectUnboundQuestions();
}