package com.example.three;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {

    @FXML
    private TextField textField;

    @FXML
    private TextField textPassword;

    public void generate(ActionEvent event) {


        String text = textField.getText();
        int value = 0;
        try{
             value = Integer.parseInt(text);
        }catch (Exception e){
            textPassword.setText("Cannot add letters. Please add numbers: ");
        }

        StringBuilder store = new StringBuilder();
        String numberOfCharacter;

        for (int j = 0; true; ) {
            if (value >= 8 && value <= 30) {
                for (int i = 0; i < 8; i++) {
                    store.append(randomString()).append(randomInt()).append(randomString()).append(randomCapitalString()).append(randomCharacter());
                }
                numberOfCharacter = store.substring(0, value);
                textPassword.setText(numberOfCharacter);
                break;
            } else {
                if(value < 8){
                    textPassword.setText(value + " numbers of character is unsafe.");
                    break;
                }else {
                    textPassword.setText(value + " numbers of character is too much");
                    break;
                }
            }
        }
    }

    private static String randomInt() {
        Random rand = new Random();
        String alphabet = "1234567890";
        String store = "";

        store += alphabet.charAt(rand.nextInt(alphabet.length()));

        return store;
    }

    // this method give random String
    private static String randomString() {

        Random rand = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyxz";
        String store = "";

        store += alphabet.charAt(rand.nextInt(alphabet.length()));

        return store;
    }

    private static String randomCapitalString() {
        Random rand = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String store = "";

        store += alphabet.charAt(rand.nextInt(alphabet.length()));

        return store;
    }

    private static String randomCharacter() {
        Random rand = new Random();
        String alphabet = "!@#$%^&*()_+{}::L><?~`±§";
        String store = "";

        store += alphabet.charAt(rand.nextInt(alphabet.length()));

        return store;
    }
}