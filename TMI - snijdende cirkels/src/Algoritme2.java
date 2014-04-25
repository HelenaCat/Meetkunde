import java.util.ArrayList;
import java.util.PriorityQueue;

public class Algoritme2 extends Algoritme {

	public Algoritme2(){
		xSnijpunten = new ArrayList<Double>();
		ySnijpunten = new ArrayList<Double>();
		uitvoeringstijd = 0;
	}
	
	private ArrayList<Double> xSnijpunten,ySnijpunten;
	private long uitvoeringstijd;
	
	@Override
	public void voerUit(ArrayList<Cirkel> cirkels) {
		long startTijd = System.currentTimeMillis();
		
		//voer algoritme uit --> xSnijpunten en ySnijpunten in ArrayLists steken + uitvoeringstijd toekennen
		PriorityQueue<Cirkel> beginXQueue = new PriorityQueue<Cirkel>(1,new xBeginComparator());
		beginXQueue.addAll(cirkels);
		PriorityQueue<Cirkel> eindXQueue = new PriorityQueue<Cirkel>(1,new xEindeComparator());
		eindXQueue.addAll(cirkels);
		
		ArrayList<Cirkel> actieveCirkels = new ArrayList<>();
		
		while(!beginXQueue.isEmpty()){
			if(beginXQueue.peek().getXBegin()<=eindXQueue.peek().getXEinde()){ //ook als gelijk, want dan kunnen ze raken en moeten ze dus nog met elkaar gechecked worden
				Cirkel nieuweCirkel = beginXQueue.poll();
				for(Cirkel actieveCirkel: actieveCirkels){
					checkEnBerekenSnijpunten(actieveCirkel, nieuweCirkel);
				}
				actieveCirkels.add(nieuweCirkel);
			}
			else{ //if(beginQueue.peek().getXBegin>eindQueue.peek().getXEinde())
				actieveCirkels.remove(eindXQueue.poll());
			}
		}
		
		long eindTijd = System.currentTimeMillis();
		uitvoeringstijd = eindTijd-startTijd;
	}

	private void checkEnBerekenSnijpunten(Cirkel c1, Cirkel c2){
		double d = Math.sqrt(Math.pow(Math.abs(c1.getXMidden()-c2.getXMidden()),2) + Math.pow(Math.abs(c1.getYMidden()-c2.getYMidden()),2));
		if(d == c1.getStraal()+c2.getStraal()){
			losOp1(c1,c2);
		}
		else if(d<c1.getStraal()+c2.getStraal()){
			if(d == Math.abs(c1.getStraal()-c2.getStraal())){
				losOp1b(c1,c2);
			}
			else if(d>Math.abs(c1.getStraal()-c2.getStraal())){
				losOp2(c1,c2,d);
			}
		}
	}	
		
	private void losOp1(Cirkel c1, Cirkel c2){
		xSnijpunten.add( (c2.getStraal()*c1.getXMidden() + c1.getStraal()*c2.getXMidden() ) / (c1.getStraal()+c2.getStraal()));
		ySnijpunten.add( (c2.getStraal()*c1.getYMidden() + c1.getStraal()*c2.getYMidden() ) / (c1.getStraal()+c2.getStraal()));
	}
	
	private void losOp1b(Cirkel c1, Cirkel c2){
		//TODO er moet voor gezorgd worden dat C1 altijd de grootste cirkel van de 2 is
		xSnijpunten.add( (c1.getStraal()*c2.getXMidden() - c2.getStraal()*c1.getXMidden() ) / (c1.getStraal()-c2.getStraal()));
		ySnijpunten.add( (c1.getStraal()*c2.getYMidden() - c2.getStraal()*c1.getYMidden() ) / (c1.getStraal()-c2.getStraal()));
	}
	
	private void losOp2(Cirkel c1, Cirkel c2, Double d){		
		double d1 = (Math.pow(c1.getStraal(),2) - Math.pow(c2.getStraal(), 2) + Math.pow(d, 2)) / (2*d);
		double h = Math.sqrt(Math.pow(c1.getStraal(),2) - Math.pow(d1, 2));
		double x3 = c1.getXMidden()+(d1*(c2.getXMidden()-c1.getXMidden()))/d;
		double y3 = c1.getYMidden()+(d1*(c2.getYMidden()-c1.getYMidden()))/d;
		
		xSnijpunten.add(x3+(h*(c2.getYMidden()-c1.getYMidden()))/d);
		ySnijpunten.add(y3-(h*(c2.getXMidden()-c1.getXMidden()))/d);
		
		xSnijpunten.add(x3-(h*(c2.getYMidden()-c1.getYMidden()))/d);
		ySnijpunten.add(y3+(h*(c2.getXMidden()-c1.getXMidden()))/d);
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
