package TQSProject.EatsDelivery.repositories;

import TQSProject.EatsDelivery.models.ActiveOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveOrderRepository extends JpaRepository<ActiveOrder, String> {


}
