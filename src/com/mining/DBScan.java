package com.mining;

import java.io.*;
import java.util.*;

class Points{
	int x;
	int y;
	boolean isKey;
	boolean isClassed;
	boolean isKey(){
		return isKey;
	}
	//* + * -9=4
	//+   -   - =4	
	//* -? * ?=4
	// / 
	// 

}
class DataObject{
	int cid;
	double point[];
	boolean Visited;
	public  double[] getVector(){
		return point;

	}
	public boolean isVisited(){
		return Visited;
	}
	public void setVisited(boolean isv){
		this.Visited=isv;
	}
	public void setCid(int cid){
		this.cid=cid;
	}
	public int getCid(){return cid;}
}

public class DBScan {
	public static double calEditDist(double arr1[],double arr2[],int n){
		double dist=0;
		for(int i=0;i<n;i++)
			dist+=(arr1[i]-arr2[i])*(arr1[i]-arr2[i]);
		return Math.sqrt(dist);
	}
	// 基于密度的聚类算法
	// E 领域
	// 密度可达
	// 密度相连
	// input  MinPts — 给定点在E领域内成为核心对象的最小领域点数
	// D  set
	// repeat 
	//	     1) 判断输入点是否为核心对象
	//	     2) 找出核心对象的E领域中的所有直接密度可达点
	//	 repeat
	//     针对所有核心对象的E领域所有直接密度可达点找到最大密度相连对象集合，
	//     中间涉及到一些密度可达对象的合并。
	//  Util 所有核心对象的E领域都遍历完毕
	double Eps=3;
	int MinPts=4;
	public Vector<DataObject> getNeighbors(DataObject p,ArrayList<DataObject> objects){
		Vector<DataObject> neighbors=new Vector<DataObject>();
		Iterator<DataObject> iter=objects.iterator();
		while(iter.hasNext()){
			DataObject q=iter.next();
			double [] arr1=p.getVector();
			double [] arr2=q.getVector();
			int len=arr1.length;
			if(DBScan.calEditDist(arr1,arr2,len)<=Eps){
				neighbors.add(q);
			}


		}
		return neighbors;
	}

	public void expandCluster(DataObject p,Vector<DataObject> neighbors, int clusterID,ArrayList<DataObject> objects){
		p.setCid(clusterID);
		Iterator<DataObject> iter= neighbors.iterator();
		while(iter.hasNext()){
			DataObject q=iter.next();
			if(!q.isVisited()){
				q.setVisited(true);
				Vector<DataObject> qneighbors=getNeighbors(q,objects);
				if(qneighbors.size()>=MinPts){
					Iterator<DataObject> it=qneighbors.iterator();
					while(it.hasNext()){
						DataObject no=it.next();
						if(no.getCid()<=0)
							no.setCid(clusterID);
					}
				}
			}
			if(q.getCid()<=0){       //q不是任何簇的成员
				q.setCid(clusterID);
			}
		}

	}
	public int dbscan(ArrayList<DataObject> objects){
		int clusterID=0;
		boolean AllVisited=false;
		while(!AllVisited){
			Iterator<DataObject> iter=objects.iterator();
			while(iter.hasNext()){
				DataObject p=iter.next();
				if(p.isVisited())continue;
				AllVisited=false;
				p.setVisited(true);
				Vector<DataObject> neighbors=getNeighbors(p,objects);
				if(neighbors.size()<MinPts){
					if(p.getCid()<=0)
						p.setCid(-1);       //cid初始为0,表示未分类；分类后设置为一个正数；设置为-1表示噪声。
				}else{
					if(p.getCid()<=0){
						clusterID++;
						expandCluster(p,neighbors,clusterID,objects);
					}else{
						int iid=p.getCid();
						expandCluster(p,neighbors,iid,objects);
					}
				}
				AllVisited=true;
			}
		}
		return clusterID;
	}

	public static void main(String args[]){
		DBScan t=new DBScan();
		ArrayList<DataObject> ob=new ArrayList<DataObject>();
		for(int i=0;i<100;i++)
		{
			DataObject s=new DataObject();
		
		}

	}



}
