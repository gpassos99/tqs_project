package Project.estafeta.Controllers;

import Project.estafeta.Models.Order;
import Project.estafeta.Models.OrderInfo;
import Project.estafeta.Services.CourierService;
import Project.estafeta.Services.OrderService;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderService order_service;
    @MockBean
    private CourierService courier_service;

    private Order test_order;
    private Order test_order2;
    private OrderInfo test_order_details;
    private OrderInfo test_order_details2;
    private List order_list;
    private JSONObject obj;

    @BeforeEach
    void setup(){
        test_order = new Order();
        test_order_details = new OrderInfo();

        order_list = new ArrayList();

        test_order_details.setClient("Jorge");
        test_order_details.setCoordinatesPickUp(new float[]{3,4});
        test_order_details.setCoordinatesClient(new float[]{1,2});
        test_order_details.setPickUp_name("KFC");



        //test_order.set_info(test_order_details);
        test_order.setId(1);

        order_list.add(test_order);
    }

    @Test
    void given_multiple_orders_get_orders_returns_all_orders() throws Exception{

        test_order_details2 = new OrderInfo();
        test_order2 = new Order();

        test_order_details2.setClient("Carlos");
        test_order_details2.setCoordinatesPickUp(new float[]{11,40});
        test_order_details2.setCoordinatesClient(new float[]{(float) 1.11, (float) 2.2});
        test_order_details2.setPickUp_name("KFC");

        //test_order2.set_info(test_order_details);
        test_order2.setId(2);

        order_list.add(test_order2);

        given(order_service.getAllOrders()).willReturn(order_list);

        mvc.perform(get("/api/order/GetOrders")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)));
    }

    /**
    @Test
    void json_order_info_adds_order() throws Exception{

        mvc.perform(post("/api/order/AddOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(test_order_details)))
                .andExpect(status().isOk())
                .andReturn();


    }
    */
}