package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.IndexCategoryMapper;
import top.zhu.tcomadminapi.model.entity.IndexCategory;
import top.zhu.tcomadminapi.service.IndexCategoryService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Service
public class IndexCategoryServiceImpl implements IndexCategoryService {

    @Autowired
    private IndexCategoryMapper indexCategoryMapper;

    @Override
    public boolean addIndexCategory(IndexCategory indexCategory) {
//        indexCategory.setPkId((long) new Random().nextInt(Integer.MAX_VALUE));
        if (indexCategory.getLevel() == null) {
            indexCategory.setLevel(1); // 默认层级
        }
        if (indexCategory.getType() == null) {
            indexCategory.setType(0); // 默认类型
        }
        indexCategory.setCreateTime(new Timestamp(System.currentTimeMillis()));
        indexCategory.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return indexCategoryMapper.insert(indexCategory) > 0;
    }


    @Override
    public boolean updateIndexCategory(Long pkId, String name, Integer isShow, Integer sort, Long parentId) {
        QueryWrapper<IndexCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pk_id", pkId);
        IndexCategory indexCategory = indexCategoryMapper.selectOne(queryWrapper);

        if (indexCategory != null) {
            indexCategory.setName(name);
            indexCategory.setIsShow(isShow);
            indexCategory.setSort(sort);
            indexCategory.setParentId(parentId); // 更新 parent_id
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
