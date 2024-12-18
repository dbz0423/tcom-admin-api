package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import top.zhu.tcomadminapi.model.entity.BookChapter;
import top.zhu.tcomadminapi.model.entity.BookChapterContent;

import java.util.List;

public interface BookChapterContentMapper extends BaseMapper<BookChapterContent> {

    List<BookChapter> getBookChapter(String title);

    void setBookChapterContent(Integer chapterId, String content);
}
