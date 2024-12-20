package com.example.rpr_t7;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController {
    @FXML
    public TextField imeField;
    @FXML
    public TextField prezimeField;
    @FXML
    public TextField emailField;
    @FXML
    public TextField korisnicko_imeField;
    @FXML
    public PasswordField lozinkaField;
    @FXML
    public ListView<Korisnik> listaKorisnika;
    @FXML
    private Label upozorenjeLabel;
    private KorisniciModel model=new KorisniciModel(); //referenca na model klasu
    //property objekat se mora napravit u konstruktoru
    //kad mijenjamo vrijednost korisnika odma se mijenja u formi i obrnuto
    private boolean validnoImeiliPrezime(String ime)
    {
        for(int i=0; i<ime.length(); i++)
        {
            if(!(ime.charAt(i)>='a' && ime.charAt(i)<='z') && !(ime.charAt(i)>='A' && ime.charAt(i)<='Z')
                    && ime.charAt(i)!='ć' && ime.charAt(i)!='č' && ime.charAt(i)!='ž' && ime.charAt(i)!='š' &&
                    ime.charAt(i)!='đ' && ime.charAt(i)!=' ') return false;
        }
        return true;
    }
    private boolean validanMail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
    private boolean validnalozinka(String lozinka)
    {
        if(lozinka.length()<8) return false;
        return true;
    }
    public HelloController()
    {
        model.napuni();
    }
    @FXML
    public void initialize() {
        listaKorisnika.setItems(model.getKorisnici()); //bind liste sa modelom
        listaKorisnika.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                               oldKorisnik, newKorisnik) -> {
            model.setTrenutnikorisnik(newKorisnik);
            listaKorisnika.refresh();
        });
        imeField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if(validnoImeiliPrezime(n))
                {
                    imeField.getStyleClass().removeAll("poljeNijeIspravno");
                    upozorenjeLabel.setVisible(false);
                }else
                {
                    imeField.getStyleClass().add("poljeNijeIspravno");
                    upozorenjeLabel.setText("Neispravan unos!");
                    upozorenjeLabel.setVisible(true);
                }
            }
        });
        prezimeField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if(validnoImeiliPrezime(n))
                {
                    prezimeField.getStyleClass().removeAll("poljeNijeIspravno");
                    upozorenjeLabel.setVisible(false);
                }else
                {
                    prezimeField.getStyleClass().add("poljeNijeIspravno");
                    upozorenjeLabel.setText("Neispravan unos!");
                    upozorenjeLabel.setVisible(true);
                }
            }
        });
        emailField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if(validanMail(n))
                {
                    emailField.getStyleClass().removeAll("poljeNijeIspravno");
                    upozorenjeLabel.setVisible(false);
                }else
                {
                    emailField.getStyleClass().add("poljeNijeIspravno");
                    upozorenjeLabel.setText("Neispravan unos!");
                    upozorenjeLabel.setVisible(true);
                }
            }
        });
        lozinkaField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if(validnalozinka(n))
                {
                    lozinkaField.getStyleClass().removeAll("poljeNijeIspravno");
                    upozorenjeLabel.setVisible(false);
                }else
                {
                    upozorenjeLabel.setText("Lozinka mora biti duža!");
                    upozorenjeLabel.setVisible(true);
                    lozinkaField.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        model.trenutniKorisnikProperty().addListener(((observableValue, oldkorisnik, newkorisnik) -> {
            if(oldkorisnik!=null)
            {
                imeField.textProperty().unbindBidirectional(oldkorisnik.imeProperty());
                prezimeField.textProperty().unbindBidirectional(oldkorisnik.prezimeProperty());
                emailField.textProperty().unbindBidirectional(oldkorisnik.emailProperty());
                korisnicko_imeField.textProperty().unbindBidirectional(oldkorisnik.korisnicko_imeProperty());
                lozinkaField.textProperty().unbindBidirectional(oldkorisnik.lozinkaProperty());
            }
            if(newkorisnik==null)
            {
                imeField.setText("");
                prezimeField.setText("");
                emailField.setText("");
                korisnicko_imeField.setText("");
                lozinkaField.setText("");
            }else
            {
                imeField.textProperty().bindBidirectional(newkorisnik.imeProperty());
                prezimeField.textProperty().bindBidirectional(newkorisnik.prezimeProperty());
                emailField.textProperty().bindBidirectional(newkorisnik.emailProperty());
                korisnicko_imeField.textProperty().bindBidirectional(newkorisnik.korisnicko_imeProperty());
                lozinkaField.textProperty().bindBidirectional(newkorisnik.lozinkaProperty());
            }
        }));

    }
    public void dodaj(MouseEvent mouseEvent) {
        if (imeField.getText().isEmpty() || prezimeField.getText().isEmpty() ||
                emailField.getText().isEmpty() || korisnicko_imeField.getText().isEmpty() ||
                lozinkaField.getText().isEmpty()) {
            // Ako su polja prazna, prikaži poruku ili obavijest korisniku
            upozorenjeLabel.setText("Popunite sva polja!");
            upozorenjeLabel.setVisible(true);
            return; // Prekini izvršavanje dodavanja novog korisnika
        }
        Korisnik k=new Korisnik();
        model.dodajkorisnika(k);
        model.setTrenutnikorisnik(model.getKorisnici().get(model.getKorisnici().size()-1));
    }
    public void kraj(MouseEvent mouseEvent) {
        //kod za zatvaranje prozora na klik
        Node n = (Node) mouseEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }

}