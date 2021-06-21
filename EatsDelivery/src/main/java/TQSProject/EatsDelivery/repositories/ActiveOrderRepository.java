package TQSProject.EatsDelivery.repositories;

import TQSProject.EatsDelivery.models.ActiveOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveOrderRepository extends JpaRepository<ActiveOrder, String> {

    @Modifying
    @Query(value="insert into active_order values (?1, ?2, ?3, ?4, ?5)", nativeQuery=true)
    int createOrder(int Active_OrderId, String user, String RestaurantName, float Price, String Rider);
}
