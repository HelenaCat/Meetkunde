import java.util.ArrayList;

public class Algoritme3 extends Algoritme {

	public Algoritme3(){
		xSnijpunten = new ArrayList<Double>();
		ySnijpunten = new ArrayList<Double>();
		uitvoeringstijd = 0;
	}
	
	private ArrayList<Double> xSnijpunten,ySnijpunten;
	private long uitvoeringstijd;
	
	@Override
	public void voerUit(ArrayList<Cirkel> cirkels) {
		// TODO voer algoritme uit --> xSnijpunten en ySnijpunten in ArrayLists steken + uitvoeringstijd toekennen
		
	}

	@Override
	public ArrayList<Double> getXSnijpunten() {
		return xSnijpunten;
	}

	@Override
	public ArrayList<Double> getYSnijpunten() {
		return ySnijpunten;
	}

	@Override
	public long getUitvoeringstijd() {
		return uitvoeringstijd;
	}

}
