package TQSProject.EatsDelivery.services;

import TQSProject.EatsDelivery.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductByRestaurantId(int RestaurantId);
    List<Product> getAllProducts();
    List<Product> searchProduct(int RestaurantId, String keyword);
}
