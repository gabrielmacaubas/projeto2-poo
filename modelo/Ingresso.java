package modelo;

public abstract class Ingresso {
    public int codigo;
    
    public Ingresso(int codigo) {
        super();
        this.codigo = codigo;
    }

    public abstract double calcularValor();
    
    public abstract int getCodigo();

    public String toString() {
        return "código=" + this.codigo;
    }
}
