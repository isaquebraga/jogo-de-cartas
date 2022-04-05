package br.com.proojetobim2;

import java.util.Scanner;

// CLASSE PARA ARMAZENAR INFORMAÇÕES DO JOGADOR
public class Jogador {
    // ATRIBUTO ESTÁTICO QUE GUARDA QUANTOS JOGADORES FORAM REGISTRADOS
    private static int quantidadeJogadoresCadastrados = 0;
    private static int quantidadeMaximaDeJogadores = 2;
    
    // ATRIBUTOS
    private String nomeJogador;
    private Carta cartaDoJogador;
    private int pontuacaoRodadaJogador = 0;
    private int pontuacaoTotalJogador = 0;

    Jogador() {
    	// CONSTRUTOR DE ENTRADA (DEFAULT)
    	
        Scanner inputJogador = new Scanner(System.in);
        Jogador.quantidadeJogadoresCadastrados++;
        
        System.out.print("Digite o nome do jogador " + quantidadeJogadoresCadastrados + ": ");
        this.nomeJogador = inputJogador.nextLine();

        if (Jogador.quantidadeJogadoresCadastrados == Jogador.quantidadeMaximaDeJogadores) {
            inputJogador.close();
        }
    }

    Jogador(String nome) {
    	// CONSTRUTOR SEM LEITOR DE ENTRADA (PARA TESTES)
    	
        this.nomeJogador = nome;
    }
    
    public static int getQuantidadeJogadoresCadastrados() {
    	// GETTER PARA QUANTIDADE DE JOGADORES CADASTRADOS
    	
    	return Jogador.quantidadeJogadoresCadastrados;
    }

    public String getNomeJogador() {
    	// GETTER PARA NOME DO JOGADOR
    	
        return this.nomeJogador;
    }
    
    public Carta getCartaDoJogador() {
    	// GETTER PARA CARTA DO JOGADOR
    	
		return cartaDoJogador;
	}
    
    public int getPontuacaoRodadaJogador() {
    	// GETTER DA PONTUAÇÃO DA RODADA
    	
        return this.pontuacaoRodadaJogador;
    }
    
    public int getPontuacaoTotalDoJogador() {
    	// GETTER DA PONTUAÇÃO TOTAL DO JOGADOR
    	
        return this.pontuacaoTotalJogador;
    }
    
    public static void setQuantidadeMaximaDeJogadores(int quantidade) {
    	// SETTER PARA A QUANTIDADE MÁXIMA DE JOGADORES
    	// QUE PODE SER MODIFICADA DEPENDENDO DA ESCOLHA DO USUÁRIO
    	// MAS NÃO PASSARÁ DE 4
    	
    	Jogador.quantidadeMaximaDeJogadores = quantidade;
    }
    
    public void setPontuacaoRodadaJogador(int novaRodada) {
    	// SETTER DA PONTUAÇÃO DA RODADA, QUE DEFINE O VALOR
        // DA RODADA DO JOGADOR E INCREMENTA NO VALOR TOTAL
    	
        this.pontuacaoRodadaJogador = novaRodada;
        
        incrementaPontuacao(novaRodada);
    }

    public void incrementaPontuacao(int pontuacao) {
    	// MÉTODO QUE INCREMENTA A PONTUAÇÃO TOTAL DO JOGADOR
    	
        this.pontuacaoTotalJogador += pontuacao;
    }
    
    public void puxaCarta(Carta temaBaralho) {
    	// PUXA UMA CARTA PARA O JOGADOR EM QUESTÃO
    	// E ARMAZENA NA VARIÁVEL DE CARTA DO JOGADOR
    	
		this.cartaDoJogador = temaBaralho.devolveCarta();
    }
    
}
