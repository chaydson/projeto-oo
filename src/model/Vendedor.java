package model;

import java.util.Date;
import java.util.List;

public class Vendedor extends FuncionarioComBeneficio {
    private List<Venda> vendas;
    public Vendedor(String nome, String cargo, Double salario, Date dataContratacao) {
        super(nome, cargo, salario, dataContratacao);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public Double getBeneficio(){
        return 1.3;
    }

    @Override
    public Double calcularSalarioComBeneficio(Date data){
        Double valorVendas = 0.0;
        for (Venda v: vendas)
            if(v.getData().equals(data))
                valorVendas += v.getValor();

        Double salario = (12000.0 + 1800.0*(dataContratacao.getTime() - data.getTime())) +
                getBeneficio() * valorVendas;
        return salario;
    }

    public Double calcularSalarioSemBeneficio(Date data){
        Double salario = 12000.0 + 1800.0*(dataContratacao.getTime() - data.getTime());
        return salario;
    }


    @Override
    public Double calcularBeneficio(Date data){
        return calcularSalarioComBeneficio(data) - calcularSalarioSemBeneficio(data);
    }
}
