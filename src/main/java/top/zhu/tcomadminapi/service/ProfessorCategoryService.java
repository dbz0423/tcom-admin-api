package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.model.entity.ProfessorCategory;

import java.util.List;

/**
 * 专家分类服务层接口
 */
public interface ProfessorCategoryService extends IService<ProfessorCategory> {

    List<ProfessorCategory> getSubCategoriesByParentId(Long parentId);

    List<ProfessorCategory> searchCategoriesByName(String name);

    List<ProfessorCategory> getCategoriesByLevel(Integer level);
}
