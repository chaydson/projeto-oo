package model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Vendedor extends FuncionarioComBeneficio {
    private List<Venda> vendas;
    public Vendedor(String nome, String cargo, Double salario, String dataContratacao, List<Venda> vendas) {
        super(nome, cargo, salario, dataContratacao);
        this.vendas = vendas;
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
    public Double calcularSalarioComBeneficio(String data) throws ParseException {
        Double valorVendas = 0.0;
        for (Venda v: vendas)
            if(v.getData().equals(data))
                valorVendas += v.getValor();

        Date dateParams = simpleDateFormat.parse(data);
        Calendar calendarParams = Calendar.getInstance();
        calendarParams.setTime(dateParams);

        Date dateObj = simpleDateFormat.parse(getDataContratacao());
        calendar.setTime(dateObj);

        Double salario = (12000.0 + 1800.0*(calendar.get(Calendar.YEAR) - calendarParams.get(Calendar.YEAR))) +
                getBeneficio() * valorVendas;
        return salario;
    }

    public Double calcularSalarioSemBeneficio(String data) throws ParseException {
        Date dateParams = simpleDateFormat.parse(data);
        Calendar calendarParams = Calendar.getInstance();
        calendarParams.setTime(dateParams);

        Date dateObj = simpleDateFormat.parse(getDataContratacao());
        calendar.setTime(dateObj);
        Double salario = 12000.0 + 1800.0*(calendar.get(Calendar.YEAR) - calendarParams.get(Calendar.YEAR));
        return salario;
    }


    @Override
    public Double calcularBeneficio(String data) throws ParseException {
        return calcularSalarioComBeneficio(data) - calcularSalarioSemBeneficio(data);
    }
}
