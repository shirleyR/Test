package com.leetcode;

/**
 * 
 *  Zigzag 
 *  pattern 
 *  
 *  
 *  P A H N
 *  APLSIIG
 *  Y I R
 *  
 *  
 *  P  D  F
 *  A GE SD 
 *  BF RW 
 *  C  I
 *  
 *  PABCFGDERIWSFD
 *  PAYPALISHIRING---->> PAHNAPLSIIGYIR
 *  
 * @author rsl
 *
 */



///   need to consider numRows equals one 

public class Solution6 {
	
	
	public String convert(String s, int numRows) {
		String con="";
		int len=s.length();
		if(numRows==1)return s;
		for(int i=1;i<=numRows;i++){
			if(i<=len) con+=s.charAt(i-1);
			if(i>len)break;
			for(int j=2;j<len;j+=2){
				int n=i+(numRows-1)*j;
			
				if(i!=1&&i!=numRows){
						int n2=n-2*(i-1);
						if(n2>len) break;
						con+=s.charAt(n2-1);
					
				}
				if(n>len) break;
				con+=s.charAt(n-1);
			}
		}
		return con;
		
	}
	public static void main(String args[]){
		Solution6 t=new Solution6();
		String s="ABCDEF";
		System.out.println(t.convert(s, 2));
	}
}
