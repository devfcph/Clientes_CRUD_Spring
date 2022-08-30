/*
*
* Autor: Francisco Pérez
* Fecha: 29-08-2022
*
* */



package com.francisco.clientes.demo;

import com.francisco.clientes.demo.models.ClienteModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

	//Lista que se utlizará para almacenar los datos
	public static List<ClienteModel> listaCliente;

	public static void main(String[] args) {
		//Inicializar lista
		listaCliente = new ArrayList<>();
		SpringApplication.run(Main.class, args);
	}

}
