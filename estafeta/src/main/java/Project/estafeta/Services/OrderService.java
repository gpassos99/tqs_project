package Project.estafeta.Services;

import Project.estafeta.Models.Order;
import Project.estafeta.Models.OrderList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.swing.plaf.BorderUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@Service
public class OrderService{

        private UriComponentsBuilder builder;
        long id = 1;
        private List orderList;

    @PostConstruct
        protected void init() {

            builder = UriComponentsBuilder.newInstance()
                    .scheme("http")
                    .host("localhost/")
                    .path("/?????")
                    .queryParam("courier", "null");
            orderList = new ArrayList<Order>();
        }

        //Method to add an order to the orders queue
        public void addOrder(Order o){
            o.setId(id);
            orderList.add(o);
            id++;
        }

        //Retrieve the order with the best coordinates for the courier
        public Order assignOrder(float[] coordinatesCourier){
            return new Order();
        }

        public List getAllOrders(){
            return this.orderList;
        }


        //
        public Order getCourierOrder(Long courier_id) {

            String url = builder.replaceQueryParam("courier", courier_id.toString()).build().toUriString();
            Order response = new RestTemplate().getForObject(url, Order.class);

            return response;
        }

    }


