package TQSProject.EatsDelivery.services;

import TQSProject.EatsDelivery.models.Restaurant;
import TQSProject.EatsDelivery.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    //search bar
    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        return restaurantRepository.searchRestaurant(keyword);

    }


}
