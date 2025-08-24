import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Adressbuch {
    
    private List<Kontakt> kontaktListe = new ArrayList<>();

    public Adressbuch(){

    }

    public void alleKontakteAnzeigen(){
        if (kontaktListe.isEmpty()) {
            System.out.println("Keine Kontakte vorhanden.");
        }
        else{
            for (Kontakt kontakt : kontaktListe) {
                System.out.println(kontakt); 
            }
        }
    }

    public void kontaktHinzufügen(Kontakt k){
        kontaktListe.add(k);
    }

    public void kontakteLaden(String dateiname){
        //kontaktListe.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dateiname));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] teile = line.split(";");
                if (teile.length == 3) {
                    Kontakt k = new Kontakt(teile[0], teile[1], teile[2]);
                    kontaktListe.add(k);
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Keine vorhanden Datei gefudnen, neues Adressbuch wird erstellt.");
        }

    }

    public void kontakteSpeichern(String dateiname){
        try {
            
            File file = new File(dateiname);
            file.setWritable(true);

            BufferedWriter writer = new BufferedWriter(new FileWriter(dateiname));
            
            for (Kontakt kontakt : kontaktListe) {
                writer.write(kontakt.getName()+ ";"+ kontakt.getTelefonnummer()+";"+kontakt.getEmail());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Fehler beim Speichern: " + e.getMessage());
        }
    }

    public void findeName(String name){
        for (Kontakt kontakt : kontaktListe) {
            if (kontakt.getName().equals(name)) {
                System.out.println("Name gefunden." + kontakt.getName() +", Email lautet: "+ kontakt.getEmail() + ", Tel. lautet: " + kontakt.getTelefonnummer());
                return;
            }
        } 
        System.out.println("Name im Adressbuch nicht vorhanden.");
    }
}
