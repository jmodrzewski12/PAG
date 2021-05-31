package zad5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


import java.io.PrintWriter;

public class ConvertFromRowToColumn {

	
	public final ArrayList<String> numbers  = new ArrayList<>();
	
    public ArrayList<String> getNumbers() {
        return numbers;
    }

    
	public void read(String fileName) throws FileNotFoundException{
    	File file = new File(fileName);
        Scanner in = new Scanner(file);
        
        String zdanie = in.nextLine();
        String[] number = zdanie.split("\\s+");
        
        for (int i = 0; i < number.length; i++) {
        	
        	if(number[i]!="\\s+") {
        		System.out.println(number[i]);
        		numbers.add(number[i]);
        	}

        }
        
	}
	
	public void read(File file) throws FileNotFoundException{
        Scanner in = new Scanner(file);
        
        String zdanie = in.nextLine();
        String[] number = zdanie.split("\\s+");
        
        for (int i = 0; i < number.length; i++) {
        	
        	if(number[i]!="\\s+") {
        		System.out.println(number[i]);
        		numbers.add(number[i]);
        	}

        }
        
	}
	
	public void write(String fileNameWrite) throws FileNotFoundException{
		PrintWriter zapis = new PrintWriter(fileNameWrite);
		for (int j = 0; j < numbers.size(); j++) {
			zapis.println(numbers.get(j));
		}
		
         zapis.close();
	}
	
	public void write(File file) throws FileNotFoundException{
		
		PrintWriter zapis = new PrintWriter(file);
		for (int j = 0; j < numbers.size(); j++) {
			zapis.println(numbers.get(j));
		}
		
         zapis.close();
	}
	
	public String getValue(int index) {
		return numbers.get(index);
		
	}
	
	public String toString() {
		return "Numbers from file: \n" + getNumbers();
	}
	
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject instanceof ConvertFromRowToColumn && super.equals(anObject)) {
        	ConvertFromRowToColumn other = (ConvertFromRowToColumn) anObject;
            return true;
        }
        return false;
     }
    
    public int hashCode() {
        return Objects.hash(getNumbers());
    }
    
    
	
    public static void main(String[] args) throws FileNotFoundException{
    	Scanner readName = new Scanner(System.in);
    	String fileNameRead = readName.nextLine();
    	
    	Scanner writeName = new Scanner(System.in);
    	String fileNameWrite = writeName.nextLine();
    	
    	File file = new File(fileNameRead);
    	File file2 = new File(fileNameWrite);
    	
    	ConvertFromRowToColumn plik = new ConvertFromRowToColumn();

    	plik.read(file);
//    	plik.read("input.txt");

    	plik.write(file2);
//    	plik.write("column.txt");
    	
    	System.out.println(plik.numbers.get(0).equals(plik.numbers.get(2)));
    	System.out.println(plik.getValue(4));
    	System.out.println(plik.hashCode());

    }

}
