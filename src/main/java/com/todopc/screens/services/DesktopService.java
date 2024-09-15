package com.todopc.screens.services;

import com.todopc.database.models.DesktopDevice;
import com.todopc.database.models.Device;
import com.todopc.database.models.DeviceSaveResponse;
import com.todopc.database.models.DeviceSaveResponseStatus;
import com.todopc.database.repositories.IDevicesRepository;

import javax.swing.*;
import java.util.List;

public class SaveDesktopService {
    private final IDevicesRepository devicesRepository;
    public SaveDesktopService(IDevicesRepository devicesRepository) {
        this.devicesRepository = devicesRepository;
    }

    public void save(DesktopDevice desktop , JFrame window) {
        List<DeviceSaveResponse> errorsResponses = desktop.checkEmptyPropertys();
        boolean isPropertiesOk = errorsResponses.isEmpty();

        if (!isPropertiesOk){
            StringBuilder sb = new StringBuilder();

            errorsResponses.forEach((deviceSaveResponse) -> {
                if(deviceSaveResponse.getStatus() == DeviceSaveResponseStatus.EMPTY_VALUE){
                    sb.append(deviceSaveResponse.getMessage()).append("\n");
                }
            });
            sb.append("No se permiten campos vacíos.");

            JOptionPane.showMessageDialog(window, sb.toString());
            return;
        }
        this.devicesRepository.saveDevice(desktop);
        JOptionPane.showMessageDialog(window, "Equipo guardado con exito");
    }
}
