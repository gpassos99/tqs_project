package Project.estafeta.Repositories;

import Project.estafeta.Models.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

    @Query(value = "select * from Couriers where email like ?1", nativeQuery = true)
    Optional<Courier> findCourierByEmail(String email);

    @Query(value = "select * from Couriers where courier_id like ?1", nativeQuery = true)
    Optional<Courier> findCourierById(Long id);
}

