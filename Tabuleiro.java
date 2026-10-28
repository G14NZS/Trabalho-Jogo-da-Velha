package jogo;

public class Tabuleiro implements Cloneable
{
    private Marca matriz [][] = new Marca [3][3];

    public boolean haMarcaNaPosicao (int lin, int col) throws Exception
    {
        if ((lin > 2 || lin < 0) || (col > 2 || col < 0)) {
            throw new Exception("Valores lin ou col invalido")
        }
        
        if(this.matriz[lin][col])
        // verifico se em matriz[lin][col]
        // tem null, retornando false em caso
        // afirmativo, ou true em caso negativo
        // dar excecao caso lin ou col invalido
    }

    public Marca getMarcaNaPosicao (int lin, int col) throws Exception
    {
        if ((lin > 2 || lin < 0) || (col > 2 || col < 0)) {
            throw new Exception("Valores lin ou col invalido")
        }
        
        return matriz[lin][col];
        
        // retornar a marca que tem em
        // matriz[lin][col]
        // dar excecao caso lin ou col invalido
    }

    public void setMarcaNaPosicao (Marca mrc, int lin, int col) throws Exception
    {
        if(mrc == null) {
            throw new Exception('Marca nula');
        }
        
        if ((lin > 2 || lin < 0) || (col > 2 || col < 0)) {
            throw new Exception("Valores lin ou col invalido")
        }
        
        // colocar mrc em matriz[lin][col],
        // dar excecao caso lin ou col invalido
        // dar excecao caso mrc seja null
    }

    @Override
    public String toString ()
    {
        return matriz[0][0] + " | " + matriz [0][1] + " | " + matriz[0][2] "\n"
                                  "-----------\n" 
               matriz[1][0] + " | " + matriz [1][1] + " | " + matriz[1][2] "\n"
                                  "-----------\n" 
               matriz[2][0] + " | " + matriz [2][1] + " | " + matriz[2][2];
    }

    @Override
    public boolean equals (Object obj)
    {
        if(obj == this) return true;
        if(obj == null) return false;
        if(obj.getClass()!=this.getClass()) return false;
        Tabuleiro tabu = (Tabuleiro)obj;
        if(!tabu.matriz.equals(this.matriz)) return false;
        
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 7
        
        hash = hash*2 + this.matriz.hashCode();
        
        if (hash<0) 
            hash = -hash;
            
        return hash;
    }

    // construtor de copia
    public Tabuleiro (Tabuleiro modelo) throws Exception
    {
        if (modelo==null) throw new Exception ("Modelo ausente");
        
        this.matriz = modelo.matriz;
    }

    @Override
    public Object clone ()
    {
        Tabuleiro retorno=null;

        try
        {
            retorno = new Tabuleiro (this);
        }
        catch (Exception erro)
        {}

        return retorno;
    }
}
