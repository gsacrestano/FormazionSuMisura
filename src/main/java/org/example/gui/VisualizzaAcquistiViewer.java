package org.example.gui;

import org.example.app.StoricoAcquistiQueryResult;
import org.example.entita.Account;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.stream.IntStream;

public class VisualizzaAcquistiViewer extends JFrame {

    VisualizzaAcquistiViewer(Account acc) {
        this.acc = acc;
        createmainPanel();
        add(mainPanel);
        setResizable(false);
        setSize(600, 500);
        setVisible(true);


    }

    private void createmainPanel() {
        mainPanel.setBackground(AppViewer.BACKGROUND);
        createFieldPanel();
        createQueryResult();

    }

    private void createQueryResult() {
        queryResultLabel = new JLabel("", SwingConstants.LEADING);
        queryResultLabel.setFont(new Font("Bold", Font.PLAIN, 16));
        queryResultLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(queryResultLabel);
    }


    private void createFieldPanel() {

        leftPanel = new JPanel();
        leftPanel.setBackground(AppViewer.BACKGROUND);
        createFiedlInizio();
        createFiedlFine();
        JButton cerca = new JButton("Cerca");
        cerca.addActionListener((e) -> {
            String dataInizio = (String) dataInzialeAA.getSelectedItem() + "-" + (String) dataInzialeMM.getSelectedItem() + "-" + (String) dataInzialeGG.getSelectedItem();
            String dataFine = (String) dataFinaleAA.getSelectedItem() + "-" + (String) dataFinaleMM.getSelectedItem() + "-" + (String) dataFinaleGG.getSelectedItem();
            StoricoAcquistiQueryResult acquistiQueryResultQ = new StoricoAcquistiQueryResult(dataInizio, dataFine, acc);
            try {
                queryResultLabel.setText("<html> Storico acquisti nelle date selezionate <br/>" + acquistiQueryResultQ.doQuery() + "</html>");
            } catch (SQLException es) {
                es.printStackTrace();
            }
        });
        leftPanel.add(cerca);
        mainPanel.add(leftPanel);


    }

    private void createFiedlInizio() {
        daInizio.setFont(new Font("Bold", Font.PLAIN, 18));
        daInizio.setForeground(AppViewer.LABEL_BACKGROUND);
        daInizio.setForeground(AppViewer.LABEL_BACKGROUND);
        leftPanel.add(daInizio);
        JPanel inizio = new JPanel(new GridLayout(1, 3));
        inizio.setBackground(AppViewer.BACKGROUND);
        inizio.add(dataInzialeGG);
        inizio.add(dataInzialeMM);
        inizio.add(dataInzialeAA);
        leftPanel.add(inizio);


    }

    private void createFiedlFine() {
        daFine.setFont(new Font("Bold", Font.PLAIN, 18));
        daFine.setForeground(AppViewer.LABEL_BACKGROUND);
        daFine.setForeground(AppViewer.LABEL_BACKGROUND);
        leftPanel.add(daFine);
        JPanel fine = new JPanel(new GridLayout(1, 3));
        fine.setBackground(AppViewer.BACKGROUND);
        fine.add(dataFinaleGG);
        fine.add(dataFinaleMM);
        fine.add(dataFinaleAA);
        leftPanel.add(fine);


    }


    private Account acc;
    private JPanel mainPanel = new JPanel(new GridLayout(1, 2));
    private JPanel leftPanel;
    private JPanel fieldPanel = new JPanel(new GridLayout(2, 4));

    private final String[] giorni = IntStream.rangeClosed(1, 31)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
    private final String[] mesi = IntStream.rangeClosed(1, 12)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
    private JComboBox<String> dataInzialeGG = new JComboBox<>(giorni);
    private JComboBox<String> dataInzialeMM = new JComboBox<>(mesi);
    private JComboBox<String> dataInzialeAA = new JComboBox<>(new String[]{"2024", "2025", "2026"});
    private JComboBox<String> dataFinaleGG = new JComboBox<>(giorni);
    private JComboBox<String> dataFinaleMM = new JComboBox<>(mesi);
    private JComboBox<String> dataFinaleAA = new JComboBox<>(new String[]{"2024", "2025", "2026"});

    private JLabel daInizio = new JLabel("Inserisci Data di Partenza", SwingConstants.CENTER);
    private JLabel daFine = new JLabel("Inserisci data Finale", SwingConstants.CENTER);
    JLabel queryResultLabel;
}
