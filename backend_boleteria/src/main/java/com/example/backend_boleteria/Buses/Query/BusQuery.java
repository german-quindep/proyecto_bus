package com.example.backend_boleteria.Buses.Query;

public enum BusQuery {
    Query;

    public static final String DELETE_BUS = """
            DELETE FROM
            tbl_bus WHERE id = :id_bus
            """;
}
