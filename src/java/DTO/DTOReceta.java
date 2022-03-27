package DTO;

public class DTOReceta{

    private int idReceta;
    private String nomApeCliente;
    private String obraSocial;
    private String nomApeProfesional;
    private String sucursal;

    public DTOReceta() {
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getNomApeCliente() {
        return nomApeCliente;
    }

    public void setNomApeCliente(String nomApeCliente) {
        this.nomApeCliente = nomApeCliente;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getNomApeProfesional() {
        return nomApeProfesional;
    }

    public void setNomApeProfesional(String nomApeProfesional) {
        this.nomApeProfesional = nomApeProfesional;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

}
