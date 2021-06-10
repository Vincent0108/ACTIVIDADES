package actividad_3;

public class Ejercicio_8 {

    public static void main(String[] args) {
        ED_Cola c = new ED_Cola();

        for (int i = 0; i < 6; i++) {
            c.insertarDerecha(new ED_Elemento());
        }
        ED_Elemento frente = new ED_Elemento();
        ED_Elemento ultimo = new ED_Elemento();
        frente = c.getCola()[0];
        ultimo = c.getCola()[0];
        c.setCabeza(frente);
        c.setTope(ultimo);

        c.getCola()[0].setDato(null);
        c.getCola()[1].setDato('E');
        c.getCola()[2].setDato('D');
        c.getCola()[3].setDato('A');
        c.getCola()[4].setDato('B');
        c.getCola()[5].setDato(null);

        c.desencolar();
        c.elimarDerecha();
        c.imprimeCola();
    }

}
