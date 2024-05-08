package academic.model;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 12S22005 Nikita Simanjuntak
 * @author 12S22021 Krisnia Calysta Siahaan
 */

public class Controller {
    public ArrayList<Course> courses = new ArrayList<>();
    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Enrollment> enrollments = new ArrayList<>();
    public static ArrayList<Lecturer> lecturers = new ArrayList<>();
    public static ArrayList<Enrollment> savedetailsStudent = new ArrayList<>();
    public ArrayList<CourseOpening> courseOpenings = new ArrayList<>();

    public ArrayList<String> bestStudents = new ArrayList<>();

    // method to add course
    public void addCourse(String courseId, String courseName, int credits, String passingGrade) {
        Course newCourse = new Course(courseId, courseName, credits, passingGrade);
        courses.add(newCourse);
    }

    public static boolean isEven(String str) {
        return Integer.parseInt(str.substring(str.length() - 2)) % 2 == 0;
    }   

    // method to add course opening
    public void addCourseOpening(String Id, String AcademicYear, String Semester, String LecturerInitial) {

    // metode untuk membuka kursus
     CourseOpening courseOpening = new CourseOpening(Id, AcademicYear, Semester, LecturerInitial);
      courseOpenings.add(courseOpening);


        Course course = courses.stream()
            .filter(c -> c.getCourseId().equals(Id))
            .findFirst()
            .orElse(null);
        courseOpening.setMatakuliah(course.getCourseName());
        courseOpening.setSKS(course.getCredits());
        courseOpening.setGrade(course.getPassingGrade());


        String[] lecturersArray = LecturerInitial.split(",");
        for (int i = 0; i < lecturersArray.length; i++) {
            String lecturerInitial = lecturersArray[i];
            for (Lecturer lecturer : lecturers) {
                if (lecturer.getLecturerInitial().equals(lecturerInitial)) {
                    courseOpening.setEmail(lecturer.getLecturerEmail());
                }
            }
        }
    
    }
    
    // method to display course history
    public void displayCourseHistory(String courseId) {
        courseOpenings.sort((co1, co2) -> co2.getSemester().compareTo(co1.getSemester()));
        // Urutkan daftar pendaftaran berdasarkan semester


             // Print course history
         for (CourseOpening courseOpening : courseOpenings) {
             System.out.println(courseId + "|" + courseOpening.getMatakuliah() + "|" + courseOpening.getSKS() + "|" + courseOpening.getGrade() + "|" + courseOpening.getAcademicYear() + "|" + courseOpening.getSemester() + "|" + courseOpening.getLecturerInitial() + " (" + courseOpening.getEmail() + ")");
             
             // Get enrollments for this course and sort them by academic year and semester

        List<Enrollment> courseEnrollments = enrollments.stream()
            .filter(e -> e.getCourseId().equals(courseId))
            .sorted(Comparator.comparing(Enrollment::getAcademicYear).thenComparing(Enrollment::getSemester))
            .collect(Collectors.toList());
    
            // Print course history
            for (Enrollment enrollment : courseEnrollments) {
                if (enrollment.getCourseId().equals(courseId)&& enrollment.getAcademicYear().equals(courseOpening.getAcademicYear()) && enrollment.getSemester().equals(courseOpening.getSemester())) {
                    Student student = students.stream()
                    .filter(s -> s.getId().equals(enrollment.getStudentId()))
                    .findFirst()
                    .orElse(null);
                    if (!enrollment.getPreviousGrade().equals("None")) {
                        System.out.println(enrollment.getCourseId() + "|" + enrollment.getStudentId() + "|" + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|" + enrollment.getGrade() + "(" + enrollment.getPreviousGrade() + ")");
                    } else {
                        System.out.println(enrollment.getCourseId() + "|" + enrollment.getStudentId() + "|" + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|" + enrollment.getGrade());
                    }                 
                }
            }
        }
    }
    // metode add Student
        public void addStudent(String studentId, String studentName, int enrollmentYear, String major) {
        boolean studentExist = false;
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                studentExist = true;
                break;
            }
        }
        if (!studentExist) {
            Student newStudent = new Student(studentId, studentName, enrollmentYear, major);
            students.add(newStudent);
        }
    }

    //metode findTheBestStudent
    // String academicYear = inputArray[1];
    // String semester = inputArray[2];

