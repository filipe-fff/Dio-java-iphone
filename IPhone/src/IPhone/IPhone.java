package IPhone;

import IPhone.interfaces.IInternet;
import IPhone.interfaces.IMusica;
import IPhone.interfaces.ITelefone;
import java.util.ArrayList;
import java.util.Scanner;

public class IPhone implements IMusica, ITelefone, IInternet {
    private boolean ligadoIPhone;
    private boolean ligadoMusica;
    private String musica;
    private boolean pauseMusica;
    private boolean ligadoTelefone;
    private boolean atendidoTelefone;
    private String correioVozTelefone;
    private boolean ligadoInternet;
    private ArrayList<String> paginasInternet;
    private int paginaAtual;
    private String msgErro;

    IPhone() {
        this.reiniciarIPhone();
        this.setLigadoInternet(false);
        this.paginasInternet = new ArrayList<>();
        this.setCorreioVozTelefone(null);
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
        this.setLigadoMusica(false);
        this.setMusica(null);
        this.setPauseMusica(false);
        this.setLigadoTelefone(false);
        this.setAtendidoTelefone(false);
        this.setPaginaAtual(0);
        this.adicionarNovaAbaInternet();
        this.setMsgErro("-");
    }

    // Musica
    // ---------------------------------------------------
    // ligar música => ligado IPhone, não ligado música, ligado internet, ter música
    public void ligarMusica() {
        if (this.isLigadoIPhone()) {
            if (!this.isLigadoMusica()) {
                if (this.isLigadoInternet()) {
                    if (this.getMusica() != null) {
                        System.out.printf("Tocando a música %s.\n", this.getMusica());
                        this.setMsgErro("-");
                    } else {
                        this.setMsgErro("O IPhone não pode tocar música se não tiver música.");
                    }
                } else {
                    this.setMsgErro("Internet não encontrada, encontre uma rede de internet para ligar a musica.");
                }
            } else {
                this.setMsgErro("Vc não pode ligar a música já que a música já está ligada.");
            }
        } else {
            this.setMsgErro("Vc não pode ligar a musica com o IPhone desligado.");
        }
    }
    public void desligarMusica() {
        if(this.isLigadoIPhone()) {
            if(this.isLigadoMusica()) {
                this.setLigadoMusica(false);
                this.setMsgErro("-");
            } else {
                this.setMsgErro("Vc não pode desligar a música já que a música já está desligada");
            }
        } else {
            this.setMsgErro("Vc não pode desligar a música com o IPhone desligado.");
        }
    }
    public void pausarMusica() {
        // pausar música => Ligado IPhone, ligado música, não pausado
        if ( this.isLigadoIPhone() ) {
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
        } else {
            this.setMsgErro("Vc não pode pausar a música enquanto o IPhone estiver desligado.");
        }
    }
    public void despausarMusica() {
        if ( this.isLigadoIPhone() ) {
            if ( this.isLigadoMusica() ) {
                if ( this.isPauseMusica() ) {
                    this.setPauseMusica(false);
                    this.setMsgErro("-");
                } else {
                    setMsgErro("Vc não pode tirar o pause se a música não está pausada.");
                }
            } else {
                this.setMsgErro("Vc não pode pausar se a música não estiver pausada.");
            }
        } else {
            this.setMsgErro("Vc não pode pausar se o IPhone estiver desligado.");
        }
    }
    public void selecionarMusica(String musica) {
        if ( this.isLigadoIPhone() ) {
            if( this.isLigadoInternet() ) {
                this.setMusica(musica);
                this.setMsgErro("-");
            } else {
                this.setMsgErro("Vc não pode selecionar música se não tem internet");
            }
        } else {
            this.setMsgErro("Vc não pode selecionar a música se o IPhone estiver desligado.");
        }
    }

