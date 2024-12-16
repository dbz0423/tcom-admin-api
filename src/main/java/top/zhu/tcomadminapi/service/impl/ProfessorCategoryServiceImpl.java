package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.zhu.tcomadminapi.common.model.Query;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.convert.ProfessorCategoryConvert;
import top.zhu.tcomadminapi.mapper.ProfessorCategoryMapper;
import top.zhu.tcomadminapi.mapper.ProfessorMapper;
import top.zhu.tcomadminapi.model.entity.ProfessorCategory;
import top.zhu.tcomadminapi.model.vo.ProfessorCategoryVO;
import top.zhu.tcomadminapi.service.ProfessorCategoryService;
import top.zhu.tcomadminapi.utils.TreeUtils;

import java.util.List;

/**
 * 专家分类服务层实现
 */
@Service
public class ProfessorCategoryServiceImpl extends ServiceImpl<ProfessorCategoryMapper, ProfessorCategory> implements ProfessorCategoryService {

    @Autowired
    private ProfessorMapper professorMapper;
    @Autowired
    private ProfessorCategoryMapper professorCategoryMapper;

    public ProfessorCategoryServiceImpl(ProfessorMapper professorMapper, ProfessorCategoryMapper professorCategoryMapper) {
        this.professorMapper = professorMapper;
        this.professorCategoryMapper = professorCategoryMapper;
    }

    /**
     * 根据父分类 ID 查询所有子分类
     * @param parentId 父分类 ID
     * @return 子分类列表
     */
    @Override
    public List<ProfessorCategory> getSubCategoriesByParentId(Long parentId) {
        return this.baseMapper.selectList(new QueryWrapper<ProfessorCategory>().eq("parent_id", parentId));
    }

    /**
     * 根据分类名称模糊查询
     * @param name 分类名称
     * @return 符合条件的分类列表
     */
    @Override
    public List<ProfessorCategory> searchCategoriesByName(String name) {
        return this.baseMapper.selectList(new QueryWrapper<ProfessorCategory>().like("name", name));
    }

    /**
     * 根据分类层级查询
     * @param level 分类层级
     * @return 符合条件的分类列表
     */
    @Override
    public List<ProfessorCategory> getCategoriesByLevel(Integer level) {
        return this.baseMapper.selectList(new QueryWrapper<ProfessorCategory>().eq("level", level));
    }

    @Override
    public List<ProfessorCategoryVO> getProfessorCategories() {
        List<ProfessorCategory> professorCategoryList = professorCategoryMapper.selectList(null);
        return TreeUtils.build(ProfessorCategoryConvert.INSTANCE.convertToProfessorCategoryVOList(professorCategoryList));
    }
}
