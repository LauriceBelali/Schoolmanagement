package test;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import main.UserInterface;
import models.Course;
import models.Student;
import services.Service;

public class UnitTest {

	
	private Service service = new Service();
	private static UserInterface userInterface = new UserInterface();

	@Test
	public void testAddCourse() {
		Course c = new Course(1, "English", "22/01/2019", 2);
		assertEquals("Course was added successefly", service.addCourse(c));
	}

	@Test
	public void testErrorAddCourse() {
		Course c1 = new Course(1, "English", "22/01/2019", 2);
		Course c2 = c1;
		assertEquals("Course was added successefly", service.addCourse(c1));
		assertEquals("Error ! impossible to add course", service.addCourse(c2));
	}

	@Test
	public void testDeleteCourse() {
		Course c = new Course(1, "English", "22/01/2019", 2);
		service.addCourse(c);
		assertEquals("Course was deleted successefly", service.deleteCourse(1));
	}

	@Test
	public void testErrorDeleteCourse() {
		assertEquals("Error ! Course not found", service.deleteCourse(5));
	}

	@Test
	public void testAddStudent() {
		service.showCourses();
		Course c = new Course(1, "English", "22/01/2019", 2);
		service.addCourse(c);
		service.showCourses();
		assertEquals("Student was successefly added !",
				service.getCourse(1).addStudent(new Student(1, "Me", "me@gmail.com", "Address")));
		service.showCourses();
	}

	@Test
	public void testErrorAddStudent() {
		Course c = new Course(1, "English", "22/01/2019", 2);
		service.addCourse(c);
		Student s = new Student(1, "Me", "me@gmail.com", "Address");
		assertEquals("Student was successefly added !", service.getCourse(1).addStudent(s));
		assertEquals("Error ! Student was not added ", service.getCourse(1).addStudent(s));
	}

	@Test
	void testCourseNotFound() {
		assertEquals(null, service.getCourse(15));
	}

	@Test
	public void testDeleteStudent() {
		Course c = new Course(1, "English", "22/01/2019", 2);
		Student s = new Student(1, "Me", "me@gmail.com", "Address");
		c.addStudent(s);
		service.addCourse(c);

		assertEquals("Student was deleted successefly", service.deleteStudent(1));
	}

	@Test
	public void testErrorDeleteStudent() {
		assertEquals("Error ! Student not found", service.deleteStudent(1));
	}

}
