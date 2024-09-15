package com.todopc.screens.services;

import com.todopc.database.models.Device;
import com.todopc.database.repositories.IDevicesRepository;

import java.util.ArrayList;
import java.util.List;

public class DevicesAbstractRepository<T extends Device> implements IDevicesRepository<T> {
    private List<T> devicesInMemoryDatabase = new ArrayList<>();

    @Override
    public T saveDevice(T device) {
        this.devicesInMemoryDatabase.add(device);
        return device;
    }
}
