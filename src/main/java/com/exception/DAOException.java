package com.exception;

public class DAOException extends Exception {
    
    public DAOException(){
        super();
    }

    public DAOException(String mesagge){
        super(mesagge);
    }

    public DAOException(Throwable cause){
        super(cause);
    }

    public DAOException(String message, Throwable couse) {
        super(message, couse);
    }
    
}
