package actividad_3;

import javax.swing.JOptionPane;

public class Ejercicio_5 {

    public static void main(String[] args) {
        ED_Cola cola = new ED_Cola();
        
        boolean loop = true;
        boolean loop2 = true;
        String valor = "";
        
        do{
            int op1 = JOptionPane.showOptionDialog(null, "QUE OPERACION DESEA REALIZAR?"
                    , "COLAS",JOptionPane.YES_NO_CANCEL_OPTION 
                    , JOptionPane.QUESTION_MESSAGE, null
                    , new String[] { "Encolar", "Desencolar"},"Encolar");
            switch(op1){
                case 0 -> {
                    do{
                        ED_Elemento nodo = new ED_Elemento();
                        valor = JOptionPane.showInputDialog(null, "Ingrese valor del "
                                + "nodo a insertar", "VALOR DEL NODO"
                                , JOptionPane.INFORMATION_MESSAGE);
                        nodo.setDato(valor);
                        if(valor != null){
                            cola.encolar(nodo);
                        }else
                            System.exit(0);

                        JOptionPane.showMessageDialog(null,cola.imprimeCola(), "COLA", JOptionPane.INFORMATION_MESSAGE);

                        int op2 = JOptionPane.showConfirmDialog(null, "Desea agregar otro nodo a la Cola?");
                        if(op2 == 0){
                            loop = true;
                        }else{
                            loop = false;
                        }
                    }while(loop);
                }
                
                case 1 -> {
                    do{
                        if(cola.getCola().length > 0 && cola.getCabeza() != null){
                            cola.desencolar();

                            JOptionPane.showMessageDialog(null,cola.imprimeCola(), "COLA", JOptionPane.INFORMATION_MESSAGE);

                            int op2 = JOptionPane.showConfirmDialog(null, "Desea sacar otro nodo de la Cola?");
                            if(op2 == 0){
                                loop = true;
                            }else{
                                loop = false;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "LO SIENTO YA NO HAY MAS NODOS EN LA COLA", "ERROR", JOptionPane.ERROR_MESSAGE);
                            loop = false;
                            cola = new ED_Cola();
                        }
                    }while(loop);
                }
                    
                default -> System.exit(0);
            }
        }while(loop2);
    }
}