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
            try{
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
            }catch(Exception e){
                System.out.println("Resposta Invalida, digite novamente.");
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
            try{
                System.out.println("Digite a linha (0 a 2): ");
                byte linha = Teclado.getUmByte();

                System.out.println("Digite a coluna (0 a 2)");
                byte coluna = Teclado.getUmByte();

                //Validacao:
                if(linha > 2 || linha < 0 || coluna > 2 || coluna < 0){
                    System.out.println("Coordenadas fora dos limites do tabuleiro. Tente novamente.");
                }
                else if(this.tabDoJogo.haMarcaNaPosicao(linha, coluna)){
                    System.out.println("Esta posição já está ocupada. Escolha outra.");
                }
                else{
                    this.tabDoJogo.setMarcaNaPosicao(this.marca, linha, coluna);
                    jogadaValida = true;
                }
            }catch(Exception e){
                System.out.println("Entrada inválida. Digite apenas números inteiros.");
            }
        } while(!jogadaValida);
    }

    public void vcGanhou ()
    {
        System.out.println("Parabens, temos um vencedor!");
    }

    public void vcPerdeu ()
    {
        System.out.println("Vish, voce perdeu!");
    }

    public void deuVelha ()
    {
        System.out.println("Puts, deu Velha!");
    }

    public boolean querMaisUmaPartida ()
    {
        // perguntar se deseja jogar de novo
        // permitindo digitacao e retornando
        // true ou false, conforme a resposta
        char resp = ' ';
        boolean respValida = false;
        do { 
            try{
                System.out.println("Deseja jogar outra partida? (S/N)");
                resp = Teclado.getUmChar();

                if(resp == 'S' || resp == 's' || resp == 'N' || resp == 'n'){
                    respValida = true;
                }
                else{
                    System.out.println("Resposta invalida, responda apenas com S ou N");
                }
            }
            catch(Exception e){
                System.out.println("Entrada inválida.");
            }

        } while (!respValida);

        return (resp == 'S' || resp == 's');
    }
}