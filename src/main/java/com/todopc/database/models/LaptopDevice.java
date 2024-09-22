package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LaptopDevice extends Device implements HardDriveStats, MemoryStats, ICheckEmptyPropertys{
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

    @Override
    public void checkEmptyPropertys() throws EmptyValueException {
        List<DeviceSaveResponse> responses = new ArrayList<>();
        responses.add(super.validateNotEmptyString("'Fabricante'",this.getManufacterBy()));
        responses.add(super.validateNotEmptyString("'Modelo",this.getModel()));
        responses.add(super.validateNotEmptyString("'Microprocesador'",this.getIntegratedChip()));
        responses.add(super.validateNotEmptyString("'Capacidad de Disco Duro'",this.getHardDriveCapacity()));
        responses.add(super.validateNotEmptyString("'Capacidad de Memoria Ram'",this.getMemoryRam()));
        responses.add(super.validateNotEmptyString("'Tamaño de pantalla'",this.getScreenSize()));

        StringBuffer sb = new StringBuffer();


        List<DeviceSaveResponse> errors = responses.stream().filter((laptop) -> laptop.getStatus() != DeviceSaveResponseStatus.SUCCESSFULLY).collect(Collectors.toList());

        errors.forEach(error -> System.out.println(error.getMessage()));


        boolean existErrors = !errors.isEmpty();

        if(existErrors) {
            sb.append("Campos vacíos:\n");
            responses.forEach(response->{
                sb.append(response.getMessage()).append("\n");});
            throw new EmptyValueException(sb.toString());
        }
    }
}
