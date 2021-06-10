package actividad_3;

import javax.swing.JOptionPane;
//Nombre de la clase
public class ED_Lista{
    //Atributos
    private ED_Elemento inicio, fin;

    //Creación de Arreglo
    private ED_Elemento[] lista;

    //Métodos setter y getter
    public ED_Elemento[] getLista() {
        return lista;
    }

    public void setLista(ED_Elemento[] lista) {
        this.lista = lista;
    }

    //Constructor para la creación de listas
    public ED_Lista() {

        lista = new ED_Elemento[1];
        inicio = lista[0];
        fin = lista[0];
    }
      
    //Métodos para operaciones con las estructuras
    //Método agregar
    public void agregar(ED_Elemento nodo) {

        //Se genera una copia de la lista 
        ED_Elemento[] lista_2 = new ED_Elemento[lista.length + 1];

        //ciclo for para recorrer el arreglo
        for (int i = 0; i < lista.length; i++) {
            //Aqui le asignamos el mismo valor
            lista_2[i] = lista[i];
        }

        //Validaciones para la lista de la primera posición
        if (lista[0] != null) {
            //Posicionando el elemento
            lista_2[lista_2.length - 1] = nodo;
            lista = lista_2;
            fin = lista[lista.length - 1];
            lista[lista.length - 1].setPrevio(lista[lista.length - 2]);
            lista[lista.length - 1].setPosterior(null);

        } else {
            lista[0] = nodo;
        }
    }

    //Método Insertar
    public void insertar(int posicion, ED_Elemento nodo) {

        //Creamos otro arrelgo para este Método
        ED_Elemento[] lista_2 = new ED_Elemento[lista.length + 1];

        /*Validamos para las operaciones
        Si la posición que se pondra supera las que se tienen en el arreglo
        el programa le indicara esto al usuario de inmediato
         */
        //SE INDICA EL ERROR
        if (posicion > lista.length) {
            JOptionPane.showMessageDialog(null, "ESTA POSICIÓN NO PUEDE OCUPARCE  "
                    + "DEBE LLENAR LAS ANTERIORES PRIMERO");
            System.exit(0);
        } else {
            //Se agrega el dato al arreglo si la posición es la correcta
            if (posicion == 0) {
                if (lista[0] == null) {
                    lista[0] = nodo;
                } else {
                    //Recorremos la estructura 
                    for (int i = posicion + 1, j = 0; j < lista.length; i++, j++) {
                        lista_2[i] = lista[j];
                    }
                    // Y asignamos los valores pertinentes

                    lista = lista_2;

                    lista[0] = nodo;
                    lista[0].setPrevio(null);
                    lista[0].setPosterior(lista[1]);
                }

                //Validaciones en caso de diferentes situaciones con las posiciones
            } else if (posicion > lista.length - 1) {

                //Ciclo para recorrer
                for (int i = 0; i < lista.length; i++) {
                    //Asignamos el valor en base a al validación
                    lista_2[i] = lista[i];
                }

                //Ahora instanciamos la lista sumandole una posición
                lista = new ED_Elemento[lista.length + 1];

                //Y la recorremos para asignarle un valor
                for (int i = 0; i < lista.length; i++) {
                    lista[i] = lista_2[i];
                }

                //De esta manera asignando dependiendo del nodo
                lista[posicion] = nodo;
                lista[posicion].setPrevio(lista[posicion - 1]);
                lista[posicion].setPosterior(null);

            } else {
                //Si no ocurre como indica el if se hace otro ciclo for asignando el valor de la segunda lista
                for (int i = 0; i < lista.length; i++) {
                    lista_2[i] = lista[i];
                }

                //Y hacemos otro ciclo for que asigne los valores de la segunda lista con la primera
                for (int i = posicion + 1, j = posicion; i < lista_2.length; i++, j++) {
                    lista_2[i] = lista[j];
                }

                //Volvemos a dar los valores al final de la lista
                lista = lista_2;
                lista[posicion].setPrevio(lista[posicion - 1]);
                lista[posicion].setPosterior(lista[posicion + 1]);
            }

            //Y al final igualamos
            lista[posicion] = nodo;
        }
    }
public void insertarListaCircular(int posicion, ED_Elemento nodo){
        ED_Elemento [] listaCopia = new ED_Elemento[lista.length+1];
        
        if(posicion > lista.length){
            JOptionPane.showMessageDialog(null, "ESTA POSICIÓN NO PUEDE OCUPARCE  "
                    + "DEBE LLENAR LAS ANTERIORES PRIMERO");
        }else{
            if(posicion == 0){
                if(lista[0] == null){
                    lista[0] = nodo;
                    inicio = lista[0];
                    fin = lista[0];
                    fin.setPosterior(inicio);
                }else {
                    for (int i = posicion+1, j = 0; j < lista.length; i++, j++) {
                        listaCopia[i] = lista[j];
                    }
                    lista = listaCopia;
                    lista[0] = nodo;
                    inicio = lista[0];
                    fin = lista[lista.length-1];
                    fin.setPosterior(inicio);
                    lista[0].setPrevio(null);
                    lista[0].setPosterior(lista[1]);
                }
            }else if(posicion > lista.length-1){
                for (int i = 0; i <lista.length; i++) {
                    listaCopia[i] = lista[i];
                }

                lista = new ED_Elemento[lista.length+1];

                for (int i = 0; i < lista.length; i++) {
                    lista[i] = listaCopia[i];
                }
                
                lista[posicion] = nodo;
                inicio = lista[0];
                fin = lista[posicion];
                fin.setPosterior(inicio);
                lista[posicion].setPrevio(lista[posicion-1]);
                lista[posicion].setPosterior(null);
            }else{
                for (int i = 0; i < lista.length; i++) {
                    listaCopia[i] = lista[i];
                }

                for (int i = posicion+1, j = posicion; i < listaCopia.length; i++, j++) {
                    listaCopia[i] = lista[j];
                }
                lista = listaCopia;
                inicio = lista[0];
                fin = lista[lista.length-1];
                fin.setPosterior(inicio);
                lista[posicion].setPrevio(lista[posicion-1]);
                lista[posicion].setPosterior(lista[posicion+1]);
            }

            lista[posicion] = nodo;
            inicio = lista[0];
            fin = lista[lista.length-1];
            fin.setPosterior(inicio);
        }
    }
    
    public ED_Lista invertirLista(ED_Lista lista, ED_Lista listaInvertida, int posicionFinal){
        if(posicionFinal >= 0){
            listaInvertida.agregar(lista.getLista()[posicionFinal]);
            listaInvertida = invertirLista(lista, listaInvertida, posicionFinal-1);
        }
        
        return listaInvertida;
    }
    
    //Ahora imprimimos la lista
    public String imprimir() {
        String impresion = "";
        int elementoPosterior = 0;
        int finalPosterior = lista.length - 1;

        //Recorrido para imprimir
        for (ED_Elemento nodo : lista) {
            if (elementoPosterior == finalPosterior) {
                System.out.print(nodo.getDato());
                impresion = impresion + nodo.getDato();
            } else {
                System.out.print(nodo.getDato() + "-");
                impresion = impresion + nodo.getDato() + "-";
            }
            elementoPosterior++;
        }
        System.out.println("");

        return impresion;
    }

}
