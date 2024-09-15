package com.todopc;

import com.todopc.database.models.DesktopDevice;
import com.todopc.screens.RegistryDeviceScreen;
import com.todopc.database.repositories.DevicesAbstractRepository;

public class Main {
    public static void main(String[] args) {
        DevicesAbstractRepository<DesktopDevice> desktopsDeviceRepository = new DevicesAbstractRepository<>();

        RegistryDeviceScreen screen = new RegistryDeviceScreen(desktopsDeviceRepository);
        screen.executeScreen();
    }
}