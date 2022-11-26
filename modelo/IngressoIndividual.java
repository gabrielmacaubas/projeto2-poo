package modelo;

public class IngressoIndividual extends Ingresso {
    private Jogo jogo;

    public IngressoIndividual(int codigo){
        super(codigo);
    }

    @Override
    public int getCodigo() {
        return super.getCodigo();
    }

    public void setJogo(Jogo jog) {
        jog.setEstoque(jog.getEstoque() - 1);
        jogo = jog;
    }

    @Override
    public double calcularValor() {
        return (1.2 * jogo.getPreco());
    }

	public String toString() {
		return super.toString() + ", jogo=" + jogo.getId();
    }
}
