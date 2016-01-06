package com.mining;

import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class Point{
	private int centerid;
	
	
	public int getCenterid() {
		return centerid;
	}
	public void setCenterid(int centerid) {
		this.centerid = centerid;
	}
	double x[];
	public double[] getDimension(){
		return x;
	}
}


// 选择K个点为初始质点
// repeat 
// 		将每个点指派到最近的质心，形成K个簇
// 		重新计算每个簇的质心
// until 簇不发生变化或达到最大迭代次数



public class Kmeans {
	int k;
	double mu;
	double[][] center;
	int repeat;
	double[] crita;
	
	public Kmeans(int k,double mu,int repeat, int len){
		this.k=k;
		this.mu=mu;
		this.repeat=repeat;
		 center = new double[k][];
	        for (int i = 0; i < k; i++)
	            center[i] = new double[len];
	        crita = new double[repeat];
	}
	
	public double getDistance(double vector[],double center[],int len){
		
		double sum=0;
		for(int i=0;i<len;i++){
			sum+=(vector[i]-center[i])*(vector[i]-center[i]);
			
		}
		return Math.sqrt(sum);
	}
	
	public void classify(ArrayList<Point> objects){
		Iterator<Point> iter=objects.iterator();
		while(iter.hasNext()){
			Point t=iter.next();
			double [] vector=t.getDimension();
			int len=vector.length;
			int index=0;
			double neardist=Double.MAX_VALUE;
			for(int i=0;i<k;i++){
				double dist=this.getDistance(vector, center[i], len);
				if(dist<neardist){
					neardist=dist;
					index=i;
				}
			}
			t.setCenterid(index);
		}
		
	}
	
	public boolean calNewCenter(ArrayList<Point> objects,int len){
		boolean end = true;
        int[] count = new int[k]; // 记录每个簇有多少个元素
        double[][] sum = new double[k][];
        for (int i = 0; i < k; i++)
            sum[i] = new double[len];
        Iterator<Point> iter = objects.iterator();
        while (iter.hasNext()) {
            Point object = iter.next();
            int id = object.getCenterid();
            count[id]++;
            for (int i = 0; i < len; i++)
                sum[id][i] += object.getDimension()[i];
        }
        for (int i = 0; i < k; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < len; j++) {
                    sum[i][j] /= count[i];
                }
            }
            // 簇中不包含任何点,及时调整质心
            else {
                int a=(i+1)%k;
                int b=(i+3)%k;
                int c=(i+5)%k;
                for (int j = 0; j < len; j++) {
                    center[i][j] = (center[a][j]+center[b][j]+center[c][j])/3;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            // 只要有一个质心需要移动的距离超过了mu，就返回false
            // if (Global.calEuraDist(sum[i], center[i], len) >= mu) { //使用欧氏距离
            if (this.getDistance(sum[i], center[i], len) >= mu) { // 使用编辑距离
                end = false;
                break;
            }
        }
        if (!end) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < len; j++)
                    center[i][j] = sum[i][j];
            }
        }
        return end;
	}
//	
//	public double getSati(ArrayList<Point> objects, int len) {
//        double satisfy = 0.0;
//        int[] count = new int[k];
//        double[] ss = new double[k];
//        Iterator<Point> iter = objects.iterator();
//        while (iter.hasNext()) {
//        	Point object = iter.next();
//            int id = object.getCid();
//            count[id]++;
//            for (int i = 0; i < len; i++)
//                ss[id] += Math.pow(object.getVector()[i] - center[id][i], 2.0);
//        }
//        for (int i = 0; i < k; i++) {
//            satisfy += count[i] * ss[i];
//        }
//        return satisfy;
//    }
// 
//    public double run(int round, Point datasource, int len) {
//        System.out.println("第" + round + "次运行");
//        initCenter(len,datasource.objects);
//        classify(datasource.objects);
//        while (!calNewCenter(datasource.objects, len)) {
//            classify(datasource.objects);
//        }
//        datasource.printResult(datasource.objects, k);
//        double ss = getSati(datasource.objects, len);
//        System.out.println("加权方差：" + ss);
//        return ss;
//    }
    
	public static void main(String args[]){
		double center[][]={{25,125},{44,105},{29,97},{35,63},{55,63},{42,57},{23,40},{64,37},{33,22},{55,20}};
		Kmeans t=new Kmeans(10,0,1,2);
		t.center=center;
		ArrayList<Point> objects=new ArrayList<Point>();
		Point temp=new Point ();
		double sy[]={25,125};
		temp.x=sy;
		objects.add(temp);
		
		Point temp2=new Point ();
		double sy2[]={44,105};
		temp2.x=sy2;
		objects.add(temp2);
		
		Point temp3=new Point ();
		double sy3[]={29,97};
		temp3.x=sy3;
		objects.add(temp3);
		
		Point temp4=new Point ();
		double sy4[]={35,63};
		temp4.x=sy4;
		objects.add(temp4);
		
		t.classify(objects);
		t.calNewCenter(objects, 2);
	}
	

}
