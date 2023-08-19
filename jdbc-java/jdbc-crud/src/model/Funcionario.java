package model;

public class Funcionario {
    private int id;
    private String nome;
    private double horasTrabalhadas;
    private double horasValor;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getHorasTrabalhadas() {
        return this.horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getHorasValor() {
        return this.horasValor;
    }

    public void setHorasValor(double horasValor) {
        this.horasValor = horasValor;
    }

}