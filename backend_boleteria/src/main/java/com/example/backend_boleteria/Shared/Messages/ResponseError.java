package com.example.backend_boleteria.Shared.Messages;

public enum ResponseError {
    nullCampo {
        @Override
        public String toString() {
            return "Este campo no puede estar vacio";
        }
    },
    list {
        @Override
        public String toString() {
            return "Parece que fallo al enlistar el resultado, por favor consulte con el administrador";
        }
    },
    save {
        @Override
        public String toString() {
            return "El guardado a fallado";
        }
    },
    filtro {
        @Override
        public String toString() {
            return "El filtro a fallado, por favor consulte con el administrador";
        }
    },
    message {
        @Override
        public String toString() {
            return "Ocurrio un error";
        }
    }
}
