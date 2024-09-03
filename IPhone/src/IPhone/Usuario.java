package IPhone;

import IPhone.apps.Musica;
import IPhone.apps.Navegador;
import IPhone.apps.Telefone;


public class Usuario {

    public static void main(String[] args) {
        Musica musica = new Musica();
        musica.setLigadoIPhone(true);
        musica.setLigadoInternet(true);
        while (true) {
            System.out.println("Nova janela");
            musica.appMusica();
        }
    }
}