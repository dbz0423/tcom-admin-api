package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.model.entity.IndexCategory;

import java.util.List;

public interface IndexCategoryService {

    // 新增首页分类
    boolean addIndexCategory(IndexCategory indexCategory);

    // 修改首页分类
    boolean updateIndexCategory(Long pkId, String name, Integer isShow, Integer sort , Long parentId);

    // 删除首页分类
    boolean deleteIndexCategory(Long pkId);

    // 获取首页分类列表
    List<IndexCategory> getIndexCategories();
}
