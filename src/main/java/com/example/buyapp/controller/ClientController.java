package com.example.buyapp.controller;

import com.example.buyapp.models.AuthenticationType;
import com.example.buyapp.models.Client;
import com.example.buyapp.models.Product;
import com.example.buyapp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @GetMapping("/{id}")
    public Map<String, Product> getClientListById(@PathVariable String id) {
        return clientService.getClientListById(id);
    }

    @PostMapping("/{id}/addProduct/{productId}/{useId}")
    public ResponseEntity<String> addProductToClient(@PathVariable String id, @PathVariable String productId, @PathVariable String useId) {
        boolean success = clientService.addProductToClient(id, productId, useId);
        if (success) {
            return ResponseEntity.ok("Product added successfully.");
        } else {
            return ResponseEntity.status(401).body("Client is not authenticated or product could not be added.");
        }
    }

    @PutMapping("/{id}/updateProduct/{productId}/{useId}")
    public ResponseEntity<String> updateClientProduct(@PathVariable String id, @PathVariable String productId, @PathVariable String useId) {
        boolean success = clientService.updateClientProduct(id, productId, useId);
        if (success) {
            return ResponseEntity.ok("Product updated successfully.");
        } else {
            return ResponseEntity.status(401).body("Client is not authenticated or product could not be updated.");
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestParam String clientId, @RequestParam AuthenticationType contactMethodType, @RequestParam String contactMethodValue) {
        clientService.authenticate(clientId, contactMethodType, contactMethodValue);
        return ResponseEntity.ok("Client authenticated successfully.");

    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutClient(@RequestParam String clientId) {
        clientService.logout(clientId);
        return ResponseEntity.ok("Client logged out successfully.");
    }
}