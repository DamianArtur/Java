import org.json.JSONException;
import datastorage.IDataSet;
import datastorage.TimeZoneDataSet;
import datasource.IDataProvider;
import datasource.IDataParser;
import datasource.JSONDataParser;
import datasource.DataProvider;
import organization.Converter;
import organization.IConverter;
import organization.ITimeZone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class ConverterForm {
    private JPanel mainPanel;
    private static JFrame mainFrame;
    private JComboBox<ITimeZone> homeTimeZoneComboBox;
    private JComboBox<ITimeZone> awayTimeZoneComboBox;
    private JTextField homeTimeTextField;
    private JTextField awayTimeTextField;
    private JButton fromHomeToAwayConvertButton;
    private JButton fromAwayToHomeConvertButton;
    private JLabel homeCityLabel;
    private JLabel homeLabel;
    private JLabel homeTimeLabel;
    private JLabel awayLabel;
    private JLabel awayCityLabel;
    private JLabel awayTimeLabel;
    private JButton setHomeTimeAsCurrentButton;
    private JButton setAwayTimeAsCurrent;
    private JRadioButton homeDaylightSavingTimeRadioButton;
    private JRadioButton homeStandardTimeRadioButton;
    private JRadioButton awayDaylightSavingTimeRadioButton;
    private JRadioButton awayStandardTimeRadioButton;
    private JLabel homeAdditionalInformationLabel;
    private JLabel awayAdditionalInformationLabel;

    private static ConverterForm converterForm;

    IDataSet dataSet;
    IDataProvider provider;
    IDataParser parser;
    private IConverter converter;

    public ConverterForm() {
        fromHomeToAwayConvertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = converterForm.homeTimeTextField.getText();
                try {
                    LocalTime homeTime = LocalTime.parse(input);
                    ITimeZone homeTimeZone = (ITimeZone) homeTimeZoneComboBox.getSelectedItem();
                    boolean homeDaylightSavingTime = converterForm.homeDaylightSavingTimeRadioButton.isSelected();
                    ITimeZone awayTimeZone = (ITimeZone) awayTimeZoneComboBox.getSelectedItem();
                    boolean awayDaylightSavingTime = converterForm.awayDaylightSavingTimeRadioButton.isSelected();
                    LocalTime awayTime = converter.convert(homeTimeZone, awayTimeZone, homeTime, homeDaylightSavingTime, awayDaylightSavingTime);
                    awayTimeTextField.setText(awayTime.toString());
                } catch (DateTimeParseException exception) {
                    JOptionPane.showMessageDialog(mainFrame, "Time format is not valid! Use HH:mm format.", "Format error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        fromAwayToHomeConvertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = converterForm.awayTimeTextField.getText();
                    LocalTime awayTime = LocalTime.parse(input);
                    ITimeZone homeTimeZone = (ITimeZone) homeTimeZoneComboBox.getSelectedItem();
                    boolean homeDaylightSavingTime = converterForm.homeDaylightSavingTimeRadioButton.isSelected();
                    ITimeZone awayTimeZone = (ITimeZone) awayTimeZoneComboBox.getSelectedItem();
                    boolean awayDaylightSavingTime = converterForm.awayDaylightSavingTimeRadioButton.isSelected();
                    LocalTime homeTime = converter.convert(awayTimeZone, homeTimeZone, awayTime, awayDaylightSavingTime, homeDaylightSavingTime);
                    homeTimeTextField.setText(homeTime.toString());
                } catch (DateTimeParseException exception) {
                JOptionPane.showMessageDialog(mainFrame, "Time format is not valid! Use HH:mm format.", "Format error", JOptionPane.ERROR_MESSAGE);
            }
            }
        });
        setHomeTimeAsCurrentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentTime((ITimeZone) Objects.requireNonNull(converterForm.homeTimeZoneComboBox.getSelectedItem()), converterForm.homeTimeTextField, converterForm.homeDaylightSavingTimeRadioButton);
            }
        });
        setAwayTimeAsCurrent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentTime((ITimeZone) Objects.requireNonNull(converterForm.awayTimeZoneComboBox.getSelectedItem()), converterForm.awayTimeTextField, converterForm.awayDaylightSavingTimeRadioButton);
            }
        });
        homeTimeZoneComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ITimeZone homeTimeZone = (ITimeZone) homeTimeZoneComboBox.getSelectedItem();
                if (homeTimeZone != null) {
                    setAdditionalInformation(homeTimeZone, converterForm.homeAdditionalInformationLabel);
                }
            }
        });
        awayTimeZoneComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ITimeZone awayTimeZone = (ITimeZone) awayTimeZoneComboBox.getSelectedItem();
                if (awayTimeZone != null) {
                    setAdditionalInformation(awayTimeZone, converterForm.awayAdditionalInformationLabel);
                }
            }
        });
    }

    public static void initForm(ConverterForm converterForm) {

        ButtonGroup homeGroup = new ButtonGroup();
        homeGroup.add(converterForm.homeDaylightSavingTimeRadioButton);
        homeGroup.add(converterForm.homeStandardTimeRadioButton);

        ButtonGroup awayGroup = new ButtonGroup();
        awayGroup.add(converterForm.awayDaylightSavingTimeRadioButton);
        awayGroup.add(converterForm.awayStandardTimeRadioButton);

        for (ITimeZone timeZone : converterForm.dataSet.getTimeZonesList()) {
            converterForm.homeTimeZoneComboBox.addItem(timeZone);
            converterForm.awayTimeZoneComboBox.addItem(timeZone);
        }

        ITimeZone homeTimeZone = (ITimeZone) converterForm.dataSet.getTimeZoneByName("Warsaw");
        ITimeZone awayTimeZone = (ITimeZone) converterForm.dataSet.getTimeZoneByName("New_York");

        converterForm.homeTimeZoneComboBox.setSelectedItem(homeTimeZone);
        converterForm.awayTimeZoneComboBox.setSelectedItem(awayTimeZone);
        setAdditionalInformation(homeTimeZone, converterForm.homeAdditionalInformationLabel);
        setAdditionalInformation(awayTimeZone, converterForm.awayAdditionalInformationLabel);

        setCurrentTime((ITimeZone) Objects.requireNonNull(converterForm.homeTimeZoneComboBox.getSelectedItem()), converterForm.homeTimeTextField, converterForm.homeDaylightSavingTimeRadioButton);
        converterForm.fromHomeToAwayConvertButton.doClick();
    }

    public static void initData(ConverterForm form) {
        form.dataSet = new TimeZoneDataSet();
        form.provider = new DataProvider();
        form.parser = new JSONDataParser();
        form.converter = new Converter();
}

    public static void getData(ConverterForm converterForm) {
        try {
            converterForm.parser.parse(converterForm.provider.downloadData("https://raw.githubusercontent.com/vvo/tzdb/main/raw-time-zones.json"), converterForm.dataSet);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void setCurrentTime(ITimeZone timeZone, JTextField textField, JRadioButton daylightSavingTimeRadioButton) {

        int offset = 0;
        if (daylightSavingTimeRadioButton.isSelected()) {
            offset = timeZone.getOffset() + 60;
        } else {
            offset = timeZone.getOffset();
        }

        LocalTime currentTime = LocalTime.from(Instant.now().atZone(ZoneId.of("UTC"))).plusMinutes(offset);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        textField.setText(currentTime.format(formatter));
    }

    public static void setAdditionalInformation(ITimeZone timeZone, JLabel label) {

        label.setText(timeZone.getCountryName() + ", " + timeZone.getContinentName());
    }

    public static void main(String[] args) {
        mainFrame = new JFrame("Time Zone Converter");
        converterForm = new ConverterForm();
        mainFrame.setContentPane(converterForm.mainPanel);
        initData(converterForm);
        getData(converterForm);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800,250);
        mainFrame.setVisible(true);
        initForm(converterForm);
    }
}
