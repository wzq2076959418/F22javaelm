package vip.epss.domain;

public class User {
    private String userid;

    private String password;

    private String username;

    private Integer usersex;

    public User(){

    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    public User(String userid, String password, String username, Integer usersex) {
        this.userid = userid;
        this.password = password;
        this.username = username;
        this.usersex = usersex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", usersex=" + usersex +
                '}';
    }


}