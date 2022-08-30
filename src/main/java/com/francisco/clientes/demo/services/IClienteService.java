/*
 *
 * Autor: Francisco Pérez
 * Fecha: 29-08-2022
 *
 * */



package com.francisco.clientes.demo.services;

import com.francisco.clientes.demo.models.ClienteModel;
import com.francisco.clientes.demo.dto.RespuestaDTO;

import java.util.List;

/*
* Interfaz que contiene los métodos a utilizar para la entidad Cliente
* */
public interface IClienteService {

    /*
    * Devuelve todos los elementos de la lista
    * @return Regresa un objeto de tipo List<ClienteModel>
    * */
    public List<ClienteModel> getAll() throws Exception;

    /*
    * Agrega al catálogo un cliente
    * @param Objeto de la entidad Cliente
    * @return Regresa el nuevo elemento agregado
    * */
    public ClienteModel add(ClienteModel cliente) throws Exception;

    /*
    * Elimina del catálogo un elemento
    * @param Recibe como parámetro un objeto de tipo ClienteModel
    * @return Regresa VERDADERO si la operación se cumple
    * */
    public Boolean delete(ClienteModel model) throws  Exception;

    /*
    * Actualiza un elemento del catálogo Cliente
    * @param Recibe un objeto de tipo ClienteModel
    * @return Devuelve el elemento actualizado
    * */
    public ClienteModel update(ClienteModel model) throws  Exception;

    /*
    * Obtiene un único elemento de la colección
    * @param Recibe un identificador
    * @return Regresa un modelo de la entidad ClienteModel
    * */
    public ClienteModel getById(Integer id) throws Exception;


}
