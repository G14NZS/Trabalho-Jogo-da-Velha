package jogador;

import uteis.Teclado;
import jogo.Marca;
import jogo.Tabuleiro;
import java.io.*;

public class JogadorHumano implements Jogador
{
    private Marca          marca     = null;
    private Tabuleiro      tabDoJogo = null;

    public JogadorHumano (Tabuleiro tab) throws Exception
    {
        if(tab == null) throw new Exception("Tabuleiro Nulo");
        // atribuir tab para tabDoJogo
        this.tabDoJogo = tab;
        // pedir para o jogador escolher
        // sua marca e permitir digitacao
        // intanciando marca
        boolean respValida = false;
        do{
            System.out.println("Escolha seu marcador (X/O): ");
            char resp  = Teclado.getUmChar();

            if(resp == 'X' || resp == 'x'){
                marca = new Marca('X');
                respValida = true;
            }
            else if(resp == 'O' || resp == 'o'){
                marca = new Marca('O');
                respValida = true;
            }
            else{
                System.out.println("Marcador Invalido! Tente novamente.");
            }
        } while(!respValida);
    }

    public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
    {
        if(tab == null || mrc == null) throw new Exception("Resposta Nula");
        // atribuir tab para tabDoJogo
        this.tabDoJogo = tab;
        // e mrc para marca
        this.marca = mrc;
    }

    public Marca getMarca ()
    {
        // retorna a marca do jogador
        return this.marca;
    }

    public void facaSuaJogada ()
    {
        // pergunta para o jogador onde ele quer
        // jogar, permitindo digitacao e chamando
        // os métodos apropriados de tabDoJogo
        boolean jogadaValida = false;

        do{
            System.out.printlh("Digite a Coordenada daa linha (Horizontal): ");
            byte resp1 = Teclado.getUmByte();

            if(resp1 )

        } while(!jogadaValida)
    }

    public void vcGanhou ()
    {
        // mostra mensagem indicando vitoria
    }

    public void vcPerdeu ()
    {
        // mostra mensagem indicando derrota
    }

    public void deuVelha ()
    {
        // mostra mensagem indicando empate
    }

    public boolean querMaisUmaPartida ()
    {
        // perguntar se deseja jogar de novo
        // permitindo digitacao e retornando
        // true ou false, conforme a resposta
    }
}