//1
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Program1 extends Application {
    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.runtime.version");

        Label msg = new Label("Hello, JavaFX!");
        Label jv = new Label("Java Version: " + javaVersion);
        Label fx = new Label("JavaFX Version: " + javafxVersion);

        VBox root = new VBox(10, msg, jv, fx);

        stage.setScene(new Scene(root, 300, 150));
        stage.setTitle("Program 1");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
//2
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Program2 extends Application {
    @Override
    public void start(Stage stage) {
        ChoiceBox<String> colorBox = new ChoiceBox<>();
        colorBox.getItems().addAll("Red", "Green", "Blue", "Yellow", "Black");

        Label display = new Label("Choose a color");

        colorBox.setOnAction(e -> {
            display.setText("Selected Color: " + colorBox.getValue());
        });

        VBox root = new VBox(10, colorBox, display);

        stage.setScene(new Scene(root, 300, 150));
        stage.setTitle("Program 2");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
//3
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Program3 extends Application {
    @Override
    public void start(Stage stage) {

        TextField name = new TextField();
        name.setPromptText("Enter Name");

        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");

        ToggleGroup genderGroup = new ToggleGroup();
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);

        ComboBox<String> dept = new ComboBox<>();
        dept.getItems().addAll("IT", "CSE", "ECE", "EEE");

        TextArea output = new TextArea();

        Button submit = new Button("Submit");

        submit.setOnAction(e -> {
            String g = ((RadioButton) genderGroup.getSelectedToggle()).getText();
            output.setText(
                "Name: " + name.getText() +
                "\nGender: " + g +
                "\nDepartment: " + dept.getValue()
            );
        });

        VBox box = new VBox(10, name, male, female, dept, submit, output);
        box.setPadding(new Insets(10));

        stage.setScene(new Scene(box, 350, 350));
        stage.setTitle("Program 3");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
//4
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Program4 extends Application {
    @Override
    public void start(Stage stage) {

        TextArea area = new TextArea();

        Menu fileMenu = new Menu("File");
        MenuItem newFile = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem exit = new MenuItem("Exit");

        fileMenu.getItems().addAll(newFile, open, save, exit);

        MenuBar bar = new MenuBar(fileMenu);

        newFile.setOnAction(e -> area.clear());

        open.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            File file = fc.showOpenDialog(stage);
            if (file != null) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) sb.append(line).append("\n");
                    br.close();
                    area.setText(sb.toString());
                } catch (Exception ex) {}
            }
        });

        save.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            File file = fc.showSaveDialog(stage);
            if (file != null) {
                try {
                    FileWriter fw = new FileWriter(file);
                    fw.write(area.getText());
                    fw.close();
                } catch (Exception ex) {}
            }
        });

        exit.setOnAction(e -> stage.close());

        BorderPane pane = new BorderPane();
        pane.setTop(bar);
        pane.setCenter(area);

        stage.setScene(new Scene(pane, 500, 400));
        stage.setTitle("Text Editor");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
