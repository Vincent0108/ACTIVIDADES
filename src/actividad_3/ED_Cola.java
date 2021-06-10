
package actividad_3;


public class ED_Cola {
    private ED_Elemento [] cola;
    private ED_Elemento cabeza; 
    private ED_Elemento tope;
    
    public ED_Cola(){
        cola = new ED_Elemento[1];
        cabeza = cola[0];
        tope = cola[0];
    }

    public ED_Elemento[] getCola() {
        return cola;
    }

    public void setCola(ED_Elemento[] cola) {
        this.cola = cola;
    }

    public ED_Elemento getCabeza() {
        return cabeza;
    }

    public void setCabeza(ED_Elemento cabeza) {
        this.cabeza = cabeza;
    }

    public ED_Elemento getTope() {
        return tope;
    }

    public void setTope(ED_Elemento tope) {
        this.tope = tope;
    }

    public void encolar(ED_Elemento nodo){
        ED_Elemento [] colaCopia = new ED_Elemento[cola.length+1];
        
        for (int i = 0; i < cola.length; i++) {
            colaCopia[i] = cola[i];
        }
        
        if(cola[0] != null){
            colaCopia[colaCopia.length-1] = nodo;
            cola = colaCopia;
            tope = cola[cola.length-1];
            cola[cola.length-1].setPrevio(cola[cola.length-2]);
            cola[cola.length-1].setPosterior(null);
        }else{
            cola[0] = nodo;
            cabeza = cola[0];
            tope = cola[0];
        }
    }
    
    public void desencolar(){
        ED_Elemento [] colaCopia = new ED_Elemento[cola.length-1];
        
        if(cola[0] != null){
            for (int i = 0; i < colaCopia.length; i++) {
                colaCopia[i] = cola[i+1];
            }
            cola = colaCopia;
        }
    }
    
    public void eliminaRepetidos(){
        ED_Elemento [] colaCopia = new ED_Elemento[cola.length];
        
        for (int i = 0; i < colaCopia.length; i++) {
            colaCopia[i] = cola[i];
        }
        
        for (int i = 0; i < cola.length; i++) {
            int contador = 0;
            for (int j = 0; j < colaCopia.length; j++) {
                if(cola[i].getDato().equals(colaCopia[j].getDato())){
                    contador++;
                    if(contador > 1){
                        colaCopia[j].setDato("vacio");
                    }
                }
            }
        }
        
        int nuevaDimension = 0;
        for (int i = 0; i < colaCopia.length; i++) {
            if(colaCopia[i].getDato() != "vacio"){
                nuevaDimension++;
            }
        }
        
        cola = new ED_Elemento[nuevaDimension];
        
        for (int i = 0, j = 0; i < cola.length; i++) {
            if(colaCopia[i].getDato() != "vacio"){
                cola[j] = colaCopia[i];
                j++;
            }
        }
    }
    
    public void insertarDerecha(ED_Elemento nodo){        
        ED_Elemento [] colaCopia = new ED_Elemento[cola.length+1];
        
        for (int i = 0; i < cola.length; i++) {
            colaCopia[i] = cola[i];
        }
        
        if(cola[0] != null){
            colaCopia[colaCopia.length-1] = nodo;
            cola = colaCopia;
            tope = cola[cola.length-1];
            cola[cola.length-1].setPrevio(cola[cola.length-2]);
            cola[cola.length-1].setPosterior(null);
        }else{
            cola[0] = nodo;
        }
    }
    
    public void elimarDerecha(){
        ED_Elemento [] colaCopia = new ED_Elemento[cola.length-1];
        
        for (int i = 0; i < colaCopia.length; i++) {
            colaCopia[i] = cola[i];
        }
        
        if(cola[0] != null){
            cola = colaCopia;
        }
    }
    
    public String imprimeCola(){
        int i = 0;
        int nodoPos = 0, ultimaPos = cola.length-1;
        String resultado = "";
        System.out.println("\nCOLA");
        for (ED_Elemento nodo : cola) {
            if(nodoPos == ultimaPos){
                System.out.print("["+nodo.getDato()+"]");
                resultado += "["+nodo.getDato()+"]";
            }else{
                System.out.print("["+nodo.getDato()+"]-");
                resultado += "["+nodo.getDato()+"]-";
            }
            nodoPos++;
        }
        System.out.println("");
        return resultado;
    }
}
