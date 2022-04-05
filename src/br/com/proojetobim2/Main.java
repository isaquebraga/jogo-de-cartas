package br.com.proojetobim2;

// CLASSE PRINCIPAL
public class Main {
	
	public static void main(String[] args) {
		// MÉTODO ONDE A CLASSE JOGO É INSTANCIADA
		// E OS PARA JOGAR SÃO CHAMADOS
		
		Jogo novoJogo = new Jogo();
	    
		novoJogo.escolheTipoBaralho();
	    System.out.println();
	    novoJogo.perguntaQuantidadeRodadas();
	    System.out.println();
	    novoJogo.cadastraJogadores();
	    System.out.println();
	    
	    novoJogo.jogar();
	}
}