package org.example;
import java.io.File;
import java.util.ArrayList;
public class LaptopDaoJSONFile implements LaptopDao{
    private
    File file;
    ArrayList<Laptop> laptopi=new ArrayList<Laptop>();
    public LaptopDaoJSONFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            laptopi = vratiPodatkeIzDatoteke();
            laptopi.add(laptop);
            objectMapper.writeValue(file, laptopi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public
    @Override
    void dodajLaptopUListu(Laptop laptop)
    {
        laptopi.add(laptop);
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
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
