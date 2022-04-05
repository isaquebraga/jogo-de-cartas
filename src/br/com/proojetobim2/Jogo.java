package br.com.proojetobim2;

import java.util.Scanner;

// CLASSE DE ESTRUTURAÇÃO DO JOGO DE CARTAS
// ONDE SÃO ARMAZENADOS AS INFORMAÇÕES E
// É FEITO O CONTROLE DO JOGO EM SI
public class Jogo {
	
	private Scanner input = new Scanner(System.in);
	
	// lista de jogadores até 4
	private Jogador[] jogadores = new Jogador[4];
	
	// número de rodadas (padrão: 3)
	private int rodadas = 3;
	
	// tema do baralho (padrão: Padrão)
	private Carta temaBaralho = new CartaPadrao();
	
	
	private int perguntaInt(String texto) {
		// MÉTODO PARA PERGUNTAR INTEIROS (PARA NÚMERO DE RODADAS
		// OU NÚMERO DE JOGADORES
		
		System.out.print(texto);
		int inteiro = this.input.nextInt();
		this.input.nextLine(); // para receber o /n que sobra do nextInt()
		
		return inteiro;
	}
	
	private int verificaInt(int entrada, int deInt, int paraInt) {
		// MÉTODO QUE VERIFICA INTEGRIDADE DO INTEIRO ATRIBUIDO EM perguntaInt()
		// SE O INTEIRO NÃO ESTIVER ERRADO, ENTÃO O MÉTODO APENAS RETORNARÁ O VALOR
		// NÃO MODIFICADO DE VOLTA
		
		while (entrada < deInt || entrada > paraInt) {
	        entrada = this.perguntaInt("Número inválido. Digite novamente: ");
	    }
		
		return entrada;
	}
	
	public void perguntaQuantidadeRodadas() {
		// PERGUNTA QUANTAS RODADAS O USUÁRIO QUER
		// SE O MÉTODO NÃO FOR CHAMADO, O PADRÃO SERÁ DE 3 RODADAS
		
		int quantidadeRodadas;
		quantidadeRodadas = this.perguntaInt("Número de rodadas (min: 3, max: 5): ");
	    quantidadeRodadas = this.verificaInt(quantidadeRodadas, 3, 5);
	    
	    this.rodadas = quantidadeRodadas;
	}
	
	public void cadastraJogadores() {
		// PERGUNTA QUANTOS JOGADORES VÃO JOGAR
		// E CRIA OS OBJETOS DOS JOGADORES DINAMICAMENTE
		// COLOCANDO-OS NA ARRAY this.jogadores
		
		int quantosJogadores;
		quantosJogadores = this.perguntaInt("Quanto jogadores vão jogar (min: 2, max: 4): ");
		quantosJogadores = this.verificaInt(quantosJogadores, 2, 4);
		Jogador.setQuantidadeMaximaDeJogadores(quantosJogadores);
		
		for(int i = 0; i < quantosJogadores; i++) {
			this.jogadores[i] = new Jogador();
		}
	}
	
	private void calculaPontuacaoBonus(Jogador[] colocacaoArray) {
		// CALCULA PONTOS BONUS DOS JOGADORES
		// E IMPRIME NO FINAL DA PARTIDA
		
		System.out.println("Nesta rodada: ");
		
        for(int index = 0; index < Jogador.getQuantidadeJogadoresCadastrados(); index++) {
        	if(colocacaoArray[index] == null) {
        		break;
        	}
        	int incremento = (Jogador.getQuantidadeJogadoresCadastrados() - index);
        	colocacaoArray[index].incrementaPontuacao(incremento);
        	
        	System.out.println(colocacaoArray[index].getNomeJogador() + " ganhou " + incremento + " pontos");
        }
	}
	
	private Jogador[] comparaPontosNoFinalDaRodada() {
		// COMPARA OS PONTOS DE TODOS OS JOGADORES EM CADA RODADA DE FORMA DINAMICA
		// E IMPRIME NA TELA
		// OBS: NÃO CONSEGUI PENSAR EM UMA FORMA DE NÃO REPETIR O CÓDIGO
		// POIS comparaPontosNoFinalDaRodada() e calculaVencedor() SÃO IGUAIS
		// MAS A ÚNICA COISA QUE MUDA SÃO MÉTODOS
		// E NÃO ACHEI UMA FORMA FÁCIL DE PASSAR MÉTODOS COMO PARÂMETROS
		
		// cria array para colocação, que é do tamanho da array this.jogadores
		Jogador[] colocacao = new Jogador[this.jogadores.length]; 
		
		// loop para colocação
        for(int i = 0; i < Jogador.getQuantidadeJogadoresCadastrados(); i++) {
        	
        	// loop para todos os jogadores a cada uma posição da colocação
        	for(int j = 0; j < Jogador.getQuantidadeJogadoresCadastrados(); j++) {
        		// para verificar se jogador já está na colocação
        		boolean jogadorEmColocacaoI = false;
        		
        		for(Jogador c : colocacao) {
        			if(c == null) {
        				break;
        			}
        			
        			if(this.jogadores[j] == c) {
        				// se atual jogador j estiver na colocação ele será desconsiderado
        				jogadorEmColocacaoI = true;
        			}
        		}
        		// o motivo disso é que se o jogador já estiver no vetor
        		// e acabar sendo o com maior pontos
        		// ele acabará sobrescrevendo todos os outros jogadores em todas as posições
        		
        		if(!jogadorEmColocacaoI) {
        			
	        		if(colocacao[i] == null) {
	        			// se atual colocação for vazia, coloca o primeiro jogador que aparecer
	            		colocacao[i] = this.jogadores[j];
	            	}
	            	else if(this.jogadores[j].getPontuacaoRodadaJogador() > colocacao[i].getPontuacaoRodadaJogador()) {
	            		// se a atual posição da colocação não estiver vazia e
	            		// o atual jogador tiver maior pontuação que o jogador que já está ocupando esse lugar
	            		// então o atual passará a ser o dono da posição da colocação
	        			colocacao[i] = this.jogadores[j];
	            	}
            	}
        		else {
        			continue;
        		}
        	}
        }
        
        return colocacao;
    }
	
