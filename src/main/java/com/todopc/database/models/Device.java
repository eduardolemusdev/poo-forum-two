package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

import java.util.Optional;

public class Device {
    private String manufacterBy;
    private String model;
    private String integratedChip;

    public Device(String manufacterBy, String model, String integratedChip) {
        this.manufacterBy = manufacterBy;
        this.model = model;
        this.integratedChip = integratedChip;
    }

    public String getManufacterBy() {
        return manufacterBy;
    }

    public void setManufacterBy(String manufacterBy) throws EmptyValueException {
        this.manufacterBy = this.validateNotEmptyString(manufacterBy);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) throws EmptyValueException {
        this.model = this.validateNotEmptyString(model);
    }

    public String getIntegratedChip() {
        return integratedChip;
    }

    public void setIntegratedChip(String integratedChip) throws EmptyValueException {
        this.integratedChip = this.validateNotEmptyString(integratedChip);
    }

    protected String validateNotEmptyString(String data) throws EmptyValueException {
       boolean isEmpty = Optional.ofNullable(data).orElse("").trim().isEmpty();
       if(!isEmpty){
           throw new EmptyValueException("Valor Requerido: "+data);
       }
       return data;
    }
}
