package top.zhu.tcomadminapi.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import top.zhu.tcomadminapi.model.entity.Subject;
import top.zhu.tcomadminapi.model.vo.SubjectVO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectConvert {

    // 将 Subject 转换为 SubjectVO
    @Mapping(source = "state", target = "stateDesc", qualifiedByName = "mapStateToDesc")
    @Mapping(source = "createTime", target = "createTime") // 不再需要转换
    @Mapping(source = "updateTime", target = "updateTime") // 不再需要转换
    SubjectVO convert(Subject subject);

    // 将 Subject 列表转换为 SubjectVO 列表
    List<SubjectVO> convertToSubjectVOList(List<Subject> subjects);

    // 将 SubjectVO 转换为 Subject
    Subject toSubject(SubjectVO subjectVO);

    // 将 SubjectVO 列表转换为 Subject 列表
    List<Subject> toSubjectList(List<SubjectVO> subjectVOs);

    // 状态转换方法
    @Named("mapStateToDesc")
    default String mapStateToDesc(Integer state) {
        switch (state) {
            case 0: return "编辑中";
            case 1: return "审核中";
            case 2: return "审核不通过";
            case 3: return "未发布";
            case 4: return "已发布";
            default: return "未知状态";
        }
    }
}
