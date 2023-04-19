package rocks.zipcode.textedit;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ZipEdit extends JFrame implements ActionListener {
    private JTextArea area;
    private JFrame frame;
    private String filename = "untitled";

    public ZipEdit() {
    }

    public static void main(String[] args) {
        ZipEdit runner = new ZipEdit();
        runner.run();
    }

    public void run() {
        frame = new JFrame(frameTitle());

        // Set the look-and-feel (LNF) of the application
        // Try to default to whatever the host system prefers
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ZipEdit.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Set attributes of the app window
        area = new JTextArea();
        // Border blackline = BorderFactory.createLineBorder(Color.black);
        // area.setBorder(blackline);
        area.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        area.setText("");
        frame.setDefaultCloseOperation(JFrame.EXITONCLOSE);
        frame.add(area);
        frame.setLocationRelativeTo(null);
        frame.setSize(640, 480);

        // Build the menu
        JMenuBar menumain = new JMenuBar();

        JMenu menufile = new JMenu("File");

        JMenuItem menuitemnew = new JMenuItem("New");
        JMenuItem menuitemopen = new JMenuItem("Open");
        JMenuItem menuitemsave = new JMenuItem("Save");
        JMenuItem menuitemquit = new JMenuItem("Quit");

        menuitemnew.addActionListener(this);
        menuitemopen.addActionListener(this);
        menuitemsave.addActionListener(this);
        menuitemquit.addActionListener(this);

        menumain.add(menufile);

        menufile.add(menuitemnew);
        menufile.add(menuitemopen);
        menufile.add(menuitemsave);
        menufile.add(menuitemquit);

        frame.setJMenuBar(menumain);

        frame.setVisible(true);

    }

    public String frameTitle() {
        return "Zip Edit (" + this.filename + ")";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ingest = "";
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose destination.");
        jfc.setFileSelectionMode(JFileChooser.FILESANDDIRECTORIES);

        String ae = e.getActionCommand();
        int returnValue;
        if (ae.equals("Open")) {
            returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVEOPTION) {
                File f = new File(jfc.getSelectedFile().getAbsolutePath());
                this.filename = jfc.getSelectedFile().getName();
                this.frame.setTitle(this.frameTitle());
                try {
                    FileReader read = new FileReader(f);
                    Scanner scan = new Scanner(read);
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine() + "\n";
                        ingest = ingest + line;
                    }
                    area.setText(ingest);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
            // SAVE
        } else if (ae.equals("Save")) {
            returnValue = jfc.showSaveDialog(null);
            this.filename = jfc.getSelectedFile().getName();
            this.frame.setTitle(this.frameTitle());
            try {
                File f = new File(jfc.getSelectedFile().getAbsolutePath());
                FileWriter out = new FileWriter(f);
                out.write(area.getText());
                out.close();
            } catch (FileNotFoundException ex) {
                Component f = null;
                JOptionPane.showMessageDialog(f, "File not found.");
            } catch (IOException ex) {
                Component f = null;
                JOptionPane.showMessageDialog(f, "Error.");
            }
        } else if (ae.equals("New")) {
            area.setText("");
        } else if (ae.equals("Quit")) {
            System.exit(0);
        }
    }
}
