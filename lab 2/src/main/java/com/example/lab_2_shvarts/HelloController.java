package com.example.lab_2_shvarts;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class HelloController {
    //Tab 1.1
    @FXML
    private Label label1;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextArea a1;

    @FXML
    protected void EncryptText() {
        String text = t1.getText();
        String key = t2.getText();

        a1.setText(Encrypt.result(text, key));
    }

    @FXML
    protected void AddToFile() {
        String EncryptText = a1.getText();
        String path = "";
        try {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Виберіть файл");
            File file = chooser.showOpenDialog(null);
            path = file.getAbsolutePath();

            FileWriter writer = new FileWriter(path, false);
            writer.write(EncryptText);
            writer.close();
            label1.setText("Записано");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    //Tab 1.2
    @FXML
    private Label label2;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextArea a2;

    @FXML
    protected void ChoseFile() {
        try {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Виберіть файл");
            File file = chooser.showOpenDialog(null);
            textField1.setText(file.getAbsolutePath());
        } catch (Exception e) {
            label2.setText("Виберіть файл");
        }
    }

    @FXML
    protected void DecryptText() {
        String key = textField2.getText();
        String path = textField1.getText();

        try (FileReader reader = new FileReader(path)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                String text = scan.nextLine() + "\n";
                a2.setText(Encrypt.decrypt(text, key));
            }
        } catch (Exception e) {
            label2.setText("Виберіть файл");
        }
    }

//Tab 2.1
    @FXML
    private Label label3;
    @FXML
    private TextField textField3;
    @FXML
    private TextField textField4;
    @FXML
    private TextArea a3;

    @FXML
    protected void Dencrypt(){
        String text = textField3.getText();
        String key = textField4.getText();

        a3.setText(Encrypt.decrypt(text, key));
    }
//Tab 2.2

    @FXML
    private Label label4;
    @FXML
    private TextField textField5;
    @FXML
    private TextField textField6;
    @FXML
    private TextArea a4;

    @FXML
    protected void ChooseFile(){
        try {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Виберіть файл");
            File file = chooser.showOpenDialog(null);
            textField5.setText(file.getAbsolutePath());
        } catch (Exception e) {
            label4.setText("Виберіть файл");
        }
    }
    @FXML
    protected void Dycrypt(){
        String key = textField6.getText();
        String text = "";

        try(FileReader reader = new FileReader(textField5.getText())) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                text += scan.nextLine() + "\n";
            }
        }catch (Exception e){
            label4.setText("Виберіть файл");
        }
        a4.setText(Encrypt.decrypt(text,key));
    }
}
