package inc.frontlooksoftwares.app_test;

public class Note {
//    private String title;
//    private String description;
//    private String id;
    private String fname;
    private String lname;
    private String mname;
    private String id;
    private String client_name;
    private String phno;
    private String dob;

    public Note(){
        //empty constructor needed
    }

    public Note(String fname, String lname, String mname, String id, String phno, String dob) {
//        this.title = title;
//        this.description = description;
//        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.id = id;
        this.client_name = fname+mname+lname;
        this.phno = phno;
        this.dob = dob;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMname() {
        return mname;
    }

    public String getId() {
        return id;
    }

    public String getClient_name() {
        return client_name;
    }

    public String getPhno() {
        return phno;
    }

    public String getDob() {
        return dob;
    }
    //    public String getTitle() {
//        return title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getId() {
//        return id;
//    }
}
