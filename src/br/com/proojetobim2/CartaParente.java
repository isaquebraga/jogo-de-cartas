package br.com.proojetobim2;

// TEMA PARENTE
// TODAS AS CARTAS COM VALORES PRIMOS SÃO MULTIPLICADOS POR TRÊS
public class CartaParente extends Carta {
	
	private int multiplicador;

	@Override
	public int calculaResultadoDaCarta() {
		// VERIFICA SE UM NÚMERO É PRIMO E CALCULA O VALOR BASEADO EM UM MULTIPLICADOR
		// TODOS OS NÚMEROS SÃO PRIMOS ATÉ QUE O FOR LOOP PROVE AO CONTRÁRIO
		// CASO O NÚMERO SEJA PRIMO, O this.multiplicador PASSA A SER 3
		// CASO CONTRÁRIO, PASSA A SER APENAS 1
		
		boolean primo = true;
		
		for(int i = 2; i <= this.getValorCarta()/2; i++) {
			if(this.getValorCarta() % i == 0) {
				primo = false;
				break;
			}
		}
		
		if(!primo || (this.getValorCarta() == 1)) {
			this.multiplicador = 1;
		}
		else {
			this.multiplicador = 3;
		}
		
		return ((this.getValorCarta() * this.multiplicador) * this.getValorNaipe());
	}
	
	@Override
	public String getCalculoDoBaralho() {
		// SE O MULTIPLICADOR FOR 3 (indicação que é um primo), A MENSAGEM TERÁ UM MULTIPLICADOR A MAIS
		// CASO CONTRÁRIO, A MENSAGEM SERÁ COMUM
		
		if(this.multiplicador == 3) {
			return (this.getValorCarta() + " * " + this.multiplicador + " * " + this.getValorNaipe() + " = " + this.calculaResultadoDaCarta());
		}
		else {
			return (this.getValorCarta() + " * " + this.getValorNaipe() + " = " + this.calculaResultadoDaCarta());
		}
	}
}
