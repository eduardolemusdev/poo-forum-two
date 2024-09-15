package com.todopc.database.repositories;

import java.util.List;

public interface IDevicesRepository<T> {
    T saveDevice(T device);
    List<T> getDevices();
}
