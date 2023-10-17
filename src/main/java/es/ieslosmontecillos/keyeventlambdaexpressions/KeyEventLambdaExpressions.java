package es.ieslosmontecillos.keyeventlambdaexpressions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventLambdaExpressions extends Application {
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 200, 50);
        Text text = new Text(20, 20, "A");

        text.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();
            double deltaX = 0;
            double deltaY = 0;

            if (key == KeyCode.DOWN)
                deltaY = 10;
            else if (key == KeyCode.UP)
                deltaY = -10;
            else if (key == KeyCode.RIGHT)
                deltaX = 10;
            else if (key == KeyCode.LEFT)
                deltaX = -10;
            else if (key.isLetterKey() || key.isDigitKey())
                text.setText(text.getText() + event.getText());

            text.setLayoutX(text.getLayoutX() + deltaX);
            text.setLayoutY(text.getLayoutY() + deltaY);
        });

        text.setFocusTraversable(true);

        root.getChildren().add(text);
        stage.setTitle("KeyEvent Lambda Event");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch(args);}
}