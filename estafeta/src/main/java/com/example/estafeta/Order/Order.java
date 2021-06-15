package com.example.estafeta.Order;

public class Order {

    private long id;
    private String client;
    private long courier_id;
    private int value;
    private float[] coordenates = new float[2];
    private String restautant_name;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRestautant_name() {
        return restautant_name;
    }

    public void setRestautant_name(String restautant_name) {
        this.restautant_name = restautant_name;
    }

    public float[] getCoordenates() {
        return coordenates;
    }

    public void setCoordenates(float[] coordenates) {
        this.coordenates = coordenates;
    }
}

