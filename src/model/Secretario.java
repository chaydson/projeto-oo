package model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Secretario extends FuncionarioComBeneficio {

    public Secretario(String nome, String cargo, Double salario, String dataContratacao) {
        super(nome, cargo, salario, dataContratacao);
    }

    @Override
    public Double getBeneficio() {
        return 1.2;
    }

    @Override
    public Double calcularSalarioComBeneficio(String data) throws ParseException {
        Date dateParams = simpleDateFormat.parse(data);
        Calendar calendarParams = Calendar.getInstance();
        calendarParams.setTime(dateParams);

        Date dateObj = simpleDateFormat.parse(getDataContratacao());
        calendar.setTime(dateObj);
        Double salario = (7000.0 + 1000.0*(calendar.get(Calendar.YEAR) - calendarParams.get(Calendar.YEAR)))
                * getBeneficio();
        return salario;
    }

    @Override
    public Double calcularSalarioSemBeneficio(String data) throws ParseException {
        Date dateParams = simpleDateFormat.parse(data);
        Calendar calendarParams = Calendar.getInstance();
        calendarParams.setTime(dateParams);

        Date dateObj = simpleDateFormat.parse(getDataContratacao());
        calendar.setTime(dateObj);
        Double salario = (7000.0 + 1000.0*(calendar.get(Calendar.YEAR) - calendarParams.get(Calendar.YEAR)));
        return salario;
    }

    @Override
    public Double calcularBeneficio(String data) throws ParseException {
        return calcularSalarioSemBeneficio(data) * (getBeneficio() - 1);
    }
}
