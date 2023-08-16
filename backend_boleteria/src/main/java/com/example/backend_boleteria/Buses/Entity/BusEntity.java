package com.example.backend_boleteria.Buses.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import com.example.backend_boleteria.Horario.Entity.HorarioEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_bus")
public class BusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @NotNull(message = "Este campo está vacio")
    @Length(min = 5, max = 30, message = "Este campo debe tener una longitud de 5 a 30 palabras")
    @Pattern(regexp = "^[^<>/'\\\\*]+$",message = "Este campo no debe contener caracteres especiales")
    private String marca;

    @NotNull(message = "Este campo está vacio")
    @Min(value = 10, message = "Este campo debe tener un minimo de 10 asientos")
    @Max(value = 40, message = "Este campo debe tener un máximo de 40 asientos")
    private Integer asientos;

    @NotNull(message = "Este campo está vacio")
    private List<Integer> asientosTotal;
    
    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<HorarioEntity> horarios;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
}
