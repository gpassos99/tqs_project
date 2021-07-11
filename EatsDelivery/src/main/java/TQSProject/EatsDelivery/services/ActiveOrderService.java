package TQSProject.EatsDelivery.services;

import TQSProject.EatsDelivery.models.ActiveOrder;

import java.util.List;

public interface ActiveOrderService {
    List<ActiveOrder> getAllActiveOrders();
    void saveActiveOrder(ActiveOrder activeOrder);
}
