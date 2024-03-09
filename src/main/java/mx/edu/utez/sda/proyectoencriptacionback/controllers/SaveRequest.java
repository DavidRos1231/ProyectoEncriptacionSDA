package mx.edu.utez.sda.proyectoencriptacionback.controllers;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;
import mx.edu.utez.sda.proyectoencriptacionback.models.Pago;
import mx.edu.utez.sda.proyectoencriptacionback.utils.CryptoService;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.awt.image.CropImageFilter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SaveRequest {
    private String nombre;
    private String apellidos;
    private String pais;
    private String estado;
    private String cuidad;
    private String cp;
    private String colonia;
    private String calle;
    private String numero;
    private String telefono;
    private Tarjeta tarjeta;
    private CryptoService cryptoService= new CryptoService();

    public Pago ParseToPago() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Pago pago = new Pago();
        pago.setNombre(cryptoService.decrypt(this.nombre));
        pago.setApellidos(cryptoService.decrypt(this.apellidos));
        pago.setPais(cryptoService.decrypt(this.pais));
        pago.setEstado(cryptoService.decrypt(this.estado));
        pago.setCiudad(cryptoService.decrypt(this.cuidad));
        pago.setCp(cryptoService.decrypt(this.cp));
        pago.setColonia(cryptoService.decrypt(this.colonia));
        pago.setCalle(cryptoService.decrypt(this.calle));
        pago.setNumero(cryptoService.decrypt(this.numero));
        pago.setTelefono(cryptoService.decrypt(this.telefono));
        pago.setTarjeta(this.tarjeta.getNumero());
        pago.setUltimos4(cryptoService.decrypt(this.tarjeta.getUltimos4()));
        pago.setCaducidad(this.tarjeta.getCaducidad());
        pago.setCvv(this.tarjeta.getCvv());
        return pago;
    }

    public  SaveRequest(Pago pago) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        setNombre(cryptoService.encrypt(pago.getNombre()));
        setApellidos(cryptoService.encrypt(pago.getApellidos()));
        setPais(cryptoService.encrypt(pago.getPais()));
        setEstado(cryptoService.encrypt(pago.getEstado()));
        setCuidad(cryptoService.encrypt(pago.getCiudad()));
        setCp(cryptoService.encrypt(pago.getCp()));
        setColonia(cryptoService.encrypt(pago.getColonia()));
        setCalle(cryptoService.encrypt(pago.getCalle()));
        setNumero(cryptoService.encrypt(pago.getNumero()));
        setTelefono(cryptoService.encrypt(pago.getTelefono()));
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setNumero(pago.getTarjeta());
        tarjeta.setUltimos4(cryptoService.encrypt(pago.getUltimos4()));
        tarjeta.setCaducidad(pago.getCaducidad());
        tarjeta.setCvv(pago.getCvv());
        setTarjeta(tarjeta);
    }
}
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
class Tarjeta {
    private String numero;
    private String ultimos4;
    private String cvv;
    private String caducidad;
    private String propietario;

    // Constructor, getters y setters
}