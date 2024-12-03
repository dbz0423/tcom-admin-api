package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.model.entity.SubjectLabel;
import top.zhu.tcomadminapi.model.vo.SubjectLabelVO;

import java.util.List;

public interface SubjectLabelService {

    // 添加标签
    void addSubjectLabel(SubjectLabel subjectLabel);

    // 更新标签
    void updateSubjectLabel(SubjectLabel subjectLabel);

    // 删除标签
    void deleteSubjectLabel(Long pkId);

    // 查询所有标签
    List<SubjectLabel> getAllSubjectLabels();
}
