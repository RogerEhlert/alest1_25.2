import java.util.LinkedList;

public class ArvoreGenerica {

    private Nodo raiz;
    private int nNodos;

    private class Nodo {            
        public int valor;
        public LinkedList<Nodo> filhos;
        public Nodo pai;

        public Nodo(int v) {
            this.valor=v;
            filhos=new LinkedList<Nodo>();
            pai=null;            
        }
    }


    public ArvoreGenerica() {        
        raiz=null;
        nNodos=0;
    }

    public boolean add(Integer e, Integer father){
        return false;
    }
    public Integer getRoot(){
        return 0;
    }
    public void setRoot(Integer e){}
    public Integer getParent(Integer e){
        return 0;
    }
    public boolean removeBranch(Integer e){
        return false;
    }
    public boolean contains(Integer e){
        return false;
    }
    public boolean isInternal(Integer e){
        return false;
    }
    public boolean isExternal(Integer e){
        return false;
    }
    public boolean isRoot(Integer e){
        return false;
    }
    public boolean isEmpty(){
        return false;
    }
    public int size(){
        return 0;
    }
    public void clear(){}
    public Integer[] positionsPre(){
        return null;
    }
    public Integer[] positionsPos(){
        return null;
    }
    public Integer[] positionsWidth(){
        return null;
    }
}

