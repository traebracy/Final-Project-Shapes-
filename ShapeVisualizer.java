import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ShapeVisualizer extends Application {

    // the shape that is pass in through main
    private static Shape shapeToDisplay;

    public static void drawShape(Shape shape) { // ex, ShapeVisualizer.drawShape(myCircle);
        shapeToDisplay = shape;
        launch();
    }

    @Override
    public void start(Stage stage) {

        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // the background
        gc.setFill(Color.web("#1e1e2e"));
        gc.fillRect(0, 0, 600, 600);


        // sequence that makes you draw the correct shape
        if (shapeToDisplay instanceof Circle c) {
            drawCircle(gc, c);
        } else if (shapeToDisplay instanceof Triangle t) {
            drawTriangle(gc, t);
        } else if (shapeToDisplay instanceof Rectangle r) {
            drawRectangle(gc, r);
        } else if (shapeToDisplay instanceof Pentagon p) {
            drawPolygonShape(gc, 5);
        } else if (shapeToDisplay instanceof GenericPolygon gp) {
            drawPolygonShape(gc, gp.getSides());
        }

        // the info of the shape that's been created through its entered arguments

        gc.setFill(Color.WHITE);
        gc.setFont(javafx.scene.text.Font.font("Arial", 14));
        gc.fillText(shapeToDisplay.toString(), 20, 570);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 600, 600);

        stage.setTitle("Shape Visualizer " + shapeToDisplay.getName());
        stage.setScene(scene);
        stage.show();
    }

    private void drawCircle(GraphicsContext gc, Circle circle) {
        double diameter = circle.getDiameter();
        double scale = Math.min(400.0 / diameter, 1.0);
        double drawDiameter = Math.min(diameter * scale, 400);
        double x = (600 - drawDiameter) / 2;
        double y = (560 - drawDiameter) / 2;

        gc.setFill(Color.web("#89b4fa", 0.5));
        gc.setStroke(Color.web("#89b4fa"));
        gc.setLineWidth(2);
        gc.fillOval(x, y, drawDiameter, drawDiameter);
        gc.strokeOval(x, y, drawDiameter, drawDiameter);
    }

    private void drawRectangle(GraphicsContext gc, Rectangle rect) {

        // Use reflection-free approach — just draw a rectangle scaled to fit

        double maxW = 400, maxH = 300;
        double drawW = maxW;
        double drawH = maxH;

        double x = (600 - drawW) / 2;
        double y = (560 - drawH) / 2;

        gc.setFill(Color.web("#a6e3a1", 0.5));
        gc.setStroke(Color.web("#a6e3a1"));
        gc.setLineWidth(2);
        gc.fillRect(x, y, drawW, drawH);
        gc.strokeRect(x, y, drawW, drawH);
    }

    private void drawTriangle(GraphicsContext gc, Triangle triangle) {
        double cx = 300, cy = 260;
        double size = 180;

        // Equilateral-style display triangle
        double[] xPoints = {
                cx,
                cx - size,
                cx + size
        };
        double[] yPoints = {
                cy - size,
                cy + size,
                cy + size
        };

        gc.setFill(Color.web("#f38ba8", 0.5));
        gc.setStroke(Color.web("#f38ba8"));
        gc.setLineWidth(2);
        gc.fillPolygon(xPoints, yPoints, 3);
        gc.strokePolygon(xPoints, yPoints, 3);
    }

    // Draws any regular polygon by number of sides (pentagon, hexagon, etc.)
    private void drawPolygonShape(GraphicsContext gc, int sides) {
        double cx = 300, cy = 270;
        double radius = 180;

        double[] xPoints = new double[sides];
        double[] yPoints = new double[sides];

        for (int i = 0; i < sides; i++) {
            // Start from the top (-90 degrees) and space points evenly
            double angle = Math.toRadians((360.0 / sides) * i - 90);
            xPoints[i] = cx + radius * Math.cos(angle);
            yPoints[i] = cy + radius * Math.sin(angle);
        }

        gc.setFill(Color.web("#cba6f7", 0.5));
        gc.setStroke(Color.web("#cba6f7"));
        gc.setLineWidth(2);
        gc.fillPolygon(xPoints, yPoints, sides);
        gc.strokePolygon(xPoints, yPoints, sides);
    }
}
