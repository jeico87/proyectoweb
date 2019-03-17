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
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEvento")
    private int IdEvento;

    @Column
    private String nombreEvento;

    @Column
    private int PuntajeEvento;

    //pendiente por revisar
    @OneToMany(mappedBy = "evento" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistrarEvento> listaRegistrarEvento;

    public Evento() {
    }

    public int getIdEvento() {
        return IdEvento;
    }

    public void setIdEvento(int IdEvento) {
        this.IdEvento = IdEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public int getPuntajeEvento() {
        return PuntajeEvento;
    }

    public void setPuntajeEvento(int PuntajeEvento) {
        this.PuntajeEvento = PuntajeEvento;
    }

    public List<RegistrarEvento> getListaRegistrarEvento() {
        return listaRegistrarEvento;
    }

    public void setListaRegistrarEvento(List<RegistrarEvento> listaRegistrarEvento) {
        this.listaRegistrarEvento = listaRegistrarEvento;
    }
}
