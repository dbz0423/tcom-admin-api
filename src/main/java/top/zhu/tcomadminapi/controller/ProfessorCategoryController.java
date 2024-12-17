package top.zhu.tcomadminapi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.dto.ProfessorCategoryEditDTO;
import top.zhu.tcomadminapi.model.entity.ProfessorCategory;
import top.zhu.tcomadminapi.model.vo.IndexCategoryVO;
import top.zhu.tcomadminapi.model.vo.ProfessorCategoryVO;
import top.zhu.tcomadminapi.model.vo.ResourceCategoryVO;
import top.zhu.tcomadminapi.service.ProfessorCategoryService;

import java.sql.Timestamp;
import java.util.List;

/**
 * 专家分类管理
 */
@RestController
@AllArgsConstructor
@RequestMapping("/v1/professor-category")
public class ProfessorCategoryController {

    private final ProfessorCategoryService professorCategoryService;

    /**
     * 新增专家分类
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody ProfessorCategoryVO professorCategoryVO) {
        System.out.println("接收到的数据: " + professorCategoryVO); // 调试打印

        professorCategoryVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
        professorCategoryVO.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        boolean success = professorCategoryService.addProfessorCategory(professorCategoryVO);
        return success ? Result.ok("分类添加成功") : Result.error("分类添加失败");
    }

    /**
     * 修改专家分类
     */
    @PutMapping("/update")
    public Result<String> updateProfessorCategory(@RequestBody ProfessorCategoryEditDTO request) {
        boolean success = professorCategoryService.updateProfessorCategory(request.getPkId(), request.getName(), request.getCover(), request.getSort(), request.getParentId());
        return success ? Result.ok("分类修改成功") : Result.error("分类不存在");
    }

    /**
     * 删除专家分类
     */
    @DeleteMapping("/delete/{pkId}")
    public Result<String> deleteProfessorCategory(@PathVariable Long pkId) {
        boolean success = professorCategoryService.deleteProfessorCategory(pkId);
        return success ? Result.ok("分类删除成功") : Result.error("分类不存在");
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
    public Result<PageResult<ProfessorCategoryVO>> getAllProfessorCategories() {
        List<ProfessorCategoryVO> list = professorCategoryService.getProfessorCategories();
        PageResult<ProfessorCategoryVO> page = new PageResult<>(list, list.size());
        return Result.ok(page);
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
