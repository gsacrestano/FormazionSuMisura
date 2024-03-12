package org.example.gui;

import org.example.app.RaccogliDatiDB;
import org.example.app.CreaNuovaLezioneQuery;
import org.example.entita.Account;
import org.example.entita.Lezione;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class CreaNuovaLezioneViewer extends JFrame {

    CreaNuovaLezioneViewer(Account acc) {
        this.acc = acc;
        createmainPanel();
        setResizable(false);
        setSize(400, 450);
        setVisible(true);

    }

    private void createmainPanel() {
        mainPanel = new JPanel(new GridLayout(16, 1));
        mainPanel.setBackground(AppViewer.BACKGROUND);
        createFirstLabel();
        createTipologia();
        createData();
        createOra();
        createClass();
        createPacchetti();
        createArgomenti();
        createNote();
        createButton();
        add(mainPanel);

    }

    private void createFirstLabel() {
        firstLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        firstLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(firstLabel);
    }

    private void createTipologia() {
        tipologiaLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(tipologiaLabel);
        mainPanel.add(tipologiaFiedl);

    }

    private void createData() {
        dataLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(dataLabel);
        JPanel dataPanel = new JPanel(new GridLayout(1, 3));
        dataPanel.setBackground(AppViewer.BACKGROUND);
        dataPanel.add(dataGG);
        dataPanel.add(dataMM);
        dataPanel.add(dataAA);
        mainPanel.add(dataPanel);
    }

    private void createOra() {
        oraLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(oraLabel);
        JPanel oraPanel = new JPanel(new GridLayout(1, 2));
        oraPanel.setBackground(AppViewer.BACKGROUND);
        oraPanel.add(oreHH);
        oraPanel.add(oreMM);
        mainPanel.add(oraPanel);
    }

    private void createClass() {
        inserisciCodiceClasse = new JLabel("Seleziona codice classe");
        inserisciCodiceClasse.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(inserisciCodiceClasse);
        mainPanel.add(classeField);
    }

    private void createNote() {
        noteLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(noteLabel);
        mainPanel.add(noteField);
    }

    private void createPacchetti() {
        JLabel pacchettoLabel = new JLabel("Scegli Studente A Cui aggiungerla");
        pacchettoLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(pacchettoLabel);
        mainPanel.add(pacchetti);
    }

    private void createArgomenti() {
        JLabel argomentoLabel = new JLabel("Scegli Argomento da Trattare");
        argomentoLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(argomentoLabel);
        mainPanel.add(argomenti);
    }

    private void createButton() {
        JButton inserisci = new JButton("Inserisci");
        inserisci.addActionListener((e) -> {
            Lezione lezione = new Lezione(0, Integer.parseInt(String.valueOf(((String) tipologiaFiedl.getSelectedItem()).charAt(0))), noteField.getText(), (String) oreHH.getSelectedItem() + ":" + (String) oreMM.getSelectedItem(), (String) dataAA.getSelectedItem() + "-" + (String) dataMM.getSelectedItem() + "-" + (String) dataGG.getSelectedItem());
            CreaNuovaLezioneQuery cQ = new CreaNuovaLezioneQuery(acc, lezione, Integer.parseInt((String) classeField.getSelectedItem()), Integer.parseInt("" + ((String) pacchetti.getSelectedItem()).charAt(0)), Integer.parseInt("" + ((String) argomenti.getSelectedItem()).charAt(0)));
            cQ.doQuery();
            setVisible(false);
        });
        mainPanel.add(inserisci);

    }

    private JPanel mainPanel;
    private final JLabel firstLabel = new JLabel("Aggiungi Lezione", SwingConstants.CENTER);
    private final JLabel tipologiaLabel = new JLabel("Tipologia");
    private final JComboBox<String> tipologiaFiedl = new JComboBox<>(new String[]{"0 -Pratica", "1 -Teorica", "2 -Ibrida"});
    private final JLabel dataLabel = new JLabel("Inserisci data");

    private final String[] giorni = IntStream.rangeClosed(1, 31)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
    private final JComboBox<String> dataGG = new JComboBox<>(giorni);
    private final String[] mesi = IntStream.rangeClosed(1, 12)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
    private final JComboBox<String> dataMM = new JComboBox<>(mesi);
    private final String[] anni = IntStream.rangeClosed(2024, 2026)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
    private final JComboBox<String> dataAA = new JComboBox<>(anni);

    private final JLabel oraLabel = new JLabel("Inserisci Ora");
    private final String[] ore = IntStream.rangeClosed(0, 23)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
    private final JComboBox<String> oreHH = new JComboBox<>(ore);

    private final String[] minuti = IntStream.rangeClosed(0, 59)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
    private final JComboBox<String> oreMM = new JComboBox<>(minuti);
    private final JLabel noteLabel = new JLabel("Aggiungi Note");
    private final JTextField noteField = new JTextField(20);
    private Account acc;
    private JLabel inserisciCodiceClasse;
    private JComboBox<String> classeField = new JComboBox<>(RaccogliDatiDB.getAule());
    private JComboBox<String> pacchetti = new JComboBox<>(RaccogliDatiDB.getAquisti());
    private JComboBox<String> argomenti = new JComboBox<>(RaccogliDatiDB.getArgomenti());

}
