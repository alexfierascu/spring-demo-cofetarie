package com.alexf.springmvccofetarie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cofetarie")
@Table(name = "cofetarie")
public class Cofetarie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cofetarie;

    private String numeCofetarie;

    private String adresaCofetarie;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_client")
    private List<Client> clientList = new ArrayList<>();

//    Set<Evenimente> listaEvenimente;
//
//    Set<ProdusCofetarie> listaProduse;

}
