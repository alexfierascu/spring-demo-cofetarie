package com.alexf.springmvccofetarie.controller;

import com.alexf.springmvccofetarie.dto.ClientDTO;
import com.alexf.springmvccofetarie.model.Client;
import com.alexf.springmvccofetarie.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/client")
@AllArgsConstructor
@Api(value = "Cofetarie Management System", description = "Operations pertaining to employee in Employee Management System")
public class ClientController {

    @Autowired
    private final ClientService clientService;


    @ApiOperation(value = "View a list of available clients", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClientById(@PathVariable int id) {
        return clientService.findClientById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client addNewClient(@RequestBody ClientDTO client) {
        return clientService.addClient(client);
        //return clientService.addClient(client);
    }

//    @ApiOperation(value = "Adds a list employee", response = List.class)
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public List<Client> addMultipleClients(@RequestBody List<Client> clientList) {
//        return clientService.addClients(clientList);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClientById(@PathVariable int id) {
        clientService.removeClientById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllClients() {
        clientService.removeAllClients();
    }
}
