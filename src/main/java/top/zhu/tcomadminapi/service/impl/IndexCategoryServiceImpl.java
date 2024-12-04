package top.zhu.tcomadminapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.IndexCategoryMapper;
import top.zhu.tcomadminapi.model.entity.IndexCategory;
import top.zhu.tcomadminapi.service.IndexCategoryService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class IndexCategoryServiceImpl implements IndexCategoryService {

    @Autowired
    private IndexCategoryMapper indexCategoryMapper;  // 假设使用 MyBatis 持久化层

    @Override
    public boolean addIndexCategory(IndexCategory indexCategory) {
        return indexCategoryMapper.insert(indexCategory) > 0;
    }

    @Override
    public boolean updateIndexCategory(Long pkId, String name, Integer isShow, Integer sort) {
        // 查找并更新指定的分类
        IndexCategory indexCategory = indexCategoryMapper.selectById(pkId);
        if (indexCategory != null) {
            indexCategory.setName(name);
            indexCategory.setIsShow(isShow);
            indexCategory.setSort(sort);
            indexCategory.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            return indexCategoryMapper.updateById(indexCategory) > 0;
        }
        return false;
    }

    @Override
    public boolean deleteIndexCategory(Long pkId) {
        return indexCategoryMapper.deleteById(pkId) > 0;
    }

    @Override
    public List<IndexCategory> getIndexCategories() {
        return indexCategoryMapper.selectList(null);
    }
}
