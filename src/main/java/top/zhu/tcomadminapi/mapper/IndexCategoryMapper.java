package top.zhu.tcomadminapi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.zhu.tcomadminapi.model.entity.IndexCategory;

import java.util.List;

@Mapper
public interface IndexCategoryMapper {

    // 插入分类
    int insert(IndexCategory indexCategory);

    // 根据 id 查找分类
    IndexCategory selectById(Long pkId);

    // 根据 id 更新分类
    int updateById(IndexCategory indexCategory);

    // 删除分类
    int deleteById(Long pkId);

    // 查询所有分类
    List<IndexCategory> selectList(@Param("query") Object query);
}
