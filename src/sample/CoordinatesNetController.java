package sample;

import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

//А ещё мы здесь сетку повесим

class CoordinatesNetController {
    private Point2D originOfCoordinates;
    private List<Line> coordinatesNet = new ArrayList<>();
    private double[] resolutionXY = new double[2];

    CoordinatesNetController(double width, double height, double xCenter, double yCenter) {
        changeResolution(width, height);
        setOriginOfCoordinates(xCenter, yCenter);
    }

    CoordinatesNetController() {

    }

    void setOriginOfCoordinates(double x, double y) {
        originOfCoordinates = new Point2D(x, y);
        coordinatesNet.clear();
        makeAbscissaAndOrdinate(resolutionXY[0], resolutionXY[1]);
    }

    void changeResolution(double width, double height) {
        this.resolutionXY[0] = width;
        this.resolutionXY[1] = height;
    }

    private void makeAbscissaAndOrdinate(double fieldWidth, double fieldHeight) {
        Line abscissa = new Line(0, originOfCoordinates.getY(), fieldWidth, originOfCoordinates.getY());
        Line ordinate = new Line(originOfCoordinates.getX(), fieldHeight, originOfCoordinates.getX(), 0);
        coordinatesNet.add(abscissa);
        coordinatesNet.add(ordinate);
    }

    double getXOriginOfCoordinate() {
        return originOfCoordinates.getX();
    }

    double getYOriginOfCoordinate() {
        return originOfCoordinates.getY();
    }

    List<Line> getCoordinatesNet() {
        return coordinatesNet;
    }
}