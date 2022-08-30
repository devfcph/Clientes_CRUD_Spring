package com.francisco.clientes.demo.controller;

import com.francisco.clientes.demo.dao.ClienteDAO;
import com.francisco.clientes.demo.models.ClienteModel;
import com.francisco.clientes.demo.dto.RespuestaDTO;
import com.francisco.clientes.demo.utils.Constants;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
* Controlador ClientesController
*
* */
@Configuration
@RestController
@RequestMapping(Constants.RUTA_CLIENTES)
public class ClientesController {

    @Autowired
    ClienteDAO dao;

    /*
    * Agrega un elemento del modelo Cliente al archivo
    * @param Mediante el body de la petición, deberá ir el modelo Cliente
    * @return ResponseEntity<ResouestaDTO>
    * */
    @PostMapping()
    public ResponseEntity<RespuestaDTO> agregar(@RequestBody ClienteModel cliente) {
        return dao.agregarCliente(cliente);
    }


    /*
     * Agrega un elemento del modelo Cliente al archivo
     * @param Mediante el body de la petición, deberá ir el modelo Cliente
     * @return ResponseEntity<ResouestaDTO>
     * */
    @GetMapping()
    public ResponseEntity<RespuestaDTO> obtenerClientes() {
        return  dao.obtenerClientes();
    }

    @GetMapping("{id}")
    public ResponseEntity<RespuestaDTO> obtenerClienteById(@PathVariable Integer id) {
        return dao.obtenerClienteById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<RespuestaDTO> eliminarCliente(@PathVariable Integer id)
    {
        return dao.eliminarCliente(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<RespuestaDTO> actualizarCliente(@PathVariable Integer id, @RequestBody ClienteModel model) {
        return  dao.editarCliente(id, model);
    }


}
