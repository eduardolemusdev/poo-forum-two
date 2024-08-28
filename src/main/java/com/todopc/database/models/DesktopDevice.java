package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

public class DesktopDevice extends Device implements MemoryStats, HardDriveStats {
    private String gpuModel;
    private String towerSize;
    private String hardDriveCapacity;
    private String memoryRam;

    public DesktopDevice(String manufacterBy, String model, String integratedChip, String gpuModel, String towerSize) {
        super(manufacterBy, model, integratedChip);
        this.gpuModel = gpuModel;
        this.towerSize = towerSize;
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public void setGpuModel(String gpuModel) throws EmptyValueException {
        this.gpuModel = super.validateNotEmptyString(gpuModel);
    }

    public String getTowerSize() {
        return towerSize;
    }

    public void setTowerSize(String towerSize) throws EmptyValueException {
        this.towerSize = super.validateNotEmptyString(towerSize);
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
