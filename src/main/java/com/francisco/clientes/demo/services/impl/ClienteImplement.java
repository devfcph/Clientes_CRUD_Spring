/*
 *
 * Autor: Francisco Pérez
 * Fecha: 29-08-2022
 *
 * */



package com.francisco.clientes.demo.services.impl;

import com.francisco.clientes.demo.Main;
import com.francisco.clientes.demo.models.ClienteModel;
import com.francisco.clientes.demo.dto.RespuestaDTO;
import com.francisco.clientes.demo.services.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;


/*
* Clase que implementa la interface IClienteService
* */
@Service
public class ClienteImplement implements IClienteService {


    /*
    * Devuelve una lista de ClienteModel
    * @return List<ClenteModel>
    * */
    @Override
    public List<ClienteModel> getAll() throws  Exception {
        try {
            if (Main.listaCliente.isEmpty()) throw  new Exception("Sin datos para mostrar");
            return  Main.listaCliente;
        }
        catch (Exception ex) {
            throw  new Exception(ex.getMessage());
        }
    }

    /*
    * Agrega un modelo Cliente al archivo
    * @param Recibe un modelo de tipo ClienteModel
    * @return Regresa el modelo agregado
    * */
    @Override
    public ClienteModel add(ClienteModel cliente) throws Exception {
        try{

            Main.listaCliente.add(cliente);
            return cliente;
        }
        catch(Exception ex){
            throw new Exception("Error al agregar: " + ex.getMessage());
        }
    }

    /*
     * Elimina un modelo del archivo
     * @param Recibe un modelo de tipo ClienteModel
     * @return Regresa una bandera booleana
     * */
    @Override
    public Boolean delete(ClienteModel model) throws Exception {
        try {
            //Si pasa
            Main.listaCliente.remove(model);
            return  true;
        }
        catch (Exception ex) {
            throw  new Exception("Error al eliminar: " + ex.getMessage());
        }
    }

    /*
     * Modifica un modelo Cliente al archivo
     * @param Recibe un modelo de tipo ClienteModel
     * @return Regresa el modelo modificado
     * */
    @Override
    public ClienteModel update(ClienteModel model) throws  Exception {
        try {

            Main.listaCliente.removeIf(obj -> obj.getIdCliente().equals(model.getIdCliente()));

            Main.listaCliente.add(model);
            return model;
        }
        catch (Exception ex) {
            throw  new Exception("Error al modificar: " + ex.getMessage());
        }

    }

    /*
     * Obtiene un elemento del archivo
     * @param Recibe el identificador del modelo a regresar
     * @return Regresa el modelo encontrado
     * */
    @Override
    public ClienteModel getById(Integer id) throws  Exception {
        try {

            ClienteModel cliente = Main.listaCliente.stream()
                    .filter(obj -> obj.getIdCliente().equals(id)).findFirst().get();

            return  cliente;
        }
        catch (Exception ex) {
            throw  new Exception("Error al obtener elemento: " + ex.getMessage());
        }
    }
}
