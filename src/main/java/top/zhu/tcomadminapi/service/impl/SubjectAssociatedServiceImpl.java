package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        subjectAssociatedMapper.insert(association); // 调用 BaseMapper 的 insert 方法
    }

    @Override
    public List<SubjectAssociated> getAssociationsBySubjectId(Long subjectId) {
        // BaseMapper 提供了常见的查询方法，这里可以使用如 selectList
        QueryWrapper<SubjectAssociated> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("subject_id", subjectId);
        return subjectAssociatedMapper.selectList(queryWrapper); // 使用 BaseMapper 提供的 selectList
    }

    @Override
    public List<SubjectAssociated> getAssociationsByLabelId(Long labelId) {
        QueryWrapper<SubjectAssociated> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("label_id", labelId);
        return subjectAssociatedMapper.selectList(queryWrapper);
    }

    @Override
    public void removeAssociation(Long subjectId, Long labelId) {
        // 调用 BaseMapper 的删除方法
        QueryWrapper<SubjectAssociated> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("subject_id", subjectId).eq("label_id", labelId);
        subjectAssociatedMapper.delete(queryWrapper); // 使用 BaseMapper 提供的 delete 方法
    }
}

