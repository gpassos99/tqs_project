package Project.estafeta.Controllers;

import Project.estafeta.Models.Order;
import Project.estafeta.Services.CourierService;
import Project.estafeta.Models.Courier;
import Project.estafeta.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;

@RestController
@RequestMapping(path = "api/courier")
public class CourierController {

    private final CourierService courierService;
    private final OrderService orderService;


    @Autowired
    public CourierController(CourierService courierService, OrderService orderService) {
        this.courierService = courierService;
        this.orderService = orderService;

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
    @GetMapping(path = "/GetOrder")
    public Order getOrder(){
        return orderService.getOrder();
    }



    //sign in de um courier
    @PostMapping
    public void registerNewCourier(@RequestBody Courier courier){
        courierService.addNewCourier(courier);
    }

    //delete account of courier
    @DeleteMapping(path = "{courierId}")
    public void deleteCourier(@PathVariable("courierId") Long courierId){
        courierService.deleteCourier(courierId);
    }

    //update courier profile
    @PutMapping(path = "{courierId}")
    public void updateCourier(@PathVariable("courierId") Long courierId, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        courierService.updateCourier(courierId,name,email);
    }

  }
