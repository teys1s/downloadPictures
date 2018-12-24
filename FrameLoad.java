package home_practic.url_load;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameLoad extends JFrame {
    protected String url;

    public FrameLoad() {
        JFrame frame = new JFrame("Load and Save File");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel();
        JTextField field = new JTextField();
        JScrollPane pane = new JScrollPane(label);
        JButton buttonLoad = new JButton("Load");
        JButton buttonSave = new JButton("Save");
        panel.add(field, BorderLayout.NORTH);
        panel.add(buttonLoad, BorderLayout.WEST);
        panel.add(buttonSave, BorderLayout.EAST);
        panel.add(pane, BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(1280, 1024));
        frame.pack();
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    url = field.getText();
                    String file = String.valueOf(chooser.getSelectedFile());
                    FileDown.download(url, file);

                }
            }
        });

        buttonLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                url = field.getText();
                label.setIcon(new ImageIcon(FileDown.loadImage(url)));
            }
        });

    }

}
