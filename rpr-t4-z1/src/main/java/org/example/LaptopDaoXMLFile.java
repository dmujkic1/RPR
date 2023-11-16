package org.example;
import java.io.File;
import java.util.ArrayList;
public class LaptopDaoXMLFile implements LaptopDao{
    private
    File file;
    ArrayList<Laptop> laptopi=new ArrayList<Laptop>();
    public
    @Override
    void dodajLaptopUListu(Laptop laptop)
    {
        laptopi.add(laptop);
    }
    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            laptopi = vratiPodatkeIzDatoteke();
            laptopi.add(laptop);
            xmlMapper.writeValue(file, laptopi);
        } catch (IOException e) {
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
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        try {
            if (file.exists()) {
                XmlMapper xmlMapper = new XmlMapper();
                return xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}