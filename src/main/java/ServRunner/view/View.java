package ServRunner.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * View
 */
public class View {

    private JFrame frame = new JFrame("Servidor NPJ");
    private JPanel mainPanel = new JPanel();
    private List<ViewListener> listeners = new ArrayList<>();

    public View() {
        setupFrame();

        frame.getContentPane().add(mainPanel);
        setupUpdateBtn();
        setupBootRunBtn();
        setupFileChooser();
        frame.setVisible(true);
    }

    private void setupFrame() {
        frame.setVisible(false);
        Dimension d = new Dimension(320, 240);
        frame.setSize(d);
        frame.setMaximumSize(d);
        frame.setMinimumSize(d);
        frame.setResizable(false);
    }

    private void setupUpdateBtn() {
        JButton btnUpdate = new JButton("Atualizar");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ViewListener listener : listeners) {
                    listener.updateClicked();
                }
            }
        });
        mainPanel.add(btnUpdate);
    }

    private void setupBootRunBtn() {
        JButton btnBootRun = new JButton("Rodar");
        btnBootRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ViewListener listener : listeners) {
                    listener.bootRunClicked();
                }
            }
        });
        mainPanel.add(btnBootRun);
    }

    private void setupFileChooser() {
        JButton btnFileChooser = new JButton("Pasta");
        btnFileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });
        mainPanel.add(btnFileChooser);
    }

    private void chooseFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(mainPanel);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            for (ViewListener l : listeners) {
                l.chosenFile(chooser.getSelectedFile().getAbsolutePath());
            }
        }        
    }

    public void addListener(ViewListener l) {
        this.listeners.add(l);
    }

}