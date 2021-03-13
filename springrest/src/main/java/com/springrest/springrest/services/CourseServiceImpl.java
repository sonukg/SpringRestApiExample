package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CoursesDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	//List<Course> list;
	@Autowired
	private CoursesDao courseDao;
	
	public CourseServiceImpl() {
		
		/*
		 * list=new ArrayList<>(); list.add(new
		 * Course(1,"Java Core Course","This is Java Core Course")); list.add(new
		 * Course(2,"Spring Boot Course","This is Spring Boot Course"));
		 */
	}
	
	@Override
	public List<Course> getCourses() {
	
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		/*
		 * Course c=null; for(Course course:list) { if(course.getId()==courseId) {
		 * c=course; break; } }
		 */
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		/*
		 * list.forEach(e ->{ if (e.getId()==course.getId()) {
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription()); }
		 * });
		 */
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course course=courseDao.getOne(parseLong);
		courseDao.delete(course);
	}

}
