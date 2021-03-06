package TQSProject.EatsDelivery.services;

import TQSProject.EatsDelivery.models.ActiveOrder;
import TQSProject.EatsDelivery.repositories.ActiveOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveOrderServiceImpl implements ActiveOrderService{

    @Autowired
    private ActiveOrderRepository activeOrderRepository;

    @Override
    public List<ActiveOrder> getAllActiveOrders() {
        return activeOrderRepository.findAll();
    }

    @Override
    public void saveActiveOrder(ActiveOrder activeOrder) {
        this.activeOrderRepository.save(activeOrder);
    }
}
