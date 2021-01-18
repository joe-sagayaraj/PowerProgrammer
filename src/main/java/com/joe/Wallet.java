package main.java.com.joe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Wallet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,List<String>> map = new HashMap<>();
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine())
		{
			String command = input.nextLine();
			if(command.contains("CreateWallet"))
			{
				List<String> lst = new ArrayList<>();
				lst.add(command.split(" ")[2]);
				map.put(command.split(" ")[1], lst);
			}
			else if(command.contains("TransferMoney"))
			{
				List<String> lst = map.get(command.split(" ")[1]);
				String newStr = String.valueOf((Integer.valueOf(lst.get(0))-Integer.valueOf(command.split(" ")[3])));
				lst.remove(0);
				lst.add(0,newStr);
				
				lst = map.get(command.split(" ")[2]);
				newStr = String.valueOf((Integer.valueOf(lst.get(0))+Integer.valueOf(command.split(" ")[3])));
				lst.remove(0);
				lst.add(0,newStr);
				
			}
			System.out.println(map.toString());
		}
		System.out.println(map.toString());
		input.close();
		


	}
	
	
	  public static void walletOperation() {  }
	 
}
