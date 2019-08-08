package models;

import java.util.HashSet;
import java.util.Date;

public class Course {

	
	private int id;
	private String name;
	private String startDate;
	private int durationInWeeks;
	private HashSet<Student> students;

	public Course(int id, String name, String startDate, int durationInWeeks) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.durationInWeeks = durationInWeeks;
		this.students=new HashSet<Student>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStartDate() {
		return startDate;
	}

	public int getDurationInWeeks() {
		return durationInWeeks;
	}

	public HashSet<Student> getStudents() {
		return this.students;
	}

	public String addStudent(Student st) {
		if(this.students.add(st)) {
			return "Student was successefly added !";
		}
		return "Error ! Student was not added ";
	}

	public void removeStudent(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				this.students.remove(student);
			}
		}
	}
}
