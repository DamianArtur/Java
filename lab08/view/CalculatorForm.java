import calculator.Solver;
import javax.swing.*;

public class CalculatorForm {
    private JButton zeroButton;
    private JButton dotButton;
    private JButton executeButton;
    private JButton additionButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton subtractionButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton multiplicationButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton divisionButton;
    private JButton clearButton;
    private JButton leftParenthesisButton;
    private JButton rightParenthesisButton;
    private JButton exitButton;
    private JPanel mainPanel;
    private JButton backSpaceButton;
    private JTextField displayTextField;

    public static CalculatorForm form;
    public static Solver solver = new Solver();

    public CalculatorForm() {

        zeroButton.addActionListener(e -> addCharacter("0"));

        dotButton.addActionListener(e -> {
            if (!displayTextField.getText().endsWith(".")) {
                displayTextField.setText(displayTextField.getText() + ".");
            }
        });

        additionButton.addActionListener(e -> addCharacter("+"));

        oneButton.addActionListener(e -> addCharacter("1"));

        twoButton.addActionListener(e -> addCharacter("2"));

        threeButton.addActionListener(e -> addCharacter("3"));

        subtractionButton.addActionListener(e -> addCharacter("-"));

        fourButton.addActionListener(e -> addCharacter("4"));

        fiveButton.addActionListener(e -> addCharacter("5"));

        sixButton.addActionListener(e -> addCharacter("6"));

        multiplicationButton.addActionListener(e -> addCharacter("*"));

        sevenButton.addActionListener(e -> addCharacter("7"));

        eightButton.addActionListener(e -> addCharacter("8"));

        nineButton.addActionListener(e -> addCharacter("9"));

        divisionButton.addActionListener(e -> addCharacter("/"));

        backSpaceButton.addActionListener(e -> {
            if (displayTextField.getText().length() == 1) {
                displayTextField.setText("0");
            } else {
                displayTextField.setText(displayTextField.getText().substring(0, displayTextField.getText().length()-1));
            }
        });

        clearButton.addActionListener(e -> displayTextField.setText("0"));

        leftParenthesisButton.addActionListener(e -> addCharacter("("));

        rightParenthesisButton.addActionListener(e -> addCharacter(")"));

        exitButton.addActionListener(e -> System.exit(0));

        executeButton.addActionListener(e -> displayTextField.setText(solver.solve(displayTextField.getText())));
    }

    private void addCharacter(String character) {
        if (displayTextField.getText().equals("0")) {
            displayTextField.setText(character);
        } else {
            displayTextField.setText(displayTextField.getText() + character);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        JFrame mainFrame = new JFrame("Kalkulator");
        form = new CalculatorForm();
        mainFrame.setContentPane(form.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }
}