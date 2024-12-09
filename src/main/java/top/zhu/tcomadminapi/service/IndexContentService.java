package top.zhu.tcomadminapi.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.model.entity.IndexContent;
import top.zhu.tcomadminapi.model.query.IndexContentQuery;
import top.zhu.tcomadminapi.model.vo.IndexContentVO;

import java.util.List;

public interface IndexContentService extends IService<IndexContent> {

    /**
     * 分页查询首页内容
     * @param indexContentQuery 查询参数
     * @return 分页结果
     */
    PageResult<IndexContentVO> page(IndexContentQuery indexContentQuery);

    /**
     * 根据 ID 获取首页内容
     * @param pkId 首页内容ID
     * @return 首页内容视图对象
     */
    IndexContentVO getIndexContentById(Long pkId);

    /**
     * 添加首页内容
     * @param indexContent 首页内容实体
     * @return 是否添加成功
     */
    boolean addIndexContent(IndexContent indexContent);

    /**
     * 更新首页内容
     * @param indexContent 首页内容实体
     * @return 是否更新成功
     */
    boolean updateIndexContent(IndexContent indexContent);

    /**
     * 删除首页内容
     * @param pkId 首页内容ID
     * @return 是否删除成功
     */
    boolean deleteIndexContent(Long pkId);

    /**
     * 获取所有首页内容
     * @return 首页内容列表
     */
    List<IndexContent> getAllIndexContents();
}
