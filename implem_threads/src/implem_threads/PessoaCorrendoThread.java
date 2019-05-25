
package implem_threads;


class PessoaCorrendoThread extends Thread {

	String nome;					
	int distanciaCorrida = 0;		
	int distanciaTotalCorrida;	
	int velocidade = 0,velAux = 0;					
	int velocidades = 0;					
	static int colocacao = 0;		
	final static int VELOCIDADE_MAXIMO = 50; 


	public PessoaCorrendoThread (String nome, int distanciaTotalCorrida) {
		super(nome);
		this.distanciaTotalCorrida = distanciaTotalCorrida;
		this.nome = nome;
	}
	public void PessoaImprimindoSituacao () {
		System.out.println("O " + nome +  " Correu " + velocidade + "km/h \t e já percorreu " +
							distanciaCorrida + "km");
	}
	public void PessoaCorreu() {
		velocidades++;
		velocidade = (int)(Math.random()* VELOCIDADE_MAXIMO);
                if(velAux < velocidade){
                    velAux = velocidade;
                }
		distanciaCorrida += velocidade;
		if (distanciaCorrida > distanciaTotalCorrida) {
			distanciaCorrida = distanciaTotalCorrida;
		}
	}
	public void PessoaDescansando () {
		yield();
	}
	public void colocacaoPessoa () {
		colocacao++;
		System.out.println(nome + " foi o " + colocacao + 
							"º colocado com " + velAux + " km/h");
	}
	public void run () {
		while (distanciaCorrida < distanciaTotalCorrida) {
			PessoaCorreu();
			PessoaImprimindoSituacao();
			PessoaDescansando();
		}
		colocacaoPessoa();
	}
}
