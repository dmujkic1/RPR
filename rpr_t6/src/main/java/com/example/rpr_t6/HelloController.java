package com.example.rpr_t6;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private TextField prikaz;
    private String string;
    private char operator;
    private Double rezultat;
    private boolean sadrzitacku;
    public HelloController() {
        string="0";
        operator='0';
        prikaz=new TextField();
        prikaz.setText(string);
        sadrzitacku=false;
    }
    private void uradioperaciju(char operator)
    {
        Double drugi=Double.parseDouble(string);
        if(operator=='+')
        {
            rezultat+=drugi;
        }
        if(operator=='-')
        {
            rezultat-=drugi;
        }
        if(operator=='*')
        {
            rezultat*=drugi;
        }
        if(operator=='\\')
        {
            rezultat=rezultat/drugi;
        }
        string="0";
    }
    private void jelpocetak()
    {
        if(string.equals("0"))
        {
            string="";
        }
    }
    public void dodajsedam(MouseEvent mouseEvent) {
        jelpocetak();
        string+="7";
        prikaz.setText(string);
    }

    public void dodajosam(MouseEvent mouseEvent) {
        jelpocetak();
        string+="8";
        prikaz.setText(string);
    }

    public void dodajdevet(MouseEvent mouseEvent) {
        jelpocetak();
        string+="9";
        prikaz.setText(string);
    }

    public void dodajcetiri(MouseEvent mouseEvent) {
        jelpocetak();
        string+="4";
        prikaz.setText(string);
    }

    public void dodajpet(MouseEvent mouseEvent) {
        jelpocetak();
        string+="5";
        prikaz.setText(string);
    }

    public void dodajsest(MouseEvent mouseEvent) {
        jelpocetak();
        string+="6";
        prikaz.setText(string);
    }

    public void dodajjedan(MouseEvent mouseEvent) {
        jelpocetak();
        string+="1";
        prikaz.setText(string);
    }

    public void dodajdva(MouseEvent mouseEvent) {
        jelpocetak();
        string+="2";
        prikaz.setText(string);
    }

    public void dodajtri(MouseEvent mouseEvent) {
        jelpocetak();
        string+="3";
        prikaz.setText(string);
    }

    public void dodajnula(MouseEvent mouseEvent) {
        jelpocetak();
        string+="0";
        prikaz.setText(string);
    }

    public void saberi(MouseEvent mouseEvent) {
        if(operator=='0')
        {
            rezultat=Double.parseDouble(string);
            operator='+';
            string="0";
        }
        else uradioperaciju(operator);
    }

    public void jednako(MouseEvent mouseEvent) {
        if(operator!='0')
        {
            uradioperaciju(operator);
            if(sadrzitacku || operator=='\\')prikaz.setText(Double.toString(rezultat));
            else if(!sadrzitacku)
            {
                int rez=(int)Math.round(rezultat);
                prikaz.setText(Integer.toString(rez));
            }
            operator='0';
            rezultat=0.0;
        }
    }

    public void dodajtacku(MouseEvent mouseEvent) {
        if(prikaz.getText().equals("0"))
        {
            string="0.";
            prikaz.setText(string);
        }else if(!prikaz.getText().contains("."))
        {
            string+=".";
            prikaz.setText(string);
        }
        sadrzitacku=true;
    }

    public void oduzmi(MouseEvent mouseEvent) {
        if(operator=='0')
        {
            rezultat=Double.parseDouble(string);
            operator='-';
            string="0";
        }else uradioperaciju(operator);
    }

    public void pomnozi(MouseEvent mouseEvent) {
        if(operator=='0')
        {
            rezultat=Double.parseDouble(string);
            operator='*';
            string="0";
        }else uradioperaciju(operator);
    }

    public void podijeli(MouseEvent mouseEvent) {
        if(operator=='0')
        {
            rezultat=Double.parseDouble(string);
            operator='\\';
            string="0";
        }else uradioperaciju(operator);
    }

    public void postotak(MouseEvent mouseEvent) {
        string="0";
        prikaz.setText(string);
    }
}