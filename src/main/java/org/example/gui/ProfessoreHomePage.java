package org.example.gui;

import org.example.app.InserisciPresenzaQuery;
import org.example.entita.Account;
import org.example.entita.Professore;

import javax.swing.*;
import java.awt.*;

public class ProfessoreHomePage extends JPanel {

    ProfessoreHomePage(Account acc) {
        this.acc = acc;
        setLayout(new GridLayout(3, 1));
        homeLabel = new JLabel("Benvenuto " + acc.getNome() + " " + acc.getCognome(), SwingConstants.LEFT);
        homeLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 28));
        homeLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        homeLabel.setIcon(new ImageIcon("Image/ico6.png"));
        add(homeLabel);
        createPanel();
        setBackground(AppViewer.BACKGROUND);

    }

    private void createPanel() {
        mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setBackground(AppViewer.BACKGROUND);
        createButtonPanel();
        createLabelPanel();
        add(mainPanel);
    }

    private void createButtonPanel() {
        buttonPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel.setBackground(AppViewer.BACKGROUND);
        creaLezioneButton.setIcon(new ImageIcon("Image/icon3.png"));
        creaLezioneButton.addActionListener((e) -> {
            JFrame frame = new CreaNuovaLezioneViewer(acc);
        });
        buttonPanel.add(creaLezioneButton);
        visuallizzaButton.setIcon(new ImageIcon("Image/icon2.png"));
        visuallizzaButton.addActionListener((e) -> {
            JFrame frame = new VisualizzaStorico(acc);
        });
        buttonPanel.add(visuallizzaButton);

        inserisciCertificazioneButton.addActionListener((e) -> {
            JFrame frame = new InserisciCertificazioneViewer(acc);
        });
        inserisciCertificazioneButton.setIcon(new ImageIcon("Image/icon6.png"));
        buttonPanel.add(inserisciCertificazioneButton);
        segnaPresenze.addActionListener((e)->{
            JFrame frame = new InserisciPresenzaViewer(acc);
        });
        segnaPresenze.setIcon(new ImageIcon("Image/icon7.png"));
        buttonPanel.add(segnaPresenze);
        mainPanel.add(buttonPanel);
    }

    private void createLabelPanel() {
        labelPanel = new JPanel(new GridLayout(1, 1));
        labelPanel.setBackground(AppViewer.BACKGROUND);
        JLabel infoLabel = new JLabel("<html>" + "Info Profilo <br />" + "Nome: " + acc.getNome() + " <br />" + "Cognome: " + acc.getCognome() + " <br />" + "E-mail: " + acc.getEmail() + " <br />", SwingConstants.RIGHT);
        infoLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        infoLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        labelPanel.add(infoLabel);
        mainPanel.add(labelPanel);

    }


    private final JLabel homeLabel;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel labelPanel;
    private JButton creaLezioneButton = new JButton("Crea Nuova Lezione");
    private JButton visuallizzaButton = new JButton("Visulizza Storico Lezioni");
    private JButton inserisciCertificazioneButton = new JButton("Inserisci Certificazione");
    private JButton segnaPresenze = new JButton("Segna Presenze");
    private JPanel infoPanel;
    private Account acc;
}
