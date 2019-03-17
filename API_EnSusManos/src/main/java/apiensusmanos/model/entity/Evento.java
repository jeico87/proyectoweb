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
    private Integer IdEvento;

    @Column
    private String nombreEvento;

    @Column
    private Integer puntajeEvento;

//    @OneToMany(mappedBy = "evento" , cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<RegistrarEvento> listaRegistrarEvento;

    public Evento() {
    }

    public Integer getIdEvento() {
        return IdEvento;
    }

    public void setIdEvento(Integer IdEvento) {
        this.IdEvento = IdEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Integer getPuntajeEvento() {
        return puntajeEvento;
    }

    public void setPuntajeEvento(Integer puntajeEvento) {
        this.puntajeEvento = puntajeEvento;
    }
}
