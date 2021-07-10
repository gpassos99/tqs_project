package TQSProject.EatsDelivery.repositories;


import TQSProject.EatsDelivery.models.Product;
import TQSProject.EatsDelivery.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "select * from users where user_name like :username and user_password like :userpassword", nativeQuery = true)
    Optional<User> searchUser2(String username, String userpassword);

}
