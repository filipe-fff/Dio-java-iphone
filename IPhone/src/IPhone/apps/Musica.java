package IPhone.apps;

import IPhone.interfaces.IMusica;

import java.util.Scanner;

public class Musica implements IMusica {
    private boolean ligadoIPhone;
    private boolean ligadoInternet;
    private String msgErro;

    private boolean ligadoMusica;
    private String musica;
    private boolean pauseMusica;

    public Musica() {}

    public void appMusica() {
        if (this.isLigadoIPhone()) {
            if (this.isLigadoInternet()) {
                this.setMsgErro("-");
                Scanner teclado = new Scanner(System.in);
                sairMusica:
                {
                    while (true) {
                        System.out.println("\t\tMúsica");
                        System.out.println("/////////////////////////////////");
                        System.out.printf("Erro: %s\n", this.getMsgErro());
                        System.out.println("/////////////////////////////////");
                        System.out.printf("/ música ligada?: %s ( 1: ligar | 2: desligar )\n", this.isLigadoMusica()?"Sim":"Não");
                        System.out.printf("/ música pausada?: %s ( 3: pausar | 4: despausar )\n", this.isPauseMusica()?"Sim":"Não");
                        System.out.printf("/ música selecionada: %s ( 5: selecionar música )\n", (this.getMusica() != null)?this.getMusica():"Nenhuma");
                        System.out.println("/ sair da música => ( \"sair\" )");
                        System.out.println("/////////////////////////////////");
                        System.out.print("\n\t////>>> ");
                        String op = teclado.next();
                        switch (op) {
                            case "1":
                                System.out.println("ok");
                                this.ligarMusica();
                                break;
                            case "2":
                                this.desligarMusica();
                                break;
                            case "3":
                                this.pausarMusica();
                                break;
                            case "4":
                                this.despausarMusica();
                                break;
                            case "5":
                                System.out.print("\tmúsica: ");
                                String musica = teclado.next();
                                this.selecionarMusica(musica);
                                break;
                            case "sair":
                                this.setLigadoMusica(false);
                                this.setPauseMusica(false);
                                this.limparConsole();
                                break sairMusica;
                            default:
                                this.setMsgErro("Opção inválida.");
                        }
                        this.limparConsole();
                    }
                }
            } else {
                this.setMsgErro("Vc não pode usar o App de música sem internet.");
            }
        } else {
            this.setMsgErro("Vc não pode ligar o App de música se não estiver ligado o IPhone.");
        }
    }
    public void limparConsole() {
        for(int n = 0; n < 7; n++) {
            System.out.print("\r\n");
        }
    }
    // ligado internet, ter música
    private void ligarMusica() {
        if (!this.isLigadoMusica()) {
            if (this.getMusica() != null) {
                this.setLigadoMusica(true);
                this.setMsgErro("-");
            } else {
                this.setMsgErro("O IPhone não pode tocar música se não tiver música.");
            }
        } else {
            this.setMsgErro("Vc não pode ligar a música já que a música já está ligada.");
        }
    }
    private void desligarMusica() {
        if(this.isLigadoMusica()) {
            this.despausarMusica();
            this.setLigadoMusica(false);
            this.setMsgErro("-");
        } else {
            this.setMsgErro("Vc não pode desligar a música já que a música já está desligada");
        }
    }
    private void pausarMusica() {
        // pausar música => ligado música, não pausado
        if ( this.isLigadoMusica() ) {
            if ( !this.isPauseMusica() ) {
                this.setPauseMusica(true);
                this.setMsgErro("-");
            } else {
                this.setMsgErro("Vc não pode pausar a música se ela já está pausada.");
            }
        } else {
            this.setMsgErro("Vc não pode pausar se a música não está ligada.");
        }
    }
    private void despausarMusica() {
        if ( this.isLigadoMusica() ) {
            if ( this.isPauseMusica() ) {
                this.setPauseMusica(false);
                this.setMsgErro("-");
            } else {
                setMsgErro("Vc não pode tirar o pause se a música não está pausada.");
            }
        } else {
            this.setMsgErro("Vc não pode tirar o pause se a música não estiver ligada.");
        }
    }
    private void selecionarMusica(String musica) {
        this.setMusica(musica);
        this.setMsgErro("-");
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

    public boolean isLigadoMusica() {
        return this.ligadoMusica;
    }
    public String getMusica() {
        return this.musica;
    }
    public boolean isPauseMusica() {
        return this.pauseMusica;
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

    public void setLigadoMusica(boolean ligadoMusica) {
        this.ligadoMusica = ligadoMusica;
    }
    public void setMusica(String musica) {
        this.musica = musica;
    }
    public void setPauseMusica(boolean pauseMusica) {
        this.pauseMusica = pauseMusica;
    }
}