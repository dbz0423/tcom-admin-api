package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.model.entity.Professor;
import java.util.List;

public interface ProfessorService extends IService<Professor> {
    // 新增专家
    boolean addProfessor(Professor professor);

    // 删除专家
    boolean deleteProfessor(Long pkId);

    // 更新专家信息
    boolean updateProfessor(Professor professor);

    // 查询专家
    Professor getProfessorById(Long pkId);

    // 查询所有专家
    List<Professor> getAllProfessors();

    // 根据条件查询专家
    List<Professor> searchProfessors(String name, String hospital, String profession);
}
