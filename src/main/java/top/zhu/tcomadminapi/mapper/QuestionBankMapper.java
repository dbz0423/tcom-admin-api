package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.zhu.tcomadminapi.model.entity.QuestionBank;

import java.util.List;

@Mapper
public interface QuestionBankMapper extends BaseMapper<QuestionBank> {

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
