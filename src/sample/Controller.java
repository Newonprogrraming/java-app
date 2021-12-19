package sample;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label resualtlabel;

    @FXML
    private Button task10btn;

    @FXML
    private Button task11btn;

    @FXML
    private Button task12btn;

    @FXML
    private Button task13btn;

    @FXML
    private Button task1btn;

    @FXML
    private Button task2btn;

    @FXML
    private Button task3btn;

    @FXML
    private Button task4btn;

    @FXML
    private Button task5btn;

    @FXML
    private Button task6btn;

    @FXML
    private Button task7btn;

    @FXML
    private Button task8btn;

    @FXML
    private Button task9btn;

    @FXML
    private TextField textinput;

    private void showdial() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Предупреждение");
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Введите текст в поле.");

        alert.showAndWait();
    }

    @FXML
    void initialize() {
        task1btn.setOnAction(e -> {
            System.out.println("Hello");
            if (textinput.getText() == ""){showdial();}else{
            String resualt = reshat("abcdefghijklmnopqrstuv18340", textinput.getText());
            resualtlabel.setText("Результат: "+resualt);}
        });
        task2btn.setOnAction(e -> {
            if (textinput.getText() == ""){
                showdial();} else {
                String resualt = reshat("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}", textinput.getText());
                resualtlabel.setText("Результат: " + resualt);
            }});
        task3btn.setOnAction(e -> {
            if (textinput.getText() == ""){
                showdial();} else {
                String resualt = reshat("^([a-fA-F]{2}:){3}([0-9]{2}:){2}[0-9]{2}", textinput.getText());
                resualtlabel.setText("Результат: " + resualt);
            }});
        task4btn.setOnAction(e -> {
            if (textinput.getText() == ""){
                showdial();} else {
            String resualt = reshat("^(https?|http)://www.[-a-zA-Z0-9+#/%=.]*[-a-zA-Z0-9+#/%=]", textinput.getText());
            resualtlabel.setText("Результат: "+resualt);
        }});
        task5btn.setOnAction(e -> {
            if (textinput.getText() == ""){
                showdial();} else{
            String resualt = reshat("^#[A-F0-9]{6}", textinput.getText());
            resualtlabel.setText("Результат: "+resualt);
        }});
        task6btn.setOnAction(e -> {
            if (textinput.getText() == ""){showdial();}
            String resualt = reshat("(0?[1-9]|[12][\\d]|3[01])/(0?[1-9]|1[0-2])/(1?[6-9]|[2-9]\\d)\\d\\d", textinput.getText());
            resualtlabel.setText("Результат: "+resualt);
        });
        task7btn.setOnAction(e -> {
            if (textinput.getText() == ""){showdial();}
            String resualt = reshat("^[a-z]@(a-z|.[com])", textinput.getText());
            resualtlabel.setText("Результат: "+resualt);
        });
        task8btn.setOnAction(e -> {
            if (textinput.getText() == ""){showdial();}
            String resualt = reshat("(1?\\d\\d|2?[1-4]\\d|2?5[0-5]|[1-9]\\d).(1?\\d\\d|2?[1-4]\\d|2?5[0-5]|[1-9]\\d|0?|1?).(1?\\d\\d|2?[1-4]\\d|2?5[0-5]|[1-9]\\d|0?|1?).(1?\\d\\d|2?[1-4]\\d|2?5[0-5]|[1-9]\\d|0?|1?)", textinput.getText());
            resualtlabel.setText("Результат: "+resualt);
        });
        task9btn.setOnAction(e -> {
            if (textinput.getText() == ""){showdial();}
            String resualt = reshat("((?=.+[a-z])(?=.+[A-Z]))(?=^.{8,}$)", textinput.getText());
            resualtlabel.setText("Результат: "+resualt);
        });
        task10btn.setOnAction(e -> {
            if (textinput.getText() == ""){showdial();}
            String resualt = reshat("([1-9]){6}", textinput.getText());
            resualtlabel.setText("Результат: "+resualt);
        });
        task11btn.setOnAction(e -> {
            if (textinput.getText() == ""){showdial();}
            String resualt = reshat("((\\w)+.(\\w)+)\\s(USD|EU|RUB)", textinput.getText());
            resualtlabel.setText("Результат: "+resualt);
        });
        task12btn.setOnAction(e -> {
            if (textinput.getText() == ""){showdial();}
            else {
                String resualt = reshat("\\d+[+]|\\d+ [+]", textinput.getText());
                resualtlabel.setText("Результат: " + resualt);
            }});
        task13btn.setOnAction(e -> {
            if (textinput.getText() == ""){showdial();}
            int sumopen = 0;
            int sumclose = 0;
            Pattern pt = Pattern.compile("[\\(]");
            Pattern pt2 = Pattern.compile("[\\)]");
            Matcher m2 = pt2.matcher(textinput.getText());
            Matcher m1 = pt.matcher(textinput.getText());
            while (m1.find()){
                sumopen +=1;}
            while (m2.find()){
                sumclose +=1;}
            if (sumopen == sumclose){
                resualtlabel.setText("Результат: ОК");
            }else{resualtlabel.setText("Результат: No found");}
        });


    }


    static String reshat(String padd, String a){
        Pattern pt = Pattern.compile(padd);
        Matcher m1 = pt.matcher(a);
        boolean b = m1.matches();
        System.out.println(b);
        String resualt = b? "True":"False";
        return resualt;
    }

}
