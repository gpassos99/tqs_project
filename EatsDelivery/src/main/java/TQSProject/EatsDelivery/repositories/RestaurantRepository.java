package TQSProject.EatsDelivery.repositories;

import TQSProject.EatsDelivery.models.Product;
import TQSProject.EatsDelivery.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    @Query(value = "select * from restaurant where restaurant_name like %:keyword%", nativeQuery = true)
    List<Restaurant> searchRestaurant(String keyword);


}
