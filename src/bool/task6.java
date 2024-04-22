package bool;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class task6 extends Application {

    private int[] booleanFunction;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Игра. ДНФ.");
        
        // Генерируем случайный вектор функции
        booleanFunction = generateBooleanFunction(8);

        // Создаем UI
        Label booleanFunctionLabel = new Label("Вектор функции: " + booleanFunctionToString(booleanFunction));
        Label dnfLabel = new Label("Введите ДНФ для этого вектора функции:");
        TextArea dnfTextArea = new TextArea();
        Button checkDNFButton = new Button("Проверить ДНФ");
        Label resultLabel = new Label();

        // Обработчик нажатия на кнопку проверки ДНФ
        checkDNFButton.setOnAction(event -> {
            String userDNF = dnfTextArea.getText().trim();
            String correctDNF = buildDNF(booleanFunction);
            if (userDNF.equals(correctDNF)) {
                resultLabel.setText("Правильно!");
            } else {
                resultLabel.setText("Неправильно. Правильный ответ: " + correctDNF);
            }
        });

        // Создаем сцену и добавляем все элементы
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.add(booleanFunctionLabel, 0, 0, 2, 1);
        root.add(dnfLabel, 0, 1);
        root.add(dnfTextArea, 0, 2);
        root.add(checkDNFButton, 1, 2);
        root.add(resultLabel, 0, 3, 2, 1);
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Генерирует случайный вектор функции заданной длины
    private int[] generateBooleanFunction(int length) {
        int[] booleanFunction = new int[length];
        for (int i = 0; i < length; i++) {
            booleanFunction[i] = Math.random() < 0.5 ? 0 : 1;
        }
        return booleanFunction;
    }

    // Преобразует вектор функции в строку
    private String booleanFunctionToString(int[] booleanFunction) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < booleanFunction.length; i++) {
            sb.append(booleanFunction[i]);
        }
        return sb.toString();
    }
    
    public static String buildDNF(int[] booleanFunction) {
        int numVariables = (int) (Math.log(booleanFunction.length) / Math.log(2));
        StringBuilder dnf = new StringBuilder();
        // Перебираем все возможные наборы переменных
        for (int i = 0; i < booleanFunction.length; i++) {
            if (booleanFunction[i] == 1) {
                String term = buildTerm(i, numVariables);
                if (dnf.length() > 0) {
                    dnf.append(" v ");
                }
                dnf.append("(" + term + ")");
            }
        }
        return dnf.toString();
    }

    private static String buildTerm(int index, int numVariables) {
        StringBuilder term = new StringBuilder();
        for (int i = 0; i < numVariables; i++) {
            int bit = (index >> i) & 1;
            char variable = (char) ('x' + i);
            if (term.length() > 0) {
                term.append(" * ");
            }
            term.append(bit == 1 ? variable : "!" + variable);
        }
        return term.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

