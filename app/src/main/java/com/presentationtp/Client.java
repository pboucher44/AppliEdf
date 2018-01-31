package com.presentationtp;

public class Client {

    protected String nomcli;
    protected String prenomcli;
    protected String adressecli;


    //constructeur
    //public Client(String unid,String unnom, String unprenom, String uneadresse, String unemail, String untel) {
    public Client(String unnom, String unprenom, String uneadresse) {
        super();

        this.nomcli = unnom;
        this.prenomcli = unprenom;
        this.adressecli=uneadresse;

    }

//les méthodes
  /*public String getIdCli(){
        return idcli;
    }*/

    public String getNomcli() {
        return nomcli;
    }

    public String getPrenomcli() {
        return prenomcli;
    }
    public String getAdressecli() {return adressecli;}


}
