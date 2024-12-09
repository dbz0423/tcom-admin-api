package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.ProfessorMapper;
import top.zhu.tcomadminapi.model.entity.Professor;
import top.zhu.tcomadminapi.service.ProfessorService;
import java.util.List;

@Service
public class ProfessorServiceImpl extends ServiceImpl<ProfessorMapper, Professor> implements ProfessorService {

    @Override
    public boolean addProfessor(Professor professor) {
        return save(professor);  // MyBatis-Plus 提供的 save 方法
    }

    @Override
    public boolean deleteProfessor(Long pkId) {
        return removeById(pkId);  // MyBatis-Plus 提供的 removeById 方法
    }

    @Override
    public boolean updateProfessor(Professor professor) {
        return updateById(professor);  // MyBatis-Plus 提供的 updateById 方法
    }

    @Override
    public Professor getProfessorById(Long pkId) {
        return getById(pkId);  // MyBatis-Plus 提供的 getById 方法
    }

    @Override
    public List<Professor> getAllProfessors() {
        return list();  // MyBatis-Plus 提供的 list 方法
    }

    @Override
    public List<Professor> searchProfessors(String name, String hospital, String profession) {
        // 创建查询条件构造器
        QueryWrapper<Professor> queryWrapper = new QueryWrapper<>();

        // 如果指定了姓名，进行模糊查询
        if (name != null && !name.isEmpty()) {
            queryWrapper.like("name", name);  // 使用 LIKE 进行模糊匹配
        }

        // 如果指定了医院，进行模糊查询
        if (hospital != null && !hospital.isEmpty()) {
            queryWrapper.like("hospital", hospital);  // 使用 LIKE 进行模糊匹配
        }

        // 如果指定了职业，进行模糊查询
        if (profession != null && !profession.isEmpty()) {
            queryWrapper.like("profession", profession);  // 使用 LIKE 进行模糊匹配
        }

        // 按照创建时间降序排序
        queryWrapper.orderByDesc("create_time");

        // 执行查询并返回符合条件的专家列表
        return list(queryWrapper);  // 使用 MyBatis-Plus 提供的 list 方法并传入 QueryWrapper
    }
}
