/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="registrarevento")
public class RegistrarEvento {
    @Id
    @Column
    private int IdRegistroEvento;

    @Column
    private Date FechaRegistroEvento;
        
    @Column
    private String UbicacionRegistoEvento;
            
    @Column
    private long FotoRegistroEvento;
            
    @ManyToOne
    @JoinColumn(name="ciudadano")
    private Ciudadano ciudadano;
    
    @ManyToOne
    @JoinColumn(name="evento")
    private Evento evento;
}
