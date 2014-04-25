import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class SnijdendeCirkels {
	
	private static int algoritmeNr, aantalCirkels;
	private static ArrayList<Cirkel> cirkels;
	private static ArrayList<Double> xSnijpunten,ySnijpunten;
	private static long uitvoeringstijd;
	
	public static void main(String[] args) throws IOException {
		
		cirkels = new ArrayList<Cirkel>();
		
		xSnijpunten = new ArrayList<Double>();
		ySnijpunten = new ArrayList<Double>();
		
		invoerInlezen();
		
		Algoritme algoritme = null;
		switch (algoritmeNr) {
		case 1:
			algoritme = new Algoritme1(); 
			break;
		case 2:
			algoritme = new Algoritme2();
			break;
		case 3:
			algoritme = new Algoritme3();
			break;
		}
		
		algoritme.voerUit(cirkels);
		xSnijpunten = algoritme.getXSnijpunten();
		ySnijpunten = algoritme.getYSnijpunten();
		uitvoeringstijd = algoritme.getUitvoeringstijd();
		
		uitvoerWegschrijven();

	}

	private static void invoerInlezen() throws FileNotFoundException {
		//algoritmeNr, aantalCirkels, xMiddens, yMiddens, stralen --> inlezen en toekennen
		File file = new File("input.txt");
		
    	Scanner scanner = new Scanner(file);
    	scanner.useLocale(Locale.US);
    	
    	algoritmeNr = scanner.nextInt();
    	aantalCirkels = scanner.nextInt();
    	    	
    	double xMidden = 0;
    	double yMidden = 0;
    	double straal = 0;
    	for(int i = 0; i<aantalCirkels;i++){
    		if(scanner.hasNextDouble())	xMidden = scanner.nextDouble();
    		if(scanner.hasNextDouble())	yMidden = scanner.nextDouble();
    		if(scanner.hasNextDouble())	straal = scanner.nextDouble();
    		cirkels.add(new Cirkel(xMidden,yMidden,straal));
    	}
    	
        scanner.close();
	}
	
	private static void uitvoerWegschrijven() throws IOException {
		// xSnijpunten, ySnijpunten, uitvoeringstijd --> wegschrijven
		// als ze null zijn: "Dit algoritme is niet geïmplementeerd" wegschrijven
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"), true);
	    
		for(int i = 0;i<xSnijpunten.size();i++){
			out.println(xSnijpunten.get(i) + " " + ySnijpunten.get(i));
		}
		out.println("");
		out.println(uitvoeringstijd+"");
		
		out.close();
	}

}
