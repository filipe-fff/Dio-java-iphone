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

    IPhone() {
        this.reiniciarIPhone();
        this.setLigadoInternet(false);
        this.setCorreioVozTelefone(null);
    }

    // IPhone
    // -----------------------------------------------------
    public void ligarIPhone() {
        if( !this.isLigadoIPhone()) {
            this.setLigadoIPhone(true);
        } else {
            System.out.println("Não pode ligar o IPhone já que ele já está ligado.");
        }
    }
    public void desligarIPhone() {
        if ( this.isLigadoIPhone() ) {
            this.reiniciarIPhone();
        } else {
            System.out.println("Não pode desligar o IPhone já que ele já está desligado.");
        }
    }
    public void limparConsole() {
        for(int n = 0; n < 10; n++) {
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
                    } else {
                        System.out.println("O IPhone não pode tocar música se não tiver música.");
                    }
                } else {
                    System.out.println("Internet não encontrada, encontre uma rede de internet para ligar a musica.");
                }
            } else {
                System.out.println("Vc não pode ligar a música já que a música já está ligada.");
            }
        } else {
            System.out.println("Vc não pode ligar a musica com o IPhone desligado.");
        }
    }
    public void desligarMusica() {
        if(this.isLigadoIPhone()) {
            if(this.isLigadoMusica()) {
                this.setLigadoMusica(false);
            } else {
                System.out.println("Vc não pode desligar a música já que a música já está desligada");
            }
        } else {
            System.out.println("Vc não pode desligar a música com o IPhone desligado.");
        }
    }
    public void pausarMusica() {
        // pausar música => Ligado IPhone, ligado música, não pausado
        if ( this.isLigadoIPhone() ) {
            if ( this.isLigadoMusica() ) {
                if ( !this.isPauseMusica() ) {
                    this.setPauseMusica(true);
                } else {
                    System.out.println("Vc não pode pausar a música se ela já está pausada.");
                }
            } else {
                System.out.println("Vc não pode pausar se a música não está ligada.");
            }
        } else {
            System.out.println("Vc não pode pausar a música enquanto o IPhone estiver desligado.");
        }
    }
    public void despausarMusica() {
        if ( this.isLigadoIPhone() ) {
            if ( this.isLigadoMusica() ) {
                if ( this.isPauseMusica() ) {
                    this.setPauseMusica(false);
                } else {
                    System.out.println("Vc não pode tirar o pause se a música não está pausada.");
                }
            } else {
                System.out.println("Vc não pode pausar se a música não estiver pausada.");
            }
        } else {
            System.out.println("Vc não pode pausar se o IPhone estiver desligado.");
        }
    }
    public void selecionarMusica(String musica) {
        if ( this.isLigadoIPhone() ) {
            if( this.isLigadoInternet() ) {
                this.setMusica(musica);
            } else {
                System.out.println("Vc não pode selecionar música se não tem internet");
            }
        } else {
            System.out.println("Vc não pode selecionar a música se o IPhone estiver desligado.");
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
                } else {
                    System.out.println("Vc não pode ligar o telefone enquanto ele estiver chamando.");
                }
            } else {
                System.out.println("Vc não pode ligar o telefone se não tiver internet.");
            }
        } else {
            System.out.println("Vc não pode ligar o telefone se o IPhone estiver desligado.");
        }
    }
    public void desligarTelefone() {
        if ( this.isLigadoIPhone() ) {
            if ( this.isLigadoTelefone() ) {
                this.setLigadoTelefone(false);
            } else {
                System.out.println("Vc não pode desligar o telefone se ele já está desligado.");
            }
        } else {
            System.out.println("Vc não pode ligar o telefone se o IPhone estiver desligado.");
        }
    }
    public void atenderTelefone() {
        // atender telefone => ligado IPhone, ligado internet, não ter atendido o telefone
        if ( this.isLigadoIPhone() ) {
            if(this.isLigadoInternet()) {
                if(!this.isAtendidoTelefone()) {
                    this.setAtendidoTelefone(true);
                    this.setLigadoTelefone(false);
                } else {
                    System.out.println("Vc não pode atender o telefone se vc já está atendendo o telefone.");
                }
            } else {
                System.out.println("Vc não pode atender o telefone se não tem Internet.");
            }
        } else {
            System.out.println("Vc não pode atender o telefone se o IPhone estiver desligado.");
        }
    }
    public void desatenderTelefone() {
        if(this.isLigadoIPhone()) {
            if(this.isAtendidoTelefone()) {
                this.setAtendidoTelefone(false);
            } else {
                System.out.println("Vc não pode desligar o telefone se ele já estiver desligado.");
            }
        } else {
            System.out.println("Vc não pode desatender o telefone se ele já estiver desatendido.");
        }
    }
    public void iniciarCorreioVozTelefone(String msg) {
        // iniciarCorreioVozTelefone => ligado IPhone, ligado internet, não ligando telefone, não atendendo telefone
        if(this.isLigadoIPhone()) {
            if(this.isLigadoInternet()) {
                if(!this.isLigadoTelefone()) {
                    if(!this.isAtendidoTelefone()) {
                        this.setCorreioVozTelefone(msg);
                    } else {
                        System.out.println("Vc não pode iniciar correio de voz enquanto estiver atendendo telefone.");
                    }
                } else {
                    System.out.println("Vc não pode iniciar correio de voz enquanto estiver ligando telefone.");
                }
            } else {
                System.out.println("Vc não pode iniciar correio de voz sem internet.");
            }
        } else {
            System.out.println("Vc não pode iniciar correio de voz com o IPhone desligado.");
        }
    }

    // Internet
    // ---------------------------------------------------
    public void ligarInternet() {
        if ( this.isLigadoIPhone() ) {
            if (!this.isLigadoInternet()) {
                this.setLigadoInternet(true);
            } else {
                System.out.println("Vc não pode ligar a internet se a internet já está ligada.");
            }
        } else {
            System.out.println("Vc não pode ligar a internet com o IPhone desligado.");
        }
    }
    public void desligarInternet() {
        if (this.isLigadoIPhone()) {
            if (this.isLigadoInternet()) {
                this.setLigadoInternet(false);
            } else {
                System.out.println("Vc não pode desligar a internet se a internet já está desligada");
            }
        } else {
            System.out.println("Vc não pode desligar a internet com o IPhone desligado.");
        }
    }
    public void navegadorInternet() {
        if (this.isLigadoIPhone()) {
            if (this.isLigadoInternet()) {
                Scanner teclado = new Scanner(System.in);
                sairNavegador:
                {
                    while (true) {
                        this.limparConsole();
                        System.out.println("==========================================");
                        System.out.println(this.exibirPaginasInternet());
                        System.out.println("==========================================");
                        System.out.println("* 1 - nova aba");
                        System.out.println("* 2 - nova página");
                        System.out.println("* 3 - remover página(index/nome)");
                        System.out.println("* + proxima página / - página anterior");
                        System.out.println("* \"sair\"");
                        System.out.print("==> ");
                        String pagina = teclado.next();
                        switch (pagina) {
                            case "1":
                                this.adicionarNovaAbaInternet();
                                break;
                            case "2":
                                System.out.print("\tnova página: ");
                                String novaPagina = teclado.next();
                                this.novaPaginaInternet(novaPagina);
                                break;
                            case "3":
                                System.out.println("\tremover página (index/nome): ");
                                String remPagina = teclado.next();
                                if (remPagina.matches("\\d+")) {
                                    int indexPagina = Integer.parseInt(remPagina);
                                    if (indexPagina < paginasInternet.size()) {
                                        this.removerPaginaInternet(indexPagina);
                                    } else {
                                        System.out.println("O index da página não existe");
                                    }
                                } else {
                                    if (this.paginasInternet.contains(remPagina)) {
                                        this.removerPaginaInternet(remPagina);
                                    } else {
                                        System.out.println("O nome não está na lista.");
                                    }
                                }
                                break;
                            case "+":
                                this.proximaPaginaInternet();
                                break;
                            case "-":
                                this.anteriorPaginaInternet();
                            case "sair":
                                break sairNavegador;
                            default:
                                System.out.println("comando inválido, tente outro.");
                        }
                    }
                }
            } else {
                System.out.println("Vc não pode navegar pelo navegador com a internet desligada.");
            }
        } else {
            System.out.println("Vc não pode ligar o navegador com o IPhone desligado.");
        }
    }
    private void novaPaginaInternet(String p) {
        this.paginasInternet.add(p);
    }
    private void removerPaginaInternet(String p) {
        this.paginasInternet.remove(p);
    }
    private void removerPaginaInternet(int p) {
        this.paginasInternet.remove(p);
    }
    private void proximaPaginaInternet() {
        if (this.getPaginaAtual() < paginasInternet.size()) {
            this.setPaginaAtual(this.getPaginaAtual()+1);
        } else {
            System.out.println("As paginas já foram no limite máximo");
        }
    }
    private void anteriorPaginaInternet() {
        if (this.getPaginaAtual() > 0) {
            this.setPaginaAtual(this.getPaginaAtual()-1);
        }
    }
    public String exibirPaginasInternet() {
        StringBuilder paginas = new StringBuilder("páginas => ");
        if(this.getPaginasInternet() != null){
            for (String pagina : this.getPaginasInternet()) {
                paginas.append("\t\t\t-").append(pagina);
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

    // setters
    public IPhone setLigadoIPhone(boolean ligadoIPhone) {
        this.ligadoIPhone = ligadoIPhone;
        return this;
    }
    public IPhone setLigadoMusica(boolean ligadoMusica) {
        this.ligadoMusica = ligadoMusica;
        return this;
    }
    public IPhone setMusica(String musica) {
        this.musica = musica;
        return this;
    }
    public IPhone setPauseMusica(boolean pauseMusica) {
        this.pauseMusica = pauseMusica;
        return this;
    }
    public IPhone setLigadoTelefone(boolean ligadoTelefone) {
        this.ligadoTelefone = ligadoTelefone;
        return this;
    }
    public IPhone setAtendidoTelefone(boolean atendidoTelefone) {
        this.atendidoTelefone = atendidoTelefone;
        return this;
    }
    public IPhone setCorreioVozTelefone(String correioVozTelefone) {
        this.correioVozTelefone = correioVozTelefone;
        return this;
    }
    public IPhone setLigadoInternet(boolean ligadoInternet) {
        this.ligadoInternet = ligadoInternet;
        return this;
    }
    public IPhone setPaginasInternet(ArrayList<String> paginasInternet) {
        this.paginasInternet = paginasInternet;
        return this;
    }
    public IPhone setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
        return this;
    }
}