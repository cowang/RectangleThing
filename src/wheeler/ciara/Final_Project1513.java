package wheeler.ciara;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


/**
 * *15.13 (Geometry: inside a rectangle?) Write a program that draws a fixed rectangle
 * centered at (100, 60) with width 100 and height 40. Whenever the mouse is
 * moved, display a message indicating whether the mouse point is inside the rectangle
 * at the mouse point or outside of it, as shown in Figure 15.27b. To detect
 * whether a point is inside a polygon, use the contains method defined in the
 * Node class.
 */
public class Final_Project1513 extends Application {
    static final double WIDTH = 400;
    static final double HEIGHT = 150;
    static double mouseX;
    static double mouseY;
    
    public static void main(String[] args) {
      Application.launch(args);
  }

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(100, 60, 100, 40);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        Text message = new Text(rectangle.getWidth() / 2, rectangle.getHeight() / 2, "");
       
        pane.getChildren().add(rectangle);
        pane.getChildren().add(message);
        
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        scene.setOnMouseMoved(mouseEvent -> {
            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();
            if (isMousePointInsideRectangle(mouseX, mouseY, rectangle)) {
                message.setText("Mouse point is inside the rectangle");
            } 
            else {
                message.setText("Mouse point is outside the rectangle");
            }
            message.setX(mouseX);
            message.setY(mouseY);
        });

        stage.setTitle(getClass().getName());
        stage.setScene(scene);
        stage.show();
    }

    private boolean isMousePointInsideRectangle(double mouseX, double mouseY, Rectangle rectangle) {
        return rectangle.contains(mouseX, mouseY);
    }

}

