import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField inputTextField;
    @FXML
    private Button createHashButton;
    @FXML
    private TextArea outputTextArea;
    @FXML
    private ListView<String> choiceList;

    @FXML
    private void initialize() {
        outputTextArea.setWrapText(true);
        choiceList.setItems(FXCollections.observableArrayList("SHA256", "SHA512", "BCrypt", "SCrypt", "PBKDF2"));
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        outputTextArea.clear();
        switch (choiceList.getSelectionModel().getSelectedItem()) {
            case "SHA256":
                outputTextArea.setText(Hasher.sha256Hash(inputTextField.getText()));
                break;
            case "SHA512":
                outputTextArea.setText(Hasher.sha512Hash(inputTextField.getText()));
                break;
            case "BCrypt":
                outputTextArea.setText(Hasher.bcryptHash(inputTextField.getText()));
                break;
            case "SCrypt":
                outputTextArea.setText(Hasher.scryptHash(inputTextField.getText()));
                break;
            case "PBKDF2":
                outputTextArea.setText(Hasher.pbkdf2Hash(inputTextField.getText()));
                break;
            default:
                outputTextArea.setText("Not existing option!!!");
        }
    }
}

