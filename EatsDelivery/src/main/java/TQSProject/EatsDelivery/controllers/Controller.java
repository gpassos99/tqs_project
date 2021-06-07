package TQSProject.EatsDelivery.controllers;

import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping (value = "/EatsDelivery/home")
    public String index() {
        return "index";
    }

    @GetMapping (value = "/EatsDelivery/user")
    public String restaurant() {
        return "user";
    }



}
