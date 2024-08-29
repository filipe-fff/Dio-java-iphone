package IPhone;
import IPhone.interfaces.IInternet;
import IPhone.interfaces.IMusica;
import IPhone.interfaces.ITelefone;


public class IPhone implements IMusica, ITelefone, IInternet {
    private boolean ligadoIPhone;

    private boolean ligadoMusica;
    private String musica;
    private boolean pauseMusica;


    private boolean ligadoTelefone;
    private boolean atendidoTelefone;
    private String correioVozTelefone;

    private boolean ligadoInternet;
    private String[] paginasInternet;
    private int paginaAtual;



    IPhone() {
        this.desligarTodoHome();
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
            this.desligarTodoHome();
        } else {
            System.out.println("Não pode desligar o IPhone já que ele já está desligado.");
        }
    }

    public void limparConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }

        } catch (final Exception e) {}
    }

    public void desligarTodoHome() {
        this.setLigadoIPhone(false);
        this.setLigadoMusica(false);
        this.setMusica(null);
        this.setPauseMusica(false);
        this.setLigadoTelefone(false);
        this.setAtendidoTelefone(false);
        this.setPaginaAtual(0);
    }

    // Musica
    // ---------------------------------------------------
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

    public void pausarMusica() {}

    public void despausarMusica() {}

    public void selecionarMusica(String musica) {}

    // Telefone
    // ------------------------------------------------
    public void ligarTelefone() {}

    public void desligarTelefone() {}

    public void atenderTelefone() {}

    public void desatenderTelefone() {}

    public void iniciarCorreioVozTelefone(String msg) {}

    public String mostrarCorreioVozTelefone() {
        return this.getCorreioVozTelefone();
    }

    // Internet
    // ---------------------------------------------------
    public void ligarInternet() {
        if( this.isLigadoInternet() ) {

        }
    }

    public void desligarInternet() {}

    public void novaPaginaInternet(String p) {}

    public void removerPaginaInternet(String p) {}

    public void removerPaginaInternet(int p) {}

    public void proximaPaginaInternet() {}

    public void anteriorPaginaInternet() {}

    public void exibirPaginasInternet() {}

    public void adicionarNovaAbaInternet() {}

    // estados
    // -------------------------------------------------------
    // getters
    private boolean isLigadoIPhone() {
        return this.ligadoIPhone;
    }
    private boolean isLigadoMusica() {
        return this.ligadoMusica;
    }
    private String getMusica() {
        return this.musica;
    }
    private boolean isPauseMusica() {
        return this.pauseMusica;
    }
    private boolean isLigadoTelefone() {
        return this.ligadoTelefone;
    }
    private boolean isAtendidoTelefone() {
        return this.atendidoTelefone;
    }
    private String getCorreioVozTelefone() {
        return this.correioVozTelefone;
    }
    private boolean isLigadoInternet() {
        return this.ligadoInternet;
    }
    private String[] getPaginasInternet() {
        return this.paginasInternet;
    }
    private int getPaginaAtual() {
        return this.paginaAtual;
    }

    // setters
    private IPhone setLigadoIPhone(boolean ligadoIPhone) {
        this.ligadoIPhone = ligadoIPhone;
        return this;
    }
    private IPhone setLigadoMusica(boolean ligadoMusica) {
        this.ligadoMusica = ligadoMusica;
        return this;
    }
    private IPhone setMusica(String musica) {
        this.musica = musica;
        return this;
    }
    private IPhone setPauseMusica(boolean pauseMusica) {
        this.pauseMusica = pauseMusica;
        return this;
    }
    private IPhone setLigadoTelefone(boolean ligadoTelefone) {
        this.ligadoTelefone = ligadoTelefone;
        return this;
    }
    private IPhone setAtendidoTelefone(boolean atendidoTelefone) {
        this.atendidoTelefone = atendidoTelefone;
        return this;
    }
    private IPhone setCorreioVozTelefone(String correioVozTelefone) {
        this.correioVozTelefone = correioVozTelefone;
        return this;
    }
    private IPhone setLigadoInternet(boolean ligadoInternet) {
        this.ligadoInternet = ligadoInternet;
        return this;
    }
    private IPhone setPaginasInternet(String[] paginasInternet) {
        this.paginasInternet = paginasInternet;
        return this;
    }
    private IPhone setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
        return this;
    }
}