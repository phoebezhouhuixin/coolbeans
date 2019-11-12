package fileDb;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileDb {
	private InputStream is;
	private OutputStream os;
	private FileWriter fw;
	public boolean isCreated = false;
	public String currentDbName;

	public boolean makeDataBase(String dbName) {
		try {
			this.fw = new FileWriter(dbName + ".txt");
			this.isCreated = true;
			this.currentDbName = dbName;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Map<String,String>> readDataBase(String dbName) {
		ArrayList<Map<String,String>> data = new ArrayList<Map<String,String>>();
		try {
			this.is = new FileInputStream(dbName + ".txt");

			int rowCounter = 0;
			ArrayList<String> colNames = new ArrayList<String>();

			Scanner sc = new Scanner(is);
			while (sc.hasNextLine()) {
				Map<String, String> map = new HashMap<String, String>();
				String[] row = sc.nextLine().split(",");
				// first row will have column names, so we get them
				if (rowCounter == 0) {
					for (String rec : row) {
						colNames.add(rec);
					}
					rowCounter+=1;
				}
				else {
					for (int i = 0; i<colNames.size(); i+=1) {
						//using each colName we previously got to be the key for it's column values
						map.put(colNames.get(i).trim(), row[i].trim());
					}
					data.add(map);
				}		
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public boolean removeEntry(String colName, String compareWith) {
		String dbName = this.currentDbName;
		try {
			this.is = new FileInputStream(dbName + ".txt");
			File inputFile = new File(dbName + ".txt");
			File tempFile = new File("myTempFile.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			int count = 0;
			List<String> first = Arrays.asList(new String[] {"temp"});
			Scanner sc = new Scanner(is);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				List<String> row = Arrays.asList(line.split(","));
				if(count==0) {
					first = row;
					writer.write(line+System.getProperty("line.separator"));
					count+=1;
				}else {
					if(row.get(first.indexOf(colName)).equals(compareWith) == false ) {
						System.out.println("in here");
						writer.write(line+System.getProperty("line.separator"));
					}
				}
			}
			writer.close(); 
			sc.close();
			return tempFile.renameTo(inputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		//Compares values at rowName with compareWith
//		ArrayList<Map<String,String>> data = this.readDataBase(dbName);
//		ArrayList<Map<String,String>> newData = new ArrayList<Map<String,String>>();
//		
//		for (int i=0; i<data.size(); i++) {
//			Map<String,String> row = data.get(i);
//			String[] record = new String[row.size()];
//			if(row.get(colName).equals(compareWith) == false) {
//				newData.add(row);
//			}
//		}
//		try {
//			this.fw = new FileWriter((this.currentDbName + ".txt")); // open new file
//			for (int i=0; i<newData.size(); i++) {
//				Map<String,String> row = newData.get(i);
//				String[] record = new String[row.size()];
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
		return false;
		
	}
	
	public void setDbName(String name) {
		this.currentDbName = name;
	}
	
	public boolean addRecord(String[] record) {
		try {
			if(this.isCreated == false) {
				// new file not created, will search for existing
				if(this.fw ==null) {
					if(this.currentDbName ==null) {
						System.out.println("Set the db name first!");
					}
					else {
						this.fw = new FileWriter((this.currentDbName + ".txt"), true); // true if opening in append mode
					}					
				}
			}
			fw.write(String.join(",", record)+"\n");
			fw.flush();
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		FileDb db = new FileDb();
		//make db
//		db.makeDataBase("records");
		// add records
//		db.setDbName("records");
//		db.addRecord(new String[]{"id", "name", "rating"});
//		db.addRecord(new String[]{"1", "shrek 2", "5"});
//		db.addRecord(new String[]{"2", "toy story 4", "4"});
//		db.addRecord(new String[]{"3", "avengers", "3"});
		// read it 
//		ArrayList<Map<String,String>> data = db.readDataBase("records"); // making you pass name so you know which db you're reading from
//		System.out.println(data.toString());
////		
//		db.removeEntry("name", "avengers");
//		db.addRecord(new String[]{"4", "BOONts", "3"});
//		System.out.println(db.readDataBase("records").toString());

	}

}

