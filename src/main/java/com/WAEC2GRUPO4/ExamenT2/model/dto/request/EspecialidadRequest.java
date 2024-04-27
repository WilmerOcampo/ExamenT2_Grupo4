package com.WAEC2GRUPO4.ExamenT2.model.dto.request;
import lombok.Data;

import java.util.Date;

@Data
public class EspecialidadRequest {

    private Integer IdEspecialidad;
    private String  Titulo;
    private String  Funcion ;
    private Date    FechGraduacion;
    private Integer IdMedico;
}
