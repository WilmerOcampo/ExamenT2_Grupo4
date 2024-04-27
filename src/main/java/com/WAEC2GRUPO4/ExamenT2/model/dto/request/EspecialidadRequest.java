package com.WAEC2GRUPO4.ExamenT2.model.dto.request;
import lombok.Data;

import java.util.Date;

@Data
public class EspecialidadRequest {

    private Integer idespecialidad;
    private String titulo;
    private String funcion;
    private Date fechagraduacion;
    private Integer idmedico;
}
