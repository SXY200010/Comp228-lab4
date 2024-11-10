package lab4;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

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
        try {
            if (fullNameField.getText().isEmpty()) {
                throw new IllegalArgumentException("Full Name is required.");
            }
            if (addressField.getText().isEmpty()) {
                throw new IllegalArgumentException("Address is required.");
            }
            if (cityField.getText().isEmpty()) {
                throw new IllegalArgumentException("City is required.");
            }
            if (provinceField.getText().isEmpty()) {
                throw new IllegalArgumentException("Province is required.");
            }
            if (postalCodeField.getText().isEmpty()) {
                throw new IllegalArgumentException("Postal Code is required.");
            }
            if (phoneField.getText().isEmpty()) {
                throw new IllegalArgumentException("Phone Number is required.");
            }
            if (emailField.getText().isEmpty()) {
                throw new IllegalArgumentException("Email is required.");
            }

            if (!phoneField.getText().matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) {
                throw new IllegalArgumentException("Phone Number format is invalid. Expected format: (123) 456-7890.");
            }
            if (!postalCodeField.getText().matches("^[A-Za-z]\\d[A-Za-z] \\d[A-Za-z]\\d$")) {
                throw new IllegalArgumentException("Postal Code format is invalid. Expected format: A1A 1A1.");
            }

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

        } catch (IllegalArgumentException e) {
            // 显示错误信息
            showAlert(AlertType.ERROR, "Input Error", e.getMessage());
        }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
