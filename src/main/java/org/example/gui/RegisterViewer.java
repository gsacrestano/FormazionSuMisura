package org.example.gui;

import org.example.entita.Account;
import org.example.entita.Indirizzo;

import javax.swing.*;
import java.awt.*;

public class RegisterViewer extends JPanel {

    private static final long serialVersionUID = 1L;

    RegisterViewer() {
        createPanel();
        setBackground(AppViewer.BACKGROUND);
    }

    private void createPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(18, 1));
        mainPanel.setBackground(AppViewer.BACKGROUND);
        addLabelandField(name, nameField);
        addLabelandField(surname, surnameField);
        addLabelandField(email, emailField);
        addLabelandField(password, passwordField);
        addLabelandField(indirizzo, indirizzoField);
        addLabelandField(cap, capField);
        addLabelandField(civico, civicofield);
        addLabelandField(dataDiNascita, nascitaField);
        studente.setForeground(AppViewer.LABEL_BACKGROUND);
        professore.setForeground(AppViewer.LABEL_BACKGROUND);
        combo.add(studente);
        combo.add(professore);

        mainPanel.add(studente);
        mainPanel.add(professore);
        add(mainPanel);

    }

    private void addLabelandField(JLabel label, JTextField field) {
        label.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(label);
        mainPanel.add(field);
    }

    private void createIndirizzo() {

    }

    protected Account returnData() {
        int id;
        if (studente.isSelected())
            id = -2;
        else
            id = -3;
        return new Account(id, nameField.getText(), surnameField.getText(), emailField.getText(), passwordField.getText(), new Indirizzo(indirizzoField.getText(), capField.getText(), Integer.parseInt(civicofield.getText())), nascitaField.getText());
    }


    private JPanel mainPanel;
    private final JLabel name = new JLabel("Name");
    private final JLabel surname = new JLabel("Surname");
    private final JLabel email = new JLabel("E-mail");
    private final JLabel password = new JLabel("Password");
    private final JLabel indirizzo = new JLabel("Indirizzo");
    private final JLabel civico = new JLabel("Civico");
    private final JLabel cap = new JLabel("CAP");
    private final JLabel dataDiNascita = new JLabel("Nascita");
    private final JRadioButton studente = new JRadioButton("Studente");
    private final JRadioButton professore = new JRadioButton("Professore");
    private final ButtonGroup combo = new ButtonGroup();
    private final JTextField nameField = new JTextField(20);
    private final JTextField surnameField = new JTextField(20);
    private final JTextField emailField = new JTextField(20);
    private final JTextField passwordField = new JTextField(20);
    private final JTextField indirizzoField = new JTextField(20);
    private final JTextField civicofield = new JTextField(20);
    private final JTextField capField = new JTextField(20);
    private final JTextField nascitaField = new JTextField(20);


}
