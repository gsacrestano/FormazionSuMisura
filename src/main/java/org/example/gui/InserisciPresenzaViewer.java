package org.example.gui;

import org.example.app.RaccogliDatiDB;
import org.example.app.InserisciPresenzaQuery;
import org.example.app.RaccogliDatiDB;
import org.example.entita.Account;

import javax.swing.*;

public class InserisciPresenzaViewer extends JFrame {


    InserisciPresenzaViewer(Account acc) {
        this.account = acc;
        lezioni = new JComboBox<>(RaccogliDatiDB.getLezioni(account.getId()));
        createmainPanel();
        setSize(300, 300);
        setResizable(false);
        setVisible(true);

    }

    private void createmainPanel() {
        mainPanel = new JPanel();
        mainPanel.setBackground(AppViewer.BACKGROUND);
        inserisciStudente.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(inserisciStudente);
        mainPanel.add(studenti);
        scegliLezioni.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(scegliLezioni);
        mainPanel.add(lezioni);
        JButton inserisciButton = new JButton("Segna Presenza");
        inserisciButton.addActionListener((e) -> {
            InserisciPresenzaQuery inserisciPresenzaQuery = new InserisciPresenzaQuery(Integer.parseInt("" + ((String) studenti.getSelectedItem()).charAt(0)), Integer.parseInt("" + ((String) lezioni.getSelectedItem()).charAt(0)));
            inserisciPresenzaQuery.doQuery();
            setVisible(false);
        });
        mainPanel.add(inserisciButton);
        add(mainPanel);
    }


    private JPanel mainPanel;
    private JLabel inserisciStudente = new JLabel("Scegli Studenti");

    private JComboBox<String> studenti = new JComboBox<>(RaccogliDatiDB.getStudenti());
    private JLabel scegliLezioni = new JLabel("Scegli lezioni");
    private JComboBox<String> lezioni;
    private Account account;
}
