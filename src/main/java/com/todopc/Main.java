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


        // Datos de prueba
        DesktopDevice desktop1 = new DesktopDevice(
                "Dell",              // Made by
                "Inspiron 3880",      // Model
                "Intel Core i5",      // Integrated Chip
                "NVIDIA GTX 1650",    // GPU
                "Mid Tower",          // Tower Size
                "1TB",                // Hard Drive Capacity
                "16GB"                // RAM Capacity
        );

        DesktopDevice desktop2 = new DesktopDevice(
                "HP",                 // Made by
                "Pavilion 590",       // Model
                "AMD Ryzen 7",        // Integrated Chip
                "AMD Radeon RX 580",  // GPU
                "Full Tower",         // Tower Size
                "512GB",              // Hard Drive Capacity
                "8GB"                 // RAM Capacity
        );

        DesktopDevice desktop3 = new DesktopDevice(
                "Lenovo",             // Made by
                "ThinkCentre M720",   // Model
                "Intel Core i7",      // Integrated Chip
                "Intel UHD 630",      // GPU
                "Small Form Factor",  // Tower Size
                "256GB",              // Hard Drive Capacity
                "32GB"                // RAM Capacity
        );

        DesktopDevice desktop4 = new DesktopDevice(
                "Acer",               // Made by
                "Aspire TC-885",      // Model
                "Intel Core i3",      // Integrated Chip
                "NVIDIA GTX 1050",    // GPU
                "Mini Tower",         // Tower Size
                "2TB",                // Hard Drive Capacity
                "12GB"                // RAM Capacity
        );

        DesktopDevice desktop5 = new DesktopDevice(
                "Asus",               // Made by
                "ROG Strix G10",      // Model
                "AMD Ryzen 5",        // Integrated Chip
                "NVIDIA RTX 2060",    // GPU
                "Full Tower",         // Tower Size
                "1TB",                // Hard Drive Capacity
                "16GB"                // RAM Capacity
        );

        desktopsDeviceRepository.saveDevice(desktop1);
        desktopsDeviceRepository.saveDevice(desktop2);
        desktopsDeviceRepository.saveDevice(desktop3);
        desktopsDeviceRepository.saveDevice(desktop4);
        desktopsDeviceRepository.saveDevice(desktop5);

        LaptopDevice laptop1 = new LaptopDevice(
                "Apple",              // Made by
                "MacBook Pro",        // Model
                "Apple M1",           // Integrated Chip
                "16GB",               // RAM Capacity
                "13.3\"",             // Screen Size
                "512GB"               // Hard Drive Capacity
        );

        LaptopDevice laptop2 = new LaptopDevice(
                "Dell",               // Made by
                "XPS 13",             // Model
                "Intel Core i7",      // Integrated Chip
                "16GB",               // RAM Capacity
                "13.4\"",             // Screen Size
                "1TB"                 // Hard Drive Capacity
        );

        laptopsDeviceRepository.saveDevice(laptop1);
        laptopsDeviceRepository.saveDevice(laptop2);

        RegistryDeviceScreen screen = new RegistryDeviceScreen(desktopsDeviceRepository, laptopsDeviceRepository, tabletsDeviceRepository);
        screen.executeScreen();
    }
}