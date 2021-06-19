package Project.estafeta.Models;

public class Order {

    private long id;
    private String client;
    private long courier_id;
    private String[] value;
    private float[] coordinatesPickUp = new float[2];
    private float[] coordinatesClient = new float[2];
    private String pickUp_name;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public long getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(long courier_id) {
        this.courier_id = courier_id;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }

    public String getPickUp_name() { return pickUp_name; }

    public void setPickUp_name(String _name) {
        this.pickUp_name = _name;
    }

    public void setCoordinatesPickUp(float[] coordinatesPickUp) { this.coordinatesPickUp = coordinatesPickUp; }

    public void setCoordinatesClient(float[] coordinatesClient) { this.coordinatesClient = coordinatesClient; }

    public float[] getCoordinatesPickUp() { return coordinatesPickUp; }

    public float[] getCoordinatesClient() { return coordinatesClient; }

    public Order(){}
}

