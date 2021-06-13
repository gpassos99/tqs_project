package TQSProject.EatsDelivery.services;

import TQSProject.EatsDelivery.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductById(int RestaurantId);
    List<Product> getAllProducts();
}
