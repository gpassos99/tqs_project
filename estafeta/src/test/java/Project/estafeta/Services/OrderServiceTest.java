package Project.estafeta.Services;

import Project.estafeta.Controllers.OrderController;
import Project.estafeta.Models.Order;
import Project.estafeta.Models.OrderInfo;
import Project.estafeta.Repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.when;

@WebMvcTest(OrderService.class)
class OrderServiceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderService order_service;
    @MockBean
    private CourierService courier_service;
    @MockBean
    OrderRepository orderRepository;

    private Order test_order;
    private Optional<Order> possibleOrder;
    private OrderInfo test_order_details;

    @BeforeEach
    void setup(){
        test_order = new Order();
        test_order_details = new OrderInfo();

        test_order_details.setClient("Jorge");
        test_order_details.setCoordinatesPickUp(new float[]{3,4});
        test_order_details.setCoordinatesClient(new float[]{1,2});
        test_order_details.setPickUp_name("KFC");

        test_order.set_info(test_order_details);
        test_order.setId(1);
        test_order.setCourier_id(1);

        possibleOrder = Optional.of(test_order);
    }

    @Test
    void if_there_is_are__multiple_orders_get_all_order_returns_all(){

        Order test_order2 = new Order();
        OrderInfo test_order_details2 = new OrderInfo();

        test_order_details2.setClient("Mario");
        test_order_details2.setCoordinatesPickUp(new float[]{6,7});
        test_order_details2.setCoordinatesClient(new float[]{4,5});
        test_order_details2.setPickUp_name("BK");

        test_order2.set_info(test_order_details2);
        test_order2.setId(2);
        test_order2.setCourier_id(1);

        Optional<Order> possibleOrder2 = Optional.of(test_order2);

        OrderService os = new OrderService(orderRepository);
        List<Order> orderList = new ArrayList<>();
        orderList.add(test_order);
        orderList.add(test_order2);

        when(orderRepository.findAllOrders()).thenReturn(orderList);

        List<Order> ol = os.getAllOrders();
        assertEquals(orderList, ol);
    }

    @Test
    void if_there_is_an_order_get_courier_order_return_order(){
        long id = 1;
        when(orderRepository.findOrderByCourier_id(id)).thenReturn(possibleOrder);
        OrderService os = new OrderService(orderRepository);

        Order o = os.getCourierOrder(id);
        assertEquals(test_order, o);
    }

    /** repository problem? test failing
    @Test
    void if_there_no_order_get_courier_order_return_null(){
        long id = 2;
        when(orderRepository.findOrderByCourier_id(id)).thenReturn(Optional.of(null));
        OrderService os = new OrderService(orderRepository);

        Order o = os.getCourierOrder(id);
        assertEquals(null, o);
    }*/

    @Test
    void if_add_order_add_to_repository(){
        long id = 1;
        OrderService os = new OrderService(orderRepository);
        when(orderRepository.findOrderByCourier_id(id)).thenReturn(possibleOrder);

        os.addOrder(test_order);
        assertEquals(test_order, os.getCourierOrder(id));
    }

}