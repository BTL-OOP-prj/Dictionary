package java_dict;

import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // primaryStage.setTitle("Dictionary");
            // Parent root =
            // FXMLLoader.load(getClass().getResource("./assets/AppUI.fxml"));
            // Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
            // Scene scene = new Scene(root);

            Button btn = new Button();
            btn.setText("Say 'Hello World'");

            StackPane layout = new StackPane();
            layout.getChildren().add(btn);

            Scene scene = new Scene(layout, 300, 250);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // public class Main {

    public static void main(String[] args) {
        launch(args);
        // System.out.println("Hello World");
    }
}
