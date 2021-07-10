package TQSProject.EatsDelivery.services;

import TQSProject.EatsDelivery.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();

    List<Restaurant> searchRestaurant(String keyword);
}
