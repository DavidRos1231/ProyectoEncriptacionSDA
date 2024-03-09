package mx.edu.utez.sda.proyectoencriptacionback.services;

import mx.edu.utez.sda.proyectoencriptacionback.controllers.SaveRequest;
import mx.edu.utez.sda.proyectoencriptacionback.models.Pago;
import mx.edu.utez.sda.proyectoencriptacionback.models.PagoRepository;
import mx.edu.utez.sda.proyectoencriptacionback.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PagoService {
    @Autowired
    PagoRepository pagoRepository;

    @Transactional(rollbackFor = {Exception.class})
    public CustomReponse<Pago> save(Pago pago) {
        return new CustomReponse<>(pagoRepository.save(pago), false, 200, "Pago registrado correctamente");
    }

    @Transactional(rollbackFor = {Exception.class})
    public CustomReponse<List<SaveRequest>> getAll() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        List<Pago> pagos = pagoRepository.findAll();
        List<SaveRequest> saveRequests = new ArrayList<>();
        for (Pago pago:pagos) {
            saveRequests.add(new SaveRequest(pago));
        }
        return new CustomReponse<>(saveRequests, false, 200, "Ok");
    }
    @Transactional(rollbackFor = {Exception.class})
    public CustomReponse<Pago> update(long id, Pago pago) {
        Optional<Pago> pagoOptional = pagoRepository.findById(id);
        if(pagoOptional.isPresent()){
            pago.setId(id);
        }else {
            return new CustomReponse<>(null, true, 400, "No se encontro el pago");
        }

        return new CustomReponse<>(pagoRepository.save(pago), false, 200, "Ok");
    }
    @Transactional(rollbackFor = {Exception.class})
    public CustomReponse<Pago> delete(long id) {
        Optional<Pago> pagoOptional = pagoRepository.findById(id);
        if(pagoOptional.isPresent()){
            pagoRepository.deleteById(id);
        }else {
            return new CustomReponse<>(null, true, 400, "No se encontro el pago");
        }
        return new CustomReponse<>(null, false, 200, "Pago eliminado correctamente");
    }
}
