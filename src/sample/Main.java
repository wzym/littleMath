package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Parent root;
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.getStylesheets().add("sample/sample.css");
        Main.primaryStage = primaryStage;
        formStage();

    }

    private void formStage() {
        primaryStage.setTitle("littleMath");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    static void makeFullScreen() {
        primaryStage.setFullScreen(true);
    }

    static void closeFullScreen() {
        primaryStage.setFullScreen(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
