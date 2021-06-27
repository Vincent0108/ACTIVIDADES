
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

class NodoCadena {

    private String dato;
    private NodoCadena izquierda, derecha;

    public NodoCadena(String dato) {
        this.dato = dato;
        this.izquierda = this.derecha = null;

    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public void setIzquierda(NodoCadena izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(NodoCadena derecha) {
        this.derecha = derecha;
    }

    public String getDato() {
        return dato;
    }

    public NodoCadena getIzquierda() {
        return izquierda;
    }

    public NodoCadena getDerecha() {
        return derecha;
    }

    public void imprimirDato() {
        System.out.println(this.getDato());
    }

}

class Arbol {

    private Nodo raiz;

    public Arbol() {

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
}

class ArbolCadena {

    private NodoCadena raiz;

    public ArbolCadena() {

    }

    public boolean existe(String busqueda) {
        return existe(this.raiz, busqueda);

    }

    public boolean existe(NodoCadena n, String busqueda) {
        if (n == null) {
            return false;

        }
        if (n.getDato().equals(busqueda)) {
            return true;
        } else if (busqueda.compareTo(n.getDato()) < 0) {
            return existe(n.getIzquierda(), busqueda);

        } else {
            return existe(n.getDerecha(), busqueda);

        }

    }

    public void insertar(String dato) {
        if (this.raiz == null) {
            this.raiz = new NodoCadena(dato);
            System.out.println("NODO RAIZ = "+dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }

    private void insertar(NodoCadena padre, String dato) {
        if (dato.compareTo(padre.getDato()) > 0) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new NodoCadena(dato));
                System.out.println("NODO DERECHO = "+dato);
            } else {
                this.insertar(padre.getDerecha(), dato);
                System.out.println("NODO DERECHO = "+dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new NodoCadena(dato));
                System.out.println("NODO IZQUIERDO = "+dato);
            } else {
                this.insertar(padre.getIzquierda(), dato);
                System.out.println("NODO IZQUIERDO = "+dato);
            }
        }
    }

    private void preorden(NodoCadena n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    private void inorden(NodoCadena n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDato();
            inorden(n.getDerecha());
        }
    }

    private void postorden(NodoCadena n) {
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

    public NodoCadena getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoCadena raiz) {
        this.raiz = raiz;
    }
    
    
}

class Main {

    public static void main(String[] argumentos) {
        Arbol arbol = new Arbol();
        arbol.insertar(25);
        arbol.insertar(20);
        arbol.insertar(10);
        arbol.insertar(8);
        arbol.insertar(23);
        arbol.insertar(21);
        arbol.insertar(90);
        arbol.insertar(80);
        arbol.insertar(62);
        arbol.insertar(47);
        arbol.insertar(32);
        arbol.insertar(100);
        System.out.println("Recorriendo inorden:");
        arbol.inorden();
        System.out.println("Recorriendo postorden:");
        arbol.postorden();
        System.out.println("Recorriendo preorden:");
        arbol.preorden();

        ArbolCadena arbol2 = new ArbolCadena();
        arbol2.insertar("K");
        arbol2.insertar("B");
        arbol2.insertar("W");
        arbol2.insertar("A");
        arbol2.insertar("F");
        arbol2.insertar("D");
        
        arbol2.insertar("M");
        arbol2.insertar("Z");
        arbol2.insertar("L");
        arbol2.insertar("O");
        arbol2.insertar("P");
        
        
        System.out.println("*********");
        System.out.println("NODO = "+arbol2.getRaiz().getDerecha().getIzquierda().getDerecha().getDerecha().getDato());
        
        
        System.out.println("Recorriendo inorden:");
        arbol2.inorden();
        System.out.println("Recorriendo postorden:");
        arbol2.postorden();
        System.out.println("Recorriendo preorden:");
        arbol2.preorden();

    }
}
