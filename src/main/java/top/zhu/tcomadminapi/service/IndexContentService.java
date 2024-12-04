package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.model.entity.IndexContent;

import java.util.List;

public interface IndexContentService {

    // 添加首页内容
    boolean addIndexContent(IndexContent indexContent);

    // 获取所有首页内容
    List<IndexContent> getAllIndexContents();

    // 根据ID获取首页内容
    IndexContent getIndexContentById(Long pkId);

    // 删除首页内容
    boolean deleteIndexContent(Long pkId);
}
