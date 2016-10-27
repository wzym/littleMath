package sample;

import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

class CoordinatesNetController {
    private static final double NET_INDENT = 10.00;
    private static final double ARROW_LENGTH = 10.00;
    private static final double ARROW_WIDTH = 5.00;
    private int amountOfPixelsInOnePoint = 50;
    private double xPixelValue;
    private double yPixelValue;
    private double xScaleLine;
    private double yScaleLine;
    private double widthValue = 3;
    private double heightValue = 3;
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
        xPixelValue = widthValue / width;
        yPixelValue = heightValue / height;
        setXScaleLine();
        setYScaleLine();
    }

    void changeWidthValue(double coefficient) {
        this.widthValue *= coefficient;
        setXScaleLine();
    }

    void changeHeightValue(double coefficient) {
        this.heightValue *= coefficient;
        setYScaleLine();
    }

    private void makeAbscissaAndOrdinate(double fieldWidth, double fieldHeight) {
        double rightAbscissa = fieldWidth - NET_INDENT;
        double bottomOrdinate = fieldHeight - NET_INDENT;
        Line abscissa = new Line(NET_INDENT, originOfCoordinates.getY(), rightAbscissa, originOfCoordinates.getY());
        Line ordinate = new Line(originOfCoordinates.getX(), bottomOrdinate, originOfCoordinates.getX(), NET_INDENT);
        coordinatesNet.add(abscissa);
        coordinatesNet.add(ordinate);
        setRightArrow(abscissa.getEndX(), abscissa.getEndY());
        setTopArrow(ordinate.getEndX(), ordinate.getEndY());
    }

    private void setTopArrow(double arrowHeadX, double arrowHeadY) {
        Line left = new Line(arrowHeadX - ARROW_WIDTH, arrowHeadY + ARROW_LENGTH, arrowHeadX, arrowHeadY);
        Line right = new Line(arrowHeadX + ARROW_WIDTH, arrowHeadY + ARROW_LENGTH, arrowHeadX, arrowHeadY);
        coordinatesNet.add(left);
        coordinatesNet.add(right);
    }

    private void setRightArrow(double arrowHeadX, double arrowHeadY) {
        Line top = new Line(arrowHeadX - ARROW_LENGTH, arrowHeadY - ARROW_WIDTH, arrowHeadX, arrowHeadY);
        Line bottom = new Line(arrowHeadX - ARROW_LENGTH, arrowHeadY + ARROW_WIDTH, arrowHeadX, arrowHeadY);
        coordinatesNet.add(top);
        coordinatesNet.add(bottom);
    }

    private void setXScaleLine() {
        double approxLinePointValue = xPixelValue * amountOfPixelsInOnePoint;
        xScaleLine = roundLinePointValue(approxLinePointValue);
        System.out.println(approxLinePointValue);
    }

    private void setYScaleLine() {
        double approxLinePointValue = yPixelValue * amountOfPixelsInOnePoint;
        yScaleLine = roundLinePointValue(approxLinePointValue);
    }

    private double roundLinePointValue(double approxLinePointValue) {
        return 0;
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