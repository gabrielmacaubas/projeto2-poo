package modelo;

public class IngressoIndividual extends Ingresso {
    private Jogo jogo;

    public IngressoIndividual(int codigo){
        super(codigo);
    }

    @Override
    public double calcularValor() {
        return (1.2 * jogo.preco);
    }

    public void setJogo(Jogo jog) {
        jog.estoque = jog.estoque - 1;
        jogo = jog;
    }
    
    @Override
    public int getCodigo() {
        return this.codigo;
    }

	public String toString() {
		return super.toString() + ", jogo=" + jogo.id;
    }
}
