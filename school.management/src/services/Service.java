package services;

import java.util.HashSet;

import models.Course;
import models.Student;

public class Service {
	
	private HashSet<Course> courses = new HashSet<Course>();

	public String addCourse(Course c) {
		if (this.courses.add(c)) {
			return "Course was added successefly";
		}
		return "Error ! impossible to add course";
	}

	public String deleteCourse(int id) {
		for (Course course : courses) {
			if (course.getId() == id) {
				this.courses.remove(course);
				return "Course was deleted successefly";
			}
		}
		return "Error ! Course not found";
	}

	public void showCourses() {
		if (this.courses.isEmpty()) {
			System.out.println("0 Course !");
		} else {
			for (Course course : courses) {
				System.out.println("___________________________________________________________________");
				System.out.println("{ ID : " + course.getId() + "|| Name : " + course.getName() + "|| Start Date : "
						+ course.getStartDate() + "|| Duration in week : " + course.getDurationInWeeks() + " }");
				if (course.getStudents().isEmpty()) {
					System.out.println("No student in this course !");
				} else {
					System.out.println("Students list : ");
					for (Student st : course.getStudents()) {
						System.out.println("**** { ID : " + st.getId() + "|| Name : " + st.getName() + "|| Email : "
								+ st.getEmail() + "|| Address : " + st.getAddress() + " } ****");
					}
				}
				System.out.println("___________________________________________________________________");

			}
		}
	}

	public Course getCourse(int i) {
		for (Course course : courses) {
			if (course.getId() == i) {
				return course;
			}
		}
		return null;
	}

	public String deleteStudent(int studentId) {
		for (Course course : courses) {
			for (Student st : course.getStudents()) {
				if (st.getId() == studentId) {
					course.removeStudent(studentId);
					return "Student was deleted successefly";
				}
			}
		}
		return "Error ! Student not found";
	}

}
