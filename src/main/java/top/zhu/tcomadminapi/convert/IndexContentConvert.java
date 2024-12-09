package top.zhu.tcomadminapi.convert;

import top.zhu.tcomadminapi.model.entity.IndexContent;
import top.zhu.tcomadminapi.model.vo.IndexContentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IndexContentConvert {

    // 获取当前转换器的实例
    IndexContentConvert INSTANCE = Mappers.getMapper(IndexContentConvert.class);

    // 将 IndexContent 转换为 IndexContentVO
    IndexContentVO convert(IndexContent indexContent);

    // 将 IndexContent 列表转换为 IndexContentVO 列表
    List<IndexContentVO> convertToIndexContentVOList(List<IndexContent> indexContents);
}
