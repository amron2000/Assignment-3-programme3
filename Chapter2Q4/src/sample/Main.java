package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main extends Application {
    Stage window2;
    ListView<Student> listView;
    Button add;
    TextField idField;
    TextField nameField;
    TextField majorField;
    TextField gradeField;

    public void start(Stage window) throws IOException, FileNotFoundException {
        window2 = new Stage();
        Button add = new Button("Add Student");
        add.setId("Buttons");
        Button view = new Button("View Student");
        view.setId("Buttons");
        VBox vbox = new VBox(10, add, view);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 300, 300);
        scene.getStylesheets().add("Css.css");
        vbox.setId("BackGround");
        window.setTitle("Options Page");
        window.setScene(scene);
        window.show();
/////////////////// Scene 2 //////////////////////
        EventHandler1 eventHandler = new EventHandler1();
        add.setOnAction(eventHandler);


    }

    public static void main(String[] args) {
        launch(args);
    }

    private class EventHandler1 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(25, 20, 10, 30));
            grid.setHgap(0);
            grid.setVgap(5);
            Label student = new Label("Student Data");
            student.setId("Welcome");
            grid.add(student, 0, 0);
            // id label
            Label Id = new Label("Id:");
            grid.add(Id, 0, 1);
            idField = new TextField();
            grid.add(idField, 1, 1);
            //
            Label name = new Label("Name:");
            grid.add(name, 0, 2);
            nameField = new TextField();
            grid.add(nameField, 1, 2);
            //
            Label major = new Label("Major:");
            grid.add(major, 0, 3);
            majorField = new TextField();
            grid.add(majorField, 1, 3);
            //
            Label grade = new Label("Grade:");
            grid.add(grade, 0, 4);
            gradeField = new TextField();
            grid.add(gradeField, 1, 4);
            //
            add = new Button("Add");
            add.setId("Buttons");
            Button reset = new Button("Reset");
            reset.setId("Buttons");
            Button exit = new Button("Exit");
            exit.setId("Buttons");
            HBox hbox = new HBox(10, add, reset, exit);
            grid.add(hbox, 1, 5);
            listView = new ListView<>();
            listView.setPrefSize(400, 250);
            grid.add(listView, 2, 1, 7, 7);

            EventHandler2 eventHandler = new EventHandler2();
            add.setOnAction(eventHandler);


            reset.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    idField.setText("");
                    nameField.setText("");
                    majorField.setText("");
                    gradeField.setText("");
                }
            });

            exit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    window2.close();
                }
            });

            Scene scene = new Scene(grid, 700, 570);
            scene.getStylesheets().add("Css.css");
            window2.setTitle("Options Page");
            window2.setScene(scene);
            window2.setResizable(false);
            window2.show();
        }
    }

    private class EventHandler2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == add) {
                if (!idField.getText().equals("") && nameField.getText() != null && majorField.getText() != null && gradeField.getText() != null) {
                    int studentId = Integer.parseInt(idField.getText());
                    String studentName = nameField.getText();
                    String studentMajor = majorField.getText();
                    double studentGrade = Double.parseDouble(gradeField.getText());
                    Student student = new Student(studentId, studentName, studentMajor, studentGrade);
                    List<Student> list = new ArrayList<>(Arrays.asList(student));
                    listView.getItems().addAll(list);
                }
            }
            listView.getItems().setAll(listView.getItems().stream().sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                    .collect(Collectors.toList())
            );

        }

    }

}



