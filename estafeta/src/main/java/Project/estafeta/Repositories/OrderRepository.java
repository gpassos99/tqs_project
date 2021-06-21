package Project.estafeta.Repositories;

import Project.estafeta.Models.Courier;
import Project.estafeta.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    @Query(value = "select * from Orders where order_id like ?1", nativeQuery = true)
    Optional<Order> findOrderById(Long id);

    @Query(value = "select * from Orders", nativeQuery = true)
    List<Order> findAllOrders();
}
