package controller;

import model.FuncionarioBase;
import model.FuncionarioComBeneficio;
import model.Venda;
import model.Vendedor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FuncionarioController {
    private List<FuncionarioBase> funcionariosBase =  new ArrayList<>();
    private List<FuncionarioComBeneficio> funcionariosComBeneficio = new ArrayList<>();
    private List<Vendedor> vendedores = new ArrayList<>();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
    private Calendar calendar = Calendar.getInstance();

    public FuncionarioController(List<FuncionarioBase> funcionariosBase,
                                 List<FuncionarioComBeneficio> funcionariosComBeneficio,
                                 List<Vendedor> vendedores) {
        this.funcionariosBase = funcionariosBase;
        this.funcionariosComBeneficio = funcionariosComBeneficio;
        this.vendedores = vendedores;
    }

    public List<FuncionarioBase> getFuncionariosBase() {
        return funcionariosBase;
    }

    public void setFuncionariosBase(List<FuncionarioBase> funcionariosBase) {
        this.funcionariosBase = funcionariosBase;
    }

    public List<FuncionarioComBeneficio> getFuncionariosComBeneficio() {
        return funcionariosComBeneficio;
    }

    public void setFuncionariosComBeneficio(List<FuncionarioComBeneficio> funcionariosComBeneficio) {
        this.funcionariosComBeneficio = funcionariosComBeneficio;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    // Um método que receba uma lista de funcionários,
    // mês e ano e retorne o valor total pago (salário e benefício) a esses funcionários no mês
    public Double valorTotalMensalDosSalariosComBeneficio(String data) throws ParseException {
        Double soma = 0.0;
        for (FuncionarioBase fb: funcionariosBase)
            soma += fb.calcularSalarioComBeneficio(data);

        return soma;
    }

    // Um método que receba uma lista de funcionários,
    // mês e ano e retorne o total pago somente em salários no mês.
    public Double valorTotalMensalDosSalariosSemBeneficio(String data) throws ParseException {
        Double soma = 0.0;
        for (FuncionarioBase fb: funcionariosBase)
            soma += fb.calcularSalarioSemBeneficio(data);
        return soma;
    }

    // Um método que receba uma lista somente com os funcionários que recebem benefícios,
    // mês e ano e retorne o total pago em benefícios no mês.
    public Double valorTotalMensalDosBeneficios(String data) throws ParseException {
        Double soma = 0.0;
        for (FuncionarioComBeneficio fcb: funcionariosComBeneficio)
            soma += fcb.calcularBeneficio(data);
        return soma;
    }

    // Um método que receba uma lista de funcionários,
    // mês e ano e retorne o que recebeu o valor mais alto no mês.
    public String salarioMaisAlto(String data) throws ParseException {
        Double soma = 0.0, maior = 0.0;
        String funcionario = "";
        for (FuncionarioBase fb: funcionariosBase) {
            soma += fb.calcularSalarioComBeneficio(data);
            if(soma > maior){
                maior = soma;
                funcionario = fb.getNome();
            }
        }
        return funcionario;
    }

    // Um método que receba uma lista somente com os funcionários que recebem benefícios,
    // mês e ano e retorne o nome do funcionário que recebeu o valor mais alto em benefícios no mês.
    public String beneficioMaisAlto(String data) throws ParseException {
        Double soma = 0.0, maior = 0.0;
        String funcionario = "";
        for (FuncionarioComBeneficio fcb: funcionariosComBeneficio) {
            soma += fcb.calcularBeneficio(data);
            if(soma > maior){
                maior = soma;
                funcionario = fcb.getNome();
            }
        }
        return funcionario;
    }

    public String melhorVendedor(String data) throws ParseException {
        int maior = 0;
        String funcionario = "";

        Date dateParams = simpleDateFormat.parse(data);
        Calendar calendarParams = Calendar.getInstance();
        calendarParams.setTime(dateParams);

        Date dateVenda;
        Calendar calendarVenda = Calendar.getInstance();

        for (Vendedor vendedor: vendedores) {
            for (Venda venda: vendedor.getVendas()) {
                dateVenda = simpleDateFormat.parse(venda.getData());
                calendarVenda.setTime(dateVenda);
                if(calendarParams.get(Calendar.YEAR) == calendarVenda.get(Calendar.YEAR)
                        && calendarParams.get(Calendar.MONTH) == calendarVenda.get(Calendar.MONTH)){
                    if(vendedor.getVendas().size() > maior){
                        maior = vendedor.getVendas().size();
                        funcionario = vendedor.getNome();
                    }
                }
            }
        }
        return funcionario;
    }
}
