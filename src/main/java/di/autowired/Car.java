package di.autowired;

import di.tire.Tire;

public class Car {

//	@Resource
//	@Inject
//	@Autowired
//	@Qualifier("sTire")
	private Tire tire;
	
	public String getInfo( ) {
		return tire.getProduct() + " 장착!!";
	}

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	
}
