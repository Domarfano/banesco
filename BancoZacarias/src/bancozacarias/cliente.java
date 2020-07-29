
package bancozacarias;

/**
 *
 * @author Zacarias
 */
public class cliente{
    public String fullnombres;
    public String fullapellidos;
    public String cedula;
    public String sexo;
    public String edad;

    public cliente(String fullnombres, String fullapellidos, String cedula, String sexo, String edad) {    
        this.fullnombres = fullnombres;
        this.fullapellidos = fullapellidos;
        this.cedula = cedula;
        this.sexo = sexo;
        this.edad = edad;
    }

    cliente() {
        
    }
    public String getFullnombres() {
        return fullnombres;
    }
    public void setFullnombres(String fullnombres) {
        this.fullnombres = fullnombres;
    }
    public String getFullpellidos() {
        return fullapellidos;
    }
    public void setFullapelldidos(String fullapellidos) {
        this.fullapellidos = fullapellidos;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    
}
