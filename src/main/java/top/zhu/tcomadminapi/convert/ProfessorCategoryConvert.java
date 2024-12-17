package top.zhu.tcomadminapi.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.zhu.tcomadminapi.model.dto.ProfessorCategoryEditDTO;
import top.zhu.tcomadminapi.model.entity.ProfessorCategory;
import top.zhu.tcomadminapi.model.vo.ProfessorCategoryVO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessorCategoryConvert {

    ProfessorCategoryConvert INSTANCE = Mappers.getMapper(ProfessorCategoryConvert.class);

    ProfessorCategoryVO convert(ProfessorCategory professorCategory);

    ProfessorCategory convert(ProfessorCategoryVO professorCategoryVO);

    ProfessorCategory convert(ProfessorCategoryEditDTO dto);

    List<ProfessorCategoryVO> convertToProfessorCategoryVOList(List<ProfessorCategory> resourceCategorys);
}
