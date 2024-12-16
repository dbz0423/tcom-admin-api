package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.zhu.tcomadminapi.model.entity.ProfessorCategory;
import top.zhu.tcomadminapi.model.query.ProfessorCategoryQuery;
import top.zhu.tcomadminapi.model.vo.ProfessorCategoryVO;

import java.util.List;

/**
 * 专家分类表 Mapper
 */
public interface ProfessorCategoryMapper extends BaseMapper<ProfessorCategory> {

}
