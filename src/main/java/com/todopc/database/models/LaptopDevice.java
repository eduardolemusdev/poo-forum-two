package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

public class LaptopDevice extends Device implements HardDriveStats, MemoryStats{
    private String screenSize;
    private String hardDriveCapacity;
    private String memoryRam;

    public LaptopDevice(String manufacterBy, String model, String integratedChip, String screenSize) throws EmptyValueException {
        super(manufacterBy, model, integratedChip);
        this.screenSize = screenSize;
    }


    @Override
    public String getHardDriveCapacity() {
        return "";
    }

    @Override
    public void setHardDriveCapacity(String hardDriveCapacity) throws EmptyValueException {

    }

    @Override
    public String getMemoryRam() {
        return "";
    }

    @Override
    public void setMemoryRam(String memoryRam) throws EmptyValueException {

    }
}
