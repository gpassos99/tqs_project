package Project.estafeta.Controllers;

import Project.estafeta.Models.Order;
import Project.estafeta.Repositories.OrderRepository;
import Project.estafeta.Services.CourierService;
import Project.estafeta.Models.Courier;
import Project.estafeta.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@org.springframework.stereotype.Controller

@RequestMapping(path = "api/courier")
public class CourierController {

    @Autowired
    private final CourierService courierService;

    @Autowired
    private final OrderService orderService;

    @Autowired
    JdbcTemplate jdbcTemplate;

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
    /*
    //receive order
    @GetMapping(path = "/GetOrder/{gpsCoordinates}/{courierId}")
    public void getOrder(@PathVariable("gpsCoordinates") float[] courierCoordinates, @PathVariable("courierId") long courierId){
        courierService.assignOrder(courierCoordinates, courierId);
    }
    */
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
    public String register(@ModelAttribute Courier courier, Model model) {
        model.addAttribute("courier", courier);
        System.out.println("GGGGGGGGGGGGGGG");

        return "register_courier";
    }

    //sign in de um courier
    @PostMapping(path = "/register_courier")
    public String registerNewCourier(Courier courier){

        // insert query

        String insert_query = "insert into couriers (id,email,name,password)" + " values(?,?,?,?);";

        //returns no of rows inserted = 1
        int rows = jdbcTemplate.update(insert_query,
                courier.getId(),
                courier.getEmail(),
                courier.getName(),
                courier.getPassword());

        if (rows == 1) {
            return "redirect:/api/courier";
        } else {
            return "error";
        }

    }

    @PostMapping(path = "/login_courier")
    public String loginCourier(Courier courier) {

        if(courierService.searchCourier(courier.getEmail(), courier.getPassword())) {
            String sql = "select id from couriers where email like ?";

            String id = (String) jdbcTemplate.queryForObject(
                    sql, new Object[] { courier.getEmail() }, String.class);
            System.out.println(id);
            return "redirect:/api/courier/home/" + id;
        }
        else {
            return "redirect:/";
        }


    }

    //home page
    @GetMapping (value = "/home/{courier_id}")
    public String home(Model model) {
        model.addAttribute("listActiveOrders", orderService.findActiveOrders());
        return "home";
    }

    @GetMapping (value = "/orders/{courier_id}")
    public String orderByCourier_page(@PathVariable("courier_id") Long courier_id, Model model) {
        model.addAttribute("listOrdersByCourier", orderService.getOrdersByCourierId(courier_id));
        return "previousOrders";
    }

    @GetMapping (value = "/home/{courier_id_current}/{order_id}")
    public String acceptOrder(@PathVariable Long order_id, @PathVariable Long courier_id_current, Model model) {
        // insert query
        String update_query = "update orders set courier_id = ?, active = 0 where id = ?";

        //returns no of rows inserted = 1
        int rows = jdbcTemplate.update(update_query, courier_id_current, order_id);

        if (rows == 1) {
            return "redirect:/api/courier/home/" + courier_id_current;
        } else {
            return "error";
        }
    }


  }
