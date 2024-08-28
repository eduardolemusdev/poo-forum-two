package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

public interface MemoryStats {
    String getMemoryRam();
    void setMemoryRam(String memoryRam) throws EmptyValueException;
}
