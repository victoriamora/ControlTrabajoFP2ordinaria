package PaqC01;
import java.util.ArrayList;
import java.util.List;


public class Hub {
    private List<Contenedor> contenedores;

    private Contenedor[][] matriz;

    public Hub(){
        this.matriz = new Contenedor[10][12];
        contenedores = new ArrayList<>();


    }

    public Contenedor[][] getMatriz(){
        return matriz;
    }

    public void setMatriz(Contenedor[][] matriz){
        if(matriz!=null) this.matriz=matriz;
    }

    public int contarContenedoresPorPrioridad(int prioridad) {
        int contador = 0;
        for (Contenedor contenedor : contenedores) {
            if (contenedor.getPrioridad() == prioridad && contenedor.isInspeccionado()) {
                contador++;
            }
        }
        return contador;
    }

    public String toString(){
        String s = new String();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j]==null) s+="[NADA]";
                else s+="["+matriz[i][j].getID()+"]";
            }
            s+="\n";
        }
        return s;
    }

    public Contenedor desapilar(int columna){
        if(columna<0 || columna>=matriz[0].length) return null;
        for(int i=0 ; i<matriz.length; i++){
            if(matriz[i][columna]!=null){
                Contenedor aux=matriz[i][columna];
                matriz[i][columna]=null;
                return aux;
            }
        }
        return null;
    }

    public boolean apilar(Contenedor c) {
        if (c != null) {
            switch (c.getPrioridad()) {
                case 1:
                case 2:
                    int columna = c.getPrioridad() - 1;

                    for (int i = matriz.length - 1; i >= 0; i--) {
                        if (matriz[i][columna] == null) {
                            matriz[i][columna] = c;
                            return true;
                        }
                    }

                    break;
                case 3:
                    for (int j = 2; j < matriz[0].length; j++) {
                        for (int i = matriz.length - 1; i >= 0; i--) {
                            if (matriz[i][j] == null) {
                                matriz[i][j] = c;
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return false;
    }


    public Contenedor mostrar(int id){
        boolean esta = false;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null && matriz[i][j].getID() == id){
                    System.out.println(matriz[i][j]);
                    esta = true;
                }
            }
        }

        if (!esta){
            System.out.println("El contenedor no está en el hub");
        }
        return null;
    }

    public int contador(String pais){
        if (pais == null) return -1;

        int c = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null && pais.equals(matriz[i][j].getPais())){
                    c++;
                }
            }
        }

        return c;
    }
}


