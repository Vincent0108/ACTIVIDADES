package actividad_3;

import java.util.Scanner;
import javax.swing.JOptionPane;
//Nombre de la clase

public class Ejercicio_41 {

    //Método Main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Atributos
        String datoValor = "";
        boolean ciclo = true, ciclo2 = true;
        //Instancia de la clase pila
        ED_pila pila = new ED_pila();
        //ciclo do-while 
        do {

            //Asignación de valores
            int opcionUser = 0;

            //Try-catch para datos númericos solamente
            try {
                //Inicio de operaciones
                System.out.println("¿Que tipo de operación desea hacer con la pila?");
                System.out.println("AGREGAR = 0 ");
                System.out.println("ELIMINAR = 1");
                 opcionUser = in.nextInt();
                
                if(opcionUser!=1&&opcionUser!=0){
                
                    System.out.println("LA OPCIÓN DEBE SER [1] O [0]");
                
                }
                             
               

            } catch (Exception erro) {

                System.out.println("LA OPCIÓN DEBE SER UN NÚMERO");
                System.out.println("SE CERRARA EL PROGRAMA");
                System.exit(0);
            }

            //Sentencia de validación de opciones
            switch (opcionUser) {
                //Primer caso
                case 0: {
                    do {
                        //Instancia de nodo
                        ED_Elemento nodo = new ED_Elemento();
                        System.out.println("¿QUE DATO QUIERE AGREGAR A LA PILA?");
                        datoValor = in.next();

                        nodo.setDato(datoValor);
                       
                            //Uso del método meter pila para almacenar
                            pila.metePila(nodo);
                        
                        //Impresión de la pila en JOption
                        JOptionPane.showMessageDialog(null, pila.imprimePila(), "IMPRIMIR PILA", JOptionPane.INFORMATION_MESSAGE);

                        int opcionUser2 = 0;
                        //Try-catch para datos númericos solamente                                   
                        try {
                            System.out.println("¿QUIERE SEGUIR AGREGANDO A LA PILA? DIGITE 0 SINO SE SACARA DE LA PILA EL ULTIMO DATO");
                            opcionUser2 = in.nextInt();
                            //Validación para un cierre de ciclo basado en la opción
                        } catch (Exception error) {
                            System.out.println("LA OPCIÓN PARA ELIMINAR DEBE SER OTRO NÚMERO DIFERENTE DE 0");
                            System.out.println("SE CERRARA EL PROGRAMA");
                            System.exit(0);

                        }

                        //Validación para ciclos de la primera opción
                        if (opcionUser2 == 0) {
                            ciclo = true;
                        } else {
                            ciclo = false;
                        }
                    } while (ciclo);
                }
                //Segunda opción
                case 1: {
                    do {
                        if (pila.getPila().length > 0 && pila.getCabeza() != null) {
                            pila.sacaPila();

                            JOptionPane.showMessageDialog(null, pila.imprimePila(), "PILA", JOptionPane.INFORMATION_MESSAGE);
                            //Variable de segunda opción
                            int op2 = 0;
                            //Try-catch para sacar elementos
                            try {

                                System.out.println("\n¿QUIERE SACAR OTRO ELEMENTO DE LA PILA? DIGITE 0 DE LO CONTRARIO SE CERRARA EL PROGRAMA");
                                op2 = in.nextInt();

                            } catch (Exception erro) {

                                System.out.println("LA OPCIÓN DEBE SER UN NÚMERO DIFERENTE DE 0");
                                System.out.println("SE CERRARA EL PROGRAMA");
                                System.exit(0);
                            }

                            //Validación para el ciclo
                            if (op2 == 0) {
                                ciclo = true;
                            } else {
                                ciclo = false;
                            }
                        } else {

                            System.out.println("NO HAY MAS NODOS EN LA PILA QUE PUEDAN SER BORRADOS");
                            System.out.println("Se cierra el programa");
                            ciclo = false;
                            pila = new ED_pila();
                        }
                    } while (ciclo);
                }

                default:
                    System.exit(0);
            }
        } while (ciclo2);
    }

}
