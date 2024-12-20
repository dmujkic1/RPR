package org.example;
import java.io.*;
import java.util.*;
public class LaptopDaoSerializableFile implements LaptopDao, Serializable {
    private
    File file;
    ArrayList<Laptop> laptopi;
    public
    LaptopDaoSerializableFile(File file){
        this.file=file;
        laptopi=new ArrayList<Laptop>();
    };
    @Override
    public void dodajLaptopUListu(Laptop laptop)
    {
        laptopi.add(laptop);
    }
    @Override
    public void dodajLaptopUFile(Laptop laptop)
    {
        try(ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(file)))
        {
            laptopi.add(laptop);
            outputStream.writeObject(laptopi);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        int velicina=laptopi.size();
        for(int i=0; i<velicina; i++)
        {
            if(laptopi.get(i).getProcesor().equals(procesor))
                return laptopi.get(i);
        }
        throw new NeodgovarajuciProcesorException("Ne postoji laptop sa tim procesorom");
    }
    @Override
    public void napuniListu(ArrayList<Laptop> laptopi)
    {
        this.laptopi.addAll(laptopi);
    }
    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke()
    {
        ArrayList<Laptop> lista = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Laptop laptop = (Laptop) inputStream.readObject();
                    lista.add(laptop);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
