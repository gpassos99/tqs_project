package Project.estafeta.Services;

import Project.estafeta.Controllers.OrderController;
import Project.estafeta.Models.Courier;
import Project.estafeta.Models.Order;
import Project.estafeta.Models.OrderInfo;
import Project.estafeta.Repositories.CourierRepository;
import Project.estafeta.Repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(CourierService.class)
class CourierServiceTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CourierService courier_service;

    @MockBean
    OrderRepository orderRepository;

    @MockBean
    CourierRepository courierRepository;


    private Courier testCourier;
    private Optional<Courier> possibleCourier;

    @BeforeEach
    void setup(){
        testCourier = new Courier("Zé", "zecourier@gmail.com");
        testCourier.setId(new Long(1));
        courier_service = new CourierService(courierRepository, orderRepository);
    }

    /**
     @Test
     void if_courier_already_exists_throw_exception(){
     Courier secondTestCourier = new Courier("Zé", "zecourier@gmail.com");

     courier_service.addNewCourier(testCourier);

     when(courierRepository.findCourierByEmail(testCourier.getEmail())).thenReturn(possibleCourier);

     assertThrows(IllegalStateException.class, () -> {
     courier_service.addNewCourier(secondTestCourier);
     });
     }*/

}