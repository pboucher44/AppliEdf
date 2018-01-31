package com.presentationtp;

/**
 * Created by Unknow on 30/01/2018.
 */

public class Releve {

    protected String datereleve;
    protected Integer releveCodeCli;
    protected Integer cptHP;
    protected Integer cptHC;
    protected String typeReleve;



    //constructeur

    public Releve(String unedate,Integer uncptHP, Integer uncptHC,Integer uncodecli,String untypereleve) {
        super();
        this.datereleve = unedate;
        this.releveCodeCli = uncodecli;
        this.cptHP = uncptHP;
        this.cptHC=uncptHC;
        this.typeReleve=untypereleve;

    }

//les méthodes



    public String getDateReleve() {return datereleve;}
    public String getCodeCli() {
        return Integer.toString(releveCodeCli);
    }
    public String getTypeReleve() {
        return typeReleve;
    }
    public String getcptHC() {return Integer.toString(cptHC);}
    public String getcptHP() {
        return Integer.toString(cptHP);
    }


}
