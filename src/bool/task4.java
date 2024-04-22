package bool;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class task4 extends Application {
    private final String[] FUNCTION_NAMES = {
        "Тождественный ноль", "Конъюнкция",
        "Дизъюнкция", "Инверсия прямой импликации",
        "Первый операнд", "Инверсия обратной импликации",
        "Второй операнд", "Отрицание второго операнда",
        "Отрицание первого операнда", "Сложение по модулю 2",
        "Импликация", "Обратная импликация",
        "Эквиваленция", "Штрих Шеффера",
        "Стрелка Пирса", "Тождественная единица"
    };
    private final String[] FUNCTION_VECTORS = {
        "0000", "0001",
        "0111", "0010",
        "0011", "0100",
        "0101", "1010",
        "1100", "0110",
        "1101", "1011",
        "1001", "1110",
        "1000", "1111",
    };

    private RadioButton[] options;
    private Button submitButton;
    private Button vectorButton;
    private Label resultLabel;
    private Label vectorLabel;
    private Label vector;
    private String selectedVector = "";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Игра. Узнать имя функции от 2-х аргументов");
        
        // Определяем радиокнопки с возможными именами функций
        options = new RadioButton[FUNCTION_NAMES.length];
        ToggleGroup toggleGroup = new ToggleGroup();
        for (int i = 0; i < FUNCTION_NAMES.length; i++) {
            RadioButton radioButton = new RadioButton(FUNCTION_NAMES[i] + "\n");
            radioButton.setToggleGroup(toggleGroup);
            options[i] = radioButton;
        }
        
        // Определяем кнопку "Выбрать вектор"
        vectorButton = new Button("Выбрать вектор");
        vectorButton.setOnAction(event -> {
            selectedVector = FUNCTION_VECTORS[(int)(Math.random() * FUNCTION_VECTORS.length)];
            for (int i = 0; i < options.length; i++) {
                vectorLabel.setText(selectedVector);
            }
        });
        
        // Определяем кнопку "Проверить"
        submitButton = new Button("Проверить");
        submitButton.setOnAction(event -> {
            //String selectedVector = FUNCTION_VECTORS[(int)(Math.random() * FUNCTION_VECTORS.length)];
            String selectedName = "";
            for (int i = 0; i < options.length; i++) {
                if (options[i].isSelected()) {
                    selectedName = FUNCTION_NAMES[i];
                    break;
                }
            }
            String correctName = getFunctionName(selectedVector);
            if (selectedName.equals(correctName)) {
                resultLabel.setText("Правильно!");
            } else {
                resultLabel.setText("Неправильно. Верный ответ: " + correctName);
            }
        });

        // Определяем метку с результатом
        resultLabel = new Label("");

        // Определяем метку с вектором
        vectorLabel = new Label("");
        
        vector = new Label("Вектор:");
        
        // Размещаем радиокнопки и кнопку в горизонтальной панели
        VBox optionsBox = new VBox();
        optionsBox.setAlignment(Pos.CENTER);
        optionsBox.setSpacing(10);
        optionsBox.getChildren().addAll(options); // Размещение радиокнопок

        // Размещаем вертикальную панель и метку в вертикальной панели
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(vector, vectorLabel, vectorButton,
                optionsBox, submitButton, resultLabel);

        Scene scene = new Scene(root, 600, 620);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String getFunctionName(String vector) {
        return switch (vector) {
            case "0001" -> "Конъюнкция";
            case "0111" -> "Дизъюнкция";
            case "0110" -> "Сложение по модулю 2";
            case "1101" -> "Импликация";
            case "1001" -> "Эквиваленция";
            case "1110" -> "Штрих Шеффера";
            case "1000" -> "Стрелка Пирса";
            case "0000" -> "Тождественный ноль";
            case "0010" -> "Инверсия прямой импликации";
            case "0011" -> "Первый операнд";
            case "0100" -> "Инверсия обратной импликации";
            case "0101" -> "Второй операнд";
            case "1010" -> "Отрицание второго операнда";
            case "1100" -> "Отрицание первого операнда";
            case "1011" -> "Обратная импликация";
            case "1111" -> "Тождественная единица";
            default -> "Неизвестная функция";
        };
    }
    
    public static void main(String[] args) {
            launch(args);
    }
}