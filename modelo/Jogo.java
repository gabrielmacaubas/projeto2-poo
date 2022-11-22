package modelo;

import java.util.ArrayList;

public class Jogo {
    public int id;
    public String data; 
    public String local;
    public int estoque;
    public double preco;
    private Time time1;   
    private Time time2;
    private ArrayList<Ingresso> ingressos = new ArrayList<Ingresso>();

    public Jogo(int id, String data, String local, int estoque, double preco, Time time1, Time time2) {
        this.id = id;
        this.data = data;
        this.local = local;
        this.estoque = estoque;
        this.preco = preco;
        this.time1 = time1;
        this.time2 = time2;
    }

    public void adicionar(Ingresso ing) {
        ingressos.add(ing);
    }

    public double obterValorArrecadado() {
        double soma = 0;

        for (Ingresso i : ingressos) {
            soma = soma + i.calcularValor();
        }
        return soma;
    }
    
    public String toString(){
        String cod_ingressos = "";

        for(Ingresso i : ingressos) {
            cod_ingressos = cod_ingressos + i.getCodigo() + ",";
        }

        return "\nid=" + this.id + ", data=" + this.data + ", local=" + this.local + ", estoque=" + this.estoque + ", preco=" + this.preco + ", time1=" + this.time1.nome + " x " + "time2=" + this.time2.nome + "\ningressos:" + cod_ingressos;
    }
    
    
}
