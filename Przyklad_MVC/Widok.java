//package mvc.widok;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import mvc.model.Model;

public class Widok extends JFrame {

    private static final String WartoscPoczatkowa = "1";

    private JTextField Input = new JTextField(5);
    private JTextField Total     = new JTextField(20);
    private JButton    Mnozenie = new JButton("wymnóż");
    private JButton    Reset    = new JButton("wyczyść");

    private Model model;

    public Widok(Model model) {

        this.model = model;
        this.model.setValue(WartoscPoczatkowa);

        Total.setText(this.model.getValue());
        Total.setEditable(false);

        JPanel content = new JPanel();
        content.setLayout( new FlowLayout());
        content.add(new JLabel("Input"));
        content.add(Input);
        content.add(Mnozenie);
        content.add(new JLabel("Total"));
        content.add(Total);
        content.add(Reset);

        this.setContentPane(content);
        this.pack();

        this.setTitle("Implementacja wzorca MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void reset() {
        Total.setText(WartoscPoczatkowa);
    }

    public String getUserInput() {
        return Input.getText();
    }

    public void setTotal(String newTotal) {
        Total.setText(newTotal);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public void addMultiplyListener(ActionListener mal) {
        Mnozenie.addActionListener(mal);
    }

    public void addClearListener(ActionListener cal) {
        Reset.addActionListener(cal);
    }
}


