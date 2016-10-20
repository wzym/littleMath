package sample;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Controller {
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
    private void closeApplication() {
        System.exit(0);
    }

    private GraphicsContext getDrawer() {
        if (drawer == null) {
            this.drawer = fieldToDraw.getGraphicsContext2D();
        }
        return drawer;
    }

    @FXML
    private void setCheckBoxFullScreenControl() {
        fieldToDraw.setWidth(2000);
        fieldToDraw.setHeight(1000);
        drawLineByPoint();
        if (checkBoxFullScreen.isSelected()) {
            Main.makeFullScreen();
        }
        if (!checkBoxFullScreen.isSelected()) {
            Main.closeFullScreen();
        }
        fieldToDraw.setHeight(paneSim.getHeight());
        fieldToDraw.setWidth(paneSim.getWidth());
    }

    private void drawLine(Point2D start, Point2D finish) {
        getDrawer().fillRect(start.getX(), start.getY(), finish.getX(), finish.getY());
    }

    private void drawPoint(Point2D point) {
        getDrawer().fillOval(point.getX(), point.getY(), 1, 1);
    }

    private void drawLineByPoint() {
        for (int i = 0; i < 2000; i++) {
            drawPoint(new Point2D(i, 20));
            drawPoint(new Point2D(20, i));
        }
    }
}
