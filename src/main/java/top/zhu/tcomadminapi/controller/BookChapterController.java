package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.entity.BookChapter;
import top.zhu.tcomadminapi.model.entity.BookChapterContent;
import top.zhu.tcomadminapi.service.BookChapterContentService;

import java.util.List;

@RestController
@RequestMapping("/v1/bookChapter")
@AllArgsConstructor
public class BookChapterController {

    private final BookChapterContentService bookChapterContentService;


    // 获取图书章节
    @Operation(summary = "获取图书章节")
    @GetMapping("/chapter/{title}")
    public Result<List<BookChapter>> getBookChapter(@PathVariable("title") String title) {
        List<BookChapter> bookChapterList = bookChapterContentService.getBookChapter(title);
        return Result.ok(bookChapterList);
    }

    @Operation(summary = "添加图片")
    @PostMapping("/chapter/add")
    public Result<String> addBookChapter(@RequestBody BookChapterContent bookChapterContent) {
        bookChapterContentService.setBookChapterContent(bookChapterContent.getChapterId(),bookChapterContent.getContent());
        return Result.ok("添加成功");
    }

}
