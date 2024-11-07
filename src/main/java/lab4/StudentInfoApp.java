package lab4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;

public class StudentInfoApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/comp228lab4/StudentInfoView.fxml"));
            Parent root = loader.load();

            Image icon = new Image(getClass().getResourceAsStream("/java.png"));
            stage.getIcons().add(icon);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Student Information Form");
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
