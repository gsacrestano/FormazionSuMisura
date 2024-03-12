package org.example.gui;

import org.example.app.AggiungiCertificazione;
import org.example.app.RaccogliDatiDB;
import org.example.entita.Account;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class InserisciCertificazioneViewer extends JFrame {
    InserisciCertificazioneViewer(Account acc) {
        this.acc = acc;
        createmainPanel();
        add(mainPanel);
        setResizable(false);
        setSize(300, 400);
        setVisible(true);
    }

    private void createmainPanel() {
        mainPanel = new JPanel();
        mainPanel.setBackground(AppViewer.BACKGROUND);
        createTitle();
        createData();
        createButton();
    }

    private void createTitle() {
        JLabel titleLabel = new JLabel("Inserisci Nome Certificazione", SwingConstants.CENTER);
        titleLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(titleLabel);
        nomeField = new JComboBox<>(RaccogliDatiDB.getCertificazioni());
        mainPanel.add(nomeField);


    }

    private void createData() {

        JLabel insericiDataConseguimento = new JLabel("Inserisici Data di Conseguimento");
        insericiDataConseguimento.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(insericiDataConseguimento);
        JPanel dataPanel = new JPanel(new GridLayout(1, 3));
        dataPanel.setBackground(AppViewer.BACKGROUND);
        dataPanel.add(dataGG);
        dataPanel.add(dataMM);
        dataPanel.add(dataAA);
        mainPanel.add(dataPanel);
    }

    private void createButton() {
        JButton inserisci = new JButton("Inserisci");
        inserisci.addActionListener((e) -> {
            AggiungiCertificazione aggiungiCertificazione = new AggiungiCertificazione(acc.getId(), Integer.parseInt("" + ((String) nomeField.getSelectedItem()).charAt(0)));
            aggiungiCertificazione.doQuery();
            setVisible(false);
        });
        mainPanel.add(inserisci);
    }


    private final String[] giorni = IntStream.rangeClosed(1, 31)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
    private final JComboBox<String> dataGG = new JComboBox<>(giorni);
    private final String[] mesi = IntStream.rangeClosed(1, 12)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
    private final JComboBox<String> dataMM = new JComboBox<>(mesi);
    private final JComboBox<String> dataAA = new JComboBox<>(new String[]{"2024", "2025", "2026", "2027"});
    private JPanel mainPanel;
    JComboBox<String> nomeField;
    private Account acc;
}
