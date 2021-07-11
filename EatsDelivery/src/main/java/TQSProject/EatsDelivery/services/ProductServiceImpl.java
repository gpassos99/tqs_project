package TQSProject.EatsDelivery.services;

import TQSProject.EatsDelivery.models.Product;
import TQSProject.EatsDelivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductByRestaurantId(int RestaurantId) {
        System.out.println(RestaurantId);
        return productRepository.findProductByRestaurantId(RestaurantId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //search bar
    @Override
    public List<Product> searchProduct(int RestaurantId, String keyword) {
        return productRepository.searchProduct(RestaurantId, keyword);
    }


}
