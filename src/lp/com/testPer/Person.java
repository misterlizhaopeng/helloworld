package lp.com.testPer;

public class Person {
	
	private String x;
	private String desc;
	public String getName() {
		return x;
	}
	public void setName(String name) {
		this.x = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "aaaaaaaaaaaaaa---->Person [name=" + x + ", desc=" + desc + "]";
	}

	
}
