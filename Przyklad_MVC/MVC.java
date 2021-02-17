//package mvcp;

//import mvc.kontroler.Kontroler;
//import mvc.model.Model;
//import mvc.widok.Widok;

public class MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Model model       = new Model();
        Widok widok       = new Widok(model);
        Kontroler kontroler = new Kontroler(model, widok);

        widok.setVisible(true);

    }
}