	private void calculaVencedor() {
		// COMPARA A POSIÇÃO FINAL DOS JOGADORES
		// E IMPRIME NA TELA
		// OBS: NÃO CONSEGUI PENSAR EM UMA FORMA DE NÃO REPETIR O CÓDIGO
		// POIS comparaPontosNoFinalDaRodada() e calculaVencedor() SÃO IGUAIS
		// MAS A ÚNICA COISA QUE MUDA SÃO MÉTODOS
		// E NÃO ACHEI UMA FORMA FÁCIL DE PASSAR MÉTODOS COMO PARÂMETROS
		
		// cria array para colocação, que é do tamanho da array this.jogadores
		Jogador[] colocacaoFinal = new Jogador[this.jogadores.length]; 
		
		// loop para colocação
        for(int i = 0; i < Jogador.getQuantidadeJogadoresCadastrados(); i++) {
        	
        	// loop para todos os jogadores a cada uma posição da colocação
        	for(int j = 0; j < Jogador.getQuantidadeJogadoresCadastrados(); j++) {
        		// para verificar se jogador já está na colocação
        		boolean jogadorEmColocacaoI = false;
        		
        		for(Jogador c : colocacaoFinal) {
        			if(c == null) {
        				break;
        			}
        			
        			if(this.jogadores[j] == c) {
        				// se atual jogador j estiver na colocação ele será desconsiderado
        				jogadorEmColocacaoI = true;
        			}
        		}
        		// o motivo disso é que se o jogador já estiver no vetor
        		// e acabar sendo o com maior pontos
        		// ele acabará sobrescrevendo todos os outros jogadores em todas as posições
        		
        		if(!jogadorEmColocacaoI) {
        			
	        		if(colocacaoFinal[i] == null) {
	        			// se atual colocação for vazia, coloca o primeiro jogador que aparecer
	            		colocacaoFinal[i] = this.jogadores[j];
	            	}
	            	else if(this.jogadores[j].getPontuacaoTotalDoJogador() > colocacaoFinal[i].getPontuacaoTotalDoJogador()) {
	            		// se a atual posição da colocação não estiver vazia e
	            		// o atual jogador tiver maior pontuação que o jogador que já está ocupando esse lugar
	            		// então o atual passará a ser o dono da posição da colocação
	        			colocacaoFinal[i] = this.jogadores[j];
	            	}
            	}
        		else {
        			continue;
        		}
        	}
        }
        
		for(int c = 0; c < Jogador.getQuantidadeJogadoresCadastrados(); c++) {
			System.out.println(colocacaoFinal[c].getNomeJogador() + " ficou em " + (c + 1) + "° lugar com " + colocacaoFinal[c].getPontuacaoTotalDoJogador() + " pontos");
        }
    }
	
	public void escolheTipoBaralho() {
		// PERGUNTA QUAL O TEMA DE BARALHO QUE O USUÁRIO QUER
		// SE O MÉTODO NÃO FOR CHAMADO, O PADRÃO SERÁ O TEMA "PADRÃO"
		
		System.out.println("VAMOS COMEÇAR!\n");
		
		System.out.println("1) Padrão (sem modificações no baralho)");
		System.out.println("2) Naipe+ (os valores de todos os naipes são 1)");
		System.out.println("3) Parente (cartas (não naipes)\n   de números primos são multiplicados por 3)\n");
		
		int temaBaralho;
		temaBaralho = this.perguntaInt("Escolha o tipo de baralho para a rodada: ");
		temaBaralho = this.verificaInt(temaBaralho, 1, 3);
		
		if(temaBaralho == 2) {
			this.temaBaralho = new CartaNaipePlus();
		}
		else if(temaBaralho == 3) {
			this.temaBaralho = new CartaParente();
		}		
	}
	
	public void jogar() {
		// LOOP DO JOGO EM SI
		// CHAMA TODOS MÉTODOS E OBJETOS IMPORTANTES PARA O JOGO FUNCIONAR
		
		for(int rodada = 0; rodada < this.rodadas; rodada++) {
			for(Jogador j : this.jogadores) {
				if(j == null) {
					break;
				}
				
				int pontuacaoRodadaJogador;
				
				// jogador puxa a carta com o tema do jogo
				j.puxaCarta(this.temaBaralho);
				// baseado na carta que o jogador puxou, os pontos da rodada são calculados e inseridos
				pontuacaoRodadaJogador = j.getCartaDoJogador().calculaResultadoDaCarta();
				j.setPontuacaoRodadaJogador(pontuacaoRodadaJogador);
				
				System.out.println(j.getNomeJogador() + ": " + j.getCartaDoJogador().getNomeBaralho());
				System.out.println("Pontuação final da carta: " + j.getCartaDoJogador().getCalculoDoBaralho());
				System.out.println();
			}
			Jogador[] colocacaoPartida = this.comparaPontosNoFinalDaRodada();
			this.calculaPontuacaoBonus(colocacaoPartida);
			
			System.out.println();
		}
		
		this.calculaVencedor();
		
		this.input.close();
	}
}
