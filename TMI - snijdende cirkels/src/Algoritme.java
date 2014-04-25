import java.util.ArrayList;

public abstract class Algoritme {

	public abstract void voerUit(ArrayList<Cirkel> cirkels);
	public abstract ArrayList<Double> getXSnijpunten();
	public abstract ArrayList<Double> getYSnijpunten();
	public abstract long getUitvoeringstijd();
}
