package e.par.connectingmist_30;

public class UserInfo {
    String name,dept,roll,email,session;

    public UserInfo(String name, String dept, String roll, String email, String session) {
        this.name = name;
        this.dept = dept;
        this.roll = roll;
        this.email = email;
        this.session = session;

    }

    public UserInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }




}
