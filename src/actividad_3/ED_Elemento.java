/*
CLASE DISEÑADA PARA TODOS LOS EJERCICIOS DE LA ACTIVIDAD DE APRENDIZAJE UNIDAD 3
ESTRUCTURA DE DATOS
 */
package actividad_3;

public class ED_Elemento {
    private Object previo;
    private Object posterior;
    private Object dato;

    public Object getPrevio() {
        return previo;
    }

    public void setPrevio(Object previo) {
        this.previo = previo;
    }

    public Object getPosterior() {
        return posterior;
    }

    public void setPosterior(Object posterior) {
        this.posterior = posterior;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }
}
