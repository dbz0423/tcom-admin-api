package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.model.entity.Podcast;

import java.util.List;

public interface PodcastService extends IService<Podcast> {

    // 批量删除播客
    boolean deletePodcasts(List<Integer> pkIds);
}
