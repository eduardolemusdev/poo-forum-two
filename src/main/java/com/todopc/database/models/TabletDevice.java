package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

public class TabletDevice extends Device{
    private String diagonalScreenSize;
    private String resistiveCapacitance;
    private String nandMemorySize;
    private String operatingSystem;

    public TabletDevice(String manufacterBy, String model, String integratedChip, String diagonalScreenSize, String resistiveCapacitance, String nandMemorySize, String operatingSystem) throws EmptyValueException {
        super(manufacterBy, model, integratedChip);
        this.diagonalScreenSize = diagonalScreenSize;
        this.resistiveCapacitance = resistiveCapacitance;
        this.nandMemorySize = nandMemorySize;
        this.operatingSystem = operatingSystem;
    }


}
