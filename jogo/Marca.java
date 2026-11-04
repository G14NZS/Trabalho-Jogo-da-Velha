package jogo;


public class Marca
{
    private char simbolo;

    public Marca (char smb) throws Exception
    {
        // validar smb, garantindo que ele
        // seja 'X' ou 'O' e coloca-lo em
        // simbolo
        // dar excecao em caso de valor invalido
        if (smb != 'X' && smb != 'O')
            throw new Exception ("Simbolo invalido");

        this.simbolo = smb;
    }

    public char getSimbolo ()
    {
        return this.simbolo;
    }

    @Override
    public String toString ()
    {
        return ""+simbolo;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Marca mrc = (Marca)obj;

        if (mrc.simbolo != this.simbolo) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 7;

        hash = hash*2 + this.simbolo;

        if (hash < 0) hash = -hash;

        return hash;
    }
}
