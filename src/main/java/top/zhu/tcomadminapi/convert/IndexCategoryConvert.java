package top.zhu.tcomadminapi.convert;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.zhu.tcomadminapi.model.entity.IndexCategory;
import top.zhu.tcomadminapi.model.vo.IndexCategoryVO;

import java.util.List;

@Mapper
public interface IndexCategoryConvert {
    // 获取当前转换器的实例
    IndexCategoryConvert INSTANCE = Mappers.getMapper(IndexCategoryConvert.class);

    IndexCategory convert(IndexCategoryVO vo);

    IndexCategoryVO convert(IndexCategory indexCategory);

    List<IndexCategoryVO> convertToIndexCategoryVOList(List<IndexCategory> indexCategoryList);
}
