package ejercicio2_4;

import java.util.ArrayList;

class Nodo {

    private int dato;
    private Nodo izquierda, derecha;
    

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = this.derecha = null;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public void imprimirDato() {
        System.out.println(this.getDato());
    }
}

class Arbol {

    private Nodo raiz;
    private int cantidadNodos;
    private ArrayList<Integer> datos;
    
    public int cuentaNodos(Nodo nodo) {

        int contador = 1;
        if (nodo.getIzquierda() != null) {
            contador += cuentaNodos(nodo.getIzquierda());
        }

        if (nodo.getDerecha() != null) {
            contador += cuentaNodos(nodo.getDerecha());
        }
        
        return contador;
    }
    
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Arbol() {
        datos = new ArrayList<>();
    }

    public boolean existe(int busqueda) {
        return existe(this.raiz, busqueda);
    }

    private boolean existe(Nodo n, int busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getDato() == busqueda) {
            return true;
        } else if (busqueda < n.getDato()) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }

    }

    public void insertar(int dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
        cantidadNodos++;
        datos.add(dato);
    }

    private void insertar(Nodo padre, int dato) {
        if (dato > padre.getDato()) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(dato));
            } else {
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(dato));
            } else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }

    private void preorden(Nodo n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDato();
            inorden(n.getDerecha());
        }
    }

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            n.imprimirDato();
        }
    }

    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
    }

    public int buscarMayor() {

        int mayor = raiz.getDato();
        Nodo nodo = raiz;
        while (nodo.getDerecha() != null) {
            nodo = nodo.getDerecha();
            mayor = nodo.getDato();
        }
        return mayor;
    }
    
    public int promedio() {
        int suma = 0;
        
        for (int i = 0; i < datos.size(); i++) {
            suma += datos.get(i);
            System.out.println("DATO "+i+" = "+datos.get(i));
        }

        return suma/datos.size();
    }

}

public class Ejercicio2_4 {

    public static void main(String[] args) {

        Arbol arbol = new Arbol();

        arbol.insertar(8);
        arbol.insertar(4);
        arbol.insertar(10);
        arbol.insertar(12);
        arbol.insertar(1);
        arbol.insertar(2);
        arbol.insertar(9);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(18);
        arbol.insertar(16);
        arbol.insertar(15);
        arbol.insertar(100);

        System.out.println(arbol.cuentaNodos(arbol.getRaiz()));
        int mayor = arbol.buscarMayor();
        System.out.println(mayor);
        
        System.out.println("Promedio = "+arbol.promedio());

    }

    

}
