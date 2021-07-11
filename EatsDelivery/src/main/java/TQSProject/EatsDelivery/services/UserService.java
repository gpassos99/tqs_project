package TQSProject.EatsDelivery.services;

import TQSProject.EatsDelivery.models.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    boolean searchUser(String userName, String userPassword);
}

