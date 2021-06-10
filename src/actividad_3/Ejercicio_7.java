/*
Defina un programa que elimine los elementos repetidos de una pila.  
Los elementos repetidos ocupan posiciones sucesivas.
 */
package actividad_3;


import javax.swing.JOptionPane;

public class Ejercicio_7 {

    public static void main(String[] args) {
        ED_pila pila = new ED_pila();
        
        boolean loop = true;
        boolean loop2 = true;
        String valor = "";
        
        do{
            int op1 = JOptionPane.showOptionDialog(null, "QUE OPERACION DESEA REALIZAR?"
                    , "COLAS",JOptionPane.YES_NO_CANCEL_OPTION 
                    , JOptionPane.QUESTION_MESSAGE, null
                    , new String[] { "Apilar", "Eliminar repetidos"},"Apilar");
            switch(op1){
                case 0 -> {
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
                            loop = true;
                        }else{
                            loop = false;
                        }
                    }while(loop);
                }
                
                case 1 -> {
                    do{
                        if(pila.getPila().length > 0 && pila.getCabeza() != null){
                            pila.eliminaRepetidos();
                            JOptionPane.showMessageDialog(null,pila.imprimePila(), "PILA", JOptionPane.INFORMATION_MESSAGE);
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "LO SIENTO, NO HAY NODOS EN LA PILA", "ERROR", JOptionPane.ERROR_MESSAGE);
                            loop = false;
                        }
                    }while(loop);
                }
                    
                default -> System.exit(0);
            }
        }while(loop2);
    }
    
}
