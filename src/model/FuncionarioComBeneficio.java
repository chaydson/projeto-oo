package model;

import java.util.Date;

public abstract class FuncionarioComBeneficio extends FuncionarioBase {
    private Double beneficio;
    public FuncionarioComBeneficio(String nome, String cargo, Double salario, Date dataContratacao) {
        super(nome, cargo, salario, dataContratacao);
    }

    public Double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Double beneficio) {
        this.beneficio = beneficio;
    }

    public Double calcularBeneficio(Date data){
        Double soma = 0.0;
        return soma;
    }
}
