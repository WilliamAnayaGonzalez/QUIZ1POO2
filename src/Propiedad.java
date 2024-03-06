public class Propiedad {
    String id_Propiedad;
    String num_matricula;
    String ciudad;
    String direccion;
    String descripcion;

    public Propiedad(String id_Propiedad, String num_matricula, String ciudad, String direccion, String descripcion) {
        this.id_Propiedad = id_Propiedad;
        this.num_matricula = num_matricula;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.descripcion = descripcion;
    }

    public String getId_Propiedad() {
        return id_Propiedad;
    }

    public void setId_Propiedad(String id_Propiedad) {
        this.id_Propiedad = id_Propiedad;
    }

    public String getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(String num_matricula) {
        this.num_matricula = num_matricula;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
