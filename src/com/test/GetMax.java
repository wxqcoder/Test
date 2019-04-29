package com.test;

public class GetMax {
	
	/**
	 * 
	 * @param a(目标数组)
	 * @param position（数组大小）
	 * @param b（目标数字）
	 * @param temp（临时存放一个代表最小值的数）
	 * @return
	 */
	
	public static int max(int[] a,int position,int b,int temp){
		//当数组比较到最后一个值的时候结束递归
		if(position==0){
			if(a[0]<=b){
				return a[0]-temp>0?a[0]:temp;
			}else{
				return temp;
			} 
			
		}else{	
			//如果当前值比目标值小且比临时值大改变临时值，否则比较下一个
			if(a[position]<b){
				if(a[position]>temp){
					temp = a[position];
				}			
			} else if(a[position]==b){
				return b;
			}	
			position--; 
			return max(a,position,b,temp);
			
		}
	}
	
	public static void main(String[] args) {
		int a[] = {4,8,12,7,5,6,9,-3,-8};//
		int position = a.length-1;
		int compareValue = -2;
		int temp = -1000;
		int result = max(a,position,compareValue,temp);
		System.out.println(result);
		
	}
	
	
}
