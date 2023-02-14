package model;

import java.text.ParseException;
import java.util.Date;

public abstract class FuncionarioComBeneficio extends FuncionarioBase {
    private Double beneficio;
    public FuncionarioComBeneficio(String nome, String cargo, Double salario, String dataContratacao) {
        super(nome, cargo, salario, dataContratacao);
    }

    public Double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Double beneficio) {
        this.beneficio = beneficio;
    }

    public Double calcularBeneficio(String data) throws ParseException {
        Double soma = 0.0;
        return soma;
    }
}
