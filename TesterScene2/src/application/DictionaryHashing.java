package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.TreeMap;

public class DictionaryHashing {
	
	static HashSet<String > hash;

	public DictionaryHashing() {
		 hash = new HashSet<String >();
	        BufferedReader rd;
			try {
				rd = new BufferedReader( new FileReader ("C:\\Users\\emily\\Downloads\\dictionary.txt"));
	        String line = "";

	        try {
				while ((line = rd.readLine()) != null){
				    hash.add(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	        
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			



	    }
	
	public HashSet<String > getHashSet(){
		return hash;
	}
	
	public boolean isInHashMap(String word) {
		
		if (hash.contains(word)) {
			return true;
		}

		return false;
		
	}
	
	
	}



