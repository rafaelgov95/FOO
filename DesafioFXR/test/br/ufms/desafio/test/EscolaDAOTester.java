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
package br.ufms.desafio.test;

import br.ufms.desafio.model.bean.Escola;
import br.ufms.desafio.model.dao.DAOFactory;

/**
 *
 * @author kleberkruger
 */
public class EscolaDAOTester extends UsuarioDAOTester<Escola> {

    public EscolaDAOTester() {
        super(DAOFactory.getInstance().getEscolaDAO());
    }

    @Override
    protected void printBean(Escola bean) {
        super.printBean(bean);
    }

    @Override
    protected Escola createBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void updateBean(Escola bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
