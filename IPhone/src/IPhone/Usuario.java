package IPhone;

public class Usuario {

    public static void main(String[] args) {

        IPhone iphone = new IPhone();
        iphone.ligarIPhone();
        iphone.ligarInternet();
        while (true) {
            iphone.navegadorInternet();
        }
    }
}