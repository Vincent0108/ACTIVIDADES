package actividad_3;

import javax.swing.JOptionPane;
//Nombre de la clase

public class Ejercicio_2 {

    //Método Main
    public static void main(String[] args) {
        
        //Atributos 
        ED_Elemento dato;
        boolean ciclo = true;
        //Listas
        ED_Lista primeraLista = new ED_Lista();
        ED_Lista segundaLista = new ED_Lista();
        //Lista combinada
        ED_Lista combinacionListas = new ED_Lista();

        //ciclo para llenar la primera lista
        //Variable para validar
        int i = 0;
        //Ciclo do-while
        do {
            //instanciar la clase elemento
            dato = new ED_Elemento();
            
            //INICIO DE TOMO DE VALORES
            String valor = JOptionPane.showInputDialog(null, 
                    "INGRESE EL VALOR DEL NODO["+i+"]", "PARA LLENAR LA PRIMERA LISTA", JOptionPane.INFORMATION_MESSAGE);
                    dato.setDato(valor);
            //VALIDACIÓN DE PROGRAMA
            if(dato.getDato() == null){
                ciclo = false;
                JOptionPane.showMessageDialog(null, "NO INGRESO DATOS EN LA LISTA 1 "
                        + "NODO["+i+"]", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
            }else{
                primeraLista.agregar(dato);
            }
            i++;
        }while(ciclo);

        //LLENANDO LISTA 2
        ciclo = true;
        i = 0;
        do {
            dato = new ED_Elemento();
            dato.setDato(JOptionPane.showInputDialog(null,
                    "INGRESE EL VALOR DEL NODO[" + i + "]", "LLENADO DE LISTA 2",
                    JOptionPane.INFORMATION_MESSAGE));

            if (dato.getDato() == null) {
                ciclo = false;
                JOptionPane.showMessageDialog(null, "NO INGRESO DATOS EN LA LISTA 2 "
                        + "NODO[" + i + "]", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
            } else {
                segundaLista.agregar(dato);
            }
            i++;
        } while (ciclo);

        //Impresión y combinación de listas
        JOptionPane.showMessageDialog(null, primeraLista.imprimir(), "LISTA 1", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, segundaLista.imprimir(), "LISTA 2", JOptionPane.INFORMATION_MESSAGE);

        combinacionListas.invertirLista(primeraLista, combinacionListas, primeraLista.getLista().length - 1);
        combinacionListas.invertirLista(segundaLista, combinacionListas, segundaLista.getLista().length - 1);

        JOptionPane.showMessageDialog(null, combinacionListas.imprimir(), "LISTAS MEZCLADAS", JOptionPane.INFORMATION_MESSAGE);
    }

}
