package com.java.repositories;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.java.model.VehicleModel;

@Repository
public class VehicleDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}
	public int insertVehicle(VehicleModel model)
	{
		SqlParameterSource namedParameters = null;
		 namedParameters = new
				  BeanPropertySqlParameterSource( model); 
		 return namedParameterJdbcTemplate.update( QueryBuilder.INSERT_VEHICLE,
				  namedParameters);
		
	}
	public int updateVehicle(VehicleModel model)
	{
		SqlParameterSource namedParameters=new BeanPropertySqlParameterSource(model);
		return namedParameterJdbcTemplate.update(QueryBuilder.UPDATE_VEHICLE, namedParameters);
	}
	public int deleteVehicle(int vId)
	{
		SqlParameterSource namedParameters=new MapSqlParameterSource().addValue("vId", vId);
		return namedParameterJdbcTemplate.update(QueryBuilder.DELETE_VEHICLE, namedParameters);
		
	}
	;

}
