package IPhone;

import java.util.ArrayList;
import java.util.Scanner;

public class IPhone {
    private boolean ligadoIPhone;
    private boolean ligadoInternet;
    private String msgErro;


    IPhone() {
        this.reiniciarIPhone();
        this.setLigadoInternet(false);
    }

    // IPhone
    // -----------------------------------------------------
    public void ligarIPhone() {
        if( !this.isLigadoIPhone()) {
            this.setLigadoIPhone(true);
            this.setMsgErro("-");
        } else {
            this.setMsgErro("Não pode ligar o IPhone já que ele já está ligado.");
        }
    }
    public void desligarIPhone() {
        if ( this.isLigadoIPhone() ) {
            this.reiniciarIPhone();
            this.setMsgErro("-");
        } else {
            this.setMsgErro("Não pode desligar o IPhone já que ele já está desligado.");
        }
    }
    public void limparConsole() {
        for(int n = 0; n < 7; n++) {
            System.out.print("\r\n");
        }
    }
    public void reiniciarIPhone() {
        this.setLigadoIPhone(false);
        this.setMsgErro("-");
    }

    // Internet
    // ---------------------------------------------------
    public void ligarInternet() {
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
    public void desligarInternet() {
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
    public boolean isLigadoIPhone() {
        return this.ligadoIPhone;
    }
    public boolean isLigadoInternet() {
        return this.ligadoInternet;
    }
    public String getMsgErro() {
        return this.msgErro;
    }

    // setters
    public void setLigadoIPhone(boolean ligadoIPhone) {
        this.ligadoIPhone = ligadoIPhone;
    }
    public void setLigadoInternet(boolean ligadoInternet) {
        this.ligadoInternet = ligadoInternet;
    }
    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }
}