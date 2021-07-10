package TQSProject.EatsDelivery.controllers;

import TQSProject.EatsDelivery.services.ProductService;
import TQSProject.EatsDelivery.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping (value = "/EatsDelivery/home/restaurants/{restaurant_id}")
    public String products_page(@PathVariable("restaurant_id") int RestaurantId, Model model) {
        model.addAttribute("listProducts", productService.getProductByRestaurantId(RestaurantId));
        return "products";
    }

    @GetMapping (value = "/EatsDelivery/user")
    public String restaurant() {
        return "user";
    }

    @GetMapping (value = "/EatsDelivery/home/restaurants/{restaurant_id}/{keyword}")
    public String search(@PathVariable int restaurant_id, @PathVariable String keyword, Model model) {
        model.addAttribute("listProducts", productService.searchProduct(restaurant_id, keyword));
        return "search_results";
    }

    @GetMapping (value = "/EatsDelivery/home/{keyword}")
    public String searchRestaurant(@PathVariable(value = "keyword", required = false) String keyword, Model model) {
        model.addAttribute("listRestaurants", restaurantService.searchRestaurant(keyword));
        return "search_restaurants";
    }

}
