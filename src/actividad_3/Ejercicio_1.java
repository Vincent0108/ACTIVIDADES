package actividad_3;

import java.util.Scanner;
import javax.swing.JOptionPane;

//Nombre de la clase
public class Ejercicio_1 {

//Método Main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Variabeles
        ED_Lista listaPrimera = new ED_Lista();
        
        //Ciclos para validación de JOptionPane
        boolean primerCicloVali = true, segundoCicloVali = true;
        String posicion, datoUsar = "";
        int lugar_pos = 0;

        //Ciclo do-while para reiniciar el programa cuando se necesite
        do {
            //Guardar dato que se almacena
            System.out.println("DIGITE EL VALOR DEL DATO "
                    + "QUE SE ALMACENARA");
            datoUsar = in.next();

            //Si el dato no es nulo procedemos a almacenarlo
            if (datoUsar != null) {
                //Ciclo do-While

                //Inicio de la operación se piden datos.
                do {
                    System.out.println("DIGITE EL NODO DONDE SE UBICARA EL DATO");
                    posicion = in.next();

                    //try catch para validar dentro las opciones
                    try {
                        lugar_pos = Integer.valueOf(posicion);

                        //Validación de números negativos
                        if (lugar_pos >= 0) {
                            segundoCicloVali = false;
                        } else {
                            System.out.println("SOLO PUEDE INGRESAR VALORES "
                                    + "POSITIVOS");
                            
                            segundoCicloVali = true;
                        }
                    } catch (NumberFormatException error) {
                        if (posicion == null) {
                            System.exit(0);
                        } else {
                            segundoCicloVali = true;
                        }
                    }
                } while (segundoCicloVali);
            } else {
                //Cierre del programa
                System.exit(0);
            }

            //Instancia para amacenar nuevo elemento
            ED_Elemento nodo = new ED_Elemento();
            nodo.setDato(datoUsar);
            
            //Insertamos a la lista
            listaPrimera.insertar(lugar_pos, nodo);

            JOptionPane.showMessageDialog(null, listaPrimera.imprimir(),"VENTANA", JOptionPane.INFORMATION_MESSAGE);

            //Validación para la seguir la aplicación
            int op = JOptionPane.showConfirmDialog(null, "INDIQUE SI QUIERE AGREGAR OTRO NODO");
            if (op == 0) {
                primerCicloVali = true;
            } else {
                primerCicloVali = false;
            }
        } while (primerCicloVali);

    }

}
