package actividad_3;

import java.util.Scanner;
import javax.swing.JOptionPane;
//Nombre de la clase

public class Ejercicio_51 {

    //Método Main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Instancia de la cola
        ED_Cola cola1 = new ED_Cola();
        //Variables 
        boolean ciclo1 = true, ciclo2 = true;
        String datoValor = "";
        //Ciclo do-while
        do {
            //Variable de opción
            int opUser1 = 0;

            try {
                //Inicio de operaciones
                System.out.println("¿QUE OPERACIÓN QUIERES HACER? DIGITE [0]AGREGAR [1]ELIMINAR");
                opUser1 = in.nextInt();
                 if(opUser1 !=1&&opUser1 !=0){
                
                    System.out.println("LA OPCIÓN DEBE SER [1] O [0]");
                
                }

            } catch (Exception erro) {

                System.out.println("LA OPCIÓN DEBE SER UN NÚMERO");
                System.out.println("SE CERRARA EL PROGRAMA");
                System.exit(0);
            }
            //Sentencia para validar la opción
            switch (opUser1) {
                //Primer caso
                case 0: {
                    //Ciclo do-while
                    do {
                        ED_Elemento nodo = new ED_Elemento();
                        System.out.println("DIGITE EL VALOR PARA EL NODO A INSERTAR");
                        
                        datoValor = in.next();
                        //Asignación de dato         
                        nodo.setDato(datoValor);
                        
                        //Uso del método para agregar
                        cola1.encolar(nodo);
                       
                        //Impresión de la cola
                        JOptionPane.showMessageDialog(null, cola1.imprimeCola(), "COLA", JOptionPane.INFORMATION_MESSAGE);

                        
                        int opUser2=0;
                        
                         //tRY-CATCH para validad opciones y tipos de datos seleccionados    
                         try {
                           System.out.println("¿QUIERE AGREGAR OTRO ELEMENTO A LA COLA? DIGITE [0] SINO DIGITE OTRO NÚMERO PARA ELIMINAR");
                            opUser2 = in.nextInt();
                            //Validación para un cierre de ciclo basado en la opción
                        } catch (Exception error) {
                            System.out.println("LA OPCIÓN PARA ELIMINAR DEBE SER OTRO NÚMERO DIFERENTE DE 0");
                            System.out.println("SE CERRARA EL PROGRAMA");
                            System.exit(0);

                        }       
                                             
                        //Ciclo para el cierre del programa                        
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
                        //Validación para eliminar de la cola
                        if (cola1.getCola().length > 0 && cola1.getCabeza() != null) {
                            
                            //Uso del método para eliminar datos de la cola
                            cola1.desencolar();

                            JOptionPane.showMessageDialog(null, cola1.imprimeCola(), "COLA", JOptionPane.INFORMATION_MESSAGE);

                            int op2 = 0;
                                                       
                        
                         //tRY-CATCH para validad opciones y tipos de datos seleccionados    
                         try {
                           System.out.println("¿QUIERE ELIMINAR OTRO ELEMENTO A LA COLA? DIGITE [0] SINO DIGITE OTRO NÚMERO PARA ACABAR");
                            op2 = in.nextInt();
                            //Validación para un cierre de ciclo basado en la opción
                        } catch (Exception error) {
                            System.out.println("LA OPCIÓN PARA ELIMINAR DEBE SER OTRO NÚMERO DIFERENTE DE 0");
                            System.out.println("SE CERRARA EL PROGRAMA");
                            System.exit(0);

                        }       
                            //Validanto las opciones
                            if (op2 == 0) {
                                ciclo1 = true;
                            } else {
                                ciclo1 = false;
                            }
                        } else {
                            System.out.println("NO SE HAN ENCONTRADO DATOS DE LA COLA");
                            ciclo1 = false;
                            cola1 = new ED_Cola();
                        }
                    } while (ciclo1);
                }

                default:
                    System.exit(0);
            }
        } while (ciclo2);
    }
}
