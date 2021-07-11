package Project.estafeta.Repositories;

import Project.estafeta.Models.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

    @Query(value = "select * from Couriers where email like ?1", nativeQuery = true)
    Optional<Courier> findCourierByEmail(String email);

    @Query(value = "select * from Couriers where courier_id like ?1", nativeQuery = true)
    Optional<Courier> findCourierById(Long id);

    @Modifying
    @Query(value = "insert into Couriers (id,birthdate,email,name) values (?1, ?2, ?3, ?4)", nativeQuery = true)
    int save(long id, LocalDate Birthdate, String email, String name);

}

