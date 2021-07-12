package Project.estafeta.Services;

import Project.estafeta.Models.Order;
import Project.estafeta.Repositories.CourierRepository;
import Project.estafeta.Models.Courier;
import Project.estafeta.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CourierService {

    @Autowired
    private final CourierRepository courierRepository;

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    public CourierService(CourierRepository courierRepository, OrderRepository orderRepository) {
        this.courierRepository = courierRepository;
        this.orderRepository = orderRepository;
    }
/*
    public void assignOrder(float[] gpsCords, long id){
        Optional<Courier> courierOptional = courierRepository.findCourierById(id);
        if (courierOptional.isPresent()){
            Courier courier = courierOptional.get();
            Order order = nearestOrder(gpsCords, orderRepository.findAllOrders());
            order.setActive(true);
            courier.setActiveOrder(order);
        }else{
            throw new IllegalStateException("Invalid User");
        }
    }
*/
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

    public static double distance (float x1, float y1, float x2, float y2) {
        double x = Math.pow(x2-x1, 2);
        double y = Math.pow(y2-y1, 2);
        return Math.sqrt(x+y);
    }
/*
    public Order nearestOrder (float[] coordinate, List<Order> orders) {

        HashMap<Long, float[][]> orders_points = new HashMap<>();
        for(Order order:orders){
            float[][] points = new float[2][2];
            points[0] = order.get_info().getCoordinatesClient();
            points[1] = order.get_info().getCoordinatesPickUp();
            orders_points.put(order.getId(), points);
        }
        final int x = 0;
        final int y = 1;
        long closest_id = orders.get(0).getId();
        float[][] closestPoint = orders_points.get(orders.get(0).getId());
        double closestDist = distance(coordinate[x], coordinate[y], closestPoint[0][x], closestPoint[0][y]) + distance(coordinate[x], coordinate[y], closestPoint[1][x], closestPoint[1][y]);
        for(Order o : orders) {
            long id = o.getId();
            double dist = distance(coordinate[x], coordinate[y], orders_points.get(id)[0][x], orders_points.get(id)[0][y]) + distance(coordinate[x], coordinate[y], orders_points.get(id)[1][x], orders_points.get(id)[1][y]);
            if (dist < closestDist) {
                closestDist = dist;
                closestPoint = orders_points.get(id);
                closest_id = id;
            }
        }

        return orderRepository.findOrderById(closest_id).get();

    }
*/
    public Courier save(Courier courier) {
        return courierRepository.save(courier);
    }


    public boolean searchCourier(String email, String password) {

        if (courierRepository.searchCourier(email, password).isPresent()){
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
            return true;
        }

        else {
            System.out.println("BBBBBBBBBBBBBBBBBBBBBBBB");
            return false;
        }

    }
}
