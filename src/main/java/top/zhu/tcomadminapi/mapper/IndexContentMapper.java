package top.zhu.tcomadminapi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.zhu.tcomadminapi.model.entity.IndexContent;
import top.zhu.tcomadminapi.model.entity.Subject;

import java.util.List;

@Mapper
public interface IndexContentMapper {

    // 插入首页内容
    int insert(IndexContent indexContent);

    // 根据专题数据插入首页内容
    int insertFromSubject(@Param("subject") Subject subject);

    // 获取所有首页内容
    List<IndexContent> selectAll();

    // 根据ID获取首页内容
    IndexContent selectById(Long pkId);

    // 删除首页内容
    int deleteById(Long pkId);
}

