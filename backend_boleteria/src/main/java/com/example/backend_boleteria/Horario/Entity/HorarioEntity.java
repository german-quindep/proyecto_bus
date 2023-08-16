package com.example.backend_boleteria.Horario.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.example.backend_boleteria.Buses.Entity.BusEntity;
import com.example.backend_boleteria.CompraAsientos.Entity.CompraAsientoEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "tbl_horario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HorarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @NotNull(message = "Este campo no debe estar vacio")
    private LocalDateTime horario_salida;

    @NotNull(message = "Este campo no debe estar vacio")
    private LocalDateTime horario_llegada;

    @NotNull(message = "Este campo no debe estar vacio")
    @Length(min = 5, max = 30, message = "Este campo debe tener un minimo de 5 y un máximo de 30 caracteres")
    @Pattern(regexp = "^[^<>/'\\\\*]+$", message = "Este campo no debe contener caracteres especiales")
    private String destino_salida;

    @NotNull(message = "Este campo no debe estar vacio")
    @Length(min = 5, max = 30, message = "Este campo debe tener un minimo de 5 y un máximo de 30 caracteres")
    @Pattern(regexp = "^[^<>/'\\\\*]+$", message = "Este campo no debe contener caracteres especiales")
    private String destino_llegada;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    @JsonBackReference
    private BusEntity bus;

    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL)
    private List<CompraAsientoEntity> comprasAsientos;
}