    // Telefone
    // ------------------------------------------------
    public void ligarTelefone() {
        // ligar telefone => ligado IPhone, ligado internet, não ligado o telefone
        if ( this.isLigadoIPhone() ) {
            if ( this.isLigadoInternet() ) {
                if ( !this.isLigadoTelefone() ) {
                    this.setLigadoTelefone(true);
                    this.setAtendidoTelefone(false);
                    this.setMsgErro("-");
                } else {
                    this.setMsgErro("Vc não pode ligar o telefone enquanto ele estiver chamando.");
                }
            } else {
                this.setMsgErro("Vc não pode ligar o telefone se não tiver internet.");
            }
        } else {
            this.setMsgErro("Vc não pode ligar o telefone se o IPhone estiver desligado.");
        }
    }
    public void desligarTelefone() {
        if ( this.isLigadoIPhone() ) {
            if ( this.isLigadoTelefone() ) {
                this.setLigadoTelefone(false);
                this.setMsgErro("-");
            } else {
                setMsgErro("Vc não pode desligar o telefone se ele já está desligado.");
            }
        } else {
            setMsgErro("Vc não pode ligar o telefone se o IPhone estiver desligado.");
        }
    }
    public void atenderTelefone() {
        // atender telefone => ligado IPhone, ligado internet, não ter atendido o telefone
        if ( this.isLigadoIPhone() ) {
            if(this.isLigadoInternet()) {
                if(!this.isAtendidoTelefone()) {
                    this.setAtendidoTelefone(true);
                    this.setLigadoTelefone(false);
                    this.setMsgErro("-");
                } else {
                    this.setMsgErro("Vc não pode atender o telefone se vc já está atendendo o telefone.");
                }
            } else {
                this.setMsgErro("Vc não pode atender o telefone se não tem Internet.");
            }
        } else {
            this.setMsgErro("Vc não pode atender o telefone se o IPhone estiver desligado.");
        }
    }
    public void desatenderTelefone() {
        if(this.isLigadoIPhone()) {
            if(this.isAtendidoTelefone()) {
                this.setAtendidoTelefone(false);
                this.setMsgErro("-");
            } else {
                this.setMsgErro("Vc não pode desligar o telefone se ele já estiver desligado.");
            }
        } else {
            this.setMsgErro("Vc não pode desatender o telefone se ele já estiver desatendido.");
        }
    }
    public void iniciarCorreioVozTelefone(String msg) {
        // iniciarCorreioVozTelefone => ligado IPhone, ligado internet, não ligando telefone, não atendendo telefone
        if(this.isLigadoIPhone()) {
            if(this.isLigadoInternet()) {
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
            } else {
                this.setMsgErro("Vc não pode iniciar correio de voz sem internet.");
            }
        } else {
            this.setMsgErro("Vc não pode iniciar correio de voz com o IPhone desligado.");
        }
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
    public void navegadorInternet() {
        if (this.isLigadoIPhone()) {
            if (this.isLigadoInternet()) {
                Scanner teclado = new Scanner(System.in);
                sairNavegador:
                {
                    while (true) {
                        System.out.println("\t\tNavegador");
                        System.out.println("================================================");
                        System.out.println(this.exibirPaginasInternet());
                        System.out.println("================================================");
                        System.out.printf("Erro: %s\n", this.getMsgErro());
                        System.out.println("================================================");
                        this.paginaAtual();
                        System.out.println("================================================");
                        System.out.println("\t******************************************");
                        System.out.println("\t* 1 - nova aba");
                        System.out.println("\t* 2 - nova página");
                        System.out.println("\t* 3 - remover página(index/nome)");
                        System.out.println("\t* + proxima página / - página anterior");
                        System.out.println("\t* \"sair\"");
                        System.out.println("\t******************************************");
                        System.out.print("\t==> ");
                        String pagina = teclado.next();
                        switch (pagina) {
                            case "1":
                                this.adicionarNovaAbaInternet();
                                this.setMsgErro("-");
                                break;
                            case "2":
                                System.out.print("\tnova página: ");
                                String novaPagina = teclado.next();
                                this.novaPaginaInternet(novaPagina);
                                this.setMsgErro("-");
                                break;
                            case "3":
                                System.out.print("\tremover página (index/nome): ");
                                String remPagina = teclado.next();
                                if (remPagina.matches("\\d+")) {
                                    int indexPagina = Integer.parseInt(remPagina);
                                    if (indexPagina < paginasInternet.size()) {
                                        this.removerPaginaInternet(indexPagina);
                                        this.setMsgErro("-");
                                    } else {
                                        this.setMsgErro("O index da página não existe");
                                    }
                                } else {
                                    if (this.paginasInternet.contains(remPagina)) {
                                        this.removerPaginaInternet(remPagina);
                                        this.setMsgErro("-");
                                    } else {
                                        this.setMsgErro("O nome não está na lista.");
                                    }
                                }
                                break;
                            case "+":
                                this.proximaPaginaInternet();
                                break;
                            case "-":
                                this.anteriorPaginaInternet();
                                break;
                            case "sair":
                                this.setMsgErro("-");
                                break sairNavegador;
                            default:
                                this.setMsgErro("comando inválido, tente outro.");
                        }
                        this.limparConsole();
                    }
                }
            } else {
                this.setMsgErro("Vc não pode navegar pelo navegador com a internet desligada.");
            }
        } else {
            this.setMsgErro("Vc não pode ligar o navegador com o IPhone desligado.");
        }
    }
    private void paginaAtual() {
        System.out.print("página atual: ");
        if (this.getPaginasInternet().size() > 0){
            System.out.printf("%d - %s\n", this.getPaginaAtual(), this.getPaginasInternet().get(this.getPaginaAtual()));
        } else {
            System.out.println(this.getPaginaAtual()+" Sem página no momento.");
        }
    }
    private void novaPaginaInternet(String p) {
        this.paginasInternet.add(p);
    }
    private void removerPaginaInternet(String p) {
        this.getPaginasInternet().remove(p);
        this.paginaAtualValido();
    }
    private void removerPaginaInternet(int p) {
        this.getPaginasInternet().remove(p);
        this.paginaAtualValido();
    }
    private void paginaAtualValido() {
        if (this.getPaginasInternet().size() == 0) {
            this.setPaginaAtual(0);
        }else if (this.getPaginasInternet().size()-1 < this.getPaginaAtual()) {
            this.setPaginaAtual(this.getPaginasInternet().size()-1);
        }
    }
    private void proximaPaginaInternet() {
        if (this.getPaginaAtual() < paginasInternet.size()-1) {
            this.setPaginaAtual(this.getPaginaAtual()+1);
        } else {
            this.setMsgErro("As paginas já foram no limite máximo");
        }
    }
    private void anteriorPaginaInternet() {
        if (this.getPaginaAtual() > 0) {
            this.setPaginaAtual(this.getPaginaAtual()-1);
            this.setMsgErro("-");
        } else {
            this.setMsgErro("As páginas já foram no limíte mínimo.");
        }
    }
    public String exibirPaginasInternet() {
        StringBuilder paginas = new StringBuilder("páginas => ");
        if(this.getPaginasInternet() != null){
            for (String pagina : this.getPaginasInternet()) {
                paginas.append("\n\t\t\t - ").append(pagina);
            }
        }
        return paginas.toString();
    }
    private void adicionarNovaAbaInternet() {
        if(this.paginasInternet != null) {
            this.paginasInternet.clear();
        }
    }

    // estados
    // -------------------------------------------------------
    // getters
    public boolean isLigadoIPhone() {
        return this.ligadoIPhone;
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
    public boolean isLigadoTelefone() {
        return this.ligadoTelefone;
    }
    public boolean isAtendidoTelefone() {
        return this.atendidoTelefone;
    }
    public String getCorreioVozTelefone() {
        return this.correioVozTelefone;
    }
    public boolean isLigadoInternet() {
        return this.ligadoInternet;
    }
    public ArrayList<String> getPaginasInternet() {
        return this.paginasInternet;
    }
    public int getPaginaAtual() {
        return this.paginaAtual;
    }
    public String getMsgErro() {
        return this.msgErro;
    }

    // setters
    public void setLigadoIPhone(boolean ligadoIPhone) {
        this.ligadoIPhone = ligadoIPhone;
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
    public void setLigadoTelefone(boolean ligadoTelefone) {
        this.ligadoTelefone = ligadoTelefone;
    }
    public void setAtendidoTelefone(boolean atendidoTelefone) {
        this.atendidoTelefone = atendidoTelefone;
    }
    public void setCorreioVozTelefone(String correioVozTelefone) {
        this.correioVozTelefone = correioVozTelefone;
    }
    public void setLigadoInternet(boolean ligadoInternet) {
        this.ligadoInternet = ligadoInternet;
    }
    public void setPaginasInternet(ArrayList<String> paginasInternet) {
        this.paginasInternet = paginasInternet;
    }
    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }
    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }
}