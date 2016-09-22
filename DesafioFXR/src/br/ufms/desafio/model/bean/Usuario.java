/*
 * Copyright (C) 2016 Kleber Kruger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.ufms.desafio.model.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que mapeia a tabela Usuario do banco de dados.
 *
 * @author Kleber Kruger
 */
public class Usuario extends Bean<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String usuario;
    private String senha;
    private String email;
    private List<Telefone> telefones;
    private Endereco endereco;
    private LocalDate criacao;

    /**
     * Cria um novo objeto usuário com nome, usuário, senha, email e endereço nulos; instancia uma
     * lista vazia de telefones; e inicializa o atributo criação com a data atual.
     */
    protected Usuario() {
        this.telefones = new ArrayList<>();
        this.criacao = LocalDate.now();
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefones
     */
    public List<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the criacao
     */
    public LocalDate getCriacao() {
        return criacao;
    }

    /**
     * @param criacao the criacao to set
     */
    public void setCriacao(LocalDate criacao) {
        this.criacao = criacao;
    }

}
