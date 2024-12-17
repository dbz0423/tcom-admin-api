package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.common.model.Query;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.model.dto.ProfessorCategoryEditDTO;
import top.zhu.tcomadminapi.model.entity.ProfessorCategory;
import top.zhu.tcomadminapi.model.vo.IndexCategoryVO;
import top.zhu.tcomadminapi.model.vo.ProfessorCategoryVO;
import top.zhu.tcomadminapi.model.vo.ResourceCategoryVO;

import java.util.List;

/**
 * 专家分类服务层接口
 */
public interface ProfessorCategoryService extends IService<ProfessorCategory> {

    List<ProfessorCategory> getSubCategoriesByParentId(Long parentId);

    List<ProfessorCategory> searchCategoriesByName(String name);

    List<ProfessorCategory> getCategoriesByLevel(Integer level);

    boolean addProfessorCategory(ProfessorCategoryVO professorCategoryVO);

    boolean updateProfessorCategory(Integer pkId, String name, String cover, Integer sort , Integer parentId);

    boolean deleteProfessorCategory(Long pkId);

    List<ProfessorCategoryVO> getProfessorCategories();
}
