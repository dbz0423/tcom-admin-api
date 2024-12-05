package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.model.entity.Book;

import java.util.List;

public interface BookService extends IService<Book> {

    // 批量删除图书
    boolean deleteBooks(List<Integer> pkIds);
}
