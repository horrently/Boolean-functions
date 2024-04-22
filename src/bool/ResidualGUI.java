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

public class ResidualGUI extends Application {
    private TextField inputVector;
    private TextField inputRes;
    private TextField inputArgNum;
    private Label outputLabel;

    @Override
    public void start(Stage primaryStage) {
        
        // Создание элементов управления
        inputVector = new TextField();
        inputRes = new TextField();
        inputArgNum = new TextField();
        outputLabel = new Label();

        Button calculateButton = new Button("Вычислить");
        calculateButton.setOnAction(event -> calculateResidual());

        // Создание интерфейса
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(new Label("Введите вектор функции:"), 0, 0);
        gridPane.add(inputVector, 1, 0);
        gridPane.add(new Label("Нулевая или единичная:"), 0, 1);
        gridPane.add(inputRes, 1, 1);
        gridPane.add(new Label("Введите номер аргумента:"), 0, 2);
        gridPane.add(inputArgNum, 1, 2);
        gridPane.add(calculateButton, 1, 3);

        HBox resultBox = new HBox(outputLabel);
        resultBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(gridPane, resultBox);
        root.setSpacing(10);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 500, 240);
        primaryStage.setTitle("Вычисление остаточной");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateResidual() {
        String vector = inputVector.getText();
        int res = Integer.parseInt(inputRes.getText());
        int argNum = Integer.parseInt(inputArgNum.getText());

        String result = Residual.residual(vector, res, argNum);

        outputLabel.setText("Результат: " + result);
    }

    public static void main(String[] args) {
        launch(args);
    }
}