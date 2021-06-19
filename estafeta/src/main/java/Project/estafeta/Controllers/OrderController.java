package Project.estafeta.Controllers;

import Project.estafeta.Models.Order;
import Project.estafeta.Services.CourierService;
import Project.estafeta.Models.Courier;
import Project.estafeta.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/order")
public class OrderController {

    private final CourierService courierService;
    private final OrderService orderService;

    @Autowired
    public OrderController(CourierService courierService, OrderService orderService) {
        this.courierService = courierService;
        this.orderService = orderService;
    }

    //list of couriers
    @PostMapping
    public void addOrder(@RequestBody Order orderDetails){
        return orderService.add();
    }
}
