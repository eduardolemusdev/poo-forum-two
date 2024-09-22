package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabletDevice extends Device implements ICheckEmptyPropertys{
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

    public String getResistiveCapacitance() {
        return resistiveCapacitance;
    }

    public String getNandMemorySize() {
        return nandMemorySize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public void checkEmptyPropertys() throws EmptyValueException {
        List<DeviceSaveResponse> responses = new ArrayList<>();
        responses.add(super.validateNotEmptyString("'Fabricante'",this.getManufacterBy()));
        responses.add(super.validateNotEmptyString("'Modelo",this.getModel()));
        responses.add(super.validateNotEmptyString("'Microprocesador'",this.getIntegratedChip()));
        responses.add(super.validateNotEmptyString("'Tamaño de Diagonal de pantalla'",this.getDiagonalScreenSize()));
        responses.add(super.validateNotEmptyString("'Tipo de pantalla'",this.getResistiveCapacitance()));
        responses.add(super.validateNotEmptyString("'Tamaño de memoria NAND'",this.getNandMemorySize()));
        responses.add(super.validateNotEmptyString("'Sistema operativo'",this.getOperatingSystem()));

        StringBuffer sb = new StringBuffer();


        List<DeviceSaveResponse> errors = responses.stream().filter((tablet) -> tablet.getStatus() != DeviceSaveResponseStatus.SUCCESSFULLY).collect(Collectors.toList());

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
