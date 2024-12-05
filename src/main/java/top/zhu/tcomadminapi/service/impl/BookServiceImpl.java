package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.BookMapper;
import top.zhu.tcomadminapi.model.entity.Book;
import top.zhu.tcomadminapi.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean deleteBooks(List<Integer> pkIds) {
        return removeByIds(pkIds); // MyBatis-Plus 提供的批量删除方法
    }
}
