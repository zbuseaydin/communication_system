
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		
		PrintStream outstream1;
		try {
			outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
		    e2.printStackTrace();
		    return;
		}
		
		for(int j=0; j<C; j++) {
			customers[j] = null;
		}
		for(int j=0; j<O; j++) {
			operators[j] = null;
		}
		int cusID = 0;
		int opID = 0;
		
		for(int i=0; i<N; i++) {
			int a = reader.nextInt();
			
			if (a == 2) {
				double talkingCharge = reader.nextDouble();
				double messageCost = reader.nextDouble();
				double networkCharge = reader.nextDouble();
				int discountRate = reader.nextInt();
				Operator myOperator = new Operator(opID, talkingCharge, messageCost, networkCharge, discountRate);
				operators[opID] = myOperator;
				opID++;
					
			}else if (a == 1) {
				String name = reader.next();
				int age = reader.nextInt();
				int operatorID = reader.nextInt();
				double limitingAccount = reader.nextDouble();
				Customer myCustomer = new Customer(cusID, name, age, operators[operatorID], limitingAccount);
				customers[cusID] = myCustomer;
				cusID++;
					
			}else if (a == 3) {
				int cusID1 = reader.nextInt();
				int cusID2 = reader.nextInt();
				int time = reader.nextInt();
				customers[cusID1].talk(time, customers[cusID2]);
					
			}else if (a == 4) {
				int cusID1 = reader.nextInt();
				int cusID2 = reader.nextInt();
				int quantity = reader.nextInt();
				customers[cusID1].message(quantity, customers[cusID2]);
								
			}else if (a == 5) {
				int cusID1 = reader.nextInt();
				double amount = reader.nextDouble();
				customers[cusID1].connection(amount);
					
			}else if (a == 6) {
				int cusID1 = reader.nextInt();
				double amount = reader.nextDouble();
				customers[cusID1].getBill().pay(amount);
						
			}else if (a == 7) {
				int cusID1 = reader.nextInt();
				int newOperatorID = reader.nextInt();
				customers[cusID1].setOperator(operators[newOperatorID]);
						
			}else if (a == 8) {
				int cusID1 = reader.nextInt();
				double newLimit = reader.nextDouble();
				customers[cusID1].getBill().changeTheLimit(newLimit);
			}
		}
		
		for(int i=0; i<O; i++) {
			outstream1.printf("Operator "+operators[i].ID+" : "+operators[i].talkingTime+" "+operators[i].numOfMessages+" %.2f\n",operators[i].MBsOfUsage);
		}
		
		for(int i=0; i<C; i++) {
			outstream1.printf("Customer "+customers[i].ID+" : %.2f %.2f\n", customers[i].getBill().amountPayed, customers[i].getBill().getCurrentDebt());
		}
		
		int maxTalk = 0;
		int maxMessages = 0;
		double maxMBs = 0;
		String maxTalkName = customers[0].name;
		String maxMessagesName = customers[0].name;
		String maxMBsName = customers[0].name;

		for(int i=0; i<C; i++) {
			if(customers[i].talkingTime > maxTalk) {
				maxTalk = customers[i].talkingTime;
				maxTalkName = customers[i].name;
			}
			if(customers[i].numOfMessages > maxMessages) {
				maxMessages = customers[i].numOfMessages;
				maxMessagesName = customers[i].name;
			}
			if(customers[i].MBsOfUsage > maxMBs) {
				maxMBs = customers[i].MBsOfUsage;
				maxMBsName = customers[i].name;
			}
		}
		
		outstream1.println(maxTalkName + " : " + maxTalk);
		outstream1.println(maxMessagesName + " : " + maxMessages);
		outstream1.printf(maxMBsName + " : %.2f\n",maxMBs);

		outstream1.close();
		reader.close();
		
	} 
}

