package org.example.gui;

import org.example.entita.Account;

import java.awt.*;
import javax.swing.*;

public class LoginViewer extends JPanel {

    private static final long serialVersionUID = 1L;

    LoginViewer(String title) {
        this.title = title;
        loginLabel = new JLabel(title.toUpperCase());
        loginLabel.setFont(new Font("Bold", Font.ITALIC, 18));
        createPanel();
        setBackground(AppViewer.BACKGROUND);
    }

    private void createPanel() {

        mainPanel = new JPanel();
        mainPanel.setBackground(AppViewer.BACKGROUND);
        mainPanel.setLayout(new GridLayout(5, 1));
        loginLabel.setFont(new Font("Bold", Font.PLAIN, 18));
        loginLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(loginLabel);
        createField();
        createButton();
        mainPanel.add(error);
        add(mainPanel);
    }

    private void createField() {
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        emailField.setText("gsacrestano@gmail.com");
        passwordField.setText("ForzaApple");
        mainPanel.add(emailField);
        mainPanel.add(passwordField);

    }

    private void createButton() {
        show = new JButton("Controlla Password");
        show.addActionListener((e) -> {
            if (!showPass)
                passwordField.setEchoChar((char) 0);
            else
                passwordField.setEchoChar('•');
            showPass = !showPass;

        });
        mainPanel.add(show);
    }

    protected Account returnData() {

        return new Account(-1, "", "", emailField.getText(), passwordField.getText(), null, "");
    }

    protected void setError() {
        error.setText("E-mail o password errata");
        error.setForeground(Color.red);
    }

    private final String title;
    private boolean showPass = false;
    private JPanel mainPanel;
    private final JLabel loginLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel error = new JLabel("");
    private JButton show;


}
