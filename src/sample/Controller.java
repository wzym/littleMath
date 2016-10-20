package sample;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {
    private CoordinatesNetController coordinatesNetController;
    private Stage primaryStage;

    private GraphicsContext drawer = null;
    @FXML
    private BorderPane parent;
    @FXML
    private Canvas fieldToDraw;
    @FXML
    private MenuItem menuItemToClose;
    @FXML
    private VBox vBoxTools;
    @FXML
    private CheckBox checkBoxFullScreen;
    @FXML
    private Pane paneSim;
    @FXML
    private TextField infoBox;
    @FXML
    private Button testFunc;

    void prepareToShow() {
        this.drawer = fieldToDraw.getGraphicsContext2D();
        coordinatesNetController = new CoordinatesNetController(fieldToDraw.getWidth(), fieldToDraw.getHeight());
    }

    @FXML
    private void closeApplication() {
        System.exit(0);
    }

    @FXML
    private void setCoordinatesByClick(MouseEvent click) {
        infoBox.setText("x: " + String.valueOf(click.getSceneX()) + ", y: " + String.valueOf(click.getSceneY()));
        paneSim.getChildren().removeAll(coordinatesNetController.getCoordinatesNet());
        coordinatesNetController.setOriginOfCoordinates(click.getX(), click.getY());
        paneSim.getChildren().addAll(coordinatesNetController.getCoordinatesNet());
    }

    @FXML
    private void setCheckBoxFullScreenControl() {
        if (checkBoxFullScreen.isSelected()) {
            primaryStage.setFullScreen(true);
        }
        if (!checkBoxFullScreen.isSelected()) {
            primaryStage.setFullScreen(false);
        }
        alignCanvasToContainer();
    }

    @FXML
    private void functionToTest() {
        paneSim.getChildren().removeAll(coordinatesNetController.getCoordinatesNet());
    }

    private void alignCanvasToContainer() {
        fieldToDraw.setHeight(paneSim.getHeight());
        fieldToDraw.setWidth(paneSim.getWidth());
        coordinatesNetController.changeResolution(paneSim.getWidth(), paneSim.getHeight());
    }

    private void drawPoint(Point2D point) {
        drawer.fillOval(point.getX(), point.getY(), 1, 1);
    }

    void setScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
