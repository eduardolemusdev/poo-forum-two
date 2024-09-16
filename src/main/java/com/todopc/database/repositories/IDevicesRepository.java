package com.todopc.database.repositories;

import com.todopc.database.models.LaptopDevice;

import java.util.List;

public interface IDevicesRepository<T> {
    T saveDevice(T device);
    List<T> getDevices();

    LaptopDevice[] getAllDevices();
}
