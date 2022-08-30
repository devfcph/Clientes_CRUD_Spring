package com.francisco.clientes.demo.dao;

import com.francisco.clientes.demo.Main;
import com.francisco.clientes.demo.dto.RespuestaDTO;
import com.francisco.clientes.demo.models.ClienteModel;
import com.francisco.clientes.demo.services.IClienteService;
import com.francisco.clientes.demo.utils.Constants;
import com.francisco.clientes.demo.utils.RegexValidation;
import com.francisco.clientes.demo.utils.ValidateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Comparator;

@Repository
public class ClienteDAO {
    //
    @Autowired
    IClienteService service;

    /*
     * Agrega un modelo al archivo
     * */
    public ResponseEntity<RespuestaDTO> agregarCliente(ClienteModel model) {

        try {
            ValidateModel.validateModelAttributes(model);

            Integer idCliente = 1;
            if (!Main.listaCliente.isEmpty()) {
                idCliente = Main.listaCliente.stream().max(Comparator.comparing(v -> v.getIdCliente())).get().getIdCliente() + 1;
            }
            model.setIdCliente(idCliente);

            return new ResponseEntity<>(RespuestaDTO.builder()
                    .exito(true)
                    .mensaje("Creado con exito")
                    .dato(service.add(model)).build(), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(RespuestaDTO.builder()
                    .exito(false)
                    .mensaje("Error al registrar al cliente")
                    .dato(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }


    /*
     * Elimina un elemento del archivo
     * */
    public ResponseEntity<RespuestaDTO> eliminarCliente(Integer id) {
        try {
            ClienteModel cliente = Main.listaCliente.stream()
                    .filter(obj -> obj.getIdCliente().equals(id))
                    .findFirst().get();

            return new ResponseEntity<>(RespuestaDTO.builder()
                    .exito(true)
                    .mensaje("Eliminado correctamente")
                    .dato(service.delete(cliente)).build(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(RespuestaDTO.builder()
                    .exito(false)
                    .mensaje("No se encontró el elemento a eliminar")
                    .dato("Detalles: " + ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * Modifica un elemento del archivo
     * */
    public ResponseEntity<RespuestaDTO> editarCliente(Integer id, ClienteModel model) {
        try {

            ClienteModel cliente = Main.listaCliente.stream().filter(obj -> obj.getIdCliente().equals(id))
                    .findFirst().get();

            ValidateModel.validateModelAttributes(model);

            cliente.setCorreo(model.getCorreo());
            cliente.setNombre(model.getNombre());
            cliente.setTelefono(model.getTelefono());



            return new ResponseEntity<>(RespuestaDTO.builder()
                    .exito(true).mensaje("Modificado con éxito")
                    .dato(service.update(cliente))
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(RespuestaDTO.builder()
                    .exito(false)
                    .mensaje("Error al modificar")
                    .dato(e.getMessage())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * Obtiene la lista de Clientes
     * */
    public ResponseEntity<RespuestaDTO> obtenerClientes() {
        try {
            return new ResponseEntity<>(RespuestaDTO.builder()
                    .exito(true)
                    .mensaje("Datos obtenidos con éxito")
                    .dato(service.getAll()).build(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(RespuestaDTO.builder()
                    .exito(false)
                    .mensaje("Sin datos para mostrar: " + ex.getMessage())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * Obtiene un elemento del archivo mediante su ID
     * */
    public ResponseEntity<RespuestaDTO> obtenerClienteById(Integer id) {
        try {
            return new ResponseEntity<>(RespuestaDTO.builder()
                    .exito(true)
                    .mensaje("Datos obtenidos correctamente")
                    .dato(service.getById(id)).build(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(RespuestaDTO.builder()
                    .exito(false)
                    .mensaje("Sin información para mostrar")
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }


}
