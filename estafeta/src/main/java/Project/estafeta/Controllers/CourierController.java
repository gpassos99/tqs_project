package Project.estafeta.Controllers;

import Project.estafeta.Models.Order;
import Project.estafeta.Repositories.OrderRepository;
import Project.estafeta.Services.CourierService;
import Project.estafeta.Models.Courier;
import Project.estafeta.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
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
    public void registerNewCourier(@RequestBody Courier courier){
        courierService.addNewCourier(courier);
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

  }
