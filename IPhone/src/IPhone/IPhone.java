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
        this.setLigadoIPhone(false);
        this.setLigadoInternet(false);
        this.setMsgErro("-");

        this.musicaApp = new Musica();
        this.telefoneApp = new Telefone();
        this.navegadorApp = new Navegador();
    }

    // IPhone
    // -----------------------------------------------------
    public void home() {
        Scanner teclado = new Scanner(System.in);
        while (true) {
            this.tabela();
            System.out.print("==> ");
            String op = teclado.next();
            switch (op) {
                case "1":
                    this.setMsgErro("-");
                    this.ligarIPhone();
                    break;
                case "2":
                    this.setMsgErro("-");
                    this.desligarIPhone();
                    break;
                case "3":
                    this.setMsgErro("-");
                    this.ligarInternet();
                    break;
                case "4":
                    this.setMsgErro("-");
                    this.desligarInternet();
                    break;
                case "5":
                    this.musicaApp.setLigadoIPhone(this.isLigadoIPhone());
                    this.musicaApp.setLigadoInternet(this.isLigadoInternet());
                    this.musicaApp.appMusica();
                    this.setMsgErro(this.musicaApp.getMsgErro());
                    break;
                case "6":
                    this.telefoneApp.setLigadoIPhone(this.isLigadoIPhone());
                    this.telefoneApp.setLigadoInternet(this.isLigadoInternet());
                    this.telefoneApp.appTelefone();
                    this.setMsgErro(telefoneApp.getMsgErro());
                    break;
                case "7":
                    this.navegadorApp.setLigadoIPhone(this.isLigadoIPhone());
                    this.navegadorApp.setLigadoInternet(this.isLigadoInternet());
                    this.navegadorApp.appNavegador();
                    this.setMsgErro(this.navegadorApp.getMsgErro());
                    break;
                default:
                    this.setMsgErro("Opção inválida.");
            }
            this.limparConsole();
        }
    }
    private void tabela() {
        System.out.println("\t\tIPhone");
        System.out.println("____________________________");
        System.out.printf("Erro: %s\n", this.getMsgErro());
        System.out.println("____________________________");
        System.out.printf("ligado IPhone?: %s ( 1: ligar IPhone | 2: desligar IPhone )\n", this.isLigadoIPhone() ? "Sim" : "Não");
        System.out.printf("ligado internet?: %s ( 3: ligar internet | 4: desligar internet )\n", this.isLigadoInternet() ? "Sim" : "Não");
        System.out.printf("5: música\n");
        System.out.printf("6: telefone\n");
        System.out.printf("7: navegador\n");
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
            this.setLigadoIPhone(false);
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