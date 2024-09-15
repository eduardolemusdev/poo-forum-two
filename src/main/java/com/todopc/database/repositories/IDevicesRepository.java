package com.todopc.database.repositories;

import com.todopc.database.models.Device;

public interface IDevicesRepository<T> {
    T saveDevice(T device);
}
