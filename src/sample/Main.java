package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;
    private Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        primaryStage.setHeight(400);
        primaryStage.setWidth(600);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        root = loader.load();
        Controller controller = loader.getController();
        formStage();
        controller.setScene(primaryStage);
//        root.getStylesheets().add("sample/sample.css");
    }

    private void formStage() {
        primaryStage.setTitle("littleMath");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
