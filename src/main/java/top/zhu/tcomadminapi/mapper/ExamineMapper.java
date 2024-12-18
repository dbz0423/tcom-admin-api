package top.zhu.tcomadminapi.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zhu.tcomadminapi.model.entity.Examine;

@Mapper
public interface ExamineMapper extends BaseMapper<Examine> {
    // 直接继承 BaseMapper，无需额外代码
}