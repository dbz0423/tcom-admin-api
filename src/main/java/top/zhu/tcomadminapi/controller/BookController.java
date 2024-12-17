package top.zhu.tcomadminapi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import top.zhu.tcomadminapi.common.result.Result;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.model.entity.Book;
import top.zhu.tcomadminapi.service.BookService;

import java.util.List;

/**
 * 图书管理
 */
@RestController
@RequestMapping("/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 新增图书
     *
     * @param book 图书信息
     * @return 返回新增成功或失败的状态码和消息
     */
    @Operation(summary = "新增图书", description = "新增一本图书")
    @PostMapping("/add")
    public Result<?> addBook(@RequestBody Book book) {
        boolean success = bookService.save(book);
        return success ? Result.ok("图书新增成功") : Result.error("图书新增失败");
    }

    /**
     * 删除图书
     *
     * @param pkId 图书的 ID
     * @return 返回 200 OK 或 404 Not Found 状态码
     */
    @Operation(summary = "删除图书", description = "根据 ID 删除图书")
    @DeleteMapping("/delete/{id}")
    public Result<?> deleteBook(@PathVariable("id") Integer pkId) {
        boolean success = bookService.removeById(pkId);
        return success ? Result.ok("图书删除成功") : Result.error("图书删除失败");
    }

    /**
     * 批量删除图书
     *
     * @param pkIds 图书的 ID 列表
     * @return 返回 200 OK 或 400 Bad Request 状态码
     */
    @Operation(summary = "批量删除图书", description = "根据 ID 列表批量删除图书")
    @DeleteMapping("/batch")
    public Result<?> deleteBooks(@RequestBody List<Integer> pkIds) {
        boolean success = bookService.deleteBooks(pkIds);
        return success ? Result.ok("批量图书删除成功") : Result.error("批量图书删除失败");
    }

    /**
     * 更新图书
     *
     * @param book 更新后的图书信息
     * @return 返回 200 OK 或 400 Bad Request 状态码
     */
    @Operation(summary = "更新图书", description = "更新图书信息")
    @PutMapping("/update")
    public Result<?> updateBook(@RequestBody Book book) {
        boolean success = bookService.updateById(book);
        return success ? Result.ok("图书更新成功") : Result.error("图书更新失败");
    }

    /**
     * 根据 ID 查询图书
     *
     * @param pkId 图书的 ID
     * @return 返回图书信息或 404 Not Found 状态码
     */
    @Operation(summary = "根据 ID 查询图书", description = "根据图书 ID 查询详细图书信息")
    @GetMapping("/{id}")
    public Result<?> getBookById(@PathVariable("id") Integer pkId) {
        Book book = bookService.getById(pkId);
        return book != null ? Result.ok(book) : Result.error("图书未找到");
    }

    /**
     * 查询所有图书
     *
     * @return 返回所有图书的列表
     */
    @Operation(summary = "查询所有图书", description = "查询所有图书信息")
    @GetMapping("/all")
    public Result<?> getAllBooks() {
        List<Book> books = bookService.list();
        return Result.ok(books);
    }

    /**
     * 分页查询图书
     *
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 返回分页后的图书列表
     */
    @Operation(summary = "分页查询图书", description = "根据页码和每页大小分页查询图书")
    @GetMapping("/page")
    public Result<Page<Book>> getBookPage(
            @RequestParam int pageNum,
            @RequestParam int pageSize) {

        Page<Book> page = new Page<>(pageNum, pageSize);
        bookService.page(page); // 调用 MyBatis-Plus 提供的分页查询方法

        return Result.ok(page);
    }
}
