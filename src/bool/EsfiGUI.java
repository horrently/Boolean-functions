package bool;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EsfiGUI extends Application {

    private final Label vectorLabel = new Label();
    private final TextField answerTextField = new TextField();
    private final Label resultLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Игра. Существенные и фиктивные переменные.");

        // Создание элементов интерфейса
        Button checkButton = new Button("Проверить");
        Label answerLabel = new Label("  Введите номера фиктивных переменных\n(если их нет, просто оставьте поле пустым):");
        VBox vbox = new VBox(vectorLabel, answerLabel, answerTextField, checkButton, resultLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        // Создание сетки для размещения элементов интерфейса
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(vbox, 0, 0);

        // Создание сцены и установка ее на primaryStage
        Scene scene = new Scene(grid, 500, 250);
        primaryStage.setScene(scene);

        // Отображение вектора функции и обработка нажатия кнопки
        String vector = ESFI.generateVector(3);
        vectorLabel.setText("Вектор: " + vector);
        checkButton.setOnAction(event -> {
            String answer = answerTextField.getText();
            String[] progAns = ESFI.defineFicVars(vector).split(" ");
            if (answer.equals(String.join(" ", progAns))) {
                resultLabel.setText("Ответ правильный.");
            } else {
                resultLabel.setText("Ответ неверный. Правильный ответ: " + String.join(" ", progAns));
            }
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}