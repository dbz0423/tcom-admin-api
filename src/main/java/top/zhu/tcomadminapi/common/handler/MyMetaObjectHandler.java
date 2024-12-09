package top.zhu.tcomadminapi.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * MyBatis-Plus 元对象处理器，用于自动填充字段
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("Insert Fill Triggered");
        if (metaObject.hasSetter("createTime")) {
            System.out.println("Filling createTime");
            this.strictInsertFill(metaObject, "createTime", Timestamp.class, Timestamp.valueOf(LocalDateTime.now()));
        }
        if (metaObject.hasSetter("updateTime")) {
            System.out.println("Filling updateTime");
            this.strictInsertFill(metaObject, "updateTime", Timestamp.class, Timestamp.valueOf(LocalDateTime.now()));
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("Update Fill Triggered");
        if (metaObject.hasSetter("updateTime")) {
            this.strictUpdateFill(metaObject, "updateTime", Timestamp.class, Timestamp.valueOf(LocalDateTime.now()));
        }
    }
}
