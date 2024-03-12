package org.example.gui;


import org.example.app.RaccogliDatiDB;
import org.example.app.CreaAcquistoQuery;
import org.example.app.RaccogliDatiDB;
import org.example.entita.Account;
import org.example.entita.Acquisto;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class StudenteHomePage extends JPanel {


    private static final long serialVersionUID = 1L;

    public StudenteHomePage(Account acc) {
        this.acc = acc;
        System.out.println(acc);
        setBackground(AppViewer.BACKGROUND);
        setLayout(new GridLayout(2, 1));
        label = new JLabel("Benvenuto " + acc.getNome() + " " + acc.getCognome(), SwingConstants.LEFT);
        createPanel();
        add(mainPanel);
        setBackground(AppViewer.BACKGROUND);

    }

    private void createPanel() {
        mainPanel = new JPanel();
        mainPanel.setBackground(AppViewer.BACKGROUND);
        mainPanel.setLayout(new GridLayout(5, 1));
        createTitleLabel();
        createAcquistoPanel();
        createRecapLabel();
        createButtonPanel();
    }

    private void createTitleLabel() {
        label.setFont(new Font(Font.SERIF, Font.ITALIC, 28));
        label.setForeground(AppViewer.LABEL_BACKGROUND);
        label.setIcon(new ImageIcon("Image/ico.png"));
        mainPanel.add(label);
    }

    private void createRecapLabel() {
        recapLabel = new JLabel("<html>" +
                "Pacchetto Scelto: " + ((String) comboBox.getSelectedItem()).substring(2) + "<br />" +
                "Lista argomenti: <br />" + RaccogliDatiDB.getArgomentiMateri(((String) comboBox.getSelectedItem()).substring(2)) + "</html>", SwingConstants.LEFT);
        recapLabel.setFont(new Font("", Font.PLAIN, 14));
        recapLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(recapLabel);
    }

    private void createAcquistoPanel() {
        JPanel acquistoPanel = new JPanel();
        acquistoPanel.setBackground(AppViewer.BACKGROUND);
        acquistaLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        acquistaLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        acquistoPanel.add(acquistaLabel);
        acquistoPanel.add(comboBox);
        comboBox.addActionListener((e) -> {
            recapLabel.setText("<html>" +
                    "Pacchetto Scelto: " + ((String) comboBox.getSelectedItem()).substring(2) + "<br />" +
                    "Lista argomenti: <br />" + RaccogliDatiDB.getArgomentiMateri(((String) comboBox.getSelectedItem()).substring(2)) + "</html>");
        });
        acquistaButton.setIcon(new ImageIcon("Image/icon.png"));
        acquistaButton.addActionListener((e) -> {
            acquistaLabel.setText("Acquisto Effettuato");
            acquistaButton.setFont(new Font(Font.SERIF, Font.BOLD, 14));
            acquistaLabel.setForeground(Color.GREEN);
            Acquisto aquisto = new Acquisto(0, new Random().nextInt(20,150), 0);
            CreaAcquistoQuery creaAcquistoQuery = new CreaAcquistoQuery(aquisto, acc.getId(), Integer.parseInt("" + ((String) comboBox.getSelectedItem()).charAt(0)));
            creaAcquistoQuery.doQuery();
        });
        acquistoPanel.add(acquistaButton);
        mainPanel.add(acquistoPanel);
    }

    private void createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
        buttonPanel.setBackground(AppViewer.BACKGROUND);
        storicoButton.addActionListener((e) -> {
            JFrame frame = new VisualizzaAcquistiViewer(acc);
        });
        storicoButton.setIcon(new ImageIcon("Image/icon2.png"));
        buttonPanel.add(storicoButton);

        programmateButton.addActionListener((e) -> {
            JFrame frame = new VisualizzaProgrammate(acc);
        });
        programmateButton.setIcon(new ImageIcon("Image/icon3.png"));
        buttonPanel.add(programmateButton);
        presenzeButton.addActionListener((e) -> {
            JFrame frame = new VisualizzaStorico(acc);
        });
        presenzeButton.setIcon(new ImageIcon("Image/icon4.png"));
        buttonPanel.add(presenzeButton);
        JButton aggiungiLezioniAiTuoPaccheti = new JButton("Inserisci Lezioni Ai Tuoi Pacchetti");
        aggiungiLezioniAiTuoPaccheti.setIcon(new ImageIcon("Image/icon8.png"));
        aggiungiLezioniAiTuoPaccheti.addActionListener((e) -> {
            JFrame frame = new AggiungiLezioniViewer(acc);
        });
        buttonPanel.add(aggiungiLezioniAiTuoPaccheti);

        mainPanel.add(buttonPanel);

    }

    private Account acc;
    private JPanel mainPanel;
    private final JLabel label;
    private final JLabel acquistaLabel = new JLabel("Acquista Un Pacchetto");
    private final String[] pack = RaccogliDatiDB.getMaterie();
    private final JComboBox<String> comboBox = new JComboBox<>(pack);
    private final JButton acquistaButton = new JButton("Compra Pacchetto");
    private final JButton storicoButton = new JButton(" Visualizza Storico Acquisti");
    private final JButton programmateButton = new JButton("Prossime Lezioni Programmate");
    private final JButton presenzeButton = new JButton("Controlla le tue Presenze");
    private JLabel recapLabel;


}
