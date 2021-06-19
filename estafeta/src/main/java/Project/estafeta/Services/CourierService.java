package Project.estafeta.Services;

import Project.estafeta.Repositories.CourierRepository;
import Project.estafeta.Models.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CourierService {

    @Autowired
    private final CourierRepository courierRepository;

    public CourierService(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    public void addNewCourier(Courier courier) {
        Optional<Courier> courierOptional = courierRepository.findCourierByEmail(courier.getEmail());
        if (courierOptional.isPresent()){
            throw new IllegalStateException("email already being used");
        }
        courierRepository.save(courier);
    }

    public List<Courier> getCouriers(){
        return courierRepository.findAll();
    }

    public void deleteCourier(Long courierId) {
        boolean exists = courierRepository.existsById(courierId);
        if (!exists){
            throw new IllegalStateException("courier with id " + courierId + " does not exist");
        }
        courierRepository.deleteById(courierId);
    }

    @Transactional
    public void updateCourier(Long courierId, String name, String email) {
        Optional<Courier> courierOptional = courierRepository.findCourierById(courierId);
        if (courierOptional.isPresent()){
            courierOptional.get().setName(name);
            courierOptional.get().setEmail(email);
        }
    }
}
