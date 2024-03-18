import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.*;

public class SimpleGUI extends JFrame {

    FileWriterAndReader fwr = new FileWriterAndReader();

    private File file;
    private JPanel mainPanel;
    private JLabel labelForWrite;
    private JLabel labelForRead;
    private JButton buttonWrite;
    private JButton buttonClear;
    private JButton buttonRead;
    private JTextArea textToWrite;
    private JTextPane textFromFile;
    private JTextField wayToFile;
    private JButton buttonCatch;
    private JButton buttonChooser;
//    private JFileChooser chooser = new JFileChooser();

    public SimpleGUI() {
        setContentPane(mainPanel);
        setTitle("FileWriterAndReader");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 400, dimension.height / 2 - 225, 800, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        buttonRead.addActionListener(listenerForReadButton);
        buttonWrite.addActionListener(listenerForWriteButton);
        buttonClear.addActionListener(listenerForClearButton);
        buttonCatch.addActionListener(listenerForCatchButton);
        buttonChooser.addActionListener(listenerForChooserButton);

        file = null;
    }

    ActionListener listenerForReadButton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            readFromFile();
        }
    };

    ActionListener listenerForWriteButton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fromTextField = textToWrite.getText();
            System.out.println(fromTextField);
            FileWriterAndReader.writeText(fromTextField, file);
            readFromFile();
            textToWrite.setText("");
        }
    };

    ActionListener listenerForClearButton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            FileWriterAndReader.clearFile(file);
            readFromFile();
            textToWrite.setText("");
        }
    };

    ActionListener listenerForCatchButton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String path = wayToFile.getText();
            file = new File(path);
            if (file.exists()) buttonCatch.setText("Catched");
            readFromFile();
        }
    };

    ActionListener listenerForChooserButton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("C:\\Users\\Александр\\IdeaProjects"));
            fc.showOpenDialog(null);
            file = fc.getSelectedFile();
        }
    };

    public void readFromFile() {
        List<String> listFromFile = FileWriterAndReader.getFileToListString(file);
        String textFromReader = String.join("\n", listFromFile);
        textFromFile.setText(textFromReader);
    }


}





//    private JButton button = new JButton("Press");
//    private JTextField input = new JTextField("", 5);
//    private JLabel label = new JLabel("Input:");
//    private JRadioButton radio1 = new JRadioButton("Select this");
//    private JRadioButton radio2 = new JRadioButton("Select that");
//    private JCheckBox check = new JCheckBox("Check", false);
//
//    public SimpleGUI () {
//        super("Simple Example");
//        this.setBounds(100, 100, 250, 100);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        Container container = this.getContentPane();
//        container.setLayout(new GridLayout(3, 2, 2, 2));
//        container.add(label);
//        container.add(input);
//        ButtonGroup group = new ButtonGroup();
//        group.add(radio1);
//        group.add(radio2);
//        container.add(radio1);
//        radio1.setSelected(true);
//        container.add(radio2);
//        container.add(check);
//        button.addActionListener(new ButtonEventListener());
//        container.add(button);
//    }
//
//    class ButtonEventListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String message = "";
//            message += "Button was pressed\n";
//            message += "Text is " + input.getText() + "\n";
//            message += (radio1.isSelected() ? "Radio#1" : "Radio#2") + " is selected\n";
//            message += "Checkbox is " + ((check.isSelected()) ? "checked" : "unchecked");
//            JOptionPane.showMessageDialog(null, message, "output", JOptionPane.PLAIN_MESSAGE);
//        }
//    }



