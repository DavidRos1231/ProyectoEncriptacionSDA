package mx.edu.utez.sda.proyectoencriptacionback.services;

import mx.edu.utez.sda.proyectoencriptacionback.models.Pago;
import mx.edu.utez.sda.proyectoencriptacionback.models.PagoRepository;
import mx.edu.utez.sda.proyectoencriptacionback.utils.CustomReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public CustomReponse<List<Pago>> getAll() {
        return new CustomReponse<>(pagoRepository.findAll(), false, 200, "Ok");
    }
}
