import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArvoreBinariaPesquisa {

    private Nodo raiz;
    private int nNodos;

    private enum profundidade {Pos, Pre, Central};

    private class Nodo {
        public Nodo pai;
        public int valor;
        public Nodo filhosDaEsquerda;
        public Nodo filhosDaDireita;

        public Nodo(int v) {
            pai=filhosDaEsquerda=filhosDaDireita=null;            
            this.valor=v;
        }
    }

    public ArvoreBinariaPesquisa() {
        raiz=null;
        nNodos=0;
    }

    public void add(Integer e){
        Nodo aux = new Nodo(e);
        if(nNodos==0)
            raiz=aux;
        else{
            Nodo pai = findFather(raiz, e);
            aux.pai=pai;
            // 10 >= 17 
            if(aux.valor<=pai.valor)
                pai.filhosDaEsquerda=aux;
            else
                pai.filhosDaDireita=aux;
        }
        nNodos++;
    }

    private Nodo findFather(Nodo ref, Integer e){

        if(e<=ref.valor){
            // seguir a esquerda
            if(ref.filhosDaEsquerda!=null)
                return findFather(ref.filhosDaEsquerda, e);
            else // filho da esquerda é nulo
                return ref;
        }            
        else{
            // seguir a direita
            if(ref.filhosDaDireita!=null)
                return findFather(ref.filhosDaDireita, e);
            else // filho da direita é nulo
                return ref;
        }

    }

    public boolean isInternal(Integer e){
        return false;
    }

    public boolean isExternal(Integer e){
        return false;
    }
    
    public boolean contains(Integer e){
        return false;
    }

    public Integer getLeft(Integer e){
        return 0;
    }

    public Integer getRight(Integer e){
        return 0;
    }

    public boolean hasRight(Integer element){
        return false;
    }
    
    public boolean hasLeft(Integer element){
        return false;
    }
    
    public Integer getParent(Integer e){
        return 0;
    }    
    
    // Nao precisa ser implementado
    public int level(Integer e){
        return -1;        
    }

    public int height(){
        return -1;
    }

    public boolean removeBranch(Integer e){
        return false;
    }

    public boolean isEmpty(){
        return (raiz==null);
        //return (nNodos==0);
    }
    
    public void clear(){
        raiz=null;
        nNodos=0;
    }
    
    public int size(){
        return nNodos;
    }
    
    public Integer getRoot(){
        if(raiz!=null) return raiz.valor;
        else return null;
    }
    
    
    public Integer[] positionsPre(){
        if(nNodos==0) return null;

        Integer[] resultado = new Integer[nNodos];

        //preordem(raiz, resultado, 0);
        caminhamentoEmProfundidade(raiz, resultado, 0, profundidade.Pre);

        return resultado;
    }
    
    public Integer[] positionsCentral(){
        if(nNodos==0) return null;

        Integer[] resultado = new Integer[nNodos];

        //central(raiz, resultado, 0);
        caminhamentoEmProfundidade(raiz, resultado, 0, profundidade.Central);

        return resultado;
    }

    public Integer[] positionsPos(){
        if(nNodos==0) return null;

        Integer[] resultado = new Integer[nNodos];

        //posordem(raiz, resultado, 0);
        caminhamentoEmProfundidade(raiz, resultado, 0, profundidade.Pos);

        return resultado;
    }
 
    private int caminhamentoEmProfundidade(Nodo ref, Integer[] lst, int idx, profundidade tipo){

        if(ref!=null){

            if(tipo==profundidade.Pre){
                // visito o nodo atual
                lst[idx]=ref.valor;
                idx++;
            }

            // visito o filho a esquerda
            idx=caminhamentoEmProfundidade(ref.filhosDaEsquerda, lst, idx, tipo);

            if(tipo==profundidade.Central){
                // visito o nodo atual
                lst[idx]=ref.valor;
                idx++;
            }

            // visito o filho a direita
            idx=caminhamentoEmProfundidade(ref.filhosDaDireita, lst, idx, tipo);

            if(tipo==profundidade.Pos){
                // visito o nodo atual
                lst[idx]=ref.valor;
                idx++;
            }
        }
        return idx;

    }
    
    public Integer[] positionsWidth(){
        if(nNodos==0) return null;
        Integer[] resultado;
        LinkedList<Nodo>    fila;
        resultado = new Integer[nNodos];
        int idx=0;

        fila = new LinkedList<Nodo>();
        fila.add(raiz);

        do{
            Nodo aux = fila.remove();

            if(aux.filhosDaEsquerda!=null) fila.add(aux.filhosDaEsquerda);
            if(aux.filhosDaDireita!=null)  fila.add(aux.filhosDaDireita);

            resultado[idx]=aux.valor;
            idx++;

        }while(! fila.isEmpty());

        return resultado;

    }

    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa();


        abp.add(4);
        abp.add(2);
        abp.add(1);
        abp.add(3);
        abp.add(6);
        abp.add(7);
        abp.add(5);

        System.out.print("Pre ordem: ");
        printArray( abp.positionsPre());
        System.out.print("Pos ordem: ");
        printArray( abp.positionsPos());
        System.out.print("Central  : ");
        printArray( abp.positionsCentral());
        System.out.print("Largura  : ");
        printArray( abp.positionsWidth());
    }

    private static void printArray(Integer[] array){
        if(array==null) System.out.println("array vazio");
        else{
            System.out.print("[");
            for(int i=0; i<array.length-1; i++)
                System.out.print(array[i]+", ");
            System.out.println(array[array.length-1]+"]");
        }
    }
    
}