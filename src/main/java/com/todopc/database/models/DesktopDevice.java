package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

import java.util.ArrayList;
import java.util.List;

public class DesktopDevice extends Device implements MemoryStats, HardDriveStats, ICheckEmptyPropertys {
    private String gpuModel;
    private String towerSize;
    private String hardDriveCapacity;
    private String memoryRam;

    public DesktopDevice(String manufacterBy, String model, String integratedChip, String gpuModel, String towerSize, String hardDriveCapacity, String memoryRam) {
        super(manufacterBy, model, integratedChip);
        this.gpuModel = gpuModel;
        this.towerSize = towerSize;
        this.hardDriveCapacity = hardDriveCapacity;
        this.memoryRam = memoryRam;
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public String getTowerSize1() {
        return towerSize;
    }

    @Override
    public List<DeviceSaveResponse> checkEmptyPropertys() {
        List<DeviceSaveResponse> responses = new ArrayList<>();
        responses.add(super.validateNotEmptyString("'Fabricado por'", this.getManufacterBy()));
        responses.add(super.validateNotEmptyString("'Modelo", this.getModel()));
        responses.add(super.validateNotEmptyString("'Microprocesador'", this.getIntegratedChip()));
        responses.add(super.validateNotEmptyString("'Tarjeta de video'", this.getGpuModel()));
        responses.add(super.validateNotEmptyString("'Capacidad de Disco Duro'", this.getHardDriveCapacity()));
        responses.add(super.validateNotEmptyString("'Capacidad de Memoria Ram'", this.getMemoryRam()));
        responses.add(super.validateNotEmptyString("'Tamaño de torre'", this.getTowerSize()));

        return responses;
    }

    @Override
    public String getHardDriveCapacity1() {
        return this.hardDriveCapacity;
    }

    @Override
    public void setHardDriveCapacity(String hardDriveCapacity) throws EmptyValueException {
        // Implementation here
    }

    @Override
    public String getMemoryRam() {
        return this.memoryRam;
    }

    // Add the following methods
    public String getMadeBy() {
        return super.getManufacterBy();
    }

    public String getModel() {
        return super.getModel();
    }

    public String getIntegratedChip() {
        return super.getIntegratedChip();
    }

    public String getMemoryRamCapacity() {
        return this.memoryRam;
    }

    public String getGpu() {
        return this.gpuModel;
    }

    public String getTowerSize() {
        return this.towerSize;
    }

    public String getHardDriveCapacity() {
        return this.hardDriveCapacity;
    }
}