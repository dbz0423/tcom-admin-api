package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.model.vo.ResourceCategoryVO;

import java.util.List;

public interface ResourceCategoryService {
    // 新增首页分类
    boolean addResourceCategory(ResourceCategoryVO resourceCategoryVO);

    // 修改首页分类
    boolean updateResourceCategory(Integer pkId, String title, Integer sort , Integer parentId);

    // 删除首页分类
    boolean deleteResourceCategory(Long pkId);

    // 获取首页分类列表
    List<ResourceCategoryVO> getResourceCategories();
}
