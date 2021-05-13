package View;

import javax.swing.*;

public class MainForm extends JFrame
{
    private JTextField CestaSouboruText;
    private JButton Vyber_soubor_tlacitko;
    private JButton Generovat_Klic_Tlacitko;
    private JTextField Cesta_Klic_Text;
    private JButton Vyber_Klic_Tlacitko;
    private JButton Sifrovat_Klic_Tlacitko;
    private JPanel mainContainer;

    public MainForm()
    {
        setSize(480, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainContainer);

    }


    public JTextField getCestaSouboruText() {
        return CestaSouboruText;
    }

    public JButton getVyber_soubor_tlacitko() {
        return Vyber_soubor_tlacitko;
    }

    public JButton getGenerovat_Klic_Tlacitko() {
        return Generovat_Klic_Tlacitko;
    }

    public JTextField getCesta_Klic_Text() {
        return Cesta_Klic_Text;
    }

    public JButton getVyber_Klic_Tlacitko() {
        return Vyber_Klic_Tlacitko;
    }

    public JButton getSifrovat_Klic_Tlacitko() {
        return Sifrovat_Klic_Tlacitko;
    }
}
