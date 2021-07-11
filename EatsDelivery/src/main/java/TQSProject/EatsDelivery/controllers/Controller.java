package TQSProject.EatsDelivery.controllers;

import TQSProject.EatsDelivery.models.User;
import TQSProject.EatsDelivery.services.ProductService;
import TQSProject.EatsDelivery.services.RestaurantService;
import TQSProject.EatsDelivery.services.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ProductService productService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping (value = "")
    public String login() {
        return "login_client";
    }

    @GetMapping (value = "/register_client")
    public String register(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "register_client";
    }

    @PostMapping(path = "/register_client")
    public String addUser(User user) {

        // insert query
        String insert_query = "insert into users (userid,lat,lon,user_name,user_password)"
                + " values(?,?,?,?,?);";

        //returns no of rows inserted = 1
        int rows = jdbcTemplate.update(insert_query,
                user.getUserID(),
                user.getUserLat(),
                user.getUserLon(),
                user.getUserName(),
                user.getUserPassword());

        if (rows == 1) {
            return "redirect:/";
        } else {
            return "error";
        }

    }

    @PostMapping(path = "/login_client")
    public String loginUser_query(User user) {

        if(userService.searchUser(user.getUserName(), user.getUserPassword())) {
            return "redirect:/EatsDelivery/home";
        }
        else {
            return "redirect:/";
        }


    }

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
