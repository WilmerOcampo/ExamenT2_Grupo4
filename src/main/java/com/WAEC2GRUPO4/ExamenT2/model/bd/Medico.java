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
    private Integer idmedico;
    @Column(name = "nommedico")
    private String nommedico;
    @Column(name = "apemedico")
    private String  apemedico ;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechnacmedico")
    private Date fechnacmedico;
}
