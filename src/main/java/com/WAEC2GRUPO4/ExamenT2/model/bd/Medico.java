package com.WAEC2GRUPO4.ExamenT2.model.bd;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name ="medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMedico;
    @Column(name = "NomMedico")
    private String NomMedico;
    @Column(name = "ApeMedico")
    private String  ApeMedico ;
    @Temporal(TemporalType.DATE)
    @Column(name = "FechNacMedico")
    private Date FechNacMedico;
}
