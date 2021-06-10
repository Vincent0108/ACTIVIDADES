package actividad_3;

import javax.swing.JOptionPane;
//Nombre de la clase

public class Ejercicio_4 {

    //Método Main
    public static void main(String[] args) {
        //Atributos
        String datoValor = "";
        boolean ciclo = true, ciclo2 = true;
        //Instancia de la clase pila
        ED_pila pila = new ED_pila();
        //ciclo do-while 
        do {
            int op1
                    = JOptionPane.showOptionDialog(null, "QUE OPERACION DESEA REALIZAR?",
                            "PILA", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Meter en la Pila", "Sacar de la Pila"}, "Meter en la Pila");

            switch (op1) {
                case 0 -> {
                    do {
                        ED_Elemento nodo = new ED_Elemento();
                        datoValor = JOptionPane.showInputDialog(null, "Ingrese valor del "
                                + "nodo a insertar", "VALOR DEL NODO",
                                JOptionPane.INFORMATION_MESSAGE);
                        nodo.setDato(datoValor);
                        if (datoValor != null) {
                            pila.metePila(nodo);
                        } else {
                            System.exit(0);
                        }

                        JOptionPane.showMessageDialog(null, pila.imprimePila(), "PILA", JOptionPane.INFORMATION_MESSAGE);

                        int op2 = JOptionPane.showConfirmDialog(null, "Desea agregar otro nodo a la Pila?");
                        if (op2 == 0) {
                            ciclo = true;
                        } else {
                            ciclo = false;
                        }
                    } while (ciclo);
                }

                case 1 -> {
                    do {
                        if (pila.getPila().length > 0 && pila.getCabeza() != null) {
                            pila.sacaPila();

                            JOptionPane.showMessageDialog(null, pila.imprimePila(), "PILA", JOptionPane.INFORMATION_MESSAGE);

                            int op2 = JOptionPane.showConfirmDialog(null, "Desea sacar otro nodo de la Pila?");
                            if (op2 == 0) {
                                ciclo = true;
                            } else {
                                ciclo = false;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "LO SIENTO YA NO HAY MAS NODOS EN LA PILA", "ERROR", JOptionPane.ERROR_MESSAGE);
                            ciclo = false;
                            pila = new ED_pila();
                        }
                    } while (ciclo);
                }

                default ->
                    System.exit(0);
            }
        } while (ciclo2);
    }

}
