package com.todopc;

import com.todopc.database.models.DesktopDevice;
import com.todopc.database.models.LaptopDevice;
import com.todopc.database.models.TabletDevice;
import com.todopc.screens.RegistryDeviceScreen;
import com.todopc.database.repositories.DevicesAbstractRepository;

public class Main {
    public static void main(String[] args) {
        DevicesAbstractRepository<DesktopDevice> desktopsDeviceRepository = new DevicesAbstractRepository<>();
        DevicesAbstractRepository<LaptopDevice> laptopsDeviceRepository = new DevicesAbstractRepository<>();
        DevicesAbstractRepository<TabletDevice> tabletsDeviceRepository = new DevicesAbstractRepository<>();

        RegistryDeviceScreen screen = new RegistryDeviceScreen(desktopsDeviceRepository, laptopsDeviceRepository, tabletsDeviceRepository);
        screen.executeScreen();
    }
}