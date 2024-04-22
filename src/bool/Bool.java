package bool;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//1
public class Bool extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Введите число аргументов функции:");
        TextField inputField = new TextField();
        Button generateButton = new Button("Сгенерировать функцию");
        Label functionLabel = new Label();
        VBox vbox = new VBox(10, label, inputField, generateButton, functionLabel);
        vbox.setAlignment(Pos.CENTER);

        generateButton.setOnAction(event -> {
            int n = Integer.parseInt(inputField.getText());
            int[] booleanFunction = generateFunction(n);
            for (int i = 0; i < booleanFunction.length; i++) {
                if(booleanFunction[i] > 0)
                    booleanFunction[i] = 1;
                else
                    booleanFunction[i] = 0;
            }
            functionLabel.setText("Функция: " + Arrays.toString(booleanFunction));
        });

        Scene scene = new Scene(vbox, 500, 250);
        stage.setScene(scene);
        stage.setTitle("Булевая функция");
        stage.show();
    }

    private int[] generateFunction(int n) {
        Random random = new Random();
        int[] booleanFunction = new int[(int)Math.pow(2, n)];
        for (int i = 0; i < booleanFunction.length; i++) {
            booleanFunction[i] = random.nextInt();
        }
        return booleanFunction;
    }

    public static void main(String[] args) {
        launch(args);
    }
}