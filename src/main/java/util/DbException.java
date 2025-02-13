/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


//exception personalizada
public class DbException extends RuntimeException {
    private static final long serialVersionUID = 1L; 
    
    public DbException(String msg){
        super(msg); 
    }
    
    
}
