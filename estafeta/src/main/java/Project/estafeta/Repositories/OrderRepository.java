package Project.estafeta.Repositories;

import Project.estafeta.Models.Courier;
import Project.estafeta.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    @Query(value = "select * from orders where id like ?1", nativeQuery = true)
    Optional<Order> findOrderById(Long id);

    @Query(value = "select * from orders", nativeQuery = true)
    List<Order> findAllOrders();

    @Query(value = "select * from orders where courier_id like :courier_id", nativeQuery = true)
    Optional<Order> findOrderByCourier_id(Long courier_id);

    @Query(value = "select * from orders where courier_id like :courier_id", nativeQuery = true)
    List<Order> findOrderCourier_id(Long courier_id);

    @Query(value = "select * from orders where courier_id = 0", nativeQuery = true)
    List<Order> findActiveOrders();


}
