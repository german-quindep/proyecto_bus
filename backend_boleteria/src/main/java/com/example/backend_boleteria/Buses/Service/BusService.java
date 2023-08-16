package com.example.backend_boleteria.Buses.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend_boleteria.Buses.DTO.out.BusList;
import com.example.backend_boleteria.Buses.Entity.BusEntity;
import com.example.backend_boleteria.Buses.Helpers.CsvDataValidate;
import com.example.backend_boleteria.Buses.Helpers.GenerateListAsiento;
import com.example.backend_boleteria.Buses.Helpers.TransformResponse;
import com.example.backend_boleteria.Buses.Repository.BusRepository;
import com.example.backend_boleteria.Shared.Csv.SaveCsv;
import com.example.backend_boleteria.Shared.Messages.ResponseError;
import com.example.backend_boleteria.Shared.Response.Response;
import com.opencsv.CSVReader;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private TransformResponse transformResponse;
    @Autowired
    private SaveCsv csvComponent;
    @Autowired
    private CsvDataValidate csvValidate;

    public ResponseEntity<?> createdBus(BusEntity busEntity) {
        Response<BusEntity, String> respo = new Response<>();
        BusEntity result = busRepository.save(busEntity);
        if (result != null)
            respo.ResponseSuccess("Se creo con exito el bus", 200, result);
        else
            respo.ResponseError(ResponseError.message.toString(), 404, ResponseError.save.toString());
        return ResponseEntity.status(respo.getStatus()).body(respo);
    }

    public ResponseEntity<?> getBuses() {
        Response<List<BusList>, String> respo = new Response<>();
        List<BusEntity> listBus = busRepository.findAll();
        List<BusList> listBusTransform = transformResponse.getDataAllBus(listBus);
        if (listBus.isEmpty())
            respo.ResponseError(ResponseError.message.toString(), 404, ResponseError.list.toString());
        else
            respo.ResponseSuccess("Se enlista con exito", 200, listBusTransform);
        return ResponseEntity.status(respo.getStatus()).body(respo);

    }

    public ResponseEntity<?> editBuses(BusEntity busEntity) {
        Response<BusEntity, String> respo = new Response<>();
        BusEntity result = busRepository.save(busEntity);
        if (result != null)
            respo.ResponseSuccess("Se actulizo con exito el bus", 200, result);
        else
            respo.ResponseError(ResponseError.message.toString(), 404, ResponseError.save.toString());
        return ResponseEntity.status(respo.getStatus()).body(respo);
    }

    public ResponseEntity<?> deleteBus(String id) {
        Response<String, String> respo = new Response<>();
        busRepository.deleteByIdBus(id);
        respo.ResponseSuccess("Se elimino con exito", 200, "");
        return ResponseEntity.status(respo.getStatus()).body(respo);
    }

    public ResponseEntity<?> csvDataAll(MultipartFile file) throws Exception {
        Response<String, String> respo = new Response<>();
        if (!csvComponent.copyCsv(file)) {
            respo.ResponseError(csvComponent.message, 400, csvComponent.message);
            return ResponseEntity.status(respo.getStatus()).body(respo);
        }
        if (!csvComponent.validateExist()) {
            respo.ResponseError(csvComponent.message, 400, csvComponent.message);
            return ResponseEntity.status(respo.getStatus()).body(respo);
        }
        CSVReader reader = csvComponent.readCsv();
        List<String> errorCsv = csvValidate.errorsCsv(reader);
        if (!errorCsv.isEmpty()) {
            Response<String, List<String>> respo2 = new Response<>();
            respo2.ResponseError("Parece que tienes algunos errores en el archivo csv", 400, errorCsv);
            return ResponseEntity.status(respo2.getStatus()).body(respo2);
        }
        reader = csvComponent.readCsv();
        String[] fila;
        while ((fila = reader.readNext()) != null) {
            var busEntity = new BusEntity();
            var generateList = new GenerateListAsiento();
            var asientos = Integer.parseInt(fila[1]);
            busEntity.setMarca(fila[0]);
            busEntity.setAsientos(asientos);
            busEntity.setAsientosTotal(generateList.generateList(asientos));
            busRepository.save(busEntity);
        }
        reader.close();
        respo.ResponseSuccess("Se guardo con exito en la base", 200, "Exito");
        return ResponseEntity.status(respo.getStatus()).body(respo);

    }
}
