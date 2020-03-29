package lp.com.spring.jdbcTemplate;

import java.math.BigInteger;

public class Dept {

	private BigInteger deptno;
	private String dname;
	private String dbsource;

	public BigInteger getDeptno() {
		return deptno;
	}

	public void setDeptno(BigInteger deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDbsource() {
		return dbsource;
	}

	public void setDbsource(String dbsource) {
		this.dbsource = dbsource;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", dbsource=" + dbsource + "]";
	}

}
