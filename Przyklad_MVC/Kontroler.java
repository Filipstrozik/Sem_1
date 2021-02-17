//package mvc.kontroler;

import java.awt.event.*;
//import mvc.model.Model;
//import mvc.widok.Widok;

public class Kontroler {

    private Model model;
    private Widok  widok;

    public Kontroler(Model model, Widok widok) {
        this.model = model;
        this.widok  = widok;

        this.widok.addMultiplyListener(new MultiplyListener());
        this.widok.addClearListener(new ClearListener());
    }

    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String userInput = "";

            try {
                userInput = widok.getUserInput();
                model.multiplyBy(userInput);
                widok.setTotal(model.getValue());

            } catch (NumberFormatException nfex) {
                widok.showError("Wystąpił błąd: '" + userInput + "'");
            }
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.kasuj();
            widok.reset();
        }
    }
}
