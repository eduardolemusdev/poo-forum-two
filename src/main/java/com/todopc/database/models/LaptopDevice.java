package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

public class LaptopDevice extends Device implements HardDriveStats, MemoryStats{
    private String screenSize;
    private String hardDriveCapacity;
    private String memoryRam;

    public LaptopDevice(String manufacterBy, String model, String integratedChip, String screenSize) {
        super(manufacterBy, model, integratedChip);
        this.screenSize = screenSize;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) throws EmptyValueException {
        this.screenSize = super.validateNotEmptyString(screenSize);
    }

    @Override
    public String getHardDriveCapacity() {
        return this.hardDriveCapacity;
    }

    @Override
    public void setHardDriveCapacity(String hardDriveCapacity) throws EmptyValueException {
        this.hardDriveCapacity = super.validateNotEmptyString(hardDriveCapacity);
    }

    @Override
    public String getMemoryRam() {
        return this.memoryRam;
    }

    @Override
    public void setMemoryRam(String memoryRam) throws EmptyValueException {
        this.memoryRam = super.validateNotEmptyString(memoryRam);
    }
}
