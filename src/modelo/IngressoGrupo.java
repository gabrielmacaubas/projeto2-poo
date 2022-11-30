package modelo;

import java.util.ArrayList;

public class IngressoGrupo extends Ingresso {
    private ArrayList<Jogo> Jogos = new ArrayList<Jogo>();

    public IngressoGrupo(int codigo){
        super(codigo);
    }

    public int getCodigo() {
        return super.getCodigo();
    }

    public void adicionar(Jogo jog){
        jog.setEstoque(jog.getEstoque() - 1);
        Jogos.add(jog);
    }

    @Override
    public double calcularValor() {
        double soma = 0;

        for (Jogo j : Jogos) {
            soma = soma + j.getPreco();
        }

        soma = soma * 0.9;
        
        return soma; 
    }

    @Override
	public String toString() {
        String ids = "";

        for(Jogo j : Jogos) {
            ids = ids + j.getId() +",";
        }

		return  super.toString() + ", jogos:" + ids;
    }
}
