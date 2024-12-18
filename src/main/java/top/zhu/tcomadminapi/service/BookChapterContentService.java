package top.zhu.tcomadminapi.service;

import top.zhu.tcomadminapi.model.entity.BookChapter;

import java.util.List;

public interface BookChapterContentService {
    List<BookChapter> getBookChapter(String title);

    void setBookChapterContent(Integer chapterId, String content);
}
