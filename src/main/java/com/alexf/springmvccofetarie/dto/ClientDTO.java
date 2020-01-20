package com.alexf.springmvccofetarie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {
    private String nume;

    private String prenume;

    private String adresa;

    private int varsta;

    private boolean clientFidel;
}
