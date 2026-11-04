package jogo;

public class AnalistaSituacional
{
    private Tabuleiro tabDoJogo;

    public AnalistaSituacional (Tabuleiro tab) throws Exception
    {
        // colocar tab em tabDoJogo
        if(tab==null) throw new Exception("Tabuleiro nulo");
        this.tabDoJogo=tab;
    }

    private boolean tresIguais (int l1, int c1, int l2, int c2, int l3, int c3){
    	1. Parênteses e ponto e vírgula (erro de compilação).
    	Conte os parênteses de cada if: falta fechar um em cada um. E depois de return false e return true falta o ;. Confira 	também que o último if fecha todos os parênteses que abre.
    
    	2. A condição do primeiro if está invertida.
    	Do jeito que está, ele retorna false quando há marca, que é o contrário do que queremos. Lembre do passo 1: se não há 	marca na posição, retorna false. Qual operador em Java inverte um boolean?
    
    	3. haMarcaNaPosicao não serve para comparar.
    	Esse método responde “tem marca aqui?” (true ou false). Ele não devolve a marca. Para comparar as marcas, você precisa 	do método que devolve a marca da posição, o getMarcaNaPosicao. Pense: comparar o boolean de uma posição com o boolean 	de outra daria true sempre que as duas estivessem preenchidas, mesmo com X numa e O na outra. Só que boolean primitivo 	nem tem .equals, então nem compilaria.
    
    	4. Falta um return no final.
    	Se o último if não for verdadeiro, o método chega ao fim sem devolver nada, e o Java não aceita isso. O que o método 	deve devolver nesse caso? (Dica: depois de corrigir, você pode até simplificar, já que a própria condição do último if 	é um boolean, como aconteceu no tabuleiroCheio.)
    
    	if(this.tabDoJogo.haMarcaNaPosicao(l1, c1) return true;
    	if(this.tabDoJogo.haMarcaNaPosicao(l1,c1).equals(this.tabDoJogo.haMarcaNaPosicao(l2,c2)) && 
    	this.tabDoJogo.haMarcaNaPosicao(l1,c1).equals(this.tabDoJogo.haMarcaNaPosicao(l3,c3)) return true;
        return false;
    }


    public Marca getMarcaDoVencedor ()
    {
        // descobrir se ha um vencedor e retornar
        // a marca dele; retornara null, quando
        // nao houver vencedor
        if (tresIguais(0,0, 0,1, 0,2)) return this.tabDoJogo.getMarcaNaPosicao(0,0);
    	if (tresIguais(1,0, 1,1, 1,2)) return this.tabDoJogo.getMarcaNaPosicao(1,0);
    	if (tresIguais(2,0, 2,1, 2,2)) return this.tabDoJogo.getMarcaNaPosicao(2,0);
    	if (tresIguais(0,0, 1,0, 2,0)) return this.tabDoJogo.getMarcaNaPosicao(0,0);
    	if (tresIguais(0,1, 1,1, 2,1)) return this.tabDoJogo.getMarcaNaPosicao(0,1);
    	if (tresIguais(0,2, 1,2, 2,2)) return this.tabDoJogo.getMarcaNaPosicao(0,2);
    	if (tresIguais(0,0, 1,1, 2,2)) return this.tabDoJogo.getMarcaNaPosicao(0,0);
    	if (tresIguais(0,2, 1,1, 2,0)) return this.tabDoJogo.getMarcaNaPosicao(0,2);
    	return null;
    }

    private boolean tabuleiroCheio ()
    {
        // verificar se todas as posicoes do
        // tabuleiro estao preenchidas (!=null)
        // retornando true em caso afirmativo,
        // ou false em caso negativo
        return this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.haMarcaNaPosicao(0,2) 
        && this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.haMarcaNaPosicao(1,2) 
        && this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.haMarcaNaPosicao(2,2); 
    }

    public boolean fimDeJogo ()
    {
        // se getMarcaDoVencedor != null,
        // retorna true
        // se tabuleiroCheio == true,
        // retorna true
        // caso contrario, retorna false
        if(getMarcaDoVencedor()!=null) return true;
        return tabuleiroCheio();
    }

    @Override
    public String toString ()
    {
        return "Analista do tabuleiro:\n" + this.tabDoJogo.toString();
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario
        if(obj==this) return true;
        if(obj==null) return false;
        if(obj.getClass()!=this.getClass()) return false;
        AnalistaSituacional anasist = (AnalistaSituacional)obj;
        if(!anasist.tabDoJogo.equals(this.tabDoJogo)) return false;
        return true;
    }

    @Override
    public int hashCode ()
    {
        int retorno = 1;
        retorno=retorno*2 + this.tabDoJogo.hashCode();
        if(retorno<0)retorno=-retorno;
        return retorno;
    }
}
