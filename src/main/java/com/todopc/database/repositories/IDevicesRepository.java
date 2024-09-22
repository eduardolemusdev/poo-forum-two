package com.todopc.database.repositories;

import com.todopc.database.models.Device;

import java.util.List;

public interface IDevicesRepository<T extends Device> {
    T saveDevice(T device);
    List<T> getDevices();
}
