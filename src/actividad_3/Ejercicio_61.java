package actividad_3;

import java.util.Scanner;
import javax.swing.JOptionPane;
//Nombre de la clase

public class Ejercicio_61 {

    //Método Main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Instancia de la clase cola
        ED_Cola cola = new ED_Cola();

        //Atributos
        boolean ciclo1 = true, ciclo2 = true;
        String datoValor = "";

        //Ciclo do-while
        do {
            int op1 = 0;

            try {
                //Inicio de operaciones
                System.out.println("¿QUE OPERACIÓN QUIERES HACER? DIGITE [0]AGREGAR[1]ELIMINAR DATOS REPETIDOS");
                op1 = in.nextInt();
                if (op1 != 1 && op1 != 0) {

                    System.out.println("LA OPCIÓN DEBE SER [1] O [0]");

                }

            } catch (Exception erro) {

                System.out.println("LA OPCIÓN DEBE SER UN NÚMERO");
                System.out.println("SE CERRARA EL PROGRAMA");
                System.exit(0);
            }

            switch (op1) {
                case 0: {
                    do {
                        ED_Elemento nodo = new ED_Elemento();
                        System.out.println("DIGITE EL VALOR PARA EL NODO A INSERTAR");

                        datoValor = in.next();
                        //Asignación de dato         
                        nodo.setDato(datoValor);

                        //Uso del método para agregar
                        cola.encolar(nodo);

                        //Impresión de la cola
                        JOptionPane.showMessageDialog(null, cola.imprimeCola(), "COLA", JOptionPane.INFORMATION_MESSAGE);

                        int opUser2 = 0;

                        //tRY-CATCH para validad opciones y tipos de datos seleccionados    
                        try {
                            System.out.println("¿QUIERE AGREGAR OTRO ELEMENTO A LA COLA? DIGITE [0] SINO DIGITE OTRO NÚMERO PARA ELIMINAR LOS DATOS REPETIDOS");
                            opUser2 = in.nextInt();
                            //Validación para un cierre de ciclo basado en la opción
                        } catch (Exception error) {
                            System.out.println("LA OPCIÓN PARA ELIMINAR ELEMENTOS REPETIDOS DEBE SER OTRO NÚMERO DIFERENTE DE 0");
                            System.out.println("SE CERRARA EL PROGRAMA");
                            System.exit(0);

                        }
                        //Imprimir y validar la opción del usuario
                        JOptionPane.showMessageDialog(null, cola.imprimeCola(), "COLA", JOptionPane.INFORMATION_MESSAGE);

                        if (opUser2 == 0) {
                            ciclo1 = true;
                        } else {
                            ciclo1 = false;
                        }
                    } while (ciclo1);
                }
                //Segundo caso
                case 1: {
                    do {
                        //Validación para los elementos a eliminar
                        if (cola.getCola().length > 0 && cola.getCabeza() != null) {
                            //Asignación de datos
                            System.out.println("COLA CON ELEMENTOS REPETIDOS ELIMINADOS");
                            cola.eliminaRepetidos();
                            //Imprimir cola
                            JOptionPane.showMessageDialog(null, cola.imprimeCola(), "COLA", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            System.out.println("NO HAY ELEMENTOS EN LA COLA");
                            ciclo1 = false;
                        }
                    //Cierre del primer ciclo
                    } while (ciclo1);
                }
                //Cierre de la sentencia switch
                default:
                    System.exit(0);
            }
          //Cierre del segundo ciclo
        } while (ciclo2);
    }
}
