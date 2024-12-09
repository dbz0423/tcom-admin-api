package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.PodcastMapper;
import top.zhu.tcomadminapi.model.entity.Podcast;
import top.zhu.tcomadminapi.service.PodcastService;

import java.util.List;

@Service
public class PodcastServiceImpl extends ServiceImpl<PodcastMapper, Podcast> implements PodcastService {

    @Autowired
    private PodcastMapper podcastMapper;

    @Override
    public boolean deletePodcasts(List<Integer> pkIds) {
        return removeByIds(pkIds); // MyBatis-Plus 提供的批量删除方法
    }
}
