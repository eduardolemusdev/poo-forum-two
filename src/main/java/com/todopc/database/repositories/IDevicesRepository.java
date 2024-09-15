package com.todopc.database.repositories;

import com.todopc.database.models.Device;

public interface IDevicesRepository {
    Device saveDevice(Device device);
}
