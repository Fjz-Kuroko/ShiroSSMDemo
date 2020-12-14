package pers.kuroko.entity;

public class User {

    private String uname;
    private String upwd;
    private String role;

    public User() {}

    public User(String uname, String upwd, String role) {
        this.uname = uname;
        this.upwd = upwd;
        this.role = role;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
