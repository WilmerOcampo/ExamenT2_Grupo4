package com.WAEC2GRUPO4.ExamenT2.model.bd;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name ="especialidad")

public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idespecialidad;
    @Column(name = " titulo")
    private String  titulo;
    @Column(name = "funcion")
    private String  funcion ;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_graduacion")
    private Date fecha_graduacion;
    @ManyToOne
    @JoinColumn(name = "idmedico")
    private Medico medico;
}
