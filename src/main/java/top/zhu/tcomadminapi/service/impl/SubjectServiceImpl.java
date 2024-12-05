package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zhu.tcomadminapi.model.entity.Subject;
import top.zhu.tcomadminapi.model.query.SubjectQuery;
import top.zhu.tcomadminapi.model.vo.SubjectVO;
import top.zhu.tcomadminapi.service.SubjectService;
import top.zhu.tcomadminapi.mapper.SubjectMapper;
import top.zhu.tcomadminapi.convert.SubjectConvert;
import top.zhu.tcomadminapi.common.result.PageResult;

import java.sql.Timestamp;
import java.util.List;


@Service
@AllArgsConstructor
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    private final SubjectMapper subjectMapper;
    private final SubjectConvert subjectConvert;

    // 其他方法...

    @Override
    public PageResult<SubjectVO> page(SubjectQuery subjectQuery) {
        Page<Subject> page = new Page<>(subjectQuery.getPage(), subjectQuery.getLimit());

        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(StringUtils.isNotBlank(subjectQuery.getTitle()), Subject::getTitle, subjectQuery.getTitle())
                .eq(subjectQuery.getType() != null, Subject::getType, subjectQuery.getType())
                .eq(subjectQuery.getState() != null, Subject::getState, subjectQuery.getState())
                .eq(subjectQuery.getManagerId() != null, Subject::getManagerId, subjectQuery.getManagerId())
                .ge(subjectQuery.getStartTime() != null, Subject::getStartTime, subjectQuery.getStartTime())
                .le(subjectQuery.getEndTime() != null, Subject::getEndTime, subjectQuery.getEndTime())
                .eq(subjectQuery.getIsExam() != null, Subject::getIsExam, subjectQuery.getIsExam());

        Page<Subject> subjectPage = this.page(page, queryWrapper);

        // 将查询的 Subject 实体转换为 SubjectVO，并返回分页结果
        List<SubjectVO> subjectVOList = subjectConvert.convertToSubjectVOList(subjectPage.getRecords());

        return new PageResult<>(subjectVOList, subjectPage.getTotal());
    }

    @Override
    public SubjectVO getSubjectById(Long id) {
        Subject subject = this.getById(id);
        if (subject == null) {
            return null;
        }
        return subjectConvert.convert(subject);
    }

    @Override
    public void addSubject(SubjectVO subjectVO) {
        Subject subject = subjectConvert.toSubject(subjectVO);
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        subject.setCreateTime(currentTime);
        subject.setUpdateTime(currentTime);
        subject.setState(0);  // 默认状态为 "编辑中"

        // 设置 label 字段的默认值，如果没有提供，则默认为空字符串
        if (subject.getLabel() == null) {
            subject.setLabel("");  // 设置为空字符串
        }

        subjectMapper.insert(subject);
    }


    @Override
    public void updateSubject(SubjectVO subjectVO) {
        Subject subject = subjectConvert.toSubject(subjectVO);
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        subject.setUpdateTime(currentTime);
        subjectMapper.updateById(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectMapper.deleteById(id);
    }

}
