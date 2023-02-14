package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class FuncionarioBase {
    String nome;
    String cargo;
    Double salario;
    String dataContratacao;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
    Calendar calendar = Calendar.getInstance();

    public FuncionarioBase(String nome, String cargo, Double salario, String dataContratacao) {
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

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Double calcularSalarioComBeneficio(String data) throws ParseException {
        Double salario = 0.0;
        return salario;
    }

    public Double calcularSalarioSemBeneficio(String data) throws ParseException {
        Double salario = 0.0;
        return salario;
    }
}
