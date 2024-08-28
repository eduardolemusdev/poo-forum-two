package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

public class TabletDevice extends Device{
    private String diagonalScreenSize;
    private String resistiveCapacitance;
    private String nandMemorySize;
    private String operatingSystem;

    public TabletDevice(String manufacterBy, String model, String integratedChip, String diagonalScreenSize, String resistiveCapacitance, String nandMemorySize, String operatingSystem) {
        super(manufacterBy, model, integratedChip);
        this.diagonalScreenSize = diagonalScreenSize;
        this.resistiveCapacitance = resistiveCapacitance;
        this.nandMemorySize = nandMemorySize;
        this.operatingSystem = operatingSystem;
    }

    public String getDiagonalScreenSize() {
        return diagonalScreenSize;
    }

    public void setDiagonalScreenSize(String diagonalScreenSize) throws EmptyValueException {
        this.diagonalScreenSize = super.validateNotEmptyString(diagonalScreenSize);
    }

    public String getResistiveCapacitance() {
        return resistiveCapacitance;
    }

    public void setResistiveCapacitance(String resistiveCapacitance) throws EmptyValueException {
        this.resistiveCapacitance = super.validateNotEmptyString(resistiveCapacitance);
    }

    public String getNandMemorySize() {
        return nandMemorySize;
    }

    public void setNandMemorySize(String nandMemorySize) throws EmptyValueException {
        this.nandMemorySize = super.validateNotEmptyString(nandMemorySize);
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) throws EmptyValueException {
        this.operatingSystem = super.validateNotEmptyString(operatingSystem);
    }
}
