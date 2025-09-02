public class FilaCircular {

    private int[] arranjo;
    private int inicioDaFila;
    private int fimDaFila;

    public FilaCircular() {
        // já corrigido para fila circular
        arranjo = new int[10];
        inicioDaFila= fimDaFila = 0;
    }

    public FilaCircular(int capacidade) {
        // já corrigido para fila circular
        arranjo = new int[capacidade];
        inicioDaFila= fimDaFila = 0;
    }

    //insere o elemento e no final da fila
    public boolean enqueue(int e){
        // Corrigido para fila circular
        if(((fimDaFila+1)%arranjo.length)==inicioDaFila)
            return false;
        arranjo[fimDaFila]=e;
        fimDaFila=((fimDaFila+1)%arranjo.length);
        return true;
    }

    //remove e retorna o elemento e do início da fila, e dá erro se a fila estiver vazia
    public int dequeue(){
        // Corrigido para fila circular
        if(fimDaFila==inicioDaFila)
            throw new RuntimeException("A fila está vazia");
        
        int elementoASerRetornado=arranjo[inicioDaFila];
        // processo de "passinho a frente"
        inicioDaFila=((inicioDaFila+1)%arranjo.length);
        return elementoASerRetornado;
    }

    //retorna, mas não remove, o primeiro elemento da fila, e dá erro se a fila estiver vazia
    public int head(){
        // Corrigido para fila circular
        if(fimDaFila==inicioDaFila)
            throw new RuntimeException("A fila está vazia");
        
        return arranjo[inicioDaFila];
    }
    
    //retorna o número de elementos da fila
    public int size(){
        // Corrigido para fila circular
        if(fimDaFila<inicioDaFila)
            return (arranjo.length-inicioDaFila)+(fimDaFila);
        return fimDaFila-inicioDaFila;
    }
    
    //retorna true se a fila estiver vazia, e false caso contrário
    public boolean isEmpty(){
        // já corrigido para fila circular
        return (fimDaFila==inicioDaFila);
    }

    //esvazia a fila
    public void clear(){
        // já corrigido para fila circular
        inicioDaFila=fimDaFila=0;
    }

    public String toString(){
        // precisa corrigir para fila circular
        if(fimDaFila==0)
            return "A fila está vazia";

        StringBuilder sb = new StringBuilder();
        sb.append("<-:"+inicioDaFila+":[");
        for(int idx=inicioDaFila; (idx!=((fimDaFila==0)?(arranjo.length-1):(fimDaFila-1))); idx=((idx+1)%arranjo.length))
            sb.append(arranjo[idx]+",");
        sb.append(arranjo[fimDaFila-1]);
        sb.append("]<-:"+(fimDaFila-1)+":"+((inicioDaFila==0)?(arranjo.length-1):inicioDaFila-1));

        return sb.toString();
    }

    public static void main(String[] args) {
        FilaCircular f = new FilaCircular(5);
        System.out.println(f);
        f.enqueue(23);
        System.out.println(f);
        f.enqueue(7);
        System.out.println(f);
        f.enqueue(95);
        System.out.println(f);
        f.dequeue();
        System.out.println(f);
        f.dequeue();
        System.out.println(f);
        f.enqueue(12);
        System.out.println(f);
        f.enqueue(25);
        System.out.println(f);
    }
}