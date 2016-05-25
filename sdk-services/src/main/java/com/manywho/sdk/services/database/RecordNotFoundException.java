package com.manywho.sdk.services.database;

import javax.ws.rs.NotFoundException;

public class RecordNotFoundException extends NotFoundException {
    public RecordNotFoundException() {
        super("The requested record could not be found");
    }
}
