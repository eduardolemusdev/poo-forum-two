package com.todopc.database.models;

public class DeviceSaveResponse {
    private String message;
    private DeviceSaveResponseStatus status;

    public DeviceSaveResponse(String message, DeviceSaveResponseStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public DeviceSaveResponseStatus getStatus() {
        return status;
    }
}
