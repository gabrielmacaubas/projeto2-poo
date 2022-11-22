package modelo;

import java.util.ArrayList;

public class IngressoGrupo extends Ingresso {
    private ArrayList<Jogo> Jogos = new ArrayList<Jogo>();

    public IngressoGrupo(int codigo){
        super(codigo);
    }

    @Override
    public double calcularValor() {
        double soma = 0;

        for (Jogo j : Jogos) {
            soma = soma + j.preco;
        }

        soma = soma * 0.9;
        
        return soma; 
    }

    public void adicionar(Jogo jog){
        jog.estoque = jog.estoque - 1;
        Jogos.add(jog);
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }
    @Override
	public String toString() {
        String ids = "";

        for(Jogo j : Jogos) {
            ids = ids + j.id +",";
        }

		return  super.toString() + ", jogos:" + ids;
    }
}
