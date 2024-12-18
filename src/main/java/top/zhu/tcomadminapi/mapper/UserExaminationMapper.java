package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.zhu.tcomadminapi.model.entity.UserExamination;

import java.util.List;

public interface UserExaminationMapper extends BaseMapper<UserExamination> {

    List<UserExamination> selectExaminationFromCity(Integer cityId);

    List<UserExamination> selectExaminationFromCityAndFinish(Integer cityId);

    List<UserExamination> selectExaminationFromCityAndPass(Integer cityId);
}
