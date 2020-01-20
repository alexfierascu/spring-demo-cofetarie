package com.alexf.springmvccofetarie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "client")
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_client;

    private String nume;

    private String prenume;

    private String adresa;

    private int varsta;

    private boolean clientFidel;
}
