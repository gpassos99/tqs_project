package Project.estafeta.Services;

import Project.estafeta.Models.Courier;
import Project.estafeta.Models.Order;
import Project.estafeta.Models.OrderList;
import Project.estafeta.Repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.swing.plaf.BorderUIResource;
import java.util.*;

@Service
public class OrderService{

        private UriComponentsBuilder builder;
        long id = 1;
        private final OrderRepository orderRepository;

    @PostConstruct
        protected void init() {

            builder = UriComponentsBuilder.newInstance()
                    .scheme("http")
                    .host("localhost/")
                    .path("/?????")
                    .queryParam("courier", "null");
        }

        public OrderService(OrderRepository orderRepository){
            this.orderRepository = orderRepository;
        }

        //Method to add an order to the orders queue
        public void addOrder(Order o){
            o.setId(id);
            Optional<Order> orderOptional = orderRepository.findOrderById(id);
            if (orderOptional.isPresent()){
                throw new IllegalStateException("order already exists");
            }
            orderRepository.save(o);
            id++;
        }

        public List getAllOrders(){
            return orderRepository.findAllOrders();
        }

        //
        public Order getCourierOrder(Long courier_id) {

            String url = builder.replaceQueryParam("courier", courier_id.toString()).build().toUriString();
            Order response = new RestTemplate().getForObject(url, Order.class);

            return response;
        }

    }


