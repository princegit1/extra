

public class Product {
	private String name;
	private int id;

	@Override
	public String toString() {
		return "Product [name=" + name + ", id=" + id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String execute() {
		return "success";
	}

}
