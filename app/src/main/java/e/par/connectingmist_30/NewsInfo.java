package e.par.connectingmist_30;

public class NewsInfo {


    String dept,email,name,roll,session;

    public NewsInfo(String dept, String email, String name, String roll, String session) {
        this.dept = dept;
        this.email = email;
        this.name = name;
        this.roll = roll;
        this.session = session;
    }

    public NewsInfo() {
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
