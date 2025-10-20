package com.kaiburr.taskmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a command contains malicious or unsafe code
 * Returns HTTP 400 Bad Request status code
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCommandException extends RuntimeException {
    
    public InvalidCommandException(String message) {
        super(message);
    }
    
    public InvalidCommandException(String command, String reason) {
        super(String.format("Invalid command '%s': %s", command, reason));
    }
}
