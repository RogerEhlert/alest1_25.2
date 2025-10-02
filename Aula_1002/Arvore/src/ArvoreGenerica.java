import java.util.LinkedList;
import java.util.Random;

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

    public Integer getRoot(){
        if(raiz!=null) return raiz.valor;
        return null;
    }

    public void setRoot(Integer e){
        if(e==null)
            throw new IllegalArgumentException("O valor passado é nulo");

        if(raiz==null){
            raiz=new Nodo(e);
            nNodos++;
        }
        else{
            raiz.valor=e;
        }
    }

    public boolean isRoot(Integer e){
        // PASSO 1 - valido o argumento passado
        //==============================
        if(e==null)
            throw new IllegalArgumentException("O valor passado é nulo");


        // PASSO 2 - avalio se a arvore está vazia
        //==============================
        // Alternativa 1 - Gera uma exceção caso a arvore esteja vazia
        if(raiz==null)
            throw new NullPointerException("A árvore está vazia");
        // Alternativa 2 - retornar falso, visto que a árvore está vazia 
        //    e não contem o valor procurado
        //  return false;

        // PASSO 3 - comparo com o valor armazenado na raiz
        return (raiz.valor==e);
    }

    public boolean isEmpty(){
        return (raiz==null);
        //return (nNodos==0);
    }
    public int size(){
        return nNodos;
    }

    public void clear(){
        raiz=null;
        nNodos=0;
    }

    public boolean add(Integer e, Integer father){

        // 1ª versão
        //   a. Inclusão de nodos filhos da raiz. Nenhuma navegação é realizada.
        //   b. O parametro father deve ser diferente de nulo

        // Passo 1 - Validar os argumentos/parametros
        if(father==null)
            throw new IllegalArgumentException("O valor do nodo pai deve ser diferente de nulo");
        if(e==null)
            throw new IllegalArgumentException("O valor a ser armazenado deve ser diferente de nulo");

        // Passo 2 - Validar a relação com a raiz
        if(father!=raiz.valor){
            System.out.println("1ª Versao - somente inclusão de filhos do nodo raiz");
            System.out.println("  Inclusão do nodo não foi realizada");
            return false;            
        }

        // Passo 3 - Adicionar o nodo
        Nodo aux = new Nodo(e);
        raiz.filhos.add(aux);
        nNodos++;
        return true;
    }

    @Override
    public String toString() {
        if(raiz==null)
            return "[0] - A árvore está vazia";

        StringBuilder sb = new StringBuilder();
        // 1ª versão - imprime raiz e seus filhos
        sb.append("["+nNodos+"] - {"+raiz.valor);
        for(Nodo aux: raiz.filhos)
            sb.append(", "+aux.valor);
        sb.append("}");
        
        return sb.toString();
        
    }

    // exige caminhamento
    public Integer getParent(Integer e){
        return 0;
    }    
    // exige caminhamento
    public boolean removeBranch(Integer e){
        return false;
    }
    // exige caminhamento
    public boolean contains(Integer e){
        return false;
    }
    // exige caminhamento
    public boolean isInternal(Integer e){
        return false;
    }
    // exige caminhamento
    public boolean isExternal(Integer e){
        return false;
    }

    // exige caminhamento
    public Integer[] positionsPre(){
        if(nNodos==0)
            return null;
        Integer[] lista = new Integer[nNodos];
        preordem(raiz, lista, 0);
        return lista;
    }

    private void preordem(Nodo ref, Integer[] list, int idx){
        // Implementação funcionante para raiz e seus filhos (altura 1)
        // Será que funciona para árvores com mais níveis?
        if(ref!=null){
            list[idx]=ref.valor;
            idx++;
            for(Nodo filho: ref.filhos){
                preordem(filho, list, idx);
                idx++;
            }
        }
    }

    // exige caminhamento
    public Integer[] positionsPos(){
        return null;
    }
    // exige caminhamento
    public Integer[] positionsWidth(){
        return null;
    }

    public static void main(String[] args) {
        ArvoreGenerica ag = new ArvoreGenerica();
        Random rnd = new Random();
        int raiz = rnd.nextInt(100);

        System.out.println(ag);

        ag.setRoot(raiz);
        System.out.println(ag);

        for(int i=0; i< 10; i++){
            ag.add(rnd.nextInt(100), raiz);            
            System.out.println(ag);
        }
    }

}

