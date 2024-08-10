package org.example.app.helper;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
     public ResourceNotFoundException() {
        super("Resource not found");
     }
}
