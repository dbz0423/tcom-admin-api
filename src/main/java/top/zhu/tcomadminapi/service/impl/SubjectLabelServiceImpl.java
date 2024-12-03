package top.zhu.tcomadminapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.SubjectLabelMapper;
import top.zhu.tcomadminapi.model.entity.SubjectLabel;
import top.zhu.tcomadminapi.service.SubjectLabelService;

import java.util.List;

@Service
public class SubjectLabelServiceImpl implements SubjectLabelService {

    @Autowired
    private SubjectLabelMapper subjectLabelMapper;

    @Override
    public void addSubjectLabel(SubjectLabel subjectLabel) {
        subjectLabelMapper.insert(subjectLabel);
    }

    @Override
    public void updateSubjectLabel(SubjectLabel subjectLabel) {
        subjectLabelMapper.updateById(subjectLabel);
    }

    @Override
    public void deleteSubjectLabel(Long pkId) {
        subjectLabelMapper.deleteById(pkId);
    }

    @Override
    public List<SubjectLabel> getAllSubjectLabels() {
        return subjectLabelMapper.selectList(null);
    }
}
