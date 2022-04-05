package br.com.proojetobim2;

// TEMA NAIPE+
// TODOS OS NAIPES PASSAM A VALER 1
public class CartaNaipePlus  extends Carta {

	@Override
	public int calculaResultadoDaCarta() {
		// DEVOLVE O CALCULO DA CARTA, POREM O NAIPE VALE 1
		
		return (this.getValorCarta() * 1);
	}
	
	@Override
	public String getCalculoDoBaralho() {
		// DEVOLVE UMA MENSAGEM ONDE O NAIPE VALE 1
		
		return (this.getValorCarta() + " * 1 = " + this.calculaResultadoDaCarta());
	}
}
