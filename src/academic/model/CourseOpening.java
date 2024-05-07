package academic.model;

public class CourseOpening {
    private String Id;
    private String AcademicYear;
    private String Semester;
    private String LecturerInitial;
    
    private String Matakuliah;
    private int SKS;
    private String Grade;

    private String Email;

    // constructor
    public CourseOpening(String Id, String AcademicYear, String Semester, String LecturerInitial) {
        this.Id = Id;
        this.AcademicYear = AcademicYear;
        this.Semester = Semester;
        this.LecturerInitial = LecturerInitial; 
        
        this.Matakuliah = "";
        this.SKS = 0;
        this.Grade = "";
        this.Email = "";
    }

    public String getId() {
        return Id;
    }

    public String getAcademicYear() {
        return AcademicYear;
    }
 
    public String getSemester() {
        return Semester;
    }

    public String getLecturerInitial() {
        return LecturerInitial;
    }

    public String getMatakuliah(){
        return Matakuliah;
    }

    public int getSKS() {
        return SKS;
    }

    public String getGrade(){
        return Grade;
    }

    public String getEmail() {
        return Email;
    }

    public void setId(String Id){
        this.Id = Id;
    }

    public void setAcademicYear(String AcademicYear){
        this.AcademicYear = AcademicYear;
    }

    public void setSemester(String Semester){
        this.Semester = Semester;
    }

    public void setLecturerEmail(String LecturerInitial){
        this.LecturerInitial = LecturerInitial;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public void setMatakuliah(String Matakuliah) {
        this.Matakuliah = Matakuliah;
    }

    public void setSKS(int SKS) {
        this.SKS = SKS;
    }
}
