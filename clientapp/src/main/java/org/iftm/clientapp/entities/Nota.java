package org.iftm.clientapp.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//INSERT INTO tb_nota (nota_valor, nota_mediaFinal) VALUES (8.5, 7.8);
@Entity
@Table(name="tb_nota")
public class Nota implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nota_valor", nullable = false)
    private Float valor;
    @Column(name = "nota_mediaFinal", nullable = false)
    private Float mediaFinal;

    public Nota(){}
    
    public Nota(Long id, Float valor, Float mediaFinal) {
        this.id = id;
        this.valor = valor;
        this.mediaFinal = mediaFinal;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public Float getValor() {
        return valor;
    }

    public Float getMediaFinal() {
        return mediaFinal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public void setMediaFinal(Float mediaFinal) {
        this.mediaFinal = mediaFinal;
    }}