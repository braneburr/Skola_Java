package Controller;
import Model.Model;
import View.MainForm;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFormController
{
    private Model model;
    private MainForm mf;


    public MainFormController(Model model, MainForm mf)
    {
        this.model = model;
        this.mf = mf;
        InitListeners();
    }
    public void InitListeners()
    {
        mf.getVyber_soubor_tlacitko().addActionListener(new OtevreniSouboru());
        mf.getGenerovat_Klic_Tlacitko().addActionListener(new Vygenerovani());
        mf.getVyber_Klic_Tlacitko().addActionListener(new OtevreniKlice());
        mf.getSifrovat_Klic_Tlacitko().addActionListener(new Zasifrovani());
    }
    public void ApplicationStart()
    {
        mf.setVisible(true);
    }

    public class OtevreniSouboru implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(new FileNameExtensionFilter("Textové soubory: (*.txt)", "txt"));
            int konec = jfc.showOpenDialog(null);

            if (konec == JFileChooser.APPROVE_OPTION) {
                File file = jfc.getSelectedFile();
                model.setFile(jfc.getSelectedFile());
                mf.getCestaSouboruText().setText(file.getPath());
            }
            if (model.getFile() != null){
                mf.getVyber_Klic_Tlacitko().setEnabled(true);
                mf.getGenerovat_Klic_Tlacitko().setEnabled(true);
            }
            else {
                mf.getVyber_Klic_Tlacitko().setEnabled(false);
                mf.getGenerovat_Klic_Tlacitko().setEnabled(false);
            }
            mf.getSifrovat_Klic_Tlacitko().setEnabled(model.getFile() != null && model.getKeyFile() != null);
        }
    }

    public class Vygenerovani implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(new FileNameExtensionFilter("Textové soubory: (*.txt)", "txt"));
            int konec = jfc.showSaveDialog(null);

            if (konec == JFileChooser.APPROVE_OPTION) {
                String klic = model.VygenerovatKlic();
                model.m.Ulozeni(klic, jfc.getSelectedFile());
                model.setKeyFile(jfc.getSelectedFile());
                mf.getCesta_Klic_Text().setText(jfc.getSelectedFile().getPath());
            }
            mf.getSifrovat_Klic_Tlacitko().setEnabled(model.getFile() != null && model.getKeyFile() != null);
        }
    }

    public class OtevreniKlice implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(new FileNameExtensionFilter("Textove soubory: (*.txt)", "txt"));
            int konec = jfc.showOpenDialog(null);

            if (konec == JFileChooser.APPROVE_OPTION) {
                model.setKeyFile(jfc.getSelectedFile());
                mf.getCesta_Klic_Text().setText(jfc.getSelectedFile().getPath());
            }
            mf.getSifrovat_Klic_Tlacitko().setEnabled(model.getFile() != null && model.getKeyFile() != null);
        }
    }

    public class Zasifrovani implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String SifrovanyText = model.Sifra();
            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(new FileNameExtensionFilter("Textové soubory: (*.txt)", "txt"));
            int konec = jfc.showSaveDialog(null);
            if (konec == JFileChooser.APPROVE_OPTION){
                model.m.Ulozeni(SifrovanyText, jfc.getSelectedFile());
                JOptionPane.showMessageDialog(mf, "Zašifrováno.");
            }
        }
    }
}
