package top.zhu.tcomadminapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.model.entity.Professor;
import top.zhu.tcomadminapi.service.ProfessorService;

import java.util.List;

/**
 * 专家管理
 */
@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;  // 专家相关的服务类，用于处理业务逻辑

    /**
     * 添加新的专家
     *
     * @param professor 待添加的专家信息
     * @return 返回操作结果，成功返回 true，失败返回 false
     */
    @PostMapping
    public boolean addProfessor(@RequestBody Professor professor) {
        // 调用服务层方法添加专家
        return professorService.addProfessor(professor);
    }

    /**
     * 根据专家的 ID 删除专家
     *
     * @param pkId 专家的唯一标识（ID）
     * @return 返回操作结果，成功返回 true，失败返回 false
     */
    @DeleteMapping("/{pkId}")
    public boolean deleteProfessor(@PathVariable Long pkId) {
        // 调用服务层方法删除指定 ID 的专家
        return professorService.deleteProfessor(pkId);
    }

    /**
     * 更新专家信息
     *
     * @param professor 包含更新信息的专家对象
     * @return 返回操作结果，成功返回 true，失败返回 false
     */
    @PutMapping
    public boolean updateProfessor(@RequestBody Professor professor) {
        // 调用服务层方法更新专家信息
        return professorService.updateProfessor(professor);
    }

    /**
     * 根据专家 ID 获取专家信息
     *
     * @param pkId 专家的唯一标识（ID）
     * @return 返回指定 ID 的专家信息
     */
    @GetMapping("/{pkId}")
    public Professor getProfessorById(@PathVariable Long pkId) {
        // 调用服务层方法根据 ID 获取专家信息
        return professorService.getProfessorById(pkId);
    }

    /**
     * 获取所有专家信息
     *
     * @return 返回包含所有专家信息的列表
     */
    @GetMapping
    public List<Professor> getAllProfessors() {
        // 调用服务层方法获取所有专家信息
        return professorService.getAllProfessors();
    }

    /**
     * 根据指定条件搜索专家
     *
     * @param name       专家的姓名（模糊匹配）
     * @param hospital   专家的医院名称（模糊匹配）
     * @param profession 专家的职业（模糊匹配）
     * @return 返回符合条件的专家信息列表
     */
    @GetMapping("/search")
    public List<Professor> searchProfessors(@RequestParam(required = false) String name,
                                            @RequestParam(required = false) String hospital,
                                            @RequestParam(required = false) String profession) {
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

        // 打印生成的 SQL 查询语句（可选，用于调试）
        System.out.println("Generated SQL: " + queryWrapper.getSqlSegment());

        // 执行查询并返回符合条件的专家列表
        List<Professor> professors = professorService.list(queryWrapper);

        // 如果查询没有返回预期结果，打印调试信息
        if (professors.isEmpty()) {
            System.out.println("No professors found for the given criteria.");
        }

        return professors;
    }
}

