package com.example.backend_boleteria.CompraAsientos.Query;

public enum QueryCompraAsiento {
    QueryData;
     public static final String GET_ASIENTOS_DISPONIBLE="""
            SELECT *
            FROM tbl_compra_asientos 
            WHERE horario_id= :#{#consult.horario_id}
            """;
}
