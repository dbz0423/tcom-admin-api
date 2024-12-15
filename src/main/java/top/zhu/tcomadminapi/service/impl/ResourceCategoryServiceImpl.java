package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.convert.ResourceCategoryConvert;
import top.zhu.tcomadminapi.mapper.ResourceCategoryMapper;
import top.zhu.tcomadminapi.model.entity.ResourceCategory;
import top.zhu.tcomadminapi.model.vo.ResourceCategoryVO;
import top.zhu.tcomadminapi.service.ResourceCategoryService;
import top.zhu.tcomadminapi.utils.TreeUtils;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public boolean addResourceCategory(ResourceCategoryVO resourceCategoryVO) {
        if (resourceCategoryVO.getType() == null) {
            // 默认类型
            resourceCategoryVO.setType(0);
        }
        resourceCategoryVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
        resourceCategoryVO.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return resourceCategoryMapper.insert(ResourceCategoryConvert.INSTANCE.convert(resourceCategoryVO)) > 0;
    }

    @Override
    public boolean updateResourceCategory(Integer pkId, String title, Integer sort, Integer parentId) {
        QueryWrapper<ResourceCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pk_id", pkId);
        ResourceCategory resourceCategory = resourceCategoryMapper.selectOne(queryWrapper);

        if (resourceCategory != null) {
            resourceCategory.setTitle(title);
            resourceCategory.setSort(sort);
            // 更新 parent_id
            resourceCategory.setParentId(parentId);
            resourceCategory.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            return resourceCategoryMapper.updateById(resourceCategory) > 0;
        }
        return false;
    }

    @Override
    public boolean deleteResourceCategory(Long pkId) {
        return resourceCategoryMapper.deleteById(pkId) > 0;
    }

    @Override
    public List<ResourceCategoryVO> getResourceCategories() {
        List<ResourceCategory> resourceCategoryList = resourceCategoryMapper.selectList(null);
        return TreeUtils.build(ResourceCategoryConvert.INSTANCE.convertToResourceCategoryVOList(resourceCategoryList));
    }
}
