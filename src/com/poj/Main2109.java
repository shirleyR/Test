package com.poj;

import java.util.*;
public class Main2109 {
	public boolean Compare(String a,String b){
		// "10002"---> 20001
		if(a.length()>b.length())return true;
		else if(a.length()<b.length())return false;
		if(a.length()==b.length()){
			int ba=a.length();
			while(ba>=0){
				if(a.charAt(ba)>b.charAt(ba)){
					return true;
				}
				if(a.charAt(ba)<b.charAt(ba)){
					return false;

				}
			}

		}
		return true;
	}
	public static String  Plus(String a,String b){

		int alen=a.length();
		int blen=b.length();
		String finalnum="";
		// c=a*b;

		int addjinwei=0;
		int multjinwei=0;

		char stem[]=new char[alen+blen];
		for(int i=0;i<alen+blen;i++)
			stem[i]='0';
		for(int i=0;i<blen;i++){

			addjinwei=0;
			multjinwei=0;
			for(int j=0;j<alen;j++)
			{
				int pa=a.charAt(j)-'0';
				int pb=b.charAt(i)-'0';
				int c=pa*pb;
				int benwei=(c%10+multjinwei)%10;
				benwei=(pa*pb+multjinwei+stem[i+j]-'0');
				multjinwei=benwei/10;
				stem[i+j]=(char)((benwei%10)+'0');
			}
			stem[i+alen]+=multjinwei;

		}
		for(int i=0;i<alen+blen;i++)
			finalnum+=stem[i];

		return finalnum;
	}
	
	public void binarySearch(String a,String b){
		
		



	}

	public static void main(String args[]){

		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int n=in.nextInt();
			String p=in.next(); // 10^101

			//	 find k -->>> k^n =p

			if(n==1) System.out.println(p);
			else{
				



			}


		}

	}
}
