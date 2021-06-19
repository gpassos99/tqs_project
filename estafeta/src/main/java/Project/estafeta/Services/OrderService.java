package Project.estafeta.Services;

import Project.estafeta.Models.Order;
import Project.estafeta.Models.OrderList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.swing.plaf.BorderUIResource;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@Service
public class OrderService{

        private UriComponentsBuilder builder;
        private Queue<Order> orderQueue;

    @PostConstruct
        protected void init() {

            builder = UriComponentsBuilder.newInstance()
                    .scheme("http")
                    .host("localhost/")
                    .path("/?????")
                    .queryParam("courier", "null");
            orderQueue = new PriorityQueue<>();
        }

        public void addOrder(Order o){
            orderQueue.add(o);
        }

        public Order getOrder(){
            return orderQueue.poll();
        }

        public Order getCourierOrder(Long courier_id) {

            String url = builder.replaceQueryParam("courier", courier_id.toString()).build().toUriString();
            Order response = new RestTemplate().getForObject(url, Order.class);

            return response;
        }

    }


