package TQSProject.EatsDelivery.models;

import javax.persistence.*;


@Entity(name="active_order")
@Table(name="active_order")
public class ActiveOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Active_OrderId;

    @Column(name = "User")
    private String user;

    @Column(name = "RestaurantName")
    private String RestaurantName;

    @Column(name = "Price")
    private float Price;

    @Column(name = "Rider")
    private String Rider;

    public int getActive_OrderId() {
        return Active_OrderId;
    }

    public void setActive_OrderId(int active_OrderId) {
        Active_OrderId = active_OrderId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getRider() {
        return Rider;
    }

    public void setRider(String rider) {
        Rider = rider;
    }
}
