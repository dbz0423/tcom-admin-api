package top.zhu.tcomadminapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.IndexContentMapper;
import top.zhu.tcomadminapi.mapper.SubjectMapper;
import top.zhu.tcomadminapi.model.entity.IndexContent;
import top.zhu.tcomadminapi.model.entity.Subject;
import top.zhu.tcomadminapi.service.IndexContentService;

import java.util.List;

@Service
public class IndexContentServiceImpl implements IndexContentService {

    @Autowired
    private IndexContentMapper indexContentMapper;
    private SubjectMapper subjectMapper;

    @Override
    public boolean addIndexContent(IndexContent indexContent) {
        return indexContentMapper.insert(indexContent) > 0;
    }

    @Override
    public List<IndexContent> getAllIndexContents() {
        return indexContentMapper.selectAll();
    }

    @Override
    public IndexContent getIndexContentById(Long pkId) {
        return indexContentMapper.selectById(pkId);
    }

    @Override
    public boolean deleteIndexContent(Long pkId) {
        return indexContentMapper.deleteById(pkId) > 0;
    }

}
