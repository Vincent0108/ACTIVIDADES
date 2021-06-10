package actividad_3;

import java.util.Scanner;
import javax.swing.JOptionPane;
//Nombre de la clase

public class Ejercicio_31 {

    //Método Main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Atributos de tipo String
        String posicion = "", valor = "";

        int lugar_pos = 0;
        ED_Lista lista = new ED_Lista();
        boolean ciclo = true, ciclo2 = true;

        //Ciclo do-while para ingresar los valores de la lista circular
        do {
            System.out.println("DIGITE EL VALOR DEL DATO "
                    + "QUE SE ALMACENARA");
            valor = in.next();
             
            //Validación para los datos ingresados
            if (valor != null) {
                //Segundo ciclo do-while
                do {
                     System.out.println("DIGITE EL NODO DONDE SE UBICARA EL DATO");
                    posicion = in.next();
                    //Validación de la posición
                    //Try catch para el error de números positivos
                    try {
                        lugar_pos = Integer.valueOf(posicion);

                        //Validando si este no es positivo dar un error
                        if (lugar_pos >= 0) {
                            
                            ciclo2 = false;
                            
                        //Validación para solo números positivos
                        } else {
                            System.out.println("SOLO PUEDE INGRESAR VALORES "
                                    + "POSITIVOS");
                            ciclo2 = true;
                        }
                    } catch (NumberFormatException error) {
                        
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
            lista.insertarListaCircular(lugar_pos, nodo);

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
