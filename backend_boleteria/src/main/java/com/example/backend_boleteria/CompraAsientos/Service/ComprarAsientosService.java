package com.example.backend_boleteria.CompraAsientos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backend_boleteria.CompraAsientos.DTO.in.ConsultAsiento;
import com.example.backend_boleteria.CompraAsientos.DTO.out.VerifyAsientos;
import com.example.backend_boleteria.CompraAsientos.Entity.CompraAsientoEntity;
import com.example.backend_boleteria.CompraAsientos.Helpers.AsientosList;
import com.example.backend_boleteria.CompraAsientos.Repository.ComprarAsientosRepository;
import com.example.backend_boleteria.Horario.Entity.HorarioEntity;
import com.example.backend_boleteria.Horario.Service.HorarioService;
import com.example.backend_boleteria.Shared.Messages.ResponseError;
import com.example.backend_boleteria.Shared.Response.Response;

@Service
public class ComprarAsientosService {

    @Autowired
    private ComprarAsientosRepository comprarRepository;
    @Autowired
    private HorarioService horarioService;

    public ResponseEntity<?> createdBus(CompraAsientoEntity compraAsientoEntity) {
        Response<CompraAsientoEntity, String> respo = new Response<>();
        CompraAsientoEntity result = comprarRepository.save(compraAsientoEntity);
        if (result != null)
            respo.ResponseSuccess("Se registro la compra", 200, result);
        else
            respo.ResponseError(ResponseError.message.toString(), 404, ResponseError.save.toString());
        return ResponseEntity.status(respo.getStatus()).body(respo);
    }

    public ResponseEntity<?> getListAsiento(ConsultAsiento asiento) {
        Response<VerifyAsientos, String> respo = new Response<>();
        List<CompraAsientoEntity> result = comprarRepository.getAllAsientosDisponible(asiento);
        if (result == null) {
            respo.ResponseError(ResponseError.message.toString(), 404, ResponseError.filtro.toString());
            return ResponseEntity.status(respo.getStatus()).body(respo);
        }
        HorarioEntity horario = horarioService.getHorarioServiceOne(asiento.getHorario_id());
        var asientosOcupados = new AsientosList();
        List<Integer> list = asientosOcupados.getArrayAsiento(result);
        var verifyAsientos = new VerifyAsientos(list, horario.getBus().getAsientosTotal());
        respo.ResponseSuccess("Se registro la compra", 200, verifyAsientos);
        return ResponseEntity.status(respo.getStatus()).body(respo);

    }
}
