package bool;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class task9 extends Application {

    private final Label resultLabel = new Label("");

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("СКНФ");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label functionLabel = new Label("Введите вектор функции:");
        GridPane.setConstraints(functionLabel, 0, 0);
        grid.getChildren().add(functionLabel);

        TextField functionField = new TextField();
        GridPane.setConstraints(functionField, 1, 0);
        grid.getChildren().add(functionField);

        Button submitButton = new Button("Построить СКНФ");
        GridPane.setConstraints(submitButton, 1, 1);
        grid.getChildren().add(submitButton);

        Label resultTitleLabel = new Label("СКНФ:");
        GridPane.setConstraints(resultTitleLabel, 0, 2);
        grid.getChildren().add(resultTitleLabel);

        GridPane.setConstraints(resultLabel, 1, 2);
        grid.getChildren().add(resultLabel);

        submitButton.setOnAction(event -> {
            String functionStr = functionField.getText();
            int length = functionStr.length();
            if ((length & (length - 1)) != 0) { // check if length is a power of 2
                resultLabel.setText("Длина вектора функции должна быть степенью двойки.");
            } else {
                int numVars = Integer.numberOfTrailingZeros(length);
                String sknf = calculateSKNF(functionStr);
                resultLabel.setText(sknf);
            }
        });

        Scene scene = new Scene(grid, 500, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static String calculateSKNF(String vector){
        StringBuffer result=new StringBuffer(),sample=new StringBuffer("(");
        int argNum=(int)(Math.log(vector.length())/Math.log(2));
        //Строим шаблон терма
        for(int i=0;i<argNum;i++){
            sample.append("X"+(i+1)+"V");
        }
        sample.deleteCharAt(sample.length()-1);
        sample.append(')');

        //A kind of magic
        for(int i=0;i<vector.length();i++){
            if(vector.charAt(i)=='0'){
                StringBuffer term=new StringBuffer(sample);

                //Строим двоичную запись нидекса и дополняем её ведущими нулями
                String f=Integer.toString(i,2);
                while(f.length()!=argNum){
                    f=0+f;
                }

                //расставляем отрицания
                int x=argNum,j=term.length()-3;
                while(x>0){
                    if(f.charAt(x-1)=='1')
                        term.insert(j,'¬');
                    x--;j-=3;
                }

                //получившийся терм добавляем в результат
                result.append(term);
                result.append("&");
            }
        }
        result.deleteCharAt(result.length()-1);

        return result.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
