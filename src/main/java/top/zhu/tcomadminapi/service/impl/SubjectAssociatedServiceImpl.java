package top.zhu.tcomadminapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.SubjectAssociatedMapper;
import top.zhu.tcomadminapi.model.entity.SubjectAssociated;
import top.zhu.tcomadminapi.service.SubjectAssociatedService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SubjectAssociatedServiceImpl implements SubjectAssociatedService {

    @Autowired
    private SubjectAssociatedMapper subjectAssociatedMapper;

    @Override
    public void associateLabelWithSubject(Long subjectId, Long labelId) {
        SubjectAssociated association = new SubjectAssociated();
        association.setSubjectId(subjectId);
        association.setLabelId(labelId);
        association.setCreateTime(new Timestamp(System.currentTimeMillis()));
        association.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        subjectAssociatedMapper.insert(association);
    }

    @Override
    public List<SubjectAssociated> getAssociationsBySubjectId(Long subjectId) {
        return subjectAssociatedMapper.getBySubjectId(subjectId);
    }

    @Override
    public List<SubjectAssociated> getAssociationsByLabelId(Long labelId) {
        return subjectAssociatedMapper.getByLabelId(labelId);
    }

    @Override
    public void removeAssociation(Long subjectId, Long labelId) {
        subjectAssociatedMapper.deleteBySubjectAndLabel(subjectId, labelId);
    }
}
