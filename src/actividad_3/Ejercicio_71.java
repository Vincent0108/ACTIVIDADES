package actividad_3;


import java.util.Scanner;
import javax.swing.JOptionPane;
//Nombre de la clase
public class Ejercicio_71 {

    //Clase principal
    public static void main(String[] args) {
        //Instanciad de la clase Scanner
        Scanner in = new Scanner(System.in);
        //Instancia de la clase pila
        ED_pila pila = new ED_pila();
        //Atributos
        boolean ciclo1 = true, ciclo2 = true;
        String valor = "";
        //primer ciclo do-while
        do{
              int op1 = 0;
         //Try-catch para toma de desiciones     
         try {
                //Inicio de operaciones
                System.out.println("¿QUE OPERACIÓN QUIERES HACER? DIGITE [0]APILAR[1]ELIMINAR DATOS REPETIDOS");
                op1 = in.nextInt();
                if (op1 != 1 && op1 != 0) {

                    System.out.println("LA OPCIÓN DEBE SER [1] O [0]");

                }

            } catch (Exception erro) {

                System.out.println("LA OPCIÓN DEBE SER UN NÚMERO");
                System.out.println("SE CERRARA EL PROGRAMA");
                System.exit(0);
            }
            //Sentencia para las opciones del programa
            switch(op1){
                case 0: {
                    do{
                        ED_Elemento nodo = new ED_Elemento();
                        valor = JOptionPane.showInputDialog(null, "Ingrese valor del "
                                + "nodo a insertar", "VALOR DEL NODO"
                                , JOptionPane.INFORMATION_MESSAGE);
                        nodo.setDato(valor);
                        if(valor != null){
                            pila.metePila(nodo);
                        }else
                            System.exit(0);

                        JOptionPane.showMessageDialog(null,pila.imprimePila(), "PILA", JOptionPane.INFORMATION_MESSAGE);

                        int op2 = JOptionPane.showConfirmDialog(null, "Desea agregar otro nodo a la Pila?");
                        if(op2 == 0){
                            ciclo1 = true;
                        }else{
                            ciclo1 = false;
                        }
                    }while(ciclo1);
                }
                
                case 1: {
                    do{
                        if(pila.getPila().length > 0 && pila.getCabeza() != null){
                            pila.eliminaRepetidos();
                            JOptionPane.showMessageDialog(null,pila.imprimePila(), "PILA", JOptionPane.INFORMATION_MESSAGE);
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "LO SIENTO, NO HAY NODOS EN LA PILA", "ERROR", JOptionPane.ERROR_MESSAGE);
                            ciclo1 = false;
                        }
                    }while(ciclo1);
                }
                    
                default: System.exit(0);
            }
        }while(ciclo2);
    }
    
}
