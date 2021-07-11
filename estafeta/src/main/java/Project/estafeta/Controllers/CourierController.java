package Project.estafeta.Controllers;

import Project.estafeta.Models.Order;
import Project.estafeta.Repositories.OrderRepository;
import Project.estafeta.Services.CourierService;
import Project.estafeta.Models.Courier;
import Project.estafeta.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping(path = "api/courier")
public class CourierController {

    @Autowired
    private final CourierService courierService;

    @Autowired
    private final OrderService orderService;

    @Autowired
    public CourierController(CourierService courierService, OrderService orderServiceImpl, OrderRepository orderRepository) {
        this.courierService = courierService;
        this.orderService = orderServiceImpl;
    }

    //list of couriers
    @GetMapping(path = "/Couriers")
    public List<Courier> getCouriers(){
        return courierService.getCouriers();
    }

    //list of orders of a specific courier
    @GetMapping(path = "/Order/{courierId}")
    public Order getCourierOrder(@PathVariable("courierId") Long courierId){
        return orderService.getCourierOrder(courierId);
    }

    //receive order
    @GetMapping(path = "/GetOrder/{gpsCoordinates}/{courierId}")
    public void getOrder(@PathVariable("gpsCoordinates") float[] courierCoordinates, @PathVariable("courierId") long courierId){
        courierService.assignOrder(courierCoordinates, courierId);
    }

    //sign in de um courier
    @PostMapping(path = "/Register")
    public String registerNewCourier(@ModelAttribute Courier courier, Model model){
        Courier courier2 = new Courier();

        courier2.setName(courier.getName());
        courier2.setEmail(courier.getEmail());
        courierService.addNewCourier(courier);
        model.addAttribute("courier",courier);
        return "redirect:/";
    }

    //delete account of courier
    @DeleteMapping(path = "/Delete/{courierId}")
    public void deleteCourier(@PathVariable("courierId") Long courierId){
        courierService.deleteCourier(courierId);
    }

    //update courier profile
    @PutMapping(path = "/Edit/{courierId}")
    public void updateCourier(@PathVariable("courierId") Long courierId, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        courierService.updateCourier(courierId,name,email);
    }

    //home page with login
    @GetMapping (value = "")
    public String login() {
        return "login_courier";
    }

    @GetMapping (value = "/register_courier")
    public String register(Courier courier) {
        return "register_courier";
    }

  }
