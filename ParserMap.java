import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
//import Country;

public class ParserMap{
	
	private ArrayList<Country> listOfCountries;
	private HashMap<String, ArrayList<Country>> map;

	private ParserMap(){
		listOfCountries = new ArrayList<Country>();
		map = new HashMap<String, ArrayList<Country>>();
	}

	public static ParserMap getParsedFile(String path){
		ParserMap map = new ParserMap();
		map.getListAndMapFrom(path);
		return map;	
	}

	public HashMap<String, ArrayList<Country>> dict(){
		return map;
	}

	public ArrayList<Country> list(){
		return listOfCountries;
	}

	public void printList(){
		for (Country c : listOfCountries)
			System.out.print(c.getName() + " ");
		System.out.println(" ");
	}

	public void printMap(){
		for(String key : map.keySet()){
		//	for(ArrayList<Country> l : map.get(key))
			System.out.print(key + ": "); 	
			for(Country c : map.get(key))
					System.out.print(c.getName() + " ");
			System.out.println(" ");
		}
	}
	
	private void getListAndMapFrom(String path){
		BufferedReader reader = null;
		String line = "";
		//Se define separador ","
		String delim = ",";

		try {
			reader = new BufferedReader(new FileReader(path));
			while ((line = reader.readLine()) != null) {
				String [] names = line.split(delim);
				String key = names[0];
				String[] borderingsNames = Arrays.copyOfRange(names, 1, names.length);
				
				this.getCountriesFrom(names);
				//
				//Creo la lista de limítrofes de turno
				ArrayList<Country> borderings = new ArrayList<Country>();
				for(String name : borderingsNames){
					//
					//Busco x nombre los países limítrofes de la linea en la lista (sí o sí
					//fueron creados y agregados anteriormente)
					borderings.add(getByName(name));
				}
				//
				//Agrego los strings como claves (no paises).
				map.putIfAbsent(key,borderings);
			}
		} catch (Exception e) {
		}	
	}

	private void getCountriesFrom(String[] names){
		for(String name : names){
			if(!isInList(name)){
				Country c =  new Country(name);
				listOfCountries.add(c);

			}
		}
	}
	
	private Country getByName(String name){
		for (Country c : listOfCountries)
			if(c.getName().equals(name))
				return c;
		return null;
	}

	private boolean isInList(String name){
			for(Country c : listOfCountries)	
				if (c.getName().equals(name))
					return true;
		return false;
	}	

}
