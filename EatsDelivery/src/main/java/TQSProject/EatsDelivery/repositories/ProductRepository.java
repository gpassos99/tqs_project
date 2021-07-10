package TQSProject.EatsDelivery.repositories;

import TQSProject.EatsDelivery.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "select * from products where restaurant_id like ?1", nativeQuery = true)
    List<Product> findProductByRestaurantId(int RestaurantId);

    @Query(value = "select product_name, price, restaurant_id from products where product_id like ?1", nativeQuery = true)
    List<Product> findProductBId(int RestaurantId);

    @Query(value = "select * from products where restaurant_id like :RestaurantId and product_name like %:keyword%", nativeQuery = true)
    List<Product> searchProduct(int RestaurantId, String keyword);

}
