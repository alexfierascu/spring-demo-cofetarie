package com.alexf.springmvccofetarie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Evenimente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_eveniment;

    private String numeEveniment;

    private int durataEveniment;

    private double pretEveniment;

    private String tematicaEveniment;

}
