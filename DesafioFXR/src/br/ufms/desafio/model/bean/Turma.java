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

import br.ufms.desafio.model.bean.enumerate.Periodo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que mapeia a tabela Turma do banco de dados.
 *
 * @author Kleber Kruger
 */
public class Turma extends Bean<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private Professor responsavel;
    private Escola escola;
    private List<Aluno> alunos;
    private Periodo periodo;

    /**
     * Cria um novo objeto Turma com os atributos nome, resposável, escola e período nulos, e
     * instancia a lista de alunos deixando-a inicialmente vazia.
     */
    public Turma() {
        this.alunos = new ArrayList<>();
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
     * @return the responsavel
     */
    public Professor getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(Professor responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the escola
     */
    public Escola getEscola() {
        return escola;
    }

    /**
     * @param escola the escola to set
     */
    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    /**
     * @return the alunos
     */
    public List<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * @param alunos the alunos to set
     */
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    /**
     * @return the periodo
     */
    public Periodo getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

}
