package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;
    private Controller controller;
    private Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        root = loader.load();
//        root.getStylesheets().add("sample/sample.css");
        controller = loader.getController();
        controller.prepareToShow();
        formStage();
    }

    private void formStage() {
        primaryStage.setTitle("littleMath");
        primaryStage.setScene(new Scene(root));
        controller.setScene(primaryStage);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
