package RutaExpress;

import java.util.Date;

public class OrdenEnvio {

    private String codigo;
    private Date fechaEmision;
    private String estado;

    public OrdenEnvio(String codigo, Date fechaEmision, String estado) {
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
