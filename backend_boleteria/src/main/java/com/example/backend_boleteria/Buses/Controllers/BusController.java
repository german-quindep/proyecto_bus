package com.example.backend_boleteria.Buses.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend_boleteria.Buses.Entity.BusEntity;
import com.example.backend_boleteria.Buses.Service.BusService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("${api.index}${api.bus.index}")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping("${api.bus.create}")
    public ResponseEntity<?> createdBus(@RequestBody @Valid BusEntity busEntity) {
        return busService.createdBus(busEntity);
    }

    @GetMapping("${api.bus.getall}")
    public ResponseEntity<?> getBuses() {
        return busService.getBuses();
    }

    @PutMapping("${api.bus.edit}")
    public ResponseEntity<?> editBuses(@RequestBody @Valid BusEntity busEntity) {
        return busService.editBuses(busEntity);
    }

    @DeleteMapping("${api.bus.delete}")
    public ResponseEntity<?> deleteBus(@PathVariable("id") String id) {
        return busService.deleteBus(id);
    }

    @PostMapping("${api.bus.csvData}")
    public ResponseEntity<?> csvDataAll(@RequestBody @Valid MultipartFile file) throws Exception {
        return busService.csvDataAll(file);
    }
}
