package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.model.entity.IndexCategory;
import top.zhu.tcomadminapi.model.vo.IndexCategoryVO;

import java.util.List;

public interface IndexCategoryService {

    // 新增首页分类
    boolean addIndexCategory(IndexCategoryVO indexCategoryVO);

    // 修改首页分类
    boolean updateIndexCategory(Integer pkId, String name, Integer isShow, Integer sort , Integer parentId);

    // 删除首页分类
    boolean deleteIndexCategory(Long pkId);

    // 获取首页分类列表
    List<IndexCategoryVO> getIndexCategories();
}
