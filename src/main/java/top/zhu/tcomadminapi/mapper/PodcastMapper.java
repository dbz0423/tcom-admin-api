package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.zhu.tcomadminapi.model.entity.Podcast;

public interface PodcastMapper extends BaseMapper<Podcast> {
    // 继承了 MyBatis-Plus 提供的基本方法，不需要再额外定义增删改查方法
}
