package TQSProject.EatsDelivery.controllers;

import TQSProject.EatsDelivery.models.Product;
import TQSProject.EatsDelivery.services.ActiveOrderService;
import TQSProject.EatsDelivery.services.ProductService;
import TQSProject.EatsDelivery.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ProductService productService;

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping (value = "/EatsDelivery/home")
    public String index(Model model) {
        model.addAttribute("listRestaurants", restaurantService.getAllRestaurants());
        return "index";
    }

    @GetMapping (value = "/EatsDelivery/home/{restaurant_id}")
    public String products_page(@PathVariable("restaurant_id") int RestaurantId, Model model) {
        model.addAttribute("listProducts", productService.getProductById(RestaurantId));
        return "products";
    }

    @GetMapping (value = "/EatsDelivery/user")
    public String restaurant() {
        return "user";
    }


}