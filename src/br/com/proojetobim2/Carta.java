package br.com.proojetobim2;

import java.util.Random;

// CLASSE ONDE A CARTA É GERADA E
// ONDE TODAS AS INFORMAÇÕES DAS CARTAS SÃO GUARDADAS
// OBS: É UMA CLASSE ABSTRATA POIS UMA CARTA SIMPLES NÃO PODE SER PUXADA
// UMA CARTA OBRIGATORIAMENTE TEM QUE PERTENCER A UM TEMA
public abstract class Carta {
    
	// nome do baralho juntando nome (ou numero) da carta e naipe
	private String nomeBaralho;
	
	// valores
	private int valorCarta;
	private int valorNaipe;
	
	
	public String getNomeBaralho() {
		// GETTER DO NOME DO BARALHO
		
		return this.nomeBaralho;
	}

	public int getValorCarta() {
		// GETTER DO VALOR DA CARTA
		
		return this.valorCarta;
	}

	public int getValorNaipe() {
		// GETTER DO VALOR DO NAIPE
		
		return this.valorNaipe;
	}

	private int geraNumeroAleatorio(int maxNum, int minNum) {
		// GERA UM NÚMERO ALEATÓRIO NO ALCANCE DEFINIDO PELO DESENVOLVEDOR
		
		Random ran = new Random();
		int valorBaralho = (ran.nextInt(maxNum) + minNum);
		
		return valorBaralho;
	}
	
	private int recebeCarta() {
		// USA MÉTODO geraNumeroAleatorio PARA GERAR UM NÚMERO DE CARTA
		
		int carta = this.geraNumeroAleatorio(13, 1);
		return carta;
	}

    private int recebeNaipe() {
    	// USA MÉTODO geraNumeroAleatorio PARA GERAR UM NÚMERO DE NAIPE
    	
    	int naipe = this.geraNumeroAleatorio((5 - 1), 2);
        return naipe;
    }

    public Carta devolveCarta() {
    	// GERA UMA STRING BASEADA NO NÚMERO DA CARTA E DO NAIPE
    	// E JUNTA NO ATRIBUTO nomeBaralho
    	// DEVOLVE O OBJETO EM SI PARA TOTAL MANIPULAÇÃO PARA O JOGADOR

        this.valorCarta = recebeCarta();
        this.valorNaipe = recebeNaipe();
        
        String nomeNaipe;
        String nomeCarta;
        
        // NAIPE EM STRING
        if (this.valorNaipe == 2) {
        	nomeNaipe = "Paus";
        }
        else if (this.valorNaipe == 3) {
            nomeNaipe = "Ouros";
        }
        else if (this.valorNaipe == 4) {
            nomeNaipe = "Copas";
        }
        else {
            nomeNaipe = "Espadas";
        }

        // CARTA EM STRING
        if (this.valorCarta == 1) {
            nomeCarta = "Ás";
        }
        else if (this.valorCarta == 11) {
            nomeCarta = "Valete";
        }
        else if (this.valorCarta == 12) {
            nomeCarta = "Dama";
        }
        else if (this.valorCarta == 13) {
            nomeCarta = "Rei";
        }
        else {
            nomeCarta = this.valorCarta + "";
        }
        
        this.nomeBaralho = nomeCarta + " de " + nomeNaipe;
        
        return this;
    }
    
    // MÉTODOS ABSTRATOS QUE PRECISAM SER IMPLEMENTADOS EM TEMAS ESPECÍFICOS    
    public abstract int calculaResultadoDaCarta();
    
    public abstract String getCalculoDoBaralho();
}
