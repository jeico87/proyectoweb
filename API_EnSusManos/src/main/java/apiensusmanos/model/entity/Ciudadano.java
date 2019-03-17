/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.model.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ciudadano")
public class Ciudadano {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer Id;
       
    @Column
    private String NombreCiudadano;
    
    @Column
    private String ApellidoCiudadano;
    
    @Column
    private String DireccionCiudadano;
    
    @Column
    private int TelefonoCiudadano;
    
    @Column
    private int CelularCiudadano;
    
    @Column
    private String MailCiudadano;
    
    @Column
    private String ContraseniaCiudadano;
    
    @Column
    private int PuntajeCiudadano;
    
//    @OneToMany(mappedBy = "ciudadano" , cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<RegistrarEvento> listaRegistrarEvento;

    public Ciudadano() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombreCiudadano() {
        return NombreCiudadano;
    }

    public void setNombreCiudadano(String NombreCiudadano) {
        this.NombreCiudadano = NombreCiudadano;
    }

    public String getApellidoCiudadano() {
        return ApellidoCiudadano;
    }

    public void setApellidoCiudadano(String ApellidoCiudadano) {
        this.ApellidoCiudadano = ApellidoCiudadano;
    }

    public String getDireccionCiudadano() {
        return DireccionCiudadano;
    }

    public void setDireccionCiudadano(String DireccionCiudadano) {
        this.DireccionCiudadano = DireccionCiudadano;
    }

    public int getTelefonoCiudadano() {
        return TelefonoCiudadano;
    }

    public void setTelefonoCiudadano(int TelefonoCiudadano) {
        this.TelefonoCiudadano = TelefonoCiudadano;
    }

    public int getCelularCiudadano() {
        return CelularCiudadano;
    }

    public void setCelularCiudadano(int CelularCiudadano) {
        this.CelularCiudadano = CelularCiudadano;
    }

    public String getMailCiudadano() {
        return MailCiudadano;
    }

    public void setMailCiudadano(String MailCiudadano) {
        this.MailCiudadano = MailCiudadano;
    }

    public String getContraseniaCiudadano() {
        return ContraseniaCiudadano;
    }

    public void setContraseniaCiudadano(String ContraseniaCiudadano) {
        this.ContraseniaCiudadano = ContraseniaCiudadano;
    }

    public int getPuntajeCiudadano() {
        return PuntajeCiudadano;
    }

    public void setPuntajeCiudadano(int PuntajeCiudadano) {
        this.PuntajeCiudadano = PuntajeCiudadano;
    }

//    public List<RegistrarEvento> getListaRegistrarEvento() {
//        return listaRegistrarEvento;
//    }
//
//    public void setListaRegistrarEvento(List<RegistrarEvento> listaRegistrarEvento) {
//        this.listaRegistrarEvento = listaRegistrarEvento;
//    }
    
}
