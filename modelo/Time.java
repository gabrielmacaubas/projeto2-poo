package modelo;

import java.util.ArrayList;

public class Time {
    public String nome;
    private String origem;

    private ArrayList<Jogo> jogos = new ArrayList<Jogo>();

    public Time(String nome, String origem) {
        this.nome = nome;
        this.origem = origem;
    }

    public void adicionar(Jogo jog) {
        jogos.add(jog);
    }

    public double obterValorArrecadado() {
        double soma = 0;

        for(Jogo j : jogos) {
            soma = soma + j.obterValorArrecadado();
        }

        return soma;
    }

    public String toString() {
        String jogos_string = "";

        for(Jogo j : jogos) {
            jogos_string = jogos_string + " " + j.id + "=" + j.data + "," + j.local;
        }

        return "\nnome=" + this.nome + ", origem=" + this.origem +
               "\njogos: " + jogos_string;
    }

}
