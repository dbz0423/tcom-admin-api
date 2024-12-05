package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.mapper.SubjectLabelMapper;
import top.zhu.tcomadminapi.model.entity.SubjectLabel;
import top.zhu.tcomadminapi.service.SubjectLabelService;

import java.util.List;


@Service
public class SubjectLabelServiceImpl implements SubjectLabelService {

    @Autowired
    private SubjectLabelMapper subjectLabelMapper;

    // 新增标签
    @Override
    public boolean addSubjectLabel(SubjectLabel subjectLabel) {
        return subjectLabelMapper.insert(subjectLabel) > 0;
    }

    // 删除标签
    @Override
    public boolean deleteSubjectLabel(Long pkId) {
        return subjectLabelMapper.deleteById(pkId) > 0;
    }

    // 批量删除标签
    @Override
    public boolean deleteSubjectLabels(List<Long> pkIds) {
        return subjectLabelMapper.deleteBatchIds(pkIds) > 0;
    }

    // 更新标签
    @Override
    public boolean updateSubjectLabel(SubjectLabel subjectLabel) {
        return subjectLabelMapper.updateById(subjectLabel) > 0;
    }

    // 根据ID查询标签
    @Override
    public SubjectLabel getSubjectLabelById(Long pkId) {
        return subjectLabelMapper.selectById(pkId);
    }

    // 查询所有标签
    @Override
    public List<SubjectLabel> getAllSubjectLabels() {
        return subjectLabelMapper.selectList(null);
    }

    // 根据专题ID查询标签
    @Override
    public List<SubjectLabel> getSubjectLabelsBySubjectId(Long subjectId) {
        return subjectLabelMapper.selectList(
                new QueryWrapper<SubjectLabel>().eq("subject_id", subjectId)
        );
    }


    // 分页查询标签
    @Override
    public PageResult<SubjectLabel> getSubjectLabelPage(int pageNum, int pageSize) {
        // 创建分页对象
        Page<SubjectLabel> page = new Page<>(pageNum, pageSize);

        // 执行分页查询
        Page<SubjectLabel> resultPage = subjectLabelMapper.selectPage(page, null);

        // 将分页结果转换为 PageResult
        return new PageResult<>(resultPage.getRecords(), resultPage.getTotal());
    }}
