
package implem_threads;


public class Implem_threads {
	final static int NUM_PESSOA = 5;	
	final static int DISTANCIA = 500;      
	public static void main (String[] args) {
		for (int i = 1; i <= NUM_PESSOA; i++) {
			new PessoaCorrendoThread("Pessoa_" + i, DISTANCIA).start();
		}
	}
}
