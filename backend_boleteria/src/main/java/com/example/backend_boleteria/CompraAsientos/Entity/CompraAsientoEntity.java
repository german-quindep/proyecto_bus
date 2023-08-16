package com.example.backend_boleteria.CompraAsientos.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import com.example.backend_boleteria.Horario.Entity.HorarioEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_compra_asientos")
@AllArgsConstructor
@NoArgsConstructor
public class CompraAsientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @NotNull(message = "No debe estar vacio")
    @Length(min = 5, max = 30, message = "Este campo debe tener una longitud de 5 a 30 palabras")
    @Pattern(regexp = "^[^<>/'\\\\*]+$", message = "Este campo no debe contener caracteres especiales")
    private String usuario;

    @NotNull(message = "No debe estar vacio")
    @Length(min = 1, max = 40, message = "Este campo debe tener una longitud de 5 a 30 palabras")
    @Pattern(regexp = "^[^<>/'\\\\*]+$", message = "Este campo no debe contener caracteres especiales")
    private String asiento_comprados;

    @ManyToOne
    @JoinColumn(name = "horario_id")
    @JsonBackReference
    private HorarioEntity horario;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
}
