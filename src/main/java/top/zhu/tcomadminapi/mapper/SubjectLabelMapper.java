package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zhu.tcomadminapi.model.entity.SubjectLabel;

import java.util.List;

public interface SubjectLabelMapper extends BaseMapper<SubjectLabel> {

    // 根据专题ID查询所有标签
    List<SubjectLabel> getBySubjectId(Long subjectId);

    // 根据标签ID删除关联的记录
    Integer deleteByLabelId(Long labelId);
}
