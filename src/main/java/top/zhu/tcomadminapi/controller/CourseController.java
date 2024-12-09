package top.zhu.tcomadminapi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.model.entity.Course;
import top.zhu.tcomadminapi.service.CourseService;

import java.util.List;

/**
 * 课程管理
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 新增课程
     *
     * @param course 课程信息
     * @return 返回新增成功或失败的状态码和消息
     */
    @Operation(summary = "新增课程", description = "新增一门课程")
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        boolean success = courseService.addCourse(course);
        return success ? ResponseEntity.ok("课程新增成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("课程新增失败");
    }

    /**
     * 删除课程
     *
     * @param pkId 课程的 ID
     * @return 返回 200 OK 或 404 Not Found 状态码
     */
    @Operation(summary = "删除课程", description = "根据 ID 删除课程")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Integer pkId) {
        boolean success = courseService.deleteCourse(pkId);
        return success ? ResponseEntity.ok("课程删除成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("课程删除失败");
    }

    /**
     * 批量删除课程
     *
     * @param pkIds 课程的 ID 列表
     * @return 返回 200 OK 或 400 Bad Request 状态码
     */
    @Operation(summary = "批量删除课程", description = "根据 ID 列表批量删除课程")
    @DeleteMapping("/batch")
    public ResponseEntity<?> deleteCourses(@RequestBody List<Integer> pkIds) {
        boolean success = courseService.deleteCourses(pkIds);
        return success ? ResponseEntity.ok("批量课程删除成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("批量课程删除失败");
    }

    /**
     * 更新课程
     *
     * @param course 更新后的课程信息
     * @return 返回 200 OK 或 400 Bad Request 状态码
     */
    @Operation(summary = "更新课程", description = "更新课程信息")
    @PutMapping
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        boolean success = courseService.updateCourse(course);
        return success ? ResponseEntity.ok("课程更新成功") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("课程更新失败");
    }

    /**
     * 根据 ID 查询课程
     *
     * @param pkId 课程的 ID
     * @return 返回课程信息或 404 Not Found 状态码
     */
    @Operation(summary = "根据 ID 查询课程", description = "根据课程 ID 查询详细课程信息")
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") Integer pkId) {
        Course course = courseService.getCourseById(pkId);
        return course != null ? ResponseEntity.ok(course) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("课程未找到");
    }

    /**
     * 查询所有课程
     *
     * @return 返回所有课程的列表
     */
    @Operation(summary = "查询所有课程", description = "查询所有课程信息")
    @GetMapping("/all")
    public ResponseEntity<?> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    /**
     * 分页查询课程
     *
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 返回分页后的课程列表
     */
    @Operation(summary = "分页查询课程", description = "根据页码和每页大小分页查询课程")
    @GetMapping("/page")
    public ResponseEntity<Page<Course>> getCoursePage(
            @RequestParam int pageNum,
            @RequestParam int pageSize) {

        Page<Course> page = new Page<>(pageNum, pageSize);
        courseService.page(page); // 调用 MyBatis-Plus 提供的分页查询方法

        return ResponseEntity.ok(page);
    }
}