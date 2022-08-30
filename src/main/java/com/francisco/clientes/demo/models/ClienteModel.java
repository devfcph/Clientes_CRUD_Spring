package com.francisco.clientes.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Entidad Cliente
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteModel {
    //Atributos de la clase
    private Integer idCliente;
    private String nombre;
    private String correo;
    private String telefono;
}
