package academic.driver;
/**
 * @author 12S22005 Nikita Simanjuntak
 */

import java.util.Scanner;
import academic.model.*;

/**
 * @author 12S22005 Nikita Simanjuntak
 * @author 12S22021 Krisnia Calysta Siahaan
 */

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
                case "find-the-best-student":
                    controller.findTheBestStudent(tokens[1],tokens[2]);
                    break;
                case "add-best-student":
                    // controller.addBestStudent(tokens[1]);
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

         for (String bestStudent : controller.bestStudents) {
            System.out.println(bestStudent.toString());
         }
 
         scanner.close();
     }
 }