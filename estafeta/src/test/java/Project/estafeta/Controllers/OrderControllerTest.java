package Project.estafeta.Controllers;

import Project.estafeta.Models.Order;
import Project.estafeta.Models.OrderInfo;
import Project.estafeta.Services.OrderService;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderService service;

    private Order test_order;
    private OrderInfo test_order_details;
    private List order_list;
    private JSONObject obj;

    @BeforeEach
    void setup(){
        test_order = new Order();
        test_order_details = new OrderInfo();
        order_list = new ArrayList();
        obj = new JSONObject();

        obj.put("client", "Jorge");
        obj.put("coordinatesPickUp", new float[]{3,4});
        obj.put("coordinatesClient", new float[]{1,2});
        obj.put("pickUp_name", "KFC");
        test_order_details.setClient("Jorge");
        test_order_details.setCoordinatesClient(new float[]{1,2});
        test_order_details.setCoordinatesPickUp(new float[]{3,4});
        test_order_details.setPickUp_name("KFC");
        test_order.set_info(test_order_details);
        test_order.setId(1);
        order_list.add(test_order);
    }

    @Test
    void given_order_get_order() throws Exception{

        mvc.perform(MockMvcRequestBuilders.post("/api/order/AddOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(obj)))
                .andExpect(status().isOk());
        //given(service.getAllOrders()).willReturn(order_list);
    }

}