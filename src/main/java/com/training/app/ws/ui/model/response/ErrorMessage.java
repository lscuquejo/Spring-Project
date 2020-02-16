package com.training.app.ws.ui.model.response;

import java.util.Date;

public class ErrorMessage {
    private Date timestamp;
    private String message;

    //no arguements constructor.
    public ErrorMessage() {}

    // with arg.
    public ErrorMessage(Date timestamp, String message)
    {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}