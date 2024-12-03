package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import top.zhu.tcomadminapi.model.entity.SubjectAssociated;

import java.util.List;

public interface SubjectAssociatedMapper extends BaseMapper<SubjectAssociated> {

    // 根据专题ID查询所有关联的标签
    List<SubjectAssociated> getBySubjectId(Long subjectId);

    // 根据标签ID查询所有关联的专题
    List<SubjectAssociated> getByLabelId(Long labelId);

    // 删除某个专题和标签的关联
    int deleteBySubjectAndLabel(Long subjectId, Long labelId);
}
