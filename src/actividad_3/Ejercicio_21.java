package actividad_3;

import java.util.Scanner;
import javax.swing.JOptionPane;
//Nombre de la clase

public class Ejercicio_21 {

    //Método Main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Atributos 
        ED_Elemento dato;
        boolean ciclo = true;
        //Listas
        ED_Lista primeraLista = new ED_Lista();
        ED_Lista segundaLista = new ED_Lista();
        //Lista combinada
        ED_Lista listaCombinada = new ED_Lista();

        //ciclo para llenar la primera lista
        //Variable para validar
        int i = 0;
        //Ciclo do-while
        do {
            //instanciar la clase elemento
            dato = new ED_Elemento();

            //INICIO DE TOMO DE VALORES
            System.out.println("Lista 1 ["+i+"]");
            String valor = in.next();
            
            dato.setDato(valor);
            primeraLista.agregar(dato);
            
            //VALIDACIÓN DE PROGRAMA
            System.out.println("QUIERES ACABAR LA LISTA? INGRESE [s/n]: ");
            String op = in.next();
            if (op.charAt(0) == 's') {
                ciclo = false;
            }else{
                i++;
            }
        } while (ciclo);

        //LLENANDO LISTA 2
        i = 0;
        ciclo = true;
        do {
            //instanciar la clase elemento
            dato = new ED_Elemento();

            //INICIO DE TOMO DE VALORES
            System.out.println("Lista 2 ["+i+"]");
            String valor = in.next();
            
            //VALIDACIÓN DE PROGRAMA
            System.out.println("QUIERE MAS VAYA A BELLSOUTH? [s/n]: ");
            String op = in.next();
            dato.setDato(valor);
            segundaLista.agregar(dato);
            if (op.charAt(0) == 'n') {
                ciclo = false;
            }else{
                i++;
            }
        } while (ciclo);
        
        //Impresión y combinación de listas
        listaCombinada.invertirLista(primeraLista, listaCombinada, primeraLista.getLista().length-1);
        listaCombinada.invertirLista(segundaLista, listaCombinada, segundaLista.getLista().length-1);
       //Primera lista
        System.out.println("PRIMERA LISTA");
        System.out.println(primeraLista.imprimir());
        //Segunda lista
        System.out.println("SEGUNDA LISTA");
        System.out.println(segundaLista.imprimir());
        //Lista combinada
        System.out.println("LISTAS COMBINADAS");
        System.out.println(listaCombinada.imprimir());
    }

}
