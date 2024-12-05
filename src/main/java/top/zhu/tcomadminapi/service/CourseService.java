package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.model.entity.Course;

import java.util.List;

public interface CourseService extends IService<Course> {

    // 增加课程
    boolean addCourse(Course course);

    // 删除课程
    boolean deleteCourse(Integer pkId);

    // 批量删除课程
    boolean deleteCourses(List<Integer> pkIds);

    // 更新课程
    boolean updateCourse(Course course);

    // 根据ID获取课程详情
    Course getCourseById(Integer pkId);

    // 获取所有课程
    List<Course> getAllCourses();
}
