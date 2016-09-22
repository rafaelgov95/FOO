/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.desafio.controller;

import br.ufms.desafio.model.bean.Aluno;

import br.ufms.desafio.model.bean.Escola;
import br.ufms.desafio.model.bean.Professor;
import br.ufms.desafio.model.bean.Responsavel;
import br.ufms.desafio.model.bean.Usuario;

/**
 *
 * @author Rafael Viana - Debian 8
 */
public class Lupa {

    static Usuario user;


    static void persistirMemoria(Usuario t) {
        if (t instanceof Escola) {
            System.out.println("User Escola");

            Lupa.user = t;
        } else if (t instanceof Aluno) {
            System.out.println("User Aluno");

            Lupa.user = t;
        } else if (t instanceof Professor) {
            System.out.println("User Professor");

            Lupa.user = t;

        } else if (t instanceof Responsavel) {

            System.out.println("User Responsavel");
            Lupa.user = t;

        }
        
    }
}
