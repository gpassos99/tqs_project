package Project.estafeta.Models;

import java.util.Objects;

public class Order {

    private long id;
    private long courier_id;
    private boolean active;
    private OrderInfo info;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(long courier_id) {
        this.courier_id = courier_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public void set_info(OrderInfo info){
        this.info = info;
    }

    public OrderInfo get_info(){
        return this.info;
    }

    public Order(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id == order.id && courier_id == order.courier_id && active == order.active && Objects.equals(info, order.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courier_id, active, info);
    }
}

