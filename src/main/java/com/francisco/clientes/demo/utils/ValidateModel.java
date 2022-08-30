package com.francisco.clientes.demo.utils;

import com.francisco.clientes.demo.Main;
import com.francisco.clientes.demo.models.ClienteModel;

public class ValidateModel {

    public static Boolean existsItemInFile(ClienteModel model) {
        Boolean itemExits = false;
        if (!Main.listaCliente.isEmpty()) {
            for(ClienteModel m : Main.listaCliente) {
                if(m.getCorreo().equals(model.getCorreo()) && m.getNombre().equals(model.getNombre()) && m.getTelefono().equals(model.getTelefono()))
                {
                    itemExits = true;
                    break;
                }
            }
        }
        return  itemExits;
    }

    public static void validateModelAttributes(ClienteModel model) throws  Exception {
        try {

            //ClienteModel modelTemporal = new ClienteModel();
            //if(!modelTemporal.equals(model))
            //    throw  new Exception(Constants.MESSAGE_INVALID_MODEL);

            if(!RegexValidation.validateOnlyAlphabet(model.getNombre()))
                throw new Exception(Constants.MESSAGE_INVALID_NAME);

            if(!RegexValidation.validateEmailPattern(model.getCorreo()))
                throw  new Exception(Constants.MESSAGE_INVALID_EMAIL);

            if(!RegexValidation.validateCellphoneNumberPattern(model.getTelefono()))
                throw  new Exception(Constants.MESSAGE_INVALID_CELLPHONE);

            if(ValidateModel.existsItemInFile(model))
                throw  new Exception(Constants.MESSAGE_DUPLICATE_ITEM);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
