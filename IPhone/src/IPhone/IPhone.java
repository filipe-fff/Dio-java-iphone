package IPhone;

import IPhone.apps.Musica;
import IPhone.apps.Navegador;
import IPhone.apps.Telefone;

import java.util.ArrayList;
import java.util.Scanner;

public class IPhone {
    private boolean ligadoIPhone;
    private boolean ligadoInternet;
    private String msgErro;

    private Musica musicaApp;
    private Telefone telefoneApp;
    private Navegador navegadorApp;


    IPhone() {
        this.reiniciarIPhone();
        this.setLigadoInternet(false);

        this.musicaApp = new Musica();
        this.telefoneApp = new Telefone();
        this.navegadorApp = new Navegador();
    }

    // IPhone
    // -----------------------------------------------------
    public void home() {
        System.out.println("\t\tIPhone");
        System.out.println("____________________________");
        System.out.printf("ligado IPhone?: %s ( 1: ligar IPhone | 2: desligar IPhone )\n", this.isLigadoIPhone()?"Sim":"Não");
        System.out.println("ligado internet?: %s ( 3: ligar internet | 4: desligar internet )\n");
        System.out.println("____________________________");
    }
    private void ligarIPhone() {
        if( !this.isLigadoIPhone()) {
            this.setLigadoIPhone(true);
            this.setMsgErro("-");
        } else {
            this.setMsgErro("Não pode ligar o IPhone já que ele já está ligado.");
        }
    }
    private void desligarIPhone() {
        if ( this.isLigadoIPhone() ) {
            this.reiniciarIPhone();
            this.setMsgErro("-");
        } else {
            this.setMsgErro("Não pode desligar o IPhone já que ele já está desligado.");
        }
    }
    private void limparConsole() {
        for(int n = 0; n < 7; n++) {
            System.out.print("\r\n");
        }
    }
    private void reiniciarIPhone() {
        this.setLigadoIPhone(false);
        this.setMsgErro("-");
    }

    // Internet
    // ---------------------------------------------------
    private void ligarInternet() {
        if ( this.isLigadoIPhone() ) {
            if (!this.isLigadoInternet()) {
                this.setLigadoInternet(true);
                this.setMsgErro("-");
            } else {
                this.setMsgErro("Vc não pode ligar a internet se a internet já está ligada.");
            }
        } else {
            this.setMsgErro("Vc não pode ligar a internet com o IPhone desligado.");
        }
    }
    private void desligarInternet() {
        if (this.isLigadoIPhone()) {
            if (this.isLigadoInternet()) {
                this.setLigadoInternet(false);
                this.setMsgErro("-");
            } else {
                this.setMsgErro("Vc não pode desligar a internet se a internet já está desligada");
            }
        } else {
            this.setMsgErro("Vc não pode desligar a internet com o IPhone desligado.");
        }
    }

    // estados
    // -------------------------------------------------------
    // getters
    private boolean isLigadoIPhone() {
        return this.ligadoIPhone;
    }
    private boolean isLigadoInternet() {
        return this.ligadoInternet;
    }
    private String getMsgErro() {
        return this.msgErro;
    }

    // setters
    private void setLigadoIPhone(boolean ligadoIPhone) {
        this.ligadoIPhone = ligadoIPhone;
    }
    private void setLigadoInternet(boolean ligadoInternet) {
        this.ligadoInternet = ligadoInternet;
    }
    private void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }
}