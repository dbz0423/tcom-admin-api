package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.NewsMapper;
import top.zhu.tcomadminapi.model.entity.News;
import top.zhu.tcomadminapi.service.NewsService;

import java.util.List;

/**
 * 资讯表 Service 实现类
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Override
    public boolean addNews(News news) {
        return save(news); // MyBatis-Plus 提供的保存方法
    }

    @Override
    public boolean updateNews(News news) {
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
}
