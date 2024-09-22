package com.todopc.database.models;

import com.todopc.execeptions.EmptyValueException;

import java.util.List;

public interface ICheckEmptyPropertys {
    void checkEmptyPropertys() throws EmptyValueException;
}
