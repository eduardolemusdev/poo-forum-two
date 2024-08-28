package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

public interface HardDriveStats {
    String getHardDriveCapacity();
    void setHardDriveCapacity(String hardDriveCapacity) throws EmptyValueException;
}
