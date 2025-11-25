package com.seuprojeto.mopo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="receita")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private String tempoPreparo;

    @NotBlank
    private String rendimento;

    @NotBlank
    private String dataInsercao;

  public Receita() {

  }

  public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(String tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getRendimento() {
        return rendimento;
    }

    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }

    public String getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(String dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Receita(@NotBlank String nome, @NotBlank String descricao, @NotBlank String tempoPreparo,
            @NotBlank String rendimento, @NotBlank String dataInsercao) {
        this.nome = nome;
        this.descricao = descricao;
        this.tempoPreparo = tempoPreparo;
        this.rendimento = rendimento;
        this.dataInsercao = dataInsercao;
    }

    public Long getId() {
        return id;
    }

}
