package com.estruturadados.academia.database.dao;

import com.estruturadados.academia.database.model.Usuario;
import java.sql.SQLException;
import java.util.List;

public abstract class SistemaDAO {
	
	public abstract List Select() throws SQLException;
        public abstract Object SelectWithCondition(Object param) throws SQLException;
	public abstract int Insert(Object param) throws SQLException;
	public abstract long Delete(Object param);
	public abstract long Update(Object param, Object param2);

}
