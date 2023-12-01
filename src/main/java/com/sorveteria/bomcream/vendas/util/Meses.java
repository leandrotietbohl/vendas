package com.sorveteria.bomcream.vendas.util;

public enum Meses {
    JAN(1, "Jan", "Janeiro"),
    FEV(2, "Fev", "Fevereiro"),
    MAR(3, "Mar", "Março"),
    ABR(4, "Abr", "Abril"),
    MAI(5, "Mai", "Maio"),
    JUN(6, "Jun", "Junho"),
    JUL(7, "Jul", "Julho"),
    AGO(8, "Ago", "Agosto"),
    SET(9, "Set", "Setembro"),
    OUT(10, "Out", "Outubro"),
    NOV(11, "Nov", "Novembro"),
    DEZ(12, "Dez", "Dezembro");

    /*
     * Construtor da enum
     */
    private Meses(int codigoMes, String mesAbreviado, String nomeMesCompleto){
        this.codigoMes = codigoMes;
        this.mesAbreviado = mesAbreviado;
        this.nomeMesCompleto = nomeMesCompleto;
    }

    /*Campos*/
    private int codigoMes;
    private String mesAbreviado;
    private String nomeMesCompleto;

    public int getCodigoMes(){
        return this.codigoMes;
    }

    public String getMesAbreviado(){
        return this.mesAbreviado;
    }

    public String getNomeMesCompleto(){
        return this.nomeMesCompleto;
    }
}
