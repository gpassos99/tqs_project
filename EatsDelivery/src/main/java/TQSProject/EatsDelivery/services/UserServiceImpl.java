package TQSProject.EatsDelivery.services;

import TQSProject.EatsDelivery.models.User;
import TQSProject.EatsDelivery.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean searchUser(String username, String userpassword) {

        if (userRepository.searchUser2(username, userpassword).isPresent()){
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
            return true;
        }

        else {
            System.out.println("BBBBBBBBBBBBBBBBBBBBBBBB");
            return false;
        }
    }

}
