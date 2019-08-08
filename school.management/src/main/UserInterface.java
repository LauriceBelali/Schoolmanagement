package main;

import java.io.IOException;
import java.util.Scanner;

import models.Course;
import models.Student;
import services.Service;

public class UserInterface {
	
	private static Scanner input = new Scanner(System.in);
	private static Service service = new Service();

	public static void main(String[] args) throws IOException {
		String choice = getChoice();
		while (!choice.equals("F")) {
			switch (choice) {
			case "A":
				System.out.println("\n===============================================================");
				System.out.println("=================== ENTER INFORMATIONS ==========================");
				System.out.println("=================================================================");
				System.out.print("Id : ");
				int courseId = input.nextInt();
				System.out.print("Name : ");
				String courseName = input.next();
				System.out.print("Start date : ");
				String startDate = input.next();
				System.out.print("Duration In Weeks : ");
				int durationInWeeks = input.nextInt();
				System.out.println("=================== "
						+ service.addCourse(new Course(courseId, courseName, startDate, durationInWeeks))
						+ " ===================");
				choice = getChoice();
				break;
			case "B":
				System.out.println("\n===============================================================");
				System.out.println("==================== ENTER COURSE ID  ===========================");
				System.out.println("=================================================================");
				System.out.print("Id : ");
				courseId = input.nextInt();
				System.out.println(service.deleteCourse(courseId));
				choice = getChoice();
				break;
			case "C":
				service.showCourses();
				choice = getChoice();
				break;
			case "D":
				System.out.println("\n===============================================================");
				System.out.println("=================== ENTER INFORMATIONS ==========================");
				System.out.println("=================================================================");
				System.out.print("Course Id : ");
				courseId = input.nextInt();
				Course c = null;
				if (service.getCourse(courseId) != null) {
					c = service.getCourse(courseId);
				}
				System.out.print("Student Id : ");
				int studentId = input.nextInt();
				System.out.print("Name : ");
				String name = input.next();
				System.out.print("Email : ");
				String email = input.next();
				System.out.print("Address : ");
				String address = input.next();
				System.out.println("=================== " + c.addStudent(new Student(studentId, name, email, address))
						+ "=================== ");
				choice = getChoice();
				break;
			case "E":
				System.out.println("\n===============================================================");
				System.out.println("==================== ENTER STUDENT ID  ==========================");
				System.out.println("=================================================================");
				System.out.print("Id : ");
				studentId = input.nextInt();

				System.out.println(service.deleteStudent(studentId));
				choice = getChoice();
				break;

			}
		}
		System.out.println("Good Bye !");
	}

	private static String getChoice() {

		String choice = "";

		while (!choice.equals("A") && !choice.equals("B") && !choice.equals("C") && !choice.equals("D")
				&& !choice.equals("E") && !choice.equals("F")) {

			System.out.println("[A]. New Course ");
			System.out.println("[B]. Delete Course ");
			System.out.println("[C]. Course ");
			System.out.println("[D]. New Student ");
			System.out.println("[E]. Delete Student ");
			System.out.println("[F]. Exit");
			if (input.hasNext()) {
				choice = input.next();
			}
			choice = choice.toUpperCase();
		}
		return choice;
	}

}
