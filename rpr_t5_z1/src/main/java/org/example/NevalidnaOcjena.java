package org.example;
import java.util.*;
public class NevalidnaOcjena extends Exception{
    private String poruka;
    public
    NevalidnaOcjena(String poruka)
    {
        super(poruka);
    }
    @Override
    public String getMessage()
    {
        return poruka;
    }
}