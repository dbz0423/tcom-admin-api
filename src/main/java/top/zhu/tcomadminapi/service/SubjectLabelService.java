package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.model.entity.SubjectLabel;

import java.util.List;

public interface SubjectLabelService {

    // 新增标签
    boolean addSubjectLabel(SubjectLabel subjectLabel);

    // 删除标签
    boolean deleteSubjectLabel(Long pkId);

    // 批量删除标签
    boolean deleteSubjectLabels(List<Long> pkIds);

    // 更新标签
    boolean updateSubjectLabel(SubjectLabel subjectLabel);

    // 根据ID查询标签
    SubjectLabel getSubjectLabelById(Long pkId);

    // 查询所有标签
    List<SubjectLabel> getAllSubjectLabels();

    // 根据专题ID查询标签
    List<SubjectLabel> getSubjectLabelsBySubjectId(Long subjectId);

    // 分页查询标签，返回 PageResult
    PageResult<SubjectLabel> getSubjectLabelPage(int pageNum, int pageSize);
}
