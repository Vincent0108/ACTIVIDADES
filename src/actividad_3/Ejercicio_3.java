package actividad_3;

import javax.swing.JOptionPane;
//Nombre de la clase

public class Ejercicio_3 {

    //Método Main
    public static void main(String[] args) {
        //Atributos de tipo String
        String posicion = "", valor = "";

        int pos = 0;
        ED_Lista lista = new ED_Lista();
        boolean ciclo = true, ciclo2 = true;

        //Ciclo do-while para ingresar los valores de la lista circular
        do {
            
             valor = JOptionPane.showInputDialog(null, "Ingrese valor del "
                    + "nodo a insertar", "VALOR DEL NODO"
                    , JOptionPane.INFORMATION_MESSAGE);
            //Validación para los datos ingresados
            if (valor != null) {
                //Segundo ciclo do-while
                do {
                    posicion = JOptionPane.showInputDialog(null, "INGRESE DONDE ESTE SE GUARDARA", "POSICION LISTA CIRCULAR", JOptionPane.INFORMATION_MESSAGE);
                    //Validación de la posición
                    //Try catch para el error de números positivos
                    try {
                        pos = Integer.valueOf(posicion);

                        //Validando si este no es positivo dar un error
                        if (pos >= 0) {
                            
                            ciclo2 = false;
                            
                        //Validación para solo números positivos
                        } else {
                            JOptionPane.showMessageDialog(null, "SOLO PUEDEN AGREGARCE VALORES "
                                    + "POSITIVOS", "VENTANA", JOptionPane.ERROR_MESSAGE);
                            ciclo2 = true;
                        }
                    } catch (NumberFormatException err) {
                        
                        //Validaciones del programa para fallos de posición
                        if (posicion == null) {
                            System.exit(0);
                        } else {
                            ciclo2 = true;
                        }
                    }
                } while (ciclo2);
            } else {
                System.exit(0);
            }

            //Instanciamos elemento
            ED_Elemento nodo = new ED_Elemento();
            //Se le asigna el valor al nodo
            nodo.setDato(valor);
            //Aplicamos el método para la lista circular basado en los datos obtenidos
            lista.insertarListaCircular(pos, nodo);

            JOptionPane.showMessageDialog(null, lista.imprimir(), "DATOS", JOptionPane.INFORMATION_MESSAGE);

            int op = JOptionPane.showConfirmDialog(null, "¿QUIERE AGREGAR OTRO NODO?");
            //Validaciónes para el ciclo y que este continue almacenando
            if (op == 0) {
                ciclo = true;
            } else {
                ciclo = false;
            }
        } while (ciclo);
    }

}
