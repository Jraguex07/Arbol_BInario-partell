package uspg;

public class Nodo_Arbol {
    int dato;
    Nodo_Arbol hijoIzquierdo;
    Nodo_Arbol hijoDerecho;
   
    public Nodo_Arbol(int dato){
        this.dato = dato;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
   
    public String toString(){
        return "su dato es " + this.dato;
    }
   
   
}


