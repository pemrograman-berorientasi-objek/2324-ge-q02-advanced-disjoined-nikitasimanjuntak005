package academic.model;

/**
 * @author 12S22005 Nikita Simanjuntak
 * @author 12S22021 Krisnia Calysta Siahaan
 */

public class Course {
    private String courseId;
    private String courseName;
    private int credits;
    private String passingGrade;
    

    public Course(String courseId, String courseName, int credits, String passingGrade) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.passingGrade = passingGrade;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getPassingGrade() {
        return passingGrade;
    }

    public void setPassingGrade(String passingGrade) {
        this.passingGrade = passingGrade;
    }

    @Override
    public String toString() {
        return courseId + "|" + courseName + "|" + credits + "|" + passingGrade;
    }

    public String getLecturerId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLecturerId'");
    }

}