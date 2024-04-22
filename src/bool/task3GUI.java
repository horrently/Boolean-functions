package bool;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class task3GUI extends Application {

    private TextField zeroRemainderField;
    private TextField oneRemainderField;
    private TextField argumentField;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {

        // Создание элементов
        zeroRemainderField = new TextField();
        oneRemainderField = new TextField();
        argumentField = new TextField();
        resultLabel = new Label();

        Button calculateButton = new Button("Вычислить");
        calculateButton.setOnAction(event -> calculateFunction());

        // Создание интерфейса
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(new Label("Введите нулевую остаточную:"), 0, 0);
        gridPane.add(zeroRemainderField, 1, 0);
        gridPane.add(new Label("Введите единичную остаточную:"), 0, 1);
        gridPane.add(oneRemainderField, 1, 1);
        gridPane.add(new Label("Введите номер аргумента:"), 0, 2);
        gridPane.add(argumentField, 1, 2);
        gridPane.add(calculateButton, 1, 3);

        HBox resultBox = new HBox(resultLabel);
        resultBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(gridPane, resultBox);
        root.setSpacing(10);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 500, 240);
        primaryStage.setTitle("Построение вектора функции");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Расчет функции и отображение результата
    private void calculateFunction() {
        String zeroRemainder = zeroRemainderField.getText();
        String oneRemainder = oneRemainderField.getText();
        int argument = Integer.parseInt(argumentField.getText());
        String result = task3.buildVectorFunction(zeroRemainder, oneRemainder, argument);
        resultLabel.setText("Функция: " + result);
    }

    public static void main(String[] args) {
        launch(args);
    }
}