package com.alexf.springmvccofetarie.dto;

import com.alexf.springmvccofetarie.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CofetarieDTO {

    private String numeCofetarie;

    private String adresaCofetarie;

    private List<Client> listaClienti = new ArrayList<>();
}
