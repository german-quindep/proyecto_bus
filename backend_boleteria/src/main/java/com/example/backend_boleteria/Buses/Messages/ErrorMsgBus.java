package com.example.backend_boleteria.Buses.Messages;

public enum ErrorMsgBus {
    csvAsiento {
        @Override
        public String toString() {
            return "La columna 'asientos' no cumple con los requisitos de longitud en la fila";
        }
    },
    csvMarca {
        @Override
        public String toString() {
            return "La columna 'marca' no cumple con los requisitos de longitud en la fila ";
        }
    },
}
