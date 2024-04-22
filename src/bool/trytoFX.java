package bool;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class trytoFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ChoiceBox<String> taskChoiceBox = new ChoiceBox<>();
        taskChoiceBox.getItems().addAll(
                "Задача 1",
                "Задача 2",
                "Задача 3",
                "Задача 4",
                "Задача 5",
                "Задача 6",
                "Задача 7",
                "Задача 8",
                "Задача 9",
                "Задача 10",
                "Задача 11",
                "Задача 12"
        );
        
        //Creating a Text object 
        Text text = new Text();
        //Setting font to the text 
        text.setFont(Font.font("verdana", 23));
        //Setting the text to be added. 
        text.setText("     Задачи на\nбулевы функции");
        StackPane.setAlignment(text, Pos.TOP_CENTER);
        
        Button openTaskButton = new Button("Открыть");
        openTaskButton.setOnAction(event -> {
            String selectedTask = taskChoiceBox.getSelectionModel().getSelectedItem();
            openTaskInterface(selectedTask);
        });

        HBox hbox = new HBox(10, taskChoiceBox, openTaskButton);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20));

        StackPane stackPane = new StackPane(text, hbox);
        Scene scene = new Scene(stackPane, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Выбор задачи");
        primaryStage.show();
    }

    private void openTaskInterface(String task) {
        if (task.equals("Задача 1")) {
            // вызов интерфейса для задачи 1
            Bool task1Interface = new Bool();
            task1Interface.start(new Stage());
        }
        else if (task.equals("Задача 2")) {
            // вызов интерфейса для задачи 2
            ResidualGUI task2Interface = new ResidualGUI();
            task2Interface.start(new Stage());
        }
        else if (task.equals("Задача 3")) {
            // вызов интерфейса для задачи 3
            task3GUI task3Interface = new task3GUI();
            task3Interface.start(new Stage());
        }
        else if (task.equals("Задача 4")) {
            // вызов интерфейса для задачи 4
            task4 task4Interface = new task4();
            task4Interface.start(new Stage());
        }
        else if (task.equals("Задача 5")) {
            // вызов интерфейса для задачи 5
            EsfiGUI task5Interface = new EsfiGUI();
            task5Interface.start(new Stage());
        }
        else if (task.equals("Задача 6")) {
            // вызов интерфейса для задачи 6
            task6 task6Interface = new task6();
            task6Interface.start(new Stage());
        }
        else if (task.equals("Задача 7")) {
            // вызов интерфейса для задачи 7
            task7 task7Interface = new task7();
            task7Interface.start(new Stage());
        }
        else if (task.equals("Задача 8")) {
            // вызов интерфейса для задачи 8
            task8 task8Interface = new task8();
            task8Interface.start(new Stage());
        }
        else if (task.equals("Задача 9")) {
            // вызов интерфейса для задачи 9
            task9 task9Interface = new task9();
            task9Interface.start(new Stage());
        }
        else if (task.equals("Задача 10")) {
            // вызов интерфейса для задачи 10
            task10GUI task10Interface = new task10GUI();
            task10Interface.start(new Stage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


                