import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Kalkulator implements ActionListener {

    JFrame ramka;
    JTextField poletekstowe,poletekstowe2;
    JButton[] przyciski_numeryczne = new JButton[10];
    JButton[] pryciski_funkcyjne = new JButton[6];
    JButton dodajButton, odejmijButton, pomnozButton,podzielButton;
    JButton rownaButton, usunButton;
    JPanel panel,panelM;

    double liczba1=0,liczba2=0, wynik=0;
    char znak;


    public Kalkulator(){
        ramka = new JFrame("Kalkulator F.S.");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(400,600);
        ramka.setLayout(null);
        ramka.setResizable(false);

        panelM = new JPanel();
        panelM.setBounds(0,0,400,600);
        panelM.setBackground(new Color(30,30,55));
        panelM.setLayout(null);

        poletekstowe2 = new JTextField("Historia");
        poletekstowe2.setBounds(50,14,300,30);
        poletekstowe2.setEditable(false);


        poletekstowe = new JTextField("");
        poletekstowe.setBounds(50,50,300,40);
        poletekstowe.setEditable(false);

        dodajButton = new JButton("+");
        odejmijButton = new JButton("-");
        pomnozButton = new JButton("*");
        podzielButton = new JButton("/");
        rownaButton = new JButton("=");
        usunButton = new JButton("del");

        pryciski_funkcyjne[0]=dodajButton;
        pryciski_funkcyjne[1]=odejmijButton;
        pryciski_funkcyjne[2]=pomnozButton;
        pryciski_funkcyjne[3]=podzielButton;
        pryciski_funkcyjne[4]=rownaButton;
        pryciski_funkcyjne[5]=usunButton;

        for(int i=0; i<6;i++){
            pryciski_funkcyjne[i].addActionListener(this);
            pryciski_funkcyjne[i].setBackground(new Color(255,205,0));
        }

        for(int i=0;i<10;i++){
            przyciski_numeryczne[i]=new JButton(String.valueOf(i));
            przyciski_numeryczne[i].addActionListener(this);
            przyciski_numeryczne[i].setBackground(new Color(200,200,200));
        }


        panel = new JPanel();
        panel.setBounds(50,110,300,400);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(przyciski_numeryczne[7]);
        panel.add(przyciski_numeryczne[8]);
        panel.add(przyciski_numeryczne[9]);
        panel.add(dodajButton);
        panel.add(przyciski_numeryczne[4]);
        panel.add(przyciski_numeryczne[5]);
        panel.add(przyciski_numeryczne[6]);
        panel.add(odejmijButton);
        panel.add(przyciski_numeryczne[1]);
        panel.add(przyciski_numeryczne[2]);
        panel.add(przyciski_numeryczne[3]);
        panel.add(pomnozButton);
        panel.add(usunButton);
        panel.add(przyciski_numeryczne[0]);
        panel.add(podzielButton);
        panel.add(rownaButton);


        panel.setBackground(new Color(10,10,10));



        panelM.add(poletekstowe2);
        panelM.add(poletekstowe);
        panelM.add(panel);

        ramka.add(panelM);

        ramka.setVisible(true);
    }

    public static void main(String[] args){
        Kalkulator kalk = new Kalkulator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource() == przyciski_numeryczne[i]){
                poletekstowe.setText(poletekstowe.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dodajButton){
            liczba1 = Double.parseDouble(poletekstowe.getText());
            znak='+';
            poletekstowe2.setText(poletekstowe.getText()+String.valueOf(znak));
            poletekstowe.setText("");
        }
        if(e.getSource() == odejmijButton){
            liczba1 = Double.parseDouble(poletekstowe.getText());
            znak='-';
            poletekstowe2.setText(poletekstowe.getText()+String.valueOf(znak));
            poletekstowe.setText("");
        }
        if(e.getSource() == pomnozButton){
            liczba1 = Double.parseDouble(poletekstowe.getText());
            znak='*';
            poletekstowe2.setText(poletekstowe.getText()+String.valueOf(znak));
            poletekstowe.setText("");
        }
        if(e.getSource() == podzielButton){
            liczba1 = Double.parseDouble(poletekstowe.getText());
            znak='/';
            poletekstowe2.setText(poletekstowe.getText()+String.valueOf(znak));
            poletekstowe.setText("");
        }
        if(e.getSource() == usunButton){
            liczba1=0;
            poletekstowe2.setText("");
            poletekstowe.setText("");
        }
        if(e.getSource() == rownaButton){
            liczba2 = Double.parseDouble(poletekstowe.getText());

            switch (znak){
                case'+':
                    wynik = liczba1 + liczba2;
                    break;
                case'-':
                    wynik = liczba1 - liczba2;
                    break;
                case'*':
                    wynik = liczba1 * liczba2;
                    break;
                case'/':
                    wynik = liczba1 / liczba2;
                    break;
                default:

            }
            poletekstowe.setText(String.valueOf(wynik));
            liczba1=wynik;
        }
    }
}
