package com.WAEC2GRUPO4.ExamenT2.model.bd.pk;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name ="especialidad")

public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  IdEspecialidad;
    @Column(name = " Titulo")
    private String  Titulo;
    @Column(name = "Funcion")
    private String  Funcion ;
    @Temporal(TemporalType.DATE)
    @Column(name = "FechGraduacion")
    private Date FechGraduacion;
    @ManyToOne
    @JoinColumn(name = "IdMedico")
    private Medico medico;
}
