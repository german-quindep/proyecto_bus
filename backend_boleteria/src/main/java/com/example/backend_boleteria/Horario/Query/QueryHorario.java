package com.example.backend_boleteria.Horario.Query;

public enum QueryHorario {
    QueryHorario;
    public static final String GET_HORARIO_DATE="""
            SELECT h.id as id, 
            h.horario_llegada as horarioLlegada, 
            h.horario_salida as horarioSalida, bus.marca as marcaBus, 
            h.destino_llegada as destinoLlegada, 
            h.destino_salida as destinoSalida,
            bus.id as idBus
            FROM tbl_horario h 
            INNER JOIN tbl_bus as bus ON bus.id=h.bus_id 
            WHERE DATE(h.horario_llegada)= :#{#consult.fechaHoy}
            """;
    public static final String GET_HORARIO_ONE="""
            SELECT * FROM 
            tbl_horario WHERE id = :idHorario
            """;
}
