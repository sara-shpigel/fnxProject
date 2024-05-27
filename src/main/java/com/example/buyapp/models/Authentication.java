package com.example.buyapp.models;

public class Authentication {

    private String clientId;
    private AuthenticationType contactMethodType;
    private String contactMethodValue;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setContactMethodType(AuthenticationType contactMethodType) {
        this.contactMethodType = contactMethodType;
    }

    public void setContactMethodValue(String contactMethodValue) {
        this.contactMethodValue = contactMethodValue;
    }

    public AuthenticationType getContactMethodType() {
        return contactMethodType;
    }

    public String getContactMethodValue() {
        return contactMethodValue;
    }
}