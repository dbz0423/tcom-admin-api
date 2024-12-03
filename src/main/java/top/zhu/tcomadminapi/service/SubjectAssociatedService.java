package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.model.entity.SubjectAssociated;


import java.util.List;

public interface SubjectAssociatedService {

    // 关联标签与专题
    void associateLabelWithSubject(Long subjectId, Long labelId);

    // 根据专题ID获取所有关联的标签
    List<SubjectAssociated> getAssociationsBySubjectId(Long subjectId);

    // 根据标签ID获取所有关联的专题
    List<SubjectAssociated> getAssociationsByLabelId(Long labelId);

    // 删除专题与标签的关联
    void removeAssociation(Long subjectId, Long labelId);
}
