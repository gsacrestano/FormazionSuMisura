package org.example.gui;

import org.example.app.VisualizzaLezioniFutureQuery;
import org.example.app.VisualizzaPresenzeQuery;
import org.example.entita.Account;

import javax.swing.*;
import java.sql.SQLException;

public class VisualizzaProgrammate extends JFrame {


    VisualizzaProgrammate(Account acc) {
        this.acc = acc;
        setResizable(false);
        setSize(300, 400);
        createPanel();
        setVisible(true);

    }

    private void createPanel() {
        mainPanel = new JPanel();
        mainPanel.setBackground(AppViewer.BACKGROUND);

        JLabel storicoLabel = new JLabel("Ecco Le Lezioni Programmate ", SwingConstants.CENTER);

        storicoLabel.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(storicoLabel);
        VisualizzaLezioniFutureQuery vQ = new VisualizzaLezioniFutureQuery(acc);
        try {
            for (String s : vQ.doQuery())
                addLabel(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        add(mainPanel);


    }

    private void addLabel(String s) {
        JLabel lab = new JLabel(s);
        lab.setForeground(AppViewer.LABEL_BACKGROUND);
        mainPanel.add(lab);
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    private String query;
    private JPanel mainPanel;
    private Account acc;
}

