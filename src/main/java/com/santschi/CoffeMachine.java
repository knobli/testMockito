package com.santschi;

public class CoffeMachine {
	
	private Container waterCointer;
	private Container coffeCointer;
	
	
	public CoffeMachine(Container waterCointer,
			Container coffeCointer) {
		super();
		this.waterCointer = waterCointer;
		this.coffeCointer = coffeCointer;
	}
	
	public boolean makeCoffee(Portion portion){
		if(waterCointer.getPortion(portion) && coffeCointer.getPortion(portion))
			return true;
		return false;
	}

}
