package com.example.estafeta.Order;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
public class OrderService{

        private UriComponentsBuilder builder;

    @PostConstruct
        protected void init() {

            builder = UriComponentsBuilder.newInstance()
                    .scheme("http")
                    .host("localhost/")
                    .path("/?????")
                    .queryParam("courier", "null");
        }


        public List<Order> getCourierOrders(Long courier_id) {

            String url = builder.replaceQueryParam("courier", courier_id.toString()).build().toUriString();
            OrderList response = new RestTemplate().getForObject(url, OrderList.class);

            return response.getOrders();
        }

    }


