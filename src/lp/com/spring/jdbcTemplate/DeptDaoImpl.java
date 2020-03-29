package lp.com.spring.jdbcTemplate;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Dept getDepts(BigInteger deptno) {
		String sql = "select deptno ,dname,dbsource from dept where deptno=?";
		RowMapper<Dept> mapper = new BeanPropertyRowMapper<>(Dept.class);
		return jdbcTemplate.queryForObject(sql, mapper, deptno);
	}

}
