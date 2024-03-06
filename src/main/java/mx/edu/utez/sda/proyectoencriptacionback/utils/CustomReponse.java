package mx.edu.utez.sda.proyectoencriptacionback.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomReponse <T>{
    private T data;
    private boolean error;
    private int codigo;
    private String mensaje;
}
