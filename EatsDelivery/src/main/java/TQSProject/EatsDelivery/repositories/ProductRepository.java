package TQSProject.EatsDelivery.repositories;

import TQSProject.EatsDelivery.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "select * from products where restaurant_id like ?1", nativeQuery = true)
    List<Product> findProductById(int RestaurantId);


}
