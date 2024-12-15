package top.zhu.tcomadminapi.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.zhu.tcomadminapi.model.entity.ResourceCategory;
import top.zhu.tcomadminapi.model.vo.ResourceCategoryVO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResourceCategoryConvert {

    // 获取当前转换器的实例
    ResourceCategoryConvert INSTANCE = Mappers.getMapper(ResourceCategoryConvert.class);

    // 将 ResourceCategory 转换为 ResourceCategoryVO
    ResourceCategoryVO convert(ResourceCategory resourceCategory);

    ResourceCategory convert(ResourceCategoryVO resourceCategoryVO);

    // 将 ResourceCategory 列表转换为 ResourceCategoryVO 列表
    List<ResourceCategoryVO> convertToResourceCategoryVOList(List<ResourceCategory> resourceCategorys);
}
