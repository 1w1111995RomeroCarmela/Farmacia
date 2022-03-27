
package Models;

import java.util.Date;


public class Presupuesto {
    
    
    private int idPresupuesto;
    private int idReceta;
    private Date fecha;
    private float montoTotal;
    private float montoFacturar;

    public Presupuesto() {
    }

    public Presupuesto(int idPresupuesto, int idReceta, Date fecha, float montoTotal, float montoFacturar) {
        this.idPresupuesto = idPresupuesto;
        this.idReceta = idReceta;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.montoFacturar = montoFacturar;
    }

    public Presupuesto(int idReceta, Date fecha, float montoTotal, float montoFacturar) {
        this.idReceta = idReceta;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.montoFacturar = montoFacturar;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public float getMontoFacturar() {
        return montoFacturar;
    }

    public void setMontoFacturar(float montoFacturar) {
        this.montoFacturar = montoFacturar;
    }

    
    
    
}
