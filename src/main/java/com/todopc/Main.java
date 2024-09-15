package com.todopc;

import com.todopc.database.repositories.DevicesRepository;
import com.todopc.screens.RegistryDeviceScreen;
import com.todopc.screens.services.SaveDesktopService;

public class Main {
    public static void main(String[] args) {
        DevicesRepository devicesRepository = new DevicesRepository();
        SaveDesktopService saveDesktopService = new SaveDesktopService(devicesRepository);
        RegistryDeviceScreen screen = new RegistryDeviceScreen(saveDesktopService);
        screen.executeScreen();
    }
}