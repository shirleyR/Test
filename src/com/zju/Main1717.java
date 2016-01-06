package com.zju;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


class point{
	int x,y;
	int value;
	public point(int x,int y, int value){
		this.x=x;
		this.y=y;
		this.value=value;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	

}

//   Queue
//   ---offer  add element
//	 ---poll  return the first in the queue and delete
// 	 --- peek/element   return the first


public class Main1717 {
	public static void main(String args[]){
		int n,m;
		char map[][];
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			n=in.nextInt();
			m=in.nextInt();
			if(n==0&&m==0)return ;
			map=new char[m][n];
			String temp="";
			for(int i=0;i<m;i++){
				temp=in.next();
				for(int j=0;j<temp.length();j++)
					map[i][j]=temp.charAt(j);
			}
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(map[i][j]>='0'&&map[i][j]<='9'){
						Queue<point> q=new LinkedList<point>();
						int va=map[i][j]-'0';
						point t=new point(i,j,va);
						q.offer(t);
						while(!q.isEmpty()){
							point qt=q.poll();
							int x=qt.getX();
							int y=qt.getY();
							int z=qt.getValue();
							// right 
							if(x+1<m&&map[x+1][y]>='0'&&map[x+1][y]<='9'){
								point te=new point(x+1,y,z+map[x+1][y]-'0');
								q.offer(te);
							}
						   // down
							if(y+1<n&&map[x][y+1]>='0'&&map[x][y+1]<='9'){
								point te=new point(x,y=1,z+map[x][y+1]-'0');
								q.offer(te);
							}
						}
					}
				}
			}


		}

	}
}
