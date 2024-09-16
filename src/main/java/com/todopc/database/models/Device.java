package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

import java.util.Optional;

public abstract class Device {
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

    public abstract String getHardDriveCapacity1();

    public String getModel() {
        return model;
    }

    public String getIntegratedChip() {
        return integratedChip;
    }

    protected DeviceSaveResponse validateNotEmptyString(String propertyTarget, String data) {
       boolean isEmpty = Optional.ofNullable(data).orElse("").trim().isEmpty();

       if (isEmpty){
         return   new DeviceSaveResponse("La propiedad: "+propertyTarget+", es requerida",DeviceSaveResponseStatus.EMPTY_VALUE);
       }
        return  new DeviceSaveResponse("",DeviceSaveResponseStatus.SUCCESSFULLY);
    }

    public Object getMemoryRamCapacity() {
        return null;
    }

    public Object getScreenDiagonalSize() {
        return null;
    }

    public Object getScreenTech() {
        return null;
    }

    public Object getMemoryNandCapacity() {
        return null;
    }

    public Object getOperativeSystem() {
        return null;
    }
}
