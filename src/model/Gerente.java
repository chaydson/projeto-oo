package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Gerente extends FuncionarioBase {
    public Gerente(String nome, String cargo, Double salario, String dataContratacao) {
        super(nome, cargo, salario, dataContratacao);
    }

    @Override
    public Double calcularSalarioComBeneficio(String data) throws ParseException {
        Date dateParams = simpleDateFormat.parse(data);
        Calendar calendarParams = Calendar.getInstance();
        calendarParams.setTime(dateParams);

        Date dateObj = simpleDateFormat.parse(getDataContratacao());
        calendar.setTime(dateObj);
        Double salario = 20000.0 + 3000.0*(calendar.get(Calendar.YEAR) - calendarParams.get(Calendar.YEAR));
        return salario;
    }

    @Override
    public Double calcularSalarioSemBeneficio(String data) throws ParseException {
        return calcularSalarioComBeneficio(data);
    }
}
