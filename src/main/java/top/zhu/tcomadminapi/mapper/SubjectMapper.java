package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zhu.tcomadminapi.model.entity.Subject;
import top.zhu.tcomadminapi.model.entity.SubjectAssociated;
import top.zhu.tcomadminapi.model.entity.SubjectLabel;

@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {

}


