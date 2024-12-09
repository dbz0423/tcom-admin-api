package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.CourseMapper;
import top.zhu.tcomadminapi.model.entity.Course;
import top.zhu.tcomadminapi.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public boolean addCourse(Course course) {
        return save(course); // MyBatis-Plus 提供的 save 方法
    }

    @Override
    public boolean deleteCourse(Integer pkId) {
        return removeById(pkId); // MyBatis-Plus 提供的 removeById 方法
    }

    @Override
    public boolean deleteCourses(List<Integer> pkIds) {
        return removeByIds(pkIds); // MyBatis-Plus 提供的 removeByIds 方法
    }

    @Override
    public boolean updateCourse(Course course) {
        return updateById(course); // MyBatis-Plus 提供的 updateById 方法
    }

    @Override
    public Course getCourseById(Integer pkId) {
        return getById(pkId); // MyBatis-Plus 提供的 getById 方法
    }

    @Override
    public List<Course> getAllCourses() {
        return list(); // MyBatis-Plus 提供的 list 方法
    }
}
