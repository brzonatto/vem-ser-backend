package com.dbc.lista1.salario;

import com.dbc.utils.Utils;

public class Salario {
    private Double valorHora;
    private Integer horaNormal;
    private Integer horaExtra50;
    private Integer horaExtra100;
    final private Double EXTRA_50 = 0.5;
    final private Double EXTRA_100 = 1.0;

    public Salario() {

    }

    public Salario(Double valorHora, Integer horaNormal, Integer horaExtra50, Integer horaExtra100) {
        this.valorHora = valorHora;
        this.horaNormal = horaNormal;
        this.horaExtra50 = horaExtra50;
        this.horaExtra100 = horaExtra100;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Integer getHoraNormal() {
        return horaNormal;
    }

    public void setHoraNormal(Integer horaNormal) {
        this.horaNormal = horaNormal;
    }

    public Integer getHoraExtra50() {
        return horaExtra50;
    }

    public void setHoraExtra50(Integer horaExtra50) {
        this.horaExtra50 = horaExtra50;
    }

    public Integer getHoraExtra100() {
        return horaExtra100;
    }

    public void setHoraExtra100(Integer horaExtra100) {
        this.horaExtra100 = horaExtra100;
    }

    public Double calculaSalario() {
        Double valorExtra50 = this.valorHora + (EXTRA_50 * this.valorHora);
        Double valorExtra100 = this.valorHora + (EXTRA_100 * this.valorHora);
        Double total = valorHora * horaNormal;
        total += (valorExtra50 * this.horaExtra50) + (valorExtra100 * this.horaExtra100);

        return total;
    }

    @Override
    public String toString() {
        return "R$" + Utils.formatarDouble(calculaSalario());
    }
}
