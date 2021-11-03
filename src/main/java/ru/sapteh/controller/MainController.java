package ru.sapteh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.model.User;
import ru.sapteh.service.UserService;

public  class MainController {

    private final UserService userService;

    @FXML
    public Label alertText;

    @FXML
    public TextField firstNameText;

    @FXML
    public TextField lastNameText;

    @FXML
    public TextField ageText;

    public MainController() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        this.userService = new UserService(factory);
    }

    public void addedButton(ActionEvent actionEvent) {
        userService.save(new User(
                firstNameText.getText(),
                lastNameText.getText(),
                Integer.parseInt(ageText.getText())
        ));
        alertText.setTextFill(Color.GREEN);
        alertText.setText("Вы успешно добавили пользователя");
    }

    public void exitButton(ActionEvent actionEvent) {
        final Button source = (Button) actionEvent.getSource();
        source.getScene().getWindow().hide();
    }

    @FXML
    public void initialize() {

    }
}
