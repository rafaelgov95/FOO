/*
 * Copyright (C) 2016 kleberkruger
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
package br.ufms.desafio.model.dao;

import br.ufms.desafio.model.bean.Professor;
import br.ufms.desafio.model.bean.enumerate.Titulacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kleberkruger
 */
public class ProfessorDAO extends JogadorDAO<Professor> {

    protected ProfessorDAO() {
        super(Professor.class);
    }
    
    @Override
    protected void insertAbst(Connection conn, Professor bean) throws SQLException {
        final String sql = "INSERT INTO desafio.professor (codigo, titulacao) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            final Titulacao titulacao = bean.getTitulacao();
            ps.setLong(1, bean.getCodigo());
            ps.setObject(2, titulacao != null ? titulacao.toString() : null);
            ps.executeUpdate();
        }
    }

    @Override
    protected void updateAbst(Connection conn, Professor bean) throws SQLException {
        final String sql = "UPDATE desafio.professor SET titulacao = ? WHERE codigo = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            final Titulacao titulacao = bean.getTitulacao();
            ps.setObject(1, titulacao != null ? titulacao.toString() : null);
            ps.setLong(2, bean.getCodigo());
            ps.executeUpdate();
        }
    }

    @Override
    protected Professor populateBean(Professor prof, Connection conn, ResultSet rs) throws SQLException {
        // Popula os atributos comum a todos os jogadores
        super.populateBean(prof, conn, rs);

        // Popula apenas os atributos do professor
        final String titulacao = rs.getString("titulacao");
        prof.setTitulacao(titulacao != null ? Titulacao.valueOf(titulacao) : null);
//        prof.setEscolas(getDAOFactory().getEscolaDAO().findByProfessor(conn, prof.getCodigo()));
        prof.setTurmas(getDAOFactory().getTurmaDAO().findByProfessor(conn, prof.getCodigo()));

        return prof;
    }

    @Override
    protected Professor resultSetToBean(Connection conn, ResultSet rs) throws SQLException {
        return populateBean(new Professor(), conn, rs);
    }

    @Override
    protected String sqlToGet(Long codigo) {
        StringBuilder command = new StringBuilder("SELECT * FROM desafio.usuario u, desafio.jogador j, desafio.professor p");
        command.append(" WHERE u.codigo = ").append(codigo);
        command.append(" and j.codigo = ").append(codigo);
        command.append(" and p.codigo = ").append(codigo);
        return command.toString();
    }

    @Override
    protected String sqlToGetAll() {
        return "SELECT * FROM desafio.usuario u JOIN desafio.jogador j ON u.codigo = j.codigo "
                + "JOIN desafio.professor p ON j.codigo = p.codigo";

//        SELECT * FROM desafio.professor p JOIN desafio.escola_professor ep ON p.codigo = ep.codigo_professor 
//                JOIN desafio.escola e ON e.codigo = ep.codigo_escola WHERE ep.codigo_professor = 8; -- where e.tipo = 'ESTADUAL';
    }

    public List<Professor> findByEscola(Connection conn, Long codigo) throws SQLException {
        final String sql = "SELECT * FROM desafio.usuario u JOIN desafio.jogador j ON u.codigo = j.codigo "
                + "JOIN desafio.professor p ON j.codigo = p.codigo JOIN desafio.escola_professor ep "
                + "ON p.codigo = ep.codigo_professor JOIN desafio.escola e ON e.codigo = ep.codigo_escola "
                + "WHERE ep.codigo_escola = ?";
        
        List<Professor> beans = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    beans.add(resultSetToBean(conn, rs));
                }
            }
        }
        return beans;
    }

    @Override
    protected List<Professor> getAllString(Connection conn, String string) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
