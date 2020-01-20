package com.alexf.springmvccofetarie.controller;

import com.alexf.springmvccofetarie.dto.CofetarieDTO;
import com.alexf.springmvccofetarie.model.Cofetarie;
import com.alexf.springmvccofetarie.service.CofetarieService;
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
@RequestMapping(path = "/api/v1/cofetarie")
@AllArgsConstructor
@Api(value = "Cofetarie Management System", description = "Operations pertaining to employee in Employee Management System")
public class CofetarieController {
    @Autowired
    private CofetarieService cofetarieService;

//    @Autowired
//    private ClientService clientService;

    @ApiOperation(value = "View a list of available clients", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cofetarie> getAllCofetaries() {
        return cofetarieService.afiseazaToateCofetariile();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cofetarie getCofetarieById(@PathVariable int id) {
        return cofetarieService.afiseazaCofetarieSpecifica(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cofetarie addNewCofetarie(@RequestBody CofetarieDTO client) {
        Cofetarie cofetarie = cofetarieService.mapDTOToEntity(client);
        return cofetarieService.adaugaCofetarieNoua(cofetarie);

        //return clientService.addClient(client);
    }

//    @ApiOperation(value = "Adds a list cofetarie", response = List.class)
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public List<Cofetarie> addMultipleCofetaries(@RequestBody List<Cofetarie> newCofetaries) {
//        return cofetarieService.adaugaCofetarii(newCofetaries);
//    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public Cofetarie updateCofetarie(@RequestBody CofetarieDTO cofetarieDTO,@PathVariable int id) {
//        return cofetarieService.updateListaClienti(cofetarieDTO,id);
//    }

}
