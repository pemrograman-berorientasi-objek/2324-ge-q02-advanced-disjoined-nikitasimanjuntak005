package academic.model;

/**
 * @author 12S22005 Nikita Simanjuntak
 */

public class Lecturer extends Person{
    private String lecturerEmail;
    private String lecturerInitial;
    private String programStudi;


    // constructor
    public Lecturer(String lecturerId, String lecturerName, String lecturerInitial, String lecturerEmail,
            String programStudi) {
        super(lecturerId, lecturerName);
        this.lecturerEmail = lecturerEmail;
        this.lecturerInitial = lecturerInitial;
        this.programStudi = programStudi;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLecturerInitial() {
        return lecturerInitial;
    }
    public String getLecturerEmail() {
        return lecturerEmail;
    }
    public void setLecturerEmail(String lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }

    public void setLecturerInitial(String lecturerInitial) {
        this.lecturerInitial = lecturerInitial;
    }


    public String getProgramStudi() {
        return programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    
    @Override
    public String toString() {
        return getId() + "|" + getName() + "|"
                + lecturerInitial + "|" + lecturerEmail + "|" + programStudi;
    }
}