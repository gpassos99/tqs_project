package TQSProject.EatsDelivery.repositories;

import TQSProject.EatsDelivery.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
    //Restaurant findbyID(int RestaurantId);


}
