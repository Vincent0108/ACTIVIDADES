
package actividad_3;

import actividad_3.ED_Elemento;

public class ED_pila {
    private ED_Elemento [] pila;
    private ED_Elemento cabeza; 
    private ED_Elemento tope;
    
    public ED_pila(){
        pila = new ED_Elemento[1];
        cabeza = pila[0];
        tope = pila[0];
    }

    public ED_Elemento[] getPila() {
        return pila;
    }

    public void setPila(ED_Elemento[] pila) {
        this.pila = pila;
    }

    public ED_Elemento getCabeza() {
        return cabeza;
    }

    public void setCabeza(ED_Elemento cabeza) {
        this.cabeza = cabeza;
    }

    public ED_Elemento getCola() {
        return tope;
    }

    public void setCola(ED_Elemento cola) {
        this.tope = cola;
    }
    
    public void metePila(ED_Elemento nodo){
        ED_Elemento [] pilaCopia = new ED_Elemento[pila.length+1];
        
        for (int i = 0; i < pila.length; i++) {
            pilaCopia[i] = pila[i];
        }
        
        if(pila[0] != null){
            pilaCopia[pilaCopia.length-1] = nodo;
            pila = pilaCopia;
            tope = pila[pila.length-1];
            pila[pila.length-1].setPrevio(pila[pila.length-2]);
            pila[pila.length-1].setPosterior(null);
        }else{
            pila[0] = nodo;
            cabeza = pila[0];
            tope = pila[0];
        }
    }
    
    public void sacaPila(){
        ED_Elemento [] listaCopia = new ED_Elemento[pila.length-1];
        
        for (int i = 0; i < listaCopia.length; i++) {
            listaCopia[i] = pila[i];
        }
        
        if(pila[0] != null){
            pila = listaCopia;
        }
    }
    
    public void eliminaRepetidos(){
        ED_Elemento [] pilaCopia = new ED_Elemento[pila.length];
        
        for (int i = 0; i < pilaCopia.length; i++) {
            pilaCopia[i] = pila[i];
        }
        
        for (int i = 0; i < pila.length; i++) {
            int contador = 0;
            for (int j = 0; j < pilaCopia.length; j++) {
                if(pila[i].getDato().equals(pilaCopia[j].getDato())){
                    contador++;
                    if(contador > 1){
                        pilaCopia[j].setDato("vacio");
                    }
                }
            }
        }
        
        int nuevaDimension = 0;
        for (int i = 0; i < pilaCopia.length; i++) {
            if(pilaCopia[i].getDato() != "vacio"){
                nuevaDimension++;
            }
        }
        
        pila = new ED_Elemento[nuevaDimension];
        
        for (int i = 0, j = 0; i < pila.length; i++) {
            if(pilaCopia[i].getDato() != "vacio"){
                pila[j] = pilaCopia[i];
                j++;
            }
        }
    }
    
    public String imprimePila(){
        int i = 0;
        int nodoPos = 0, ultimaPos = pila.length-1;
        String resultado = "";
        System.out.println("\nPILA");
        for (ED_Elemento nodo : pila) {
            if(nodoPos == ultimaPos){
                System.out.print("["+nodo.getDato()+"]");
                resultado += "["+nodo.getDato()+"]";
            }else{
                System.out.print("["+nodo.getDato()+"]-");
                resultado += "["+nodo.getDato()+"]-";
            }
            nodoPos++;
        }
        return resultado;
    }
}
