package PaqC01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

    public class Puerto implements Serializable {
        private List<Hub> hubs;
        private Hub[] puerto;

        public Puerto() {
            this.puerto = new Hub[3];
            hubs = new ArrayList<>();
        }

        public Hub[] getPuerto() {
            return puerto;
        }

        public void setPuerto(Hub[] puerto) {
            this.puerto = puerto;
        }

        public boolean apilaContenedor(int hub_apilar, Contenedor c) {
            return puerto[hub_apilar].apilar(c);
        }

        public Contenedor desapilaContenedor(int hub_desapilar, int columna) {
            return puerto[hub_desapilar].desapilar(columna);
        }

        public Contenedor mostrarDatos(int hub_mostrar, int numIdentf) {
            return puerto[hub_mostrar].mostrar(numIdentf);
        }

        public String toStringHUB(int hub_mostrar) {
            return puerto[hub_mostrar].toString();
        }

        public int contenedoresPorPais(String pais) {
            int total = 0;

            for (int i = 0; i < puerto.length; i++) {
                total += puerto[i].contador(pais);
            }

            return total;
        }

        public int contarContenedoresChequeadosPorPrioridad(int prioridad) {
            int contador = 0;
            for (Hub hub : hubs) {
                contador += hub.contarContenedoresPorPrioridad(prioridad);
            }
            return contador;
        }
    }




