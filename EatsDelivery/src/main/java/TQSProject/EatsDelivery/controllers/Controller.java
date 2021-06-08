package TQSProject.EatsDelivery.controllers;

import TQSProject.EatsDelivery.models.ActiveOrder;
import TQSProject.EatsDelivery.services.ActiveOrderService;
import TQSProject.EatsDelivery.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ActiveOrderService activeOrderService;

    @GetMapping (value = "/EatsDelivery/home")
    public String index(Model model) {
        model.addAttribute("listRestaurants", restaurantService.getAllRestaurants());
        return "index";
    }

    @GetMapping (value = "/EatsDelivery/user")
    public String restaurant() {
        return "user";
    }

    @PostMapping("/saveActiveOrder")
    public String saveActiveOrder(@ModelAttribute("activeOrder") ActiveOrder activeOrder) {
        activeOrderService.saveActiveOrder(activeOrder);
        return "user";
    }

}
