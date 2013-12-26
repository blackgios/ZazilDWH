/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zazil.dwh.app.util;

/**
 *
 * @author Hector Rodriguez
 */
public class BussinesException extends Exception{
    /**
     * 
     * @param message 
     */
    public BussinesException(String message) {
        super(message);
    }
    
    /**
     * 
     * @param message
     * @param cause 
     */
    public BussinesException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
