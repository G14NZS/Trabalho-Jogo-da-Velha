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

    private boolean tresIguais (int l1, int c1, int l2, int c2, int l3, int c3) throws Exception {
    if (!this.tabDoJogo.haMarcaNaPosicao(l1,c1) ||
        !this.tabDoJogo.haMarcaNaPosicao(l2,c2) ||
        !this.tabDoJogo.haMarcaNaPosicao(l3,c3))
        return false;
    if (this.tabDoJogo.getMarcaNaPosicao(l1,c1).equals(
        this.tabDoJogo.getMarcaNaPosicao(l2,c2)) &&
        this.tabDoJogo.getMarcaNaPosicao(l1,c1).equals(
        this.tabDoJogo.getMarcaNaPosicao(l3,c3)))
        return true;
    return false;
    }


    public Marca getMarcaDoVencedor () throws Exception
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

    private boolean tabuleiroCheio () throws Exception
    {
        // verificar se todas as posicoes do
        // tabuleiro estao preenchidas (!=null)
        // retornando true em caso afirmativo,
        // ou false em caso negativo
        return this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.haMarcaNaPosicao(0,2) 
        && this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.haMarcaNaPosicao(1,2) 
        && this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.haMarcaNaPosicao(2,2); 
    }

    public boolean fimDeJogo () throws Exception
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
