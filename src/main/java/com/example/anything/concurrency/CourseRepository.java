package com.example.anything.concurrency;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
    Course findCourseByCourseId(long id);
}
