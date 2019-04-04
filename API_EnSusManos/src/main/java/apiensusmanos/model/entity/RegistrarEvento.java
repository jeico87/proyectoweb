/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.model.entity;

import com.mysql.cj.jdbc.Blob;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "registrarevento")
public class RegistrarEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer IdRegistroEvento;

    @Column
    private Date FechaRegistroEvento;

    @Column
    private String UbicacionRegistoEvento;

    @Column
    private String FotoRegistroEvento;

    @Transient
    private Integer IdCiudadano;
    
    @Transient
    private Integer IdEvento;

    public RegistrarEvento() {
    }
    
    @ManyToOne
    @JoinColumn(name = "IdCiudadano", nullable = false)
    private Ciudadano ciudadano;

    @ManyToOne
    @JoinColumn(name = "IdEvento")
    private Evento evento;

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public Integer getIdRegistroEvento() {
        return IdRegistroEvento;
    }

    public void setIdRegistroEvento(Integer IdRegistroEvento) {
        this.IdRegistroEvento = IdRegistroEvento;
    }

    public Date getFechaRegistroEvento() {
        return FechaRegistroEvento;
    }

    public void setFechaRegistroEvento(Date FechaRegistroEvento) {
        this.FechaRegistroEvento = FechaRegistroEvento;
    }

    public String getUbicacionRegistoEvento() {
        return UbicacionRegistoEvento;
    }

    public void setUbicacionRegistoEvento(String UbicacionRegistoEvento) {
        this.UbicacionRegistoEvento = UbicacionRegistoEvento;
    }

    public String getFotoRegistroEvento() {
        return FotoRegistroEvento;
    }

    public void setFotoRegistroEvento(String FotoRegistroEvento) {
        this.FotoRegistroEvento = FotoRegistroEvento;
    }

    public Integer getIdCiudadano() {
        return IdCiudadano;
    }

    public void setIdCiudadano(Integer IdCiudadano) {
        this.IdCiudadano = IdCiudadano;
    }

    public Integer getIdEvento() {
        return IdEvento;
    }

    public void setIdEvento(Integer IdEvento) {
        this.IdEvento = IdEvento;
    }
}
