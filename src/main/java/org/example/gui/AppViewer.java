package org.example.gui;

import org.example.app.CheckData;
import org.example.entita.Account;
import org.example.entita.Studente;
import org.example.exception.DataProblemException;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.sql.SQLException;

public class AppViewer extends JFrame {

    private static final long serialVersionUID = 1L;

    public AppViewer(String title) {
        super(title);
        this.title = title;
        createMenu();
        createPanel();
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void createPanel() {
        mainPanel = new JPanel();
        mainPanel.setBackground(BACKGROUND);
        createRegisterPanel();
        login = new LoginViewer(title);
        mainPanel.add(login);
        mainPanel.add(registerPanel);
        add(mainPanel);
    }

    private void createRegisterPanel() {
        registerPanel = new JPanel();
        registerPanel.setBackground(BACKGROUND);
        registerLabel.setForeground(LABEL_BACKGROUND);
        registerPanel.add(loginButton);
        registerPanel.add(registerLabel);
        registerPanel.add(registerButton);
        createButton();
    }

    private void createButton() {
        registerButton.addActionListener((e) -> {
            setSize(400, 600);
            state--;
            mainPanel.removeAll();
            mainPanel.add(register);
            mainPanel.add(registerPanel);
            registerPanel.remove(registerLabel);
            registerPanel.remove(loginButton);

            if (state == 0) {
                System.out.println(register.returnData());
                CheckData dataCheck = new CheckData(register.returnData());
                addHomePage(dataCheck);
            }
            forcedRevalidate();
        });
        loginButton.addActionListener((e) -> {
            CheckData dataCheck = new CheckData(login.returnData());
            addHomePage(dataCheck);
        });
        exit.addActionListener((e) -> System.exit(EXIT_ON_CLOSE));
        logOut.addActionListener((e) -> {
            state = 2;
            setSize(400, 350);
            refresh();
        });
        dark.addActionListener((e) -> {
            BACKGROUND = new Color(32, 32, 32);
            LABEL_BACKGROUND = Color.white;
            refresh();
        });
        light.addActionListener((e) -> {
            BACKGROUND = new Color(255, 250, 240);
            LABEL_BACKGROUND = Color.black;
            refresh();
        });
    }

    private void refresh() {
        mainPanel.removeAll();
        mainPanel.setBackground(BACKGROUND);
        registerPanel.setBackground(BACKGROUND);
        registerLabel.setForeground(LABEL_BACKGROUND);
        login = new LoginViewer(title);
        register = new RegisterViewer();

        switch (state) {
            case 0: {
                chooseHomePage(acc);
                break;
            }
            case 1: {
                mainPanel.add(register);
                mainPanel.add(registerPanel);
                break;
            }
            case 2: {
                mainPanel.add(login);
                registerPanel.add(loginButton);
                registerPanel.add(registerLabel);
                registerPanel.add(registerButton);
                mainPanel.add(registerPanel);
                break;
            }
        }
        forcedRevalidate();

    }

    private void forcedRevalidate() {
        setSize(getWidth() + 1, getHeight());
        setSize(getWidth() - 1, getHeight());
    }

    private void createMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenu tema = new JMenu("Temi");
        JMenu icon = new JMenu("");
        icon.setIcon(new ImageIcon("Image/icon5.png"));
        logOut = new JMenuItem("LogOut");
        exit = new JMenuItem("Uscita");
        dark = new JMenuItem("Dark");
        light = new JMenuItem("Light");
        menu.add(exit);
        menu.add(logOut);
        tema.add(light);
        tema.add(dark);
        bar.add(icon);
        bar.add(menu);
        bar.add(tema);
        setJMenuBar(bar);
    }

    private void addHomePage(CheckData dataCheck) {
        try {
            acc = dataCheck.chek();
            setSize(700, 500);
            mainPanel.removeAll();
            chooseHomePage(acc);
            state = 0;
            forcedRevalidate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DataProblemException ex) {
            login.setError();
        }
    }

    private void chooseHomePage(Account acc) {
        if (acc.getClass() == Studente.class)
            mainPanel.add(new StudenteHomePage(acc));
        else
            mainPanel.add(new ProfessoreHomePage(acc));
    }

    public static Color BACKGROUND = new Color(255, 250, 240);
    public static Color LABEL_BACKGROUND = Color.black;
    private JPanel mainPanel;
    private JPanel registerPanel;

    // L'intero state monitora lo stato del programma 2 = Login, 1 = Registrazione , 0 = HomePage
    private int state = 2;
    private JMenuItem exit;
    private JMenuItem logOut;
    private JMenuItem dark;
    private JMenuItem light;
    private final JLabel registerLabel = new JLabel("Se non sei registrato");
    private final JButton registerButton = new JButton("Register");
    private final JButton loginButton = new JButton("Login");
    private final String title;
    private LoginViewer login;
    private RegisterViewer register = new RegisterViewer();
    private Account acc;

}

