package com.example.backend_boleteria.Shared.Csv;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class SaveCsv {
    public Path pathArchivo;
    public String nameArchivo;
    public File fileArchive;
    public String message;
    private static final String UPLOAD_DIR = "csv";
    private static final String CSV_EXTENSION = ".csv";

    public boolean copyCsv(MultipartFile file) throws Exception {
        this.nameArchivo = file.getOriginalFilename();
        if (this.validateCsv()) {
            this.message = "Este archivo csv no es valido, porfavor suba uno con extension .csv";
            return false;
        }
        try {
            this.pathArchivo = Paths.get(UPLOAD_DIR + "/" + this.nameArchivo);
            Files.copy(file.getInputStream(), this.pathArchivo, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            this.message = "Ocurrio un error al cargar el archivo, por favor intentelo mas tarde";
            return false;
        }

    }

    public CSVReader readCsv() throws Exception {
        Path rutaArchivo = Paths.get(UPLOAD_DIR + "/" + this.nameArchivo);
        CSVReader reader = new CSVReaderBuilder(new FileReader(rutaArchivo.toFile())).withSkipLines(1).build();
        return reader;
    }

    public boolean validateCsv() {
        return !this.nameArchivo.toLowerCase().endsWith(CSV_EXTENSION);
    }

    public boolean validateExist() {
        this.fileArchive = new File(UPLOAD_DIR, this.nameArchivo);
        if (!this.fileArchive.exists()) {
            this.message = "Es posible que el archivo no se guardo correctamente en el servidor";
            return false;
        } else {
            return true;
        }
    }
}
