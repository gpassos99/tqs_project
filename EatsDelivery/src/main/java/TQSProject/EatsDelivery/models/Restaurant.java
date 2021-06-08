package TQSProject.EatsDelivery.models;

import javax.persistence.*;

@Entity(name="restaurant")
@Table(name="restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int RestaurantId;

    @Column(name = "RestaurantName")
    private String RestaurantName;

    @Column(name = "Lat")
    private float Lat;

    @Column(name = "Lon")
    private float Lon;

    @Column(name = "image")
    private String image;

    public int getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        RestaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public float getLat() {
        return Lat;
    }

    public void setLat(float lat) {
        Lat = lat;
    }

    public float getLon() {
        return Lon;
    }

    public void setLon(float lon) {
        Lon = lon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
