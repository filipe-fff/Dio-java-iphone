package IPhone.interfaces;

public interface IInternet {

    public abstract void ligarInternet();
    public abstract void desligarInternet();
    public abstract void novaPaginaInternet(String p);
    public abstract void removerPaginaInternet(String p);
    public abstract void removerPaginaInternet(int p);
    public abstract void proximaPaginaInternet();
    public abstract void anteriorPaginaInternet();
    public abstract void exibirPaginasInternet();
    public abstract void adicionarNovaAbaInternet();
}