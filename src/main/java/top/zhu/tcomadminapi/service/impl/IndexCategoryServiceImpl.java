package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.convert.IndexCategoryConvert;
import top.zhu.tcomadminapi.mapper.IndexCategoryMapper;
import top.zhu.tcomadminapi.model.entity.IndexCategory;
import top.zhu.tcomadminapi.model.vo.IndexCategoryVO;
import top.zhu.tcomadminapi.service.IndexCategoryService;
import top.zhu.tcomadminapi.utils.TreeUtils;

import java.sql.Timestamp;
import java.util.List;

@Service
public class IndexCategoryServiceImpl implements IndexCategoryService {

    @Autowired
    private IndexCategoryMapper indexCategoryMapper;

    @Override
    public boolean addIndexCategory(IndexCategoryVO indexCategoryVO) {
//        indexCategory.setPkId((long) new Random().nextInt(Integer.MAX_VALUE));
        if (indexCategoryVO.getLevel() == null) {
            indexCategoryVO.setLevel(1); // 默认层级
        }
        if (indexCategoryVO.getType() == null) {
            indexCategoryVO.setType(0); // 默认类型
        }
        indexCategoryVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
        indexCategoryVO.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return indexCategoryMapper.insert(IndexCategoryConvert.INSTANCE.convert(indexCategoryVO)) > 0;
    }


    @Override
    public boolean updateIndexCategory(Integer pkId, String name, Integer isShow, Integer sort, Integer parentId) {
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
    public List<IndexCategoryVO> getIndexCategories() {
        List<IndexCategory> indexCategoryList = indexCategoryMapper.selectList(null);
        return TreeUtils.build(IndexCategoryConvert.INSTANCE.convertToIndexCategoryVOList(indexCategoryList));

    }

}
