package com.zju;

import java.util.Scanner;
import java.util.*;

class Rect{
	int x;
	int y;
	int z;
}

public class Main1093 {


	public static void main(String args[]){
		Scanner in =new Scanner(System.in);
		while(in.hasNext()){

			// matrix
			int n=in.nextInt();
			List<Rect> list=new ArrayList<Rect>();
			while(n>0){
				n--;
				// start point??
				int a=in.nextInt();
				int b=in.nextInt();
				int c=in.nextInt();
				int x=0,y,z=0;
				if(a>b){
					x=a;
					y=b;
				}else {
					x=b;
					y=a;
				}
				if(x>c){
					if(c>y){
						z=y;
						y=c;
					}else z=c;
				}else {
					z=y;
					y=x;
					x=c;
				}
				Rect rect1=new Rect();
				rect1.x=x;
				rect1.y=y;
				rect1.z=z;
				
				
				Rect rect2=new Rect();
				rect2.x=y;
				rect2.y=z;
				rect2.z=x;
				
				
				Rect rect3=new Rect();
				rect3.x=x;
				rect3.y=z;
				rect3.z=y;
				
				list.add(rect1);
				list.add(rect2);
				list.add(rect3);
				
			}
			Collections.sort(list,new Comparator<Rect>(){
				public int compare(Rect a,Rect b){
					if(a.x<b.x)
					return 1;
					if(a.x==b.x){
						if(a.y<b.y)return 1;
						else
							if(a.y>b.y)return -1;
							else if(a.z<b.z)return 1;
							else return -1;
					}
					return -1;
					
				}
			});
			
			
			System.out.println(list.get(0).x);
			//  how to choose 
			// dp[i]=max (dp[j]+height[i]|);
			int dp[]=new int[list.size()+5];
			int loc[]=new int [list.size()+5];
			for(int i=0;i<list.size();i++){
				Rect t=list.get(i);
				int ans=0;
				dp[i]=t.z;
				for(int j=0;j<i;j++){
					Rect tj=list.get(j);
					if(t.x<tj.x&&t.y<tj.y){
						ans=Math.max(ans, dp[j]);
					}	
				}
				dp[i]=ans+dp[i];
			}
			
			System.out.println(dp[list.size()-1]);
			
			
		

			// 

			// Collections.sort(list,new Comparator<User>(){ public int compare(User arg0, User arg1){ return   compareTo }});






		}


	}

}
