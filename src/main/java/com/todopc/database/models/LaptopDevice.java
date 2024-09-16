package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

public class LaptopDevice extends Device implements HardDriveStats, MemoryStats{
    private String screenSize;
    private String hardDriveCapacity;
    private String memoryRam;

    public LaptopDevice(String manufacterBy, String model, String integratedChip,String memoryRam, String screenSize, String hardDriveCapacity) {
        super(manufacterBy, model, integratedChip);
        this.screenSize = screenSize;
        this.memoryRam = memoryRam;
        this.hardDriveCapacity = hardDriveCapacity;
    }


    @Override
    public String getHardDriveCapacity() {
        return this.hardDriveCapacity;
    }

    @Override
    public void setHardDriveCapacity(String hardDriveCapacity) throws EmptyValueException {
        this.hardDriveCapacity = hardDriveCapacity;
    }

    @Override
    public String getMemoryRam() {
        return this.memoryRam;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public Object getMadeBy() {
        return null;
    }

    @Override
    public String getHardDriveCapacity1() {
        return "";
    }
}
