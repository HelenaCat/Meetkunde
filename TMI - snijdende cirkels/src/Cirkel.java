
public class Cirkel {

	private double xMidden, yMidden, straal, xBegin, xEinde;
	
	public Cirkel(double xMidden, double yMidden, double straal){
		this.xMidden = xMidden;
		this.yMidden = yMidden;
		this.straal = straal;
		this.xBegin = xMidden - straal;
		this.xEinde = xMidden + straal;
	}
	
	public double getXMidden(){
		return xMidden;
	}
	
	public double getYMidden(){
		return yMidden;
	}
	
	public double getStraal(){
		return straal;
	}
	
	public double getXBegin(){
		return xBegin;
	}
	
	public double getXEinde(){
		return xEinde;
	}
}
