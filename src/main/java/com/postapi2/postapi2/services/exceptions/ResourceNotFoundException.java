package com.postapi2.postapi2.services.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Can't find id: " + id);
    }
}
