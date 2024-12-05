package top.zhu.tcomadminapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.model.entity.ProfessorCategory;
import top.zhu.tcomadminapi.service.ProfessorCategoryService;

import java.util.List;

/**
 * 专家分类管理
 */
@RestController
@RequestMapping("/professor-category")
public class ProfessorCategoryController {

    @Autowired
    private ProfessorCategoryService professorCategoryService;

    /**
     * 新增专家分类
     */
    @PostMapping("/add")
    public boolean addProfessorCategory(@RequestBody ProfessorCategory professorCategory) {
        return professorCategoryService.save(professorCategory);
    }

    /**
     * 更新专家分类
     */
    @PutMapping("/update")
    public boolean updateProfessorCategory(@RequestBody ProfessorCategory professorCategory) {
        return professorCategoryService.updateById(professorCategory);
    }

    /**
     * 删除专家分类
     */
    @DeleteMapping("/delete/{id}")
    public boolean deleteProfessorCategory(@PathVariable("id") Long id) {
        return professorCategoryService.removeById(id);
    }

    /**
     * 根据 ID 查询专家分类
     */
    @GetMapping("/get/{id}")
    public ProfessorCategory getProfessorCategoryById(@PathVariable("id") Long id) {
        return professorCategoryService.getById(id);
    }

    /**
     * 查询所有专家分类
     */
    @GetMapping("/list")
    public List<ProfessorCategory> getAllProfessorCategories() {
        return professorCategoryService.list();
    }

    /**
     * 根据父分类 ID 查询子分类
     */
    @GetMapping("/sub-categories/{parentId}")
    public List<ProfessorCategory> getSubCategoriesByParentId(@PathVariable("parentId") Long parentId) {
        return professorCategoryService.getSubCategoriesByParentId(parentId);
    }

    /**
     * 根据分类名称模糊查询
     */
    @GetMapping("/search-by-name")
    public List<ProfessorCategory> searchCategoriesByName(@RequestParam("name") String name) {
        return professorCategoryService.searchCategoriesByName(name);
    }

    /**
     * 根据分类层级查询
     */
    @GetMapping("/search-by-level")
    public List<ProfessorCategory> getCategoriesByLevel(@RequestParam("level") Integer level) {
        return professorCategoryService.getCategoriesByLevel(level);
    }
}
