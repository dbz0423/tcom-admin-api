package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.zhu.tcomadminapi.model.entity.Subject;
import top.zhu.tcomadminapi.model.vo.SubjectVO;

import java.util.List;

@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {
    @Select("SELECT pk_id, name, ... FROM t_subject")
    List<SubjectVO> selectAllSubjects();
}


