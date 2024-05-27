package com.example.buyapp.models;

import java.util.*;

public class Client {
    private String id;
    private List<Authentication> authentications = new ArrayList<>();
    private Map<String, Product> clientProducts = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Authentication> getAuthentications() {
        return authentications;
    }

    public void setAuthentications(List<Authentication> authentications) {
        this.authentications = authentications;
    }

    public Map<String, Product> getClientProducts() {
        return clientProducts;
    }

    public void setClientProducts(Map<String, Product> clientProducts) {
        this.clientProducts = clientProducts;
    }
}
