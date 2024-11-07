package lab4;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentInfoController {
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField provinceField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;

    @FXML
    private RadioButton csRadioButton;
    @FXML
    private RadioButton businessRadioButton;
    @FXML
    private ComboBox<String> courseComboBox;
    @FXML
    private ListView<String> courseListView;

    @FXML
    private CheckBox studentCouncilCheckBox;
    @FXML
    private CheckBox volunteerCheckBox;

    @FXML
    private TextArea displayArea;

    @FXML
    protected void handleCourseSelection() {
        String selectedCourse = courseComboBox.getValue();
        if (selectedCourse != null && !courseListView.getItems().contains(selectedCourse)) {
            courseListView.getItems().add(selectedCourse);
        }
    }

    @FXML
    protected void handleMajorSelection() {
        courseComboBox.getItems().clear();
        if (csRadioButton.isSelected()) {
            courseComboBox.getItems().addAll("Java Programming", "Data Structures", "Algorithms");
        } else if (businessRadioButton.isSelected()) {
            courseComboBox.getItems().addAll("Business Ethics", "Marketing", "Financial Accounting");
        }
    }

    @FXML
    protected void handleSubmit() {
        StringBuilder studentInfo = new StringBuilder();
        studentInfo.append("Full Name: ").append(fullNameField.getText()).append("\n")
                .append("Address: ").append(addressField.getText()).append("\n")
                .append("City: ").append(cityField.getText()).append("\n")
                .append("Province: ").append(provinceField.getText()).append("\n")
                .append("Postal Code: ").append(postalCodeField.getText()).append("\n")
                .append("Phone: ").append(phoneField.getText()).append("\n")
                .append("Email: ").append(emailField.getText()).append("\n")
                .append("Major: ").append(csRadioButton.isSelected() ? "Computer Science" : "Business").append("\n")
                .append("Courses: ").append(courseListView.getItems()).append("\n")
                .append("Activities: ");
        if (studentCouncilCheckBox.isSelected()) studentInfo.append("Student Council ");
        if (volunteerCheckBox.isSelected()) studentInfo.append("Volunteer Work ");
        studentInfo.append("\n");

        displayArea.setText(studentInfo.toString());
    }
}
