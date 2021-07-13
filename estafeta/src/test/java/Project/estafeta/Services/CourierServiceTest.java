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
        possibleCourier = Optional.of(testCourier);
        courier_service = new CourierService(courierRepository, orderRepository);
    }

    @Test
    void update_courier_on_existing_courier_changes_courier_values(){
        courier_service.addNewCourier(testCourier);

        when(courierRepository.findCourierById(testCourier.getId())).thenReturn(possibleCourier);

        courier_service.updateCourier(testCourier.getId(), "Carlos", "carloscourier@gmail.com");

        assertTrue(testCourier.getName() == "Carlos");
    }

    @Test
    void deleting_non_existing_couriers_throws_illegal_state_exception(){

        when(courierRepository.existsById(new Long(2))).thenReturn(false);

        assertThrows(IllegalStateException.class, () -> {
            courier_service.deleteCourier(new Long(2));
        });
    }

    /**
     @Test
     void if_courier_already_exists_throw_exception(){
         Courier secondTestCourier = new Courier("Zé", "zecourier@gmail.com");

         when(courierRepository.findCourierByEmail(testCourier.getEmail())).thenReturn(possibleCourier);

         courier_service.addNewCourier(testCourier);

         assertThrows(IllegalStateException.class, () -> {
         courier_service.addNewCourier(secondTestCourier);
        });
     }*/

}