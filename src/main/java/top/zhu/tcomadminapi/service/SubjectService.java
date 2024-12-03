package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.model.entity.Subject;
import top.zhu.tcomadminapi.model.query.SubjectQuery;
import top.zhu.tcomadminapi.model.vo.SubjectVO;
import top.zhu.tcomadminapi.common.result.PageResult;

import java.util.List;

public interface SubjectService extends IService<Subject> {
    PageResult<SubjectVO> page(SubjectQuery subjectQuery);
    SubjectVO getSubjectById(Long id);
    void addSubject(SubjectVO subjectVO);
    void updateSubject(SubjectVO subjectVO);
    void deleteSubject(Long id);
}