    // for (Enrollment<String, String> enrollmentOdd : enrollments) {
    //     if (enrollmentOdd.getTahun().equals(academicYear) && enrollmentOdd.getEven().equals("odd")) {
    //         for (Enrollment<String, String> enrollmentEven : enrollments) {
    //             if (enrollmentEven.getTahun().equals(academicYear) && enrollmentEven.getEven().equals("even") &&
    //                     enrollmentEven.getNim().equals(enrollmentOdd.getNim())) {
    //                 if (isEven(enrollmentEven.getNim())) {
    //                     if (!enrollmentOdd.getEven2().equals(enrollmentEven.getEven2())) {
    //                         String result = enrollmentOdd.getNim() + "|" + enrollmentOdd.getEven2() + "/" + enrollmentEven.getEven2();
    //                         bestStudents.add(result);
    //                     }   
    //                 }
    //             }
    //         }
    //     }
    // }
    // buatlah code diatas menjafi metode findTheBestStudent 
    public void findTheBestStudent(String academicYear, String semester) {
        List<Enrollment> oddEnrollments = enrollments.stream()
            .filter(e -> e.getAcademicYear().equals(academicYear) && e.getSemester().equals("odd") && !isEven(e.getStudentId()))
            .collect(Collectors.toList());
    
        List<Enrollment> evenEnrollments = enrollments.stream()
            .filter(e -> e.getAcademicYear().equals(academicYear) && e.getSemester().equals("even") && isEven(e.getStudentId()))
            .collect(Collectors.toList());
    
        for (Enrollment oddEnrollment : oddEnrollments) {
            for (Enrollment evenEnrollment : evenEnrollments) {
                if (oddEnrollment.getStudentId().equals(evenEnrollment.getStudentId())) {
                    if (!oddEnrollment.getGrade().equals(evenEnrollment.getGrade())) {
                        bestStudents.add(oddEnrollment.getStudentId() + "|" + oddEnrollment.getGrade() + "/" + evenEnrollment.getGrade());
                    }
                }
            }
            for (String bestStudent : bestStudents) {
                System.out.println(bestStudent);
            }
        }
    }
     

    // method to add enrollment
    public void addEnrollment(String courseId, String studentId, String academicYear, String semester) {
        boolean courseExist = false;
        boolean studentExist = false;
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                courseExist = true;
                break;
            }
        }
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                studentExist = true;
                break;
            }
        }
        if (!courseExist) {
            System.out.println("invalid course|" + courseId);
        } else if (!studentExist) {
            System.out.println("invalid student|" + studentId);
        } else {
            Enrollment newEnrollment = new Enrollment(courseId, studentId, academicYear, semester, "None");
            enrollments.add(newEnrollment);
        }
    }

    // method sorting course by course id
    public void sortCourseById() {
        Collections.sort(courses, new Comparator<Course>() {

            public int compare(Course o1, Course o2) {
                return o1.getCourseId().compareTo(o2.getCourseId());
            }
        });
    }

    // method sorting student by student id
    public void sortStudentById() {
        Collections.sort(students, new Comparator<Student>() {

            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
    }

    public void addLecturer(String lecturerId, String lecturerName, String lecturerInitial, String lecturerEmail,
            String programStudi) {
        boolean lecturerExist = false;
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getId().equals(lecturerId)) {
                lecturerExist = true;
                break;
            }
        }
        if (!lecturerExist) {
            Lecturer newLecturer = new Lecturer(lecturerId, lecturerName, lecturerInitial, lecturerEmail, programStudi);
            lecturers.add(newLecturer);
        }
    }

    public void addGrade(String courseId, String studentId, String academicYear, String semester, String grade) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseId().equals(courseId) && enrollment.getStudentId().equals(studentId)
                    && enrollment.getAcademicYear().equals(academicYear)
                    && enrollment.getSemester().equals(semester)) {
                enrollment.setGrade(grade);
            }
        }
    }

    private Enrollment findEnrollment(String courseId, String studentId, String academicYear, String semester) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseId().equals(courseId) && enrollment.getStudentId().equals(studentId)
                    && enrollment.getAcademicYear().equals(academicYear) && enrollment.getSemester().equals(semester)) {
                return enrollment;
            }
        }
        return null;
    }

    public void remedialGrade(String courseId, String studentId, String academicYear, String semester, String grade) {
        Enrollment enrollment = findEnrollment(courseId, studentId, academicYear, semester);
        if (enrollment != null && !enrollment.getGrade().equals("None")) {
            if (enrollment.getPreviousGrade().equals("None")) {
                enrollment.setPreviousGrade(enrollment.getGrade());
                enrollment.setGrade(grade);
            }
        }
    }
    

    public void calculateStudentGPA(String studentId) {
        String[] codecrs = new String[5];
        String[] value = new String[5];
        double totalgpa = 0;
        int totalcredit = 0;
        int i = 0;
        
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId().equals(studentId)) {
                for (Course course : courses) {
                    if (course.getCourseId().equals(enrollment.getCourseId())) {
                        codecrs[i] = course.getCourseId();
                        value[i] = enrollment.getGrade();
                        i++;
                    }
                }
            }
        }

        for (int j = 0; j < i; j++) {
            for (int k= j+1; k < i; k++) {
                if (codecrs[j].equals(codecrs[k])) {
                     value[j] = value[k];
                     codecrs[k] = null;
                    value[k] = null;
                }
            }
        }

        for (int j = 0; j < i; j++) {
            for (Course course : courses) {
                if (course.getCourseId().equals(codecrs[j])) {
                    totalgpa += getGPA(value[j]) * course.getCredits();
                    totalcredit += course.getCredits();
                }
            }
        }
        
        double gpa = totalgpa / totalcredit;

        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                System.out.println(student.getId() + "|" + student.getName() +"|" + student.getEnrollmentYear() + "|"+student.getDepartment() + "|" + String.format("%.2f", gpa).replace(",", ".") + "|" + totalcredit);
            }
        }
        
    }

    private static double getGPA(String grade) {
        switch (grade) {
            case "A":
                return 4.0;
            case "AB":
                return 3.5;
            case "B":
                return 3.0;
            case "BC":
                return 2.5;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "E":
                return 0.0;
            default:
                return 0.0;
        }
    }
}
