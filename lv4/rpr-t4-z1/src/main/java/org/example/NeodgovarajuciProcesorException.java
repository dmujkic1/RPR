package org.example;
import java.util.*;
public class NeodgovarajuciProcesorException extends Exception{
    private String poruka;
    public
    NeodgovarajuciProcesorException(String poruka)
    {
        this.poruka=poruka;
    }
    String getPoruka()
    {
        return poruka;
    }
}