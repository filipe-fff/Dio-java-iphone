package IPhone.apps;

import IPhone.interfaces.INavegador;

import java.util.ArrayList;
import java.util.Scanner;

public class Navegador implements INavegador {
    private boolean ligadoIPhone;
    private boolean ligadoInternet;
    private String msgErro;

    private ArrayList<String> paginasNavegador;
    private int paginaAtualNavegador;

    public Navegador() {
        this.paginasNavegador = new ArrayList<String>();
        this.reiniciarNavegador();
    }
    public void appNavegador() {
        if (this.isLigadoIPhone()) {
            if (this.isLigadoInternet()) {
                this.setMsgErro("-");
                Scanner teclado = new Scanner(System.in);
                this.limparConsole();
                sairNavegador:
                {
                    while (true) {
                        this.tabela();
                        System.out.print("\t==> ");
                        String pagina = teclado.next();
                        switch (pagina) {
                            case "1":
                                this.adicionarNovaAbaNavegador();
                                this.setMsgErro("-");
                                break;
                            case "2":
                                teclado.nextLine();
                                System.out.print("\tnova página: ");
                                String novaPagina = teclado.nextLine();
                                this.novaPaginaNavegador(novaPagina);
                                this.setMsgErro("-");
                                break;
                            case "3":
                                teclado.nextLine();
                                System.out.print("\tremover página (index/nome): ");
                                String remPagina = teclado.nextLine();
                                if (remPagina.matches("\\d+")) {
                                    int indexPagina = Integer.parseInt(remPagina);
                                    if (indexPagina < getPaginasNavegador().size()) {
                                        this.removerPaginaNavegador(indexPagina);
                                        this.setMsgErro("-");
                                    } else {
                                        this.setMsgErro("O index da página não existe");
                                    }
                                } else {
                                    if (this.paginasNavegador.contains(remPagina)) {
                                        this.removerPaginaNavegador(remPagina);
                                        this.setMsgErro("-");
                                    } else {
                                        this.setMsgErro("O nome não está na lista.");
                                    }
                                }
                                break;
                            case "+":
                                this.proximaPaginaNavegador();
                                break;
                            case "-":
                                this.anteriorPaginaNavegador();
                                break;
                            case "sair":
                                this.limparConsole();
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
    public void limparConsole() {
        for(int n = 0; n < 7; n++) {
            System.out.print("\r\n");
        }
    }
    public void reiniciarNavegador() {
        this.setPaginaAtualNavegador(0);
        this.adicionarNovaAbaNavegador();
        this.setMsgErro("-");
    }

    private void tabela() {
        System.out.println("\t\tNavegador");
        System.out.println("================================================");
        System.out.println(this.exibirPaginasNavegador());
        System.out.println("================================================");
        System.out.printf("Erro: %s\n", this.getMsgErro());
        System.out.println("================================================");
        this.paginaAtualNavegador();
        System.out.println("================================================");
        System.out.println("\t******************************************");
        System.out.println("\t* 1 - nova aba");
        System.out.println("\t* 2 - nova página");
        System.out.println("\t* 3 - remover página(index/nome)");
        System.out.println("\t* + proxima página / - página anterior");
        System.out.println("\t* \"sair\"");
        System.out.println("\t******************************************");
    }
    private void paginaAtualNavegador() {
        System.out.print("página atual: ");
        if (this.paginasNavegador.size() > 0){
            System.out.printf("%d - %s\n", this.getPaginaAtualNavegador(), this.getPaginasNavegador().get(this.getPaginaAtualNavegador()));
        } else {
            System.out.println(" Sem página no momento.");
        }
    }
    private void novaPaginaNavegador(String p) {
        this.paginasNavegador.add(p);
    }
    private void removerPaginaNavegador(String p) {
        this.getPaginasNavegador().remove(p);
        this.paginaAtualValidoNavegador();
    }
    private void removerPaginaNavegador(int p) {
        this.getPaginasNavegador().remove(p);
        this.paginaAtualValidoNavegador();
    }
    private void paginaAtualValidoNavegador() {
        if (this.getPaginasNavegador().size() == 0) {
            this.setPaginaAtualNavegador(0);
        }else if (this.getPaginasNavegador().size()-1 < this.getPaginaAtualNavegador()) {
            this.setPaginaAtualNavegador(this.getPaginasNavegador().size()-1);
        }
    }
    private void proximaPaginaNavegador() {
        if (this.getPaginaAtualNavegador() < paginasNavegador.size()-1) {
            this.setPaginaAtualNavegador(this.getPaginaAtualNavegador()+1);
        } else {
            this.setMsgErro("As paginas já foram no limite máximo");
        }
    }
    private void anteriorPaginaNavegador() {
        if (this.getPaginaAtualNavegador() > 0) {
            this.setPaginaAtualNavegador(this.getPaginaAtualNavegador()-1);
            this.setMsgErro("-");
        } else {
            this.setMsgErro("As páginas já foram no limíte mínimo.");
        }
    }
    private String exibirPaginasNavegador() {
        int index = 0;
        StringBuilder paginas = new StringBuilder("páginas => ");
        if(this.getPaginasNavegador() != null){
            for (String pagina : this.getPaginasNavegador()) {
                paginas.append("\n\t\t\t").append(index++).append(" - ").append(pagina);
            }
        }
        return paginas.toString();
    }
    private void adicionarNovaAbaNavegador() {
        if(this.paginasNavegador != null) {
            this.paginasNavegador.clear();
        }
    }

    // getters
    public boolean isLigadoIPhone() {
        return ligadoIPhone;
    }
    public boolean isLigadoInternet() {
        return this.ligadoInternet;
    }
    public String getMsgErro() {
        return this.msgErro;
    }
    public ArrayList<String> getPaginasNavegador() {
        return this.paginasNavegador;
    }
    public int getPaginaAtualNavegador() {
        return this.paginaAtualNavegador;
    }
    // ------------------------------------------------

    // setters
    // ------------------------------------------------
    public void setLigadoIPhone(boolean ligadoIPhone) {
        this.ligadoIPhone = ligadoIPhone;
    }
    public void setLigadoInternet(boolean ligadoInternet) {
        this.ligadoInternet = ligadoInternet;
    }
    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }
    public void setPaginasNavegador(ArrayList<String> paginasNavegador) {
        this.paginasNavegador = paginasNavegador;
    }
    public void setPaginaAtualNavegador(int paginaAtualNavegador) {
        this.paginaAtualNavegador = paginaAtualNavegador;
    }
}