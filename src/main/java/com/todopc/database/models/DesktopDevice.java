package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

import java.util.ArrayList;
import java.util.Collections;
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

    public String getTowerSize() {
        return towerSize;
    }

    @Override
    public List<DeviceSaveResponse> checkEmptyPropertys() {
        List<DeviceSaveResponse> responses = new ArrayList<>();
        responses.add(super.validateNotEmptyString("'Fabricado por'",this.getManufacterBy()));
        responses.add(super.validateNotEmptyString("'Modelo",this.getModel()));
        responses.add(super.validateNotEmptyString("'Microprocesador'",this.getIntegratedChip()));
        responses.add(super.validateNotEmptyString("'Tarjeta de video'",this.getGpuModel()));
        responses.add(super.validateNotEmptyString("'Capacidad de Disco Duro'",this.getHardDriveCapacity()));
        responses.add(super.validateNotEmptyString("'Capacidad de Memoria Ram'",this.getMemoryRam()));
        responses.add(super.validateNotEmptyString("'Tamaño de torre'",this.getTowerSize()));

        return responses;
    }

    @Override
    public String getHardDriveCapacity() {
        return this.hardDriveCapacity;
    }

    @Override
    public void setHardDriveCapacity(String hardDriveCapacity) throws EmptyValueException {

    }

    @Override
    public String getMemoryRam() {
        return this.memoryRam;
    }

    @Override
    public void setMemoryRam(String memoryRam) throws EmptyValueException {

    }
}
