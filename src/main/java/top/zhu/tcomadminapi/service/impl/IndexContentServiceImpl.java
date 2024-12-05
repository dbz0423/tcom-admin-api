package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.IndexContentMapper;
import top.zhu.tcomadminapi.model.entity.IndexContent;
import top.zhu.tcomadminapi.model.query.IndexContentQuery;
import top.zhu.tcomadminapi.model.vo.IndexContentVO;
import top.zhu.tcomadminapi.service.IndexContentService;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.convert.IndexContentConvert;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndexContentServiceImpl extends ServiceImpl<IndexContentMapper, IndexContent> implements IndexContentService {

    private final IndexContentMapper indexContentMapper;
    private final IndexContentConvert indexContentConvert;

    /**
     * 分页查询首页内容
     * @param indexContentQuery 查询参数
     * @return 分页结果
     */
    @Override
    public PageResult<IndexContentVO> page(IndexContentQuery indexContentQuery) {
        // 分页对象
        Page<IndexContent> page = new Page<>(indexContentQuery.getPage(), indexContentQuery.getLimit());

        // 构建查询条件
        QueryWrapper<IndexContent> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(StringUtils.isNotBlank(indexContentQuery.getTitle()), IndexContent::getTitle, indexContentQuery.getTitle())
                .eq(indexContentQuery.getCategoryId() != null, IndexContent::getCategoryId, indexContentQuery.getCategoryId())
                .eq(indexContentQuery.getType() != null, IndexContent::getType, indexContentQuery.getType())
                .ge(indexContentQuery.getCreateTime() != null, IndexContent::getCreateTime, indexContentQuery.getCreateTime())
                .le(indexContentQuery.getUpdateTime() != null, IndexContent::getUpdateTime, indexContentQuery.getUpdateTime());

        // 执行分页查询
        Page<IndexContent> indexContentPage = this.page(page, queryWrapper);

        // 将查询结果转为VO对象
        List<IndexContentVO> indexContentVOList = indexContentConvert.convertToIndexContentVOList(indexContentPage.getRecords());

        return new PageResult<>(indexContentVOList, indexContentPage.getTotal());
    }

    /**
     * 根据 ID 获取首页内容
     * @param pkId 首页内容ID
     * @return 首页内容视图对象
     */

    @Override
    public IndexContentVO getIndexContentById(Long pkId) {
        // 获取 IndexContent 实体对象
        IndexContent indexContent = this.getById(pkId);

        // 如果找不到对应的 IndexContent，则返回 null 或者抛出异常
        if (indexContent == null) {
            return null;
        }

        // 使用 IndexContentConvert 将实体转换为视图对象
        return indexContentConvert.convert(indexContent);
    }

    /**
     * 添加首页内容
     * @param indexContent 首页内容实体
     * @return 是否添加成功
     */
    @Override
    public boolean addIndexContent(IndexContent indexContent) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        indexContent.setCreateTime(currentTime);
        indexContent.setUpdateTime(currentTime);
        return this.save(indexContent);  // 调用 MyBatis-Plus 的 save 方法
    }

    /**
     * 更新首页内容
     * @param indexContent 首页内容实体
     * @return 是否更新成功
     */
    @Override
    public boolean updateIndexContent(IndexContent indexContent) {
        indexContent.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return this.updateById(indexContent);  // 调用 MyBatis-Plus 的 updateById 方法
    }

    /**
     * 删除首页内容
     * @param pkId 首页内容ID
     * @return 是否删除成功
     */
    @Override
    public boolean deleteIndexContent(Long pkId) {
        return this.removeById(pkId);  // 调用 MyBatis-Plus 的 removeById 方法
    }

    /**
     * 获取所有首页内容
     * @return 首页内容列表
     */
    @Override
    public List<IndexContent> getAllIndexContents() {
        return this.list();  // 调用 MyBatis-Plus 的 list 方法，获取所有数据
    }
}
