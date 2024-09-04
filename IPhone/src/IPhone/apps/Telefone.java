package IPhone.apps;

import IPhone.interfaces.ITelefone;

import java.util.Scanner;

public class Telefone implements ITelefone {
    private boolean ligadoIPhone;
    private boolean ligadoInternet;
    private String msgErro;

    private boolean ligadoTelefone;
    private boolean atendidoTelefone;
    private String correioVozTelefone;

    public Telefone() {
        this.setLigadoTelefone(false);
        this.setAtendidoTelefone(false);
    }
    public void limparConsole() {
        for(int n = 0; n < 7; n++) {
            System.out.print("\r\n");
        }
    }

    public void appTelefone() {
        if (this.isLigadoIPhone()) {
            if (this.isLigadoInternet()) {
                this.setMsgErro("-");
                Scanner teclado = new Scanner(System.in);
                String op;
                this.limparConsole();
                sairTelefone: {
                    while (true) {
                        this.tabela();
                        System.out.print("\ttelefone: ");
                        op = teclado.next();

                        switch (op) {
                            case "1":
                                this.ligarTelefone();
                                break;
                            case "2":
                                this.desligarTelefone();
                                break;
                            case "3":
                                this.atenderTelefone();
                                break;
                            case "4":
                                this.desatenderTelefone();
                                break;
                            case "5":
                                teclado.nextLine();
                                System.out.print("\tcorreio de voz: ");
                                op = teclado.nextLine();
                                this.iniciarCorreioVozTelefone(op);
                                break;
                            case "sair":
                                this.limparConsole();
                                this.setLigadoTelefone(false);
                                this.setAtendidoTelefone(false);
                                this.setMsgErro("-");
                                break sairTelefone;
                            default:
                                this.setMsgErro("-");
                        }
                        this.limparConsole();
                    }
                }
            } else {
                this.setMsgErro("Vc não pode fazer ligações sem internet.");
            }
        } else {
            this.setMsgErro("Vc não pode fazer ligações com o IPhone desligado.");
        }
    }
    private void tabela() {
        System.out.println("\t\tTelefone");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("Erro: %s\n", this.getMsgErro());
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| ligado telefone?: %s ( 1: ligar | 2: desligar )\n", this.isLigadoTelefone()?"Sim":"Não");
        System.out.printf("| atendido telefone?: %s ( 3: atender | 4: desatender )\n", this.isAtendidoTelefone()?"Sim":"Não");
        System.out.printf("| correio de voz: %s ( 5: iniciar correio de voz )\n", this.getCorreioVozTelefone() != null?this.getCorreioVozTelefone():"Nenhum");
        System.out.println("| sair ==> ( \"sair\" )\n");
        System.out.println("---------------------------------------------------------------------------");
    }
    private void ligarTelefone() {
        // ligar telefone => não ligado o telefone
        if ( !this.isLigadoTelefone() ) {
            this.setLigadoTelefone(true);
            this.setAtendidoTelefone(false);
            this.setMsgErro("-");
        } else {
            this.setMsgErro("Vc não pode ligar o telefone enquanto ele estiver chamando.");
        }
    }
    private void desligarTelefone() {
        if ( this.isLigadoTelefone() ) {
            this.setLigadoTelefone(false);
            this.setMsgErro("-");
        } else {
            setMsgErro("Vc não pode desligar o telefone se ele já está desligado.");
        }
    }
    private void atenderTelefone() {
        // atender telefone => não ter atendido o telefone
        if(!this.isAtendidoTelefone()) {
            this.setAtendidoTelefone(true);
            this.setLigadoTelefone(false);
            this.setMsgErro("-");
        } else {
            this.setMsgErro("Vc não pode atender o telefone se vc já está atendendo o telefone.");
        }
    }
    private void desatenderTelefone() {
        if(this.isAtendidoTelefone()) {
            this.setAtendidoTelefone(false);
            this.setMsgErro("-");
        } else {
            this.setMsgErro("Vc não pode desatender o telefone se ele já estiver desatendido.");
        }
    }
    private void iniciarCorreioVozTelefone(String msg) {
        // iniciarCorreioVozTelefone => ligado IPhone, ligado internet, não ligando telefone, não atendendo telefone
        if(!this.isLigadoTelefone()) {
            if(!this.isAtendidoTelefone()) {
                this.setCorreioVozTelefone(msg);
                this.setMsgErro("-");
            } else {
                this.setMsgErro("Vc não pode iniciar correio de voz enquanto estiver atendendo telefone.");
            }
        } else {
            this.setMsgErro("Vc não pode iniciar correio de voz enquanto estiver ligando telefone.");
        }
    }

    // getters
    //---------------------------------
    public boolean isLigadoIPhone() {
        return this.ligadoIPhone;
    }
    public boolean isLigadoInternet() {
        return this.ligadoInternet;
    }
    public String getMsgErro() {
        return this.msgErro;
    }

    public boolean isLigadoTelefone() {
        return this.ligadoTelefone;
    }
    public boolean isAtendidoTelefone() {
        return this.atendidoTelefone;
    }
    public String getCorreioVozTelefone() {
        return this.correioVozTelefone;
    }

    // setters
    //---------------------------------
    public void setLigadoIPhone(boolean ligadoIPhone) {
        this.ligadoIPhone = ligadoIPhone;
    }
    public void setLigadoInternet(boolean ligadoInternet) {
        this.ligadoInternet = ligadoInternet;
    }
    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }

    public void setLigadoTelefone(boolean ligadoTelefone) {
        this.ligadoTelefone = ligadoTelefone;
    }
    public void setAtendidoTelefone(boolean atendidoTelefone) {
        this.atendidoTelefone = atendidoTelefone;
    }
    public void setCorreioVozTelefone(String correioVozTelefone) {
        this.correioVozTelefone = correioVozTelefone;
    }
}