package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.model.entity.News;

import java.util.List;

/**
 * 资讯表 Service 接口
 */
public interface NewsService extends IService<News> {
    // 额外的服务方法（如果需要自定义增删改查等）
    boolean addNews(News news);
    boolean updateNews(News news);
    boolean deleteNews(Integer pkId);
    boolean deleteNewsBatch(List<Integer> pkIds);
    News getNewsById(Integer pkId);
    List<News> getAllNews();
}
