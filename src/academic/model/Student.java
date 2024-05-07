package academic.model;

/**
 * @author 12S22005 Nikita Simanjuntak
 */

public class Student extends Person {
    private int enrollmentYear;
    private String department;
    private Float gpa;
    private Integer totalCredit;

    public Student(String studentId, String studentName, int enrollmentYear, String department) {
        super(studentId, studentName);
        this.enrollmentYear = enrollmentYear;
        this.department = department;
        this.gpa = 0.0f;
        this.totalCredit = 0;
    }

    @Override
    public String toString() {
        String gpaString = (gpa != null && !gpa.equals(0.0f)) ? String.valueOf(gpa) : "";
        String creditString = (totalCredit != null && totalCredit != 0) ? String.valueOf(totalCredit) : "";
        return getId() + "|" + getName() + "|" + enrollmentYear + "|" + department ;
    }


    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public Integer getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Integer totalCredit) {
        this.totalCredit = totalCredit;
    }

 }