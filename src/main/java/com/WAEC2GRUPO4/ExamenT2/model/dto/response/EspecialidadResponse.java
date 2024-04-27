package com.WAEC2GRUPO4.ExamenT2.model.dto.response;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class EspecialidadResponse {
    private Boolean respuesta;
    private String mensaje;
}
