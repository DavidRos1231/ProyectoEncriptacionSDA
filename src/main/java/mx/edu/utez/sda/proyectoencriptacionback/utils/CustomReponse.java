package mx.edu.utez.sda.proyectoencriptacionback.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomReponse <T>{
    private T data;
    private boolean error;
    private int codigo;
    private String mensaje;
}
