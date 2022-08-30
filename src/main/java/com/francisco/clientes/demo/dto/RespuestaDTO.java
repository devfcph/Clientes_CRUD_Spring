package com.francisco.clientes.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* Clase genérica, la cual regresará un status, un mensaje y datos
*
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaDTO {
    private String mensaje;
    private Boolean exito;
    private Object dato;
}
