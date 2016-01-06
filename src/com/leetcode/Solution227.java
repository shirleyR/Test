package com.leetcode;



public class Solution227 {
	public int calculate(String s) {
		char []c=new char[1000];
		int num=0;
		int stack[]=new int[1000];
		int temp=0;
		s=s+"/";
		int labelc=-1;
		int labels=-1;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch>='0'&&ch<='9'){
				temp=ch-'0'+temp*10;
			}else 
				if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
					if(labelc>=0&&c[labelc]=='*'){
						labelc--;
						stack[labels]=stack[labels]*temp;
					}else if(labelc>=0&&c[labelc]=='/'){
						stack[labels]=stack[labels]/temp;
						labelc--;
					}else {
					 labels++;
					stack[labels]=temp;
					}
					labelc++;
					c[labelc]=ch;
					temp=0;
				}

		}
//		labels++;
//		stack[labels]=temp;
		int t=1;
		for(int i=0;i<labelc;i++){
			if(c[i]=='+'){
				stack[t]=stack[t]+stack[t-1];
			}else if(c[i]=='-'){
				stack[t]=stack[t-1]-stack[t];
			}else if(c[i]=='*'){
				stack[t]=stack[t-1]*stack[t];
			}else if(c[i]=='/'){
				stack[t]=stack[t-1]/stack[t];
				
			}
			t++;
		}
		num=stack[labels];


		return num;
	}
	public static void main(String args[]){
		Solution227 t=new Solution227();
		String s="282-1*2*13-30-2*2*2/2-95/5*2+55+804+3024";
		System.out.println(t.calculate(s));
	}
}
