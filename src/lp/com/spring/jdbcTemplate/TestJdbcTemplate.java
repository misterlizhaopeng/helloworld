package lp.com.spring.jdbcTemplate;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestJdbcTemplate {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
	JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
	ComboPooledDataSource comboPooledDataSource = ctx.getBean("dataSource", ComboPooledDataSource.class);
	
	
	//要深刻理解此种写法和@Autowired的不同
	DeptDao deptDao = ctx.getBean("deptDaoImpl", DeptDaoImpl.class);
	
	// @Autowired
	// private DeptDao deptDao;

	@Test
	public void testAutowired() {
		// System.out.println(DeptDao);
		
		
		Dept depts = deptDao.getDepts(new BigInteger("3"));
		System.out.println(depts);
	}

	/**
	 * 查询一个实体
	 * 
	 * @date 2018年12月3日
	 * @author misterLip
	 */
	@Test
	public void testQueryForObject() {
		String sql = "select deptno,dname,dbsource from dept where deptno =6";
		RowMapper<Dept> mapper = new BeanPropertyRowMapper<>(Dept.class);
		Dept dept = jdbcTemplate.queryForObject(sql, mapper);
		System.out.println(dept);
	}

	/**
	 * 查询集合
	 * 
	 * @date 2018年12月3日
	 * @author misterLip
	 */
	@Test
	public void testQueryForList() {
		String sql = "select deptno,dname,dbsource from dept";
		RowMapper<Dept> mapper = new BeanPropertyRowMapper<>(Dept.class);
		// List<Dept> list = jdbcTemplate.queryForList(sql, Dept.class);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		System.out.println(list);
	}

	/**
	 * 查询多条记录
	 * 
	 * @date 2018年12月3日
	 * @author misterLip
	 */
	@Test
	public void testQuery() {
		String sql = "select deptno,dname,dbsource from dept";
		RowMapper<Dept> mapper = new BeanPropertyRowMapper<>(Dept.class);
		List<Dept> query = jdbcTemplate.query(sql, mapper);
		System.out.println(query);

	}
}
