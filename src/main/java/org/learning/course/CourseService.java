package org.learning.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public List<Course> getAllCourses(String topicId){
        List<Course> courses = new ArrayList<>();
        Iterable<Course> itr = courseRepository.findByTopicId(topicId);
        for (Course course : itr){
            courses.add(course);
        }
        return courses;
    }

    public Course getCourse(String id){
        return courseRepository.findOne(id);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course){
        courseRepository.save(course);
    }

    public void deleteCourse(String id){
        courseRepository.delete(id);
    }
}
