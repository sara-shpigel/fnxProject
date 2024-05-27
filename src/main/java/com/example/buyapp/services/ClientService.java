//// ClientService.java
package com.example.buyapp.services;

import com.example.buyapp.models.AuthenticationType;
import com.example.buyapp.models.Client;
import com.example.buyapp.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientService {

    @Autowired
    private ProductService productService;
    private Map<String, Client> clients = new HashMap<>();
    private final Map<String, Boolean> authenticationStatus = new HashMap<>();

    public Map<String, Product> getClientListById(String id) {
        return clients.get(id).getClientProducts();
    }

    public void addClient(Client client) {
        clients.put(client.getId(), client);
        authenticationStatus.put(client.getId(), false);
    }

    public boolean addProductToClient(String clientId, String productId, String userId) {
        if (isClientAuthenticated(clientId)) {
            Client client = clients.get(clientId);
            Product product = productService.getProductById(productId);

            if (client != null && product != null && !client.getClientProducts().containsKey(userId)) {
                client.getClientProducts().put(userId, product);
                return true;
            }
        }
        return false;
    }


    public boolean updateClientProduct(String clientId, String productId, String userId) {
        if (authenticationStatus.getOrDefault(clientId, false)) { // Check if the client is authenticated
            Client client = clients.get(clientId);
            Product product = productService.getProductById(productId);
            if (client != null) {
                client.getClientProducts().put(userId, product);
                return true;
            }
        }
        return false;
    }

    public boolean authenticate(String clientId, AuthenticationType contactMethodType, String contactMethodValue) {
        Client client = clients.get(clientId);
        if (client != null) {
            boolean isAuthenticated = client.getAuthentications().stream()
                    .anyMatch(auth -> auth.getContactMethodType().equals(contactMethodType)
                            && auth.getContactMethodValue().equals(contactMethodValue));
            if (isAuthenticated) {
                authenticationStatus.put(clientId, true);
            }
            return isAuthenticated;
        }
        return false;
    }

    public void logout(String clientId) {
        authenticationStatus.put(clientId, false);
    }

    public boolean isClientAuthenticated(String clientId) {
        return authenticationStatus.getOrDefault(clientId, false);
    }
}
