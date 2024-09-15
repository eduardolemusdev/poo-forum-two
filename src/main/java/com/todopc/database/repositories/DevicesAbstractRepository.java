package com.todopc.database.repositories;

import com.todopc.database.models.Device;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DevicesAbstractRepository<T extends Device> implements IDevicesRepository<T> {
    private List<T> devicesInMemoryDatabase = new ArrayList<>();

    @Override
    public T saveDevice(T device) {
        this.devicesInMemoryDatabase.add(device);
        return device;
    }

    @Override
    public List<T> getDevices() {
        return this.devicesInMemoryDatabase;
    }
}
