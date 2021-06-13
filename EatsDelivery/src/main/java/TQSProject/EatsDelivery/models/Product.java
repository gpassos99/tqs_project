package TQSProject.EatsDelivery.models;


import javax.persistence.*;

@Entity(name="products")
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ProductId;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "Price")
    private float price;

    @Column(name = "Description")
    private String description;


    @Column(name = "RestaurantId")
    private float restaurantId;

    @Column(name = "image")
    private String image;

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(float restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
