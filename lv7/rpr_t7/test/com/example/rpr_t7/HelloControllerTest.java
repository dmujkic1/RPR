package com.example.rpr_t7;
import com.sun.tools.javac.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.fxml.FXMLLoader;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(ApplicationExtension.class)

class HelloControllerTest{
    @Start
    public void start(Stage stage) throws Exception
    {
        Parent mainNode = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("hello-view.fxml")));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    void initialize() {
    }

    @Test
    void dodaj() {
    }

    @Test
    void kraj() {
    }
}