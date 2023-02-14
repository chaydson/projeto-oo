package model;

import java.util.Date;

public class Gerente extends FuncionarioBase {
    public Gerente(String nome, String cargo, Double salario, Date dataContratacao) {
        super(nome, cargo, salario, dataContratacao);
    }

    @Override
    public Double calcularSalarioComBeneficio(Date data){
        Double salario = 20000.0 + 3000.0*(dataContratacao.getTime() - data.getTime());
        return salario;
    }

    @Override
    public Double calcularSalarioSemBeneficio(Date data){
        return calcularSalarioComBeneficio(data);
    }
}
