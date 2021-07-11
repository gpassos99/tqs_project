package Project.estafeta.Models;

import java.io.Serializable;

public class OrderInfo implements Serializable {

    private String client;
    private float[] coordinatesPickUp = new float[2];
    private float[] coordinatesClient = new float[2];
    private String pickUp_name;

    public OrderInfo(){}

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getPickUp_name() { return pickUp_name; }

    public void setPickUp_name(String _name) {
        this.pickUp_name = _name;
    }

    public void setCoordinatesPickUp(float[] coordinatesPickUp) { this.coordinatesPickUp = coordinatesPickUp; }

    public void setCoordinatesClient(float[] coordinatesClient) { this.coordinatesClient = coordinatesClient; }

    public float[] getCoordinatesPickUp() { return coordinatesPickUp; }

    public float[] getCoordinatesClient() { return coordinatesClient; }


}
