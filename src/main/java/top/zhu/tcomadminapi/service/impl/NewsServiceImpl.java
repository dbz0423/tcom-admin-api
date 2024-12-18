package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.convert.NewsConvert;
import top.zhu.tcomadminapi.mapper.NewsMapper;
import top.zhu.tcomadminapi.model.entity.News;
import top.zhu.tcomadminapi.model.vo.NewsVO;
import top.zhu.tcomadminapi.service.NewsService;

import java.util.List;

/**
 * 资讯表 Service 实现类
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Override
    public boolean addNews(NewsVO newsVO) {
        if (newsVO.getCover() == null) {
            newsVO.setCover("avatar/4yZSJHBrsa.jpg");
        }
        System.out.println(newsVO.getContent());
        return save(NewsConvert.INSTANCE.convert(newsVO)); // MyBatis-Plus 提供的保存方法
    }

    @Override
    public boolean updateNews(News news) {
        if (news.getCover() == null) {
            news.setCover("avatar/4yZSJHBrsa.jpg");
        }
        return updateById(news); // MyBatis-Plus 提供的更新方法
    }

    @Override
    public boolean deleteNews(Integer pkId) {
        return removeById(pkId); // MyBatis-Plus 提供的删除方法
    }

    @Override
    public boolean deleteNewsBatch(List<Integer> pkIds) {
        return removeByIds(pkIds); // MyBatis-Plus 提供的批量删除方法
    }

    @Override
    public News getNewsById(Integer pkId) {
        return getById(pkId); // MyBatis-Plus 提供的根据ID查询方法
    }

    @Override
    public List<News> getAllNews() {
        return list(); // MyBatis-Plus 提供的查询所有方法
    }



    @Override
    public PageResult<News> getNewsList(int pageNum, int pageSize, String title) {
        // 创建分页对象
        Page<News> page = new Page<>(pageNum, pageSize);

        // 构建查询条件
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        if (title != null && !title.isEmpty()) {
            queryWrapper.like("title", title);  // 按照标题进行模糊查询
        }

        // 分页查询
        Page<News> newsPage = this.page(page, queryWrapper);

        // 使用现有的 PageResult 封装分页结果
        return new PageResult<>(newsPage.getTotal(), newsPage.getRecords());
    }
}
