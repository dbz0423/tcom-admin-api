package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.BookChapterContentMapper;
import top.zhu.tcomadminapi.model.entity.BookChapter;
import top.zhu.tcomadminapi.model.entity.BookChapterContent;
import top.zhu.tcomadminapi.service.BookChapterContentService;

import java.util.List;

@Service
@AllArgsConstructor
public class BookChapterContentServiceImpl extends ServiceImpl<BookChapterContentMapper, BookChapterContent> implements BookChapterContentService {

    private final BookChapterContentMapper bookChapterContentMapper;

    @Override
    public List<BookChapter> getBookChapter(String title) {
        return bookChapterContentMapper.getBookChapter(title);
    }

    @Override
    public void setBookChapterContent(Integer chapterId, String content) {
        bookChapterContentMapper.setBookChapterContent(chapterId, content);
    }
}
