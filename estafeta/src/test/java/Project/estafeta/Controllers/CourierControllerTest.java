package Project.estafeta.Controllers;

import Project.estafeta.Models.Courier;
import Project.estafeta.Models.Order;
import Project.estafeta.Models.OrderInfo;
import Project.estafeta.Services.CourierService;
import Project.estafeta.Services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourierController.class)
class CourierControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CourierService courier_service;

    private LocalDate courierBirthday;
    private Courier testCourier;
    private JSONObject obj;

    @BeforeEach
    void setup(){
        courierBirthday = LocalDate.of(1999, 01,02);
        testCourier = new Courier("Zé", "zecourier@gmail.com");
    }

    @Test
    void if_there_are_multiple_couriers_get_couriers_will_return_all_couriers() throws Exception{

        Courier testCourier2 = new Courier("Manuel", "manuelcourier@gmail.com");
        List<Courier> courierList = new ArrayList<>();

        courierList.add(testCourier2);
        courierList.add(testCourier);

        when(courier_service.getCouriers()).thenReturn(courierList);

        mvc.perform(get("/api/courier/Couriers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void truetest(){
        assertTrue(true);
    }

}