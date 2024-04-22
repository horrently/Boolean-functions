package bool;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class task10GUI extends Application {
    private int n = 3;
    private String vector;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Игра. Замкнутые классы б.ф.");
        vector = task10.generateVector(n);

        Label vectorLabel = new Label("Вектор: " + vector);
        Label inputLabel = new Label("Выберите классы вектора:");

        CheckBox t0CheckBox = new CheckBox("T0");
        CheckBox t1CheckBox = new CheckBox("T1");
        CheckBox sCheckBox = new CheckBox("S");
        CheckBox mCheckBox = new CheckBox("M");
        CheckBox lCheckBox = new CheckBox("L");

        Button submitButton = new Button("Проверить");

        TextField resultField = new TextField();
        resultField.setEditable(false);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(vectorLabel, 0, 0, 2, 1);
        gridPane.add(inputLabel, 0, 1, 2, 1);
        gridPane.add(t0CheckBox, 0, 2);
        gridPane.add(t1CheckBox, 0, 3);
        gridPane.add(sCheckBox, 0, 4);
        gridPane.add(mCheckBox, 0, 5);
        gridPane.add(lCheckBox, 0, 6);
        gridPane.add(submitButton, 1, 7);
        gridPane.add(resultField, 0, 8, 2, 1);

        submitButton.setOnAction(event -> {
            // проверяем ответ пользователя
            boolean[] userAns = new boolean[5];
            userAns[0] = t0CheckBox.isSelected();
            userAns[1] = t1CheckBox.isSelected();
            userAns[2] = sCheckBox.isSelected();
            userAns[3] = mCheckBox.isSelected();
            userAns[4] = lCheckBox.isSelected();

            int userCheck = 0;
            for (boolean ans : userAns) {
                if (ans) {
                    userCheck++;
                }
            }

            boolean[] progAns = new boolean[5];
            if (task10.checkT0(vector)) {
                progAns[0] = true;
            }
            if (task10.checkT1(vector)) {
                progAns[1] = true;
            }
            if (task10.checkS(vector)) {
                progAns[2] = true;
            }
            if (task10.checkM(vector)) {
                progAns[3] = true;
            }
            if (task10.checkL(vector)) {
                progAns[4] = true;
            }

            int progCheck = 0;
            for (boolean ans : progAns) {
                if (ans) {
                    progCheck++;
                }
            }
            
            if (userCheck == progCheck) {
                resultField.setText("Правильно!");
            }
            else {
                resultField.setText("Неправильно");
            }
        });
        
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(gridPane);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new javafx.geometry.Insets(20, 20, 20, 20));
        hBox.getChildren().addAll(vBox);

        Scene scene = new Scene(hBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
