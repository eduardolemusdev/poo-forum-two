package com.todopc.database.repositories;

import com.todopc.database.models.Device;

import java.util.ArrayList;
import java.util.List;

public class DevicesRepository implements IDevicesRepository {
    private final List<Device> devices = new ArrayList<>();


    @Override
    public Device saveDevice(Device device) {
        this.devices.add(device);
        return device;
    }
}
