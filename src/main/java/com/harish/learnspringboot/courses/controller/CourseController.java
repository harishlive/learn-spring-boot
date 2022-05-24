package com.harish.learnspringboot.courses.controller;

import com.harish.learnspringboot.courses.bean.Course;
import com.harish.learnspringboot.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository repository;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return repository.findAll();
//        return Arrays.asList(new Course(1,"learn Microservices","in28 minutes"));
    }

    @GetMapping("/courses/{id}")
    public Course getCoursesDetails(@PathVariable long id) {
        Optional<Course> course = repository.findById( id );
        if (course.isEmpty()) {
            throw new RuntimeException( "Course not found wit id " + id );
        }

        return course.get();
    }

    @PostMapping("/courses")
    public void createNewCourse(@RequestBody Course course) {
        repository.save( course );
    }
    @PutMapping ("/courses/{id}")
    public void updateCourse(@PathVariable long id, @RequestBody Course course) {
        repository.save( course );
    }

    @DeleteMapping  ("/courses/{id}")
    public void updateCourse(@PathVariable long id) {
        repository.deleteById( id );
    }

}
