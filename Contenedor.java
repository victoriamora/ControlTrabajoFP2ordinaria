package PaqC01;

public class Contenedor {
    private final int id;
    private int  prioridad;
    private float peso;
    private String pais, contenido, emisor, receptor;
    private boolean inspeccionado;

    //CONSTRUCTORES
    public Contenedor(int id){
        //if(id<0) id==-id;
        this.id=id;
        this.prioridad=3;         //SE PUEDE HACER ARRIBA TAMBIEN
    }

    public Contenedor(int id, float peso, int prioridad, String pais, String contenido, String emisor, String receptor){
        this(id);
        this.setPeso(peso);
        this.setPrioridad(prioridad);
        this.setPais(pais);
        this.setContenido(contenido);
        this.setEmisor(emisor);
        this.setReceptor(receptor);
    }

    //GETTERS Y SETTERS

    public int getID(){
        return this.id;
    }

    public float getPeso(){
        return this.peso;
    }

    public void setPeso(float peso){
        if(peso>0) this.peso=peso;
    }

    public int getPrioridad(){
        return this.prioridad;
    }

    public void setPrioridad(int prioridad){
        if(prioridad>1 && prioridad>3) this.prioridad=prioridad;
    }

    public String getPais(){
        return this.pais;
    }

    public void setPais(String pais){
        this.pais=pais;
    }

    public String getContenido(){
        return this.contenido;
    }

    public void setContenido(String contenido){
        this.contenido=contenido;
    }

    public String getEmisor(){
        return this.emisor;
    }

    public void setEmisor(String emisor){
        this.emisor=emisor;
    }

    public String getReceptor(){
        return this.receptor;
    }

    public void setReceptor(String receptor){
        this.receptor=receptor;
    }

    public boolean isInspeccionado(){
        return this.inspeccionado;
    }

    //TO STRING

    public String toString(){
        String s = new String();
        s+="ID:"+id+"\n";
        s+="Peso:"+peso+"\n";
        s+="Prioridad:"+prioridad+"\n";
        s+="Pais:"+pais+"\n";
        s+="Contenido:"+contenido+"\n";
        s+="Emisor:"+emisor+"\n";
        s+="Receptor:"+receptor+"\n";
        if(inspeccionado) s+="Inspeccionado\n";
        else s+="No Inspeccionado\n";
        return s;
    }
}


