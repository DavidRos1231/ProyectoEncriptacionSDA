package mx.edu.utez.sda.proyectoencriptacionback.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pago")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 30)
    private String nombre;

    @Column(name = "apellidos", length = 50)
    private String apellidos;

    @Column(name = "pais", length = 50)
    private String pais;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "ciudad", length = 50)
    private String ciudad;

    @Column(name = "cp", length = 5)
    private String cp;

    @Column(name = "colonia", length = 60)
    private String colonia;

    @Column(name = "calle", length = 60)
    private String calle;

    @Column(name = "numero", length = 10)
    private String numero;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "tarjeta",columnDefinition = "TEXT")
    private String tarjeta;

    @Column(name = "ultimos4", length = 4)
    private String ultimos4;

    @Column(name = "caducidad",columnDefinition = "TEXT")
    private String caducidad;

    @Column(name = "cvv",columnDefinition = "TEXT")
    private String cvv;

    @Column(name = "propietario",length = 80)
    private String propietario;

}
