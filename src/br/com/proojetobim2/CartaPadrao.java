package br.com.proojetobim2;

// TEMA PADRÃO
// NENHUM VALOR É ALTERADO
public class CartaPadrao extends Carta{
	
	@Override
	public int calculaResultadoDaCarta() {
		// CALCULA VALOR TOTAL DA CARTA SEM ALTERAÇÃO DE VALORES
		
    	return (this.getValorCarta() * this.getValorNaipe());
    }

	@Override
	public String getCalculoDoBaralho() {
		// DEVOLVE UMA MENSAGEM COMUM DO CALCULO DO BARALHO
		
		return (this.getValorCarta() + " * " + this.getValorNaipe() + " = " + this.calculaResultadoDaCarta());
	}
	
}
