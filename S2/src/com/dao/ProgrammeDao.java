package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.dto.Programme;
import com.dto.Speakers;

public class ProgrammeDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*public List<Programme> listProg() {
		String psc = "select * from program_data";
		ResultSetExtractor<Programme> rse = new ResultSetExtractor<Programme>() {
			@Override
			public Programme extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Programme> list = new ArrayList<Programme>();
				while (rs.next()) {
					Programme p = new Programme();
					p.setPid(rs.getInt("pid"));
					p.setHeading(rs.getString("heading"));
					p.setTime(rs.getString("time"));
					list.add(p);

				}
				return (Programme) list;

			}
		};
		return (List<Programme>) jdbcTemplate.query(psc, rse);

	}*/

	public List<Programme> getAllProgrammes() {
		
		String psc = "select pid, heading, time from program_data";
		//String psc = "select p.pid,p.heading,p.time,s.sid,s.pid,s.designation,s.image,s.name from program_data p,speaker_data s where p.pid=s.pid";
		return jdbcTemplate.query(psc, new ResultSetExtractor<List<Programme>>() {
			@Override
			public List<Programme> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Programme> list = new ArrayList<Programme>();
				while (rs.next()) {
					Speakers speakers = new Speakers();   
					Programme p = new Programme();      
					/*speakers.setName(rs.getString("name"));                        
					speakers.setImage(rs.getString("image"));
                    speakers.setDesignation(rs.getString("designation"));
                    speakers.setSid(rs.getInt("sid"));*/
					    
					p.setPid(rs.getInt("pid"));
					p.setHeading(rs.getString("heading"));
					p.setTime(rs.getString("time"));
					/*p.setSpeakers(speakers);     */         
					
					list.add(p);   
				}                   
				return list;
			}                       
		});
	}   
	
	
	public List<Speakers> getAllSpeakers() {
		String psc = "select p.pid,s.sid,s.pid,s.designation,s.image,s.name from program_data p,speaker_data s where p.pid=s.pid";   
		return jdbcTemplate.query(psc, new ResultSetExtractor<List<Speakers>>() {
			@Override
			public List<Speakers> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Speakers> spk = new ArrayList<Speakers>();
				while (rs.next()) {
					
					Speakers speakers = new Speakers();   
					speakers.setName(rs.getString("name"));                        
					speakers.setImage(rs.getString("image"));
                    speakers.setDesignation(rs.getString("designation"));
                    speakers.setSid(rs.getInt("sid"));
                    speakers.setPid(rs.getInt("pid"));
                    spk.add(speakers);                 
				}                                       
				return spk;   
			}
		});
	}  
	
	public int update(Programme p){  
	    String sql="update program_data set heading='"+p.getHeading()+"', time='"+p.getTime()+"' where pid="+p.getPid()+"";  
	    return jdbcTemplate.update(sql);  
	}                    
                                         
}
