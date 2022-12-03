
package lab8p1_rodrigovasquez;

public class Superheroe {
    public String nombre;
    public String superNombre; 
    public String company; 
    public String city; 

    public Superheroe(String nombre, String superNombre, String company, String city) {
        this.nombre = nombre;
        this.superNombre = superNombre;
        this.company = company;
        this.city = city;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSuperNombre() {
        return superNombre;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSuperNombre(String superNombre) {
        this.superNombre = superNombre;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Nombre del super héroe: " + superNombre + "\nNombre real: " + nombre + "\nCiudad de origen: " + city + "\nFranquicia: " + company;
    }
    
    
}
