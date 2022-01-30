package com.generalmanagmentservice.Service;
import java.io.CharArrayReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

import javax.print.DocFlavor.INPUT_STREAM;


import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.stat.Statistics;
import org.springframework.scheduling.config.Task;

import java.util.Comparator;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class Iotools 
{
//////////////sort a file 
	public static void sortFile() throws IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));
		
		String inStr = br.readLine();
		
		ArrayList<String> lststr = new ArrayList<String>();
		while (inStr!=null)  
		{
			lststr.add(inStr);
			
		}
		
		Collections.sort(lststr);
		
		for (Iterator iterator = lststr.iterator(); iterator.hasNext();) {
			String outstr = (String) iterator.next();
			wr.write(outstr);			
		}
		br.close();
		wr.close();
	}
	public void findAccurances() {
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter a string");
		String cp =sc.nextLine();
		
		char [] arr = cp.toCharArray();
		char [][] iarr=new char[arr.length][2];
		for (int i = 0; i < iarr.length; i++) {
			iarr[i][0]='_';
			iarr[i][1]='0';
		}
		
		for (int i = 0; i < arr.length; i++) 
		{
			for (int j = 0; j < iarr.length; j++) 
			{
				if (arr[i]==iarr[j][0])
				{
					int temp = Integer.parseInt(String.valueOf(iarr[j][1]));
					temp++;
					iarr[j][1]= Character.valueOf((char) temp);
				}
				if (iarr[j][0]=='_') 
				{
					iarr[j][0]=arr[i];
				}
			}
		}
		for (int j = 0; j < iarr.length; j++) 
		{
			if (iarr[j][1]!='0' && iarr[j][1]!='_') 
			{
				System.out.println(iarr[j][0]+": "+iarr[j][1]);
			}
		}
	}
	
	//find a character occurrence number i a string
	public void findAccurancesWithMap() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter a string");
		String cp =sc.nextLine();
		
		char [] arr = cp.toCharArray();
		Map<Character, Integer> res = new HashMap<>();
		for (int i = 0; i < arr.length; i++) 
		{
			if(res.containsKey(arr[i]))
			{
				res.replace(arr[i], res.get(arr[i])+1);
			}else
			{
				res.put(arr[i], 1);
			}
		}
		
		for (Map.Entry<Character, Integer> entry : res.entrySet()) {
			Character key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key+": "+val);
			
		}
	}
	
	//is binary number
	public void isBinary() 
	{
		Scanner sc = new Scanner(System.in);
		String cp = sc.nextLine();
		boolean isb = true;
		
		for (int i = 2; i < 10; i++) 
		{
			if (cp.contains(String.valueOf(i))) 
			{
				isb = false;
				break;
			}
		}
		if (isb==true) {
			System.out.println("is binary");
		}
		else System.out.println("NOT binary");
		
		
	}
	
	
	public void reverseWordsInString() 
	{
		Scanner sc = new Scanner(System.in);
		String brev = sc.nextLine();
		
		String [] temp = brev.split("//s+");
		for (String str : temp) 
		{
			StringBuffer bf = new StringBuffer();
			bf.append(str);
			System.out.println(bf.reverse());
		}
		
	}
	
	public static void seperateZeros(int [] arr) 
	{

//		int[] dest= new int [arr.length];
//		
//		for (int i = 0, j=dest.length-1,k=0; i < j; i++) 
//		{
//		
//			if(arr[i]!=0)
//			{
//				dest[k]=arr[i];
//				k++;
//				continue;
//			}
//			if(arr[i]==0)
//			{
//				dest[j]=0;
//				j--;
//			}
//			
//		}
//		
//		for (int k = 0; k < dest.length; k++) {
//			System.out.println(dest[k]+",");
//		}
		LinkedList<Integer> lst = new LinkedList<>();
		int k=0;
		for (int i = 0; i<arr.length; i++) 
		{
		
			if(arr[i]!=0)
			{
				lst.add(k,arr[i]);
				k++;
				continue;
			}
			if(arr[i]==0)
			{
				lst.addLast(0);
			}
			
		}
		
		for (Iterator iterator = lst.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
		
		
			
			
	}
	
	class Mycomperator implements Comparator<String>
	{
		public int compare(String o1, String o2)
		{
			return o1=o2;
		}		
	}
	
	
	
	public static void main(String[] args) {
	


LinkedList <Integer>lst1 = new LinkedList<Integer>();
		LinkedList <Integer>lst2 = new LinkedList<Integer>();
		 Set<Integer> st1 = new HashSet<>();
	     Set<Integer> st2 = new HashSet<>();
		
	     lst1.add(5);
	     lst1.add(7);
	     lst1.add(4);
	     lst1.add(1);
	     lst1.add(55);
	     lst1.add(75);
	     lst1.add(45);
	     lst1.add(13);
	     
	     lst2.add(6);
	     lst2.add(8);
	     lst2.add(4);
	     lst2.add(0);
	     lst2.add(64);
	     lst2.add(84);
	     lst2.add(45);
	     lst2.add(32);
	     int i = lst1.getFirst();
	     System.out.println(i);
	        
	     lst1.stream().sorted().forEach(System.out::println);
	     
	     st1.addAll(lst1); 
		    st2.addAll(lst2); 
		    st1.retainAll(st2);
			System.out.println(st1);
		BufferedReader br = new BufferedReader(new File("input.txt"));
		BufferedWriter wr = new BufferedWriter(new File("output.txt"));
		
		int i=0;
		LinkedList<String> lststr = new LinkedList<>();
	
		while (br.hasNext()) 
		{
			lststr.add(br.readLine());
		}
		lststr.sort(Mycomperator);
		
		for (Iterator iterator = lststr.iterator(); iterator.hasNext();) {
			wr.write(iterator.next());
			
		}
		
		int [] test = {10,6,0,2,88,0,5,0,34,56,1,5,3,67,0,5,34,23,0};
		seperateZeros(test);
//		Scanner sc = new Scanner(System.in);
//		String brev = sc.nextLine();
//		
//		String [] temp = brev.split(" ");
//		for (String str : temp) 
//		{
//			StringBuffer bf = new StringBuffer();
//			bf.append(str);
//			System.out.println(bf.reverse());
//		}
		
		
//		int [] arr = {2,5,55,4,7,67,3,6,3,6,99,4,88,3,111};
//		IntStream.of(arr).min().ifPresent(System.out::println);
//		IntStream.of(arr).max().ifPresent(System.out::println);
//		IntStream.of(arr).average().ifPresent(System.out::println);
//		IntSummaryStatistics stat =  IntStream.of(arr).summaryStatistics();
//		System.out.println(stat);
//		IntStream.of(arr).distinct().sorted().limit(3).forEach(System.out::println);
//		
//		
//		List<Slot> lst= new ArrayList<>();
//		lst.stream()
//			.sorted(Comparator.comparingInt(Slot::getId).reversed()) //sort all object in the list according to this comparator of int's and reverse them so first is maximum 
//			.filter(slot -> isActive(slot))			//filtering according to existing method that checks status
//			.filter(slot -> slot.getId()==3)		//find only a slot with id=3 in the list
//			.limit(3)								//only first 3 results are considered 
//			.map(Slot::getAisle)					//get for each of the 3 the aisle number that matches it
//			.forEach(System.out::println); 			//print this sequentially 
//
//		for (int i = 0; i < 100; i++) 
//		{
//			ExecutorService cpuBound = Executors.newFixedThreadPool(4);//defining our own threadPool limited by CPU cores number
//			ExecutorService ioBound = Executors.newCachedThreadPool();//defining our own threadPool dependent on IO response of external database
//			
//			CompletableFuture.supplyAsync(()->getOrder(),ioBound)
//			.thenApply(order -> enrich(order))
//			.thenApplyAsync(order -> performPayment(order),ioBound)//payment is depended on external cloud DB therefore will use separate threadPool with "then apply ASync" operation waiting for the response
//			//.exceptionally(e-> new FaildOrder())//an option to handle a failure exeption in performing the payment task/method
//			.thenApply(order -> dispatch(order))
//			.thenApplyAsync(order -> sendEmail(order),cpuBound);
//		}
//		
		
		
		
		
	}

	

	

	private static boolean isActive(Slot slt) {
		if (slt.getId()<=3) return true;
		else return false;
	}
	
	private static Object sendEmail(Object order) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object dispatch(Object order) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object performPayment(Object order) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object enrich(Object order) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}