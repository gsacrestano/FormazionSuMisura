package org.example.gui;

import org.example.app.AggiungiLezioneQuery;
import org.example.app.RaccogliDatiDB;
import org.example.entita.Account;

import javax.swing.*;
import java.awt.*;

public class AggiungiLezioniViewer extends JFrame {


    AggiungiLezioniViewer(Account acc) {
        this.acc = acc;
        pacchetti = new JComboBox<>(RaccogliDatiDB.getAquisti(acc.getId()));
        setSize(400, 300);
        createMainPanel();
        setResizable(false);
        setVisible(true);

    }

    private void createMainPanel() {
        mainPanel = new JPanel(new GridLayout(5, 1));
        mainPanel.setBackground(AppViewer.BACKGROUND);
        scegliTraPacchettiLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(scegliTraPacchettiLabel);
        mainPanel.add(pacchetti);
        scegliNumeroLezioni.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(scegliNumeroLezioni);
        mainPanel.add(numeri);
        JButton aggiungi = new JButton("Aggiungi");
        aggiungi.addActionListener((e) -> {
            AggiungiLezioneQuery aggiungiLezioneQuery = new AggiungiLezioneQuery(Integer.parseInt("" + ((String) pacchetti.getSelectedItem()).charAt(0)), Integer.parseInt("" + ((String) numeri.getSelectedItem()).charAt(0)));
            aggiungiLezioneQuery.doQuery();
            setVisible(false);

        });
        mainPanel.add(aggiungi);
        add(mainPanel);

    }


    private Account acc;
    private JPanel mainPanel;
    private JLabel scegliTraPacchettiLabel = new JLabel("Pacchetti a cui aggiunere lezioni");
    private JComboBox<String> pacchetti;
    private JLabel scegliNumeroLezioni = new JLabel("Scegli quante lezioni fare");
    private JComboBox<String> numeri = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});


}
