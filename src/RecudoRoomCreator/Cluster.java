package RecudoRoomCreator;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.bukkit.Location;

import com.main.Main;




public class Cluster{	
	public static LibraryOfRoom lib;
	static List<Room> rooms = new ArrayList<Room>();
	Map<String, String> params = new HashMap<String, String>();
	public Cluster() throws Exception {
		lib = new LibraryOfRoom();
		params.put("NumberOfRooms", "50");
		params.put("NumberOfLevels", "1");
		params.put("NumberOfTheBossRoomsInLevel", "1");
	}
	public static Cluster generate() throws Exception {
		Cluster cluster = new Cluster();
		rooms.add(new Room("mainHall", new Position(-499, -499)));
		connectRoom(rooms.get(0), "basicRoom",  "Right", true);
		return cluster;
	}
	public static void print(Location l) throws IOException {
		for(Room r : rooms) {
			r.create(l.getX(), l.getY(), l.getZ());
		}
		
	}
	private static boolean connectRoom(Room r1, String r2,String mode, boolean hasCorridor) {
		Shape sh2 = LibraryOfRoom.getRoomShape(r2);
		switch(mode) {
			case "Right":
				for(Position p : r1.shape.out) {
					if(p != null && p.y==r1.shape.n) {
						if(hasCorridor) {
							rooms.add(new Room("hCorridor", p.getPos()));
							
						} else {
							
						}
					}
					else continue;
				}
				break;
			case "Left":
				break;
			case "Up":
				break;
			case "Down":
				break;
			
		}
		return false;
	}
}


class Room{
	ArrayList<Position> p= new ArrayList<Position>();
	Shape shape;
	public Room(Shape shape) {
		this.shape = shape;
	}
	
	public Room(String name, Position startPosition) {
		shape = LibraryOfRoom.getRoomShape(name);
		if(shape == null) {
			System.out.println("Сетка пуста");
			return;
		}
		for(int x = startPosition.x ;x < startPosition.x + shape.m; x ++)
			for(int y = startPosition.y ;y < startPosition.y + shape.n; y ++)
				p.add(new Position(x, y));
	}
	
	public void setPosition(Position startPosition) {
		for(int x = startPosition.x ;x <= x+shape.m; x ++)
			for(int y = startPosition.y ;y <= y+shape.n; y ++)
				p.add(new Position(x, y));
	}

	public void create(double x, double y, double z) {
		char[] arr = shape.arr.toString().toCharArray();
		int i = 0;
		for(Position p : this.p) {
			Location l = new Location(Main.GetNess(), x, y, z);
			switch (arr[i]) {
			
			case '#':
				break;
			case '$':
				
				break;
			case '%':
				
				break;
			case '&':
				
				break;
			
			}
		}
		i++;
	}
	
	
}
class Position {
	int x;
	int y; 

	public Position(int x, int y) {
		this.x = x;		
		this.y = y;	
	}
	public Position addPos(Position p) {
		this.x += p.x;
		this.y += p.y;
		return(this);
				
	}
	public Position subPos(Position p) {
		this.x -= p.x;
		this.y -= p.y;
		return(this);
				
	}
	public Position setPos(Position p) {
		this.x = p.x;
		this.y = p.y;
		return(this);
				
	}
	public Position getPos() {
		return(this);			
	}


}

class Shape{
	char[][] arr;
	int m;
	int n;
	Position[] out;
	
	public Shape(char[][] arr, int m, int n, Position[] out) {
		this.arr = arr;
		this.m = m;
		this.n = n;
		this.out = out;
	}
	public char getElement(int x, int y) {
		return arr[x][y];
	}
	
}

class LibraryOfRoom {
	static Map<String, Shape> dic = new HashMap<String, Shape>();
	
	public LibraryOfRoom() throws Exception{
		File folder = new File("E:\\MinecraftServer\\plugins\\SPD\\Rooms");
		if(!folder.exists()) {
			folder.createNewFile();
		}
		for (File f : folder.listFiles()) {
			if(f.getName().length() < 1) continue;
			String key = f.getName().substring(0, f.getName().length()-4);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new FileReader(f));
			List<String> list = new ArrayList<String>();
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());

			}
			char[][] arr = new char[list.size()][list.get(0).length()];
			ArrayList<Position> out = new ArrayList<Position>();
			for(int i = 0; i < list.size(); i++) {
				int ind = list.get(i).indexOf('$');
				int lind = list.get(i).lastIndexOf('$');
				if(ind > -1)
					out.add(new Position(i, ind));
				if(lind > -1 && ind != lind) 
					out.add(new Position(i, lind));
				
					
				arr[i] = list.get(i).toCharArray();
			}
			for(Position p : out) {
			}
			dic.put(key, new Shape(arr, list.size(), list.get(0).length(), (Position[]) out.toArray(new Position[0])));
			/*
			for(int x = 0 ;x < list.size(); x ++)
			{
				
				for(int y = 0 ;y < list.get(0).length(); y ++)
					System.out.print(arr[x][y]);
				System.out.println("|");
			}
			*/
			
				
			
		}
	}
	
	public static Shape getRoomShape(String name) {
		if(dic.get(name) != null)
		return dic.get(name);
		else	{
			System.out.println("Неверно указоно имя комнаты: " + name);
			return null;
		}
	}
	public int getLen() {
		return dic.size();
	}
}



