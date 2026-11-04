package jogo;

public class Tabuleiro implements Cloneable
{
    private Marca matriz [][] = new Marca [3][3];

    public Tabuleiro ()
    {
    }

    private static void valideCoordenadas (int lin, int col) throws Exception
    {
        if (lin < 0 || lin > 2 || col < 0 || col > 2)
            throw new Exception ("Valores lin ou col invalido");
    }

    public boolean haMarcaNaPosicao (int lin, int col) throws Exception
    {
        // verifico se em matriz[lin][col]
        // tem null, retornando false em caso
        // afirmativo, ou true em caso negativo
        // dar excecao caso lin ou col invalido
        valideCoordenadas(lin, col);

        return this.matriz[lin][col] != null;
    }

    public Marca getMarcaNaPosicao (int lin, int col) throws Exception
    {
        // retornar a marca que tem em
        // matriz[lin][col]
        // dar excecao caso lin ou col invalido
        valideCoordenadas(lin, col);

        return this.matriz[lin][col];
    }

    public void setMarcaNaPosicao (Marca mrc, int lin, int col) throws Exception
    {
        // colocar mrc em matriz[lin][col],
        // dar excecao caso lin ou col invalido
        // dar excecao caso mrc seja null
        if (mrc == null)
            throw new Exception ("Marca nula");

        valideCoordenadas (lin, col);

        if (this.matriz[lin][col] != null)
            throw new Exception ("Posicao ja ocupada");

        this.matriz[lin][col] = mrc;
    }

    @Override
    public String toString ()
    {
        // return matriz[0][0] + " | " + matriz [0][1] + " | " + matriz[0][2] + "\n" +
        //                           "-----------\n" +
        //        matriz[1][0] + " | " + matriz [1][1] + " | " + matriz[1][2] + "\n" +
        //                           "-----------\n" +
        //        matriz[2][0] + " | " + matriz [2][1] + " | " + matriz[2][2];
        return (matriz[0][0] == null ? " " : matriz[0][0]) + " | " +
           (matriz[0][1] == null ? " " : matriz[0][1]) + " | " +
           (matriz[0][2] == null ? " " : matriz[0][2]) + "\n" +
           "-----------\n" +
           (matriz[1][0] == null ? " " : matriz[1][0]) + " | " +
           (matriz[1][1] == null ? " " : matriz[1][1]) + " | " +
           (matriz[1][2] == null ? " " : matriz[1][2]) + "\n" +
           "-----------\n" +
           (matriz[2][0] == null ? " " : matriz[2][0]) + " | " +
           (matriz[2][1] == null ? " " : matriz[2][1]) + " | " +
           (matriz[2][2] == null ? " " : matriz[2][2]);
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Tabuleiro tabu = (Tabuleiro)obj;

        for (int lin = 0; lin < 3; lin++)
            for (int col = 0; col < 3; col++)
            {
                if (this.matriz[lin][col] == null)
                {
                    if (tabu.matriz[lin][col] != null) return false;
                }
                else if (!this.matriz[lin][col].equals(tabu.matriz[lin][col])) return false;
            }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 7;

        for (int lin = 0; lin < 3; lin++)
            for (int col = 0; col < 3; col++)
                if (this.matriz[lin][col] != null)
                    hash = hash*2 + this.matriz[lin][col].hashCode();
                else
                    hash = hash*2;

        if (hash < 0) hash = -hash;

        return hash;
    }

    // construtor de copia
    public Tabuleiro (Tabuleiro modelo) throws Exception
    {
        if (modelo == null) throw new Exception ("Modelo ausente");

        this.matriz = new Marca [3][3];

        for (int lin = 0; lin < 3; lin++)
            for (int col = 0; col < 3; col++)
                this.matriz[lin][col] = modelo.matriz[lin][col]; // Marca e imutavel, pode compartilhar
    }

    @Override
    public Object clone ()
    {
        Tabuleiro retorno = null;

        try
        {
            retorno = new Tabuleiro (this);
        }
        catch (Exception erro)
        {} // nao acontece, pois this nunca e null

        return retorno;
    }
}
