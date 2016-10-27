package sample;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
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
    @FXML
    private Slider sliderXScale;
    @FXML
    private Slider sliderYScale;

    void setScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        prepareToShow();
    }

    private void prepareToShow() {
        this.drawer = fieldToDraw.getGraphicsContext2D();
        coordinatesNetController = new CoordinatesNetController();
        alignOnChangedResolution();
        paneSim.heightProperty().addListener(observable -> alignOnChangedResolution());
        paneSim.widthProperty().addListener(observable -> alignOnChangedResolution());
    }

    private void alignOnChangedResolution() {
        coordinatesNetController.changeResolution(paneSim.getWidth(), paneSim.getHeight());
        fieldToDraw.setHeight(paneSim.getHeight());
        fieldToDraw.setWidth(paneSim.getWidth());
        sliderXScale.setMinWidth(paneSim.getWidth() - 50);
        sliderYScale.setMinHeight(paneSim.getHeight() - 30);
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
    }

    @FXML
    private void functionToTest() {
        paneSim.getChildren().removeAll(coordinatesNetController.getCoordinatesNet());
    }

    @FXML
    private void changeWidthValue() {
        double coefficient = (sliderXScale.getValue() >= 50) ? (50 / (100 - sliderXScale.getValue())) :
                (sliderXScale.getValue() / 50);
        coordinatesNetController.changeWidthValue(coefficient);
        sliderXScale.setValue(50);
    }

    @FXML
    private void changeHeightValue() {
        double coefficient = (sliderYScale.getValue() >= 50) ? (50 / (100 - sliderYScale.getValue())) :
                (sliderYScale.getValue() / 50);
        coordinatesNetController.changeHeightValue(coefficient);
        sliderYScale.setValue(50);
    }

    private void drawPoint(Point2D point) {
        drawer.fillOval(point.getX(), point.getY(), 1, 1);
    }
}
