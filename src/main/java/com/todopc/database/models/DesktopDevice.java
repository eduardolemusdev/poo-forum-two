package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void checkEmptyPropertys() throws EmptyValueException {
        List<DeviceSaveResponse> responses = new ArrayList<>();
        responses.add(super.validateNotEmptyString("'Fabricante'",this.getManufacterBy()));
        responses.add(super.validateNotEmptyString("'Modelo",this.getModel()));
        responses.add(super.validateNotEmptyString("'Microprocesador'",this.getIntegratedChip()));
        responses.add(super.validateNotEmptyString("'Tarjeta de video'",this.getGpuModel()));
        responses.add(super.validateNotEmptyString("'Capacidad de Disco Duro'",this.getHardDriveCapacity()));
        responses.add(super.validateNotEmptyString("'Capacidad de Memoria Ram'",this.getMemoryRam()));
        responses.add(super.validateNotEmptyString("'Tamaño de torre'",this.getTowerSize()));

        StringBuffer sb = new StringBuffer();


        List<DeviceSaveResponse> errors = responses.stream().filter((desktop) -> desktop.getStatus() != DeviceSaveResponseStatus.SUCCESSFULLY).collect(Collectors.toList());

        errors.forEach(error -> System.out.println(error.getMessage()));


        boolean existErrors = !errors.isEmpty();

        if(existErrors) {
            sb.append("Campos vacíos:\n");
            responses.forEach(response->{
                sb.append(response.getMessage()).append("\n");});
            throw new EmptyValueException(sb.toString());
        }

    }

    @Override
    public String getHardDriveCapacity() {
        return this.hardDriveCapacity;
    }

    @Override
    public String getMemoryRam() {
        return this.memoryRam;
    }

}
