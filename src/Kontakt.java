public class Kontakt {
    
    private String name;
    private String telefonnummer;
    private String email;
    
    public Kontakt(String name, String telefonnummer, String email){
        this.name = name;
        this.telefonnummer = telefonnummer;
        this.email = email;
    }   

    public String getName() {
        return name;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Tel: " + telefonnummer + ", E-MAil: " + email;
    }
}
