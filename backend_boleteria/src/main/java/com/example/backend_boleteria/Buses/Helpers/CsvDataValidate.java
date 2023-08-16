package com.example.backend_boleteria.Buses.Helpers;

import org.springframework.stereotype.Component;

import com.example.backend_boleteria.Buses.Messages.ErrorMsgBus;
import com.opencsv.CSVReader;
import java.util.List;
import java.util.ArrayList;

@Component
public class CsvDataValidate {

    public List<String> errorsCsv(CSVReader reader) throws Exception {
        List<String> listError = new ArrayList<>();
        String fila[];
        int numeroFila = 1;

        while ((fila = reader.readNext()) != null) {
            String valor = fila[0];
            String valorColumna = fila[1];

            if (!(valor.matches("^[a-zA-Z ]{5,30}$")))
                listError.add(ErrorMsgBus.csvMarca.toString() + numeroFila);
            if (!(valorColumna.matches("^(?:3[0-9]|[1-2][0-9]|40)$")))
                listError
                        .add(ErrorMsgBus.csvAsiento.toString() + numeroFila);

            numeroFila++;
        }
        reader.close();
        return listError;
    }
}
