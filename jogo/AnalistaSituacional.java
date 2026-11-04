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

    public Marca getMarcaDoVencedor ()
    {
        // descobrir se ha um vencedor e retornar
        // a marca dele; retornara null, quando
        // nao houver vencedor
        if 
        return Marca;
    }

    private boolean tabuleiroCheio ()
    {
        // verificar se todas as posicoes do
        // tabuleiro estao preenchidas (!=null)
        // retornando true em caso afirmativo,
        // ou false em caso negativo
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.haMarcaNaPosicao(0,2) 
        && this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.haMarcaNaPosicao(2,1) 
        && this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.haMarcaNaPosicao(2,2)) return true;
        return false; 
        
    }

    public boolean fimDeJogo ()
    {
        // se getMarcaDoVencedor != null,
        // retorna true
        // se tabuleiroCheio == true,
        // retorna true
        // caso contrario, retorna false
        if(getMarcaDoVencedor!=null) return true;
        if(tabuleiroCheio==true) return true;
        return false;
    }

    @Override
    public String toString ()
    {
        // faça
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario
        if(obj==this) return true;
        if(obj==null) return false;
        if(obj.getClass()!=this.getClass()) return false;
        AnalistaSituacional anasist = (obj)AnalistaSituacional;
        if(!analist.tabDoJogo.equals(this.tabDoJogo)) return false;
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
