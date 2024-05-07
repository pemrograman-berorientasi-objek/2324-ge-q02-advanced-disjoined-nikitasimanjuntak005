package academic.driver;
/**
 * @author 12S22005 Nikita Simanjuntak
 */

import java.util.Scanner;
import academic.model.Controller;
import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import academic.model.Lecturer;
import academic.model.CourseOpening;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        String input;
        while (!(input = scanner.nextLine()).equals("---")) {
            String[] tokens = input.split("#");
            String command = tokens[0];
            switch (command) {
                case "course-add":
                    controller.addCourse(tokens[1], tokens[2], Integer.parseInt(tokens[3]), tokens[4]);
                    break;
                case "course-open":
                    controller.addCourseOpening(tokens[1], tokens[2], tokens[3], tokens[4]);
                    break;
                case "course-history":
                    controller.displayCourseHistory(tokens[1]);
                    break;
                    case "student-add":
                    controller.addStudent(tokens[1], tokens[2], Integer.parseInt(tokens[3]), tokens[4]);
                    break;
                case "enrollment-add":
                    controller.addEnrollment(tokens[1], tokens[2], tokens[3], tokens[4]);
                    break;
                case "lecturer-add":
                    controller.addLecturer(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                    break;
                case "enrollment-grade":
                    controller.addGrade(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                    break;
                case "student-details":
                    controller.calculateStudentGPA(tokens[1]);
                    break;
                case "enrollment-remedial":
                    controller.remedialGrade(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                    break;
            }
        }
        
        for (Lecturer lecturer : controller.lecturers) {
            System.out.println(lecturer.toString());
         }
 
         for (Course course : controller.courses) {
             System.out.println(course.toString());
         }
 
 
         for (Student student : controller.students) {
             System.out.println(student.toString());
         }
 
         for (Enrollment enrollment : controller.enrollments) {
             System.out.println(enrollment);
         }
 
         scanner.close();
     }
 }