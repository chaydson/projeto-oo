package model;

import java.util.Date;

public abstract class FuncionarioBase {
    String nome;
    String cargo;
    Double salario;
    Date dataContratacao;

    public FuncionarioBase(String nome, String cargo, Double salario, Date dataContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Double calcularSalarioComBeneficio(Date data){
        Double salario = 0.0;
        return salario;
    }

    public Double calcularSalarioSemBeneficio(Date data){
        Double salario = 0.0;
        return salario;
    }
}
