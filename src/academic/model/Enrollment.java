package academic.model;

import java.util.HashMap;

/**
 * @author 12S22005 Nikita Simanjuntak
 * @author 12S22021 Krisnia Calysta Siahaan
 */

public class Enrollment {

    // class definition
    private String courseId;
    private String studentId;
    private String academicYear;
    private String semester;
    private String grade = "None";
    private HashMap<String, String> previousGrades = new HashMap<>();
    private String previousGrade = "None";

    public Enrollment(String _courseId, String _studentId, String academicYear, String semester, String grade) {
        this.courseId = _courseId;
        this.studentId = _studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = grade;
    }

    public enum Grade {
        A, AB, B, BC, C, CD, D, E;
    }

    // CONvert grade to float
    public float getGradeValue() {
        switch (grade) {
            case "A":
                return 4.0f;
            case "AB":
                return 3.5f;
            case "B":
                return 3.0f;
            case "BC":
                return 2.5f;
            case "C":
                return 2.0f;
            case "CD":
                return 1.5f;
            case "D":
                return 1.0f;
            case "E":
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    // method mengambil id course dari class course
    public String getCourseId() {
        return courseId;
    }

    // method mengambil id student dari class student
    public String getStudentId() {
        return studentId;
    }

    // method mengambil tahun akademik
    public String getAcademicYear() {
        return academicYear;
    }

    // method mengambil semester
    public String getSemester() {
        return semester;
    }

    // method mengambil grade
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void addPreviousGrade(String academicYearSemester, String previousGrade) {
        if (!previousGrades.containsKey(academicYearSemester)) {
            previousGrades.put(academicYearSemester, previousGrade);
        }
    }

    public String getPreviousGrade(String academicYearSemester) {
        return previousGrades.getOrDefault(academicYearSemester, "None");
    }

    public String getPreviousGrade() {
        return previousGrade;
    }

    public void setPreviousGrade(String previousGrade) {
        this.previousGrade = previousGrade;
    }

    @Override
    public String toString() {
        if (!previousGrade.equals("None")) {
            return courseId + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade + "(" + previousGrade
                    + ")";
        } else {
            return courseId + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
        }
    }

    public char[] topreveiousgade() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'topreveiousgade'");
    }
}