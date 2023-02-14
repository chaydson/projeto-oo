package model;

import java.util.Date;

public class Secretario extends FuncionarioComBeneficio {

    public Secretario(String nome, String cargo, Double salario, Date dataContratacao) {
        super(nome, cargo, salario, dataContratacao);
    }

    @Override
    public Double getBeneficio() {
        return 1.2;
    }

    @Override
    public Double calcularSalarioComBeneficio(Date data){
        Double salario = (7000.0 + 1000.0*(dataContratacao.getTime() - data.getTime())) * getBeneficio();
        return salario;
    }

    @Override
    public Double calcularSalarioSemBeneficio(Date data){
        Double salario = (7000.0 + 1000.0*(dataContratacao.getTime() - data.getTime()));
        return salario;
    }

    @Override
    public Double calcularBeneficio(Date data){
        return calcularSalarioSemBeneficio(data) * (getBeneficio() - 1);
    }
}
