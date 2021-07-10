package TQSProject.EatsDelivery.models;


import javax.persistence.*;

@Entity(name="users")
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int UserID;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPassword")
    private String userPassword;

    @Column(name = "lat")
    private float lat;


    @Column(name = "lon")
    private float lon;

    public User() {
    }

    public User(int UserID, float lat, float lon, String userName, String userPassword) {
        this.UserID = UserID;
        this.lat = lat;
        this.lon = lon;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public float getUserLat() {
        return lat;
    }

    public void setUserLat(float lat) {
        this.lat = lat;
    }

    public float getUserLon() {
        return lon;
    }

    public void setUserLon(float lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
