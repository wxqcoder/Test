package com.test;

public class GetMax {
	
	/**
	 * 
	 * @param a(Ŀ������)
	 * @param position�������С��
	 * @param b��Ŀ�����֣�
	 * @param temp����ʱ���һ��������Сֵ������
	 * @return
	 */
	
	public static int max(int[] a,int position,int b,int temp){
		//������Ƚϵ����һ��ֵ��ʱ������ݹ�
		if(position==0){
			if(a[0]<=b){
				return a[0]-temp>0?a[0]:temp;
			}else{
				return temp;
			} 
			
		}else{	
			//�����ǰֵ��Ŀ��ֵС�ұ���ʱֵ��ı���ʱֵ������Ƚ���һ��
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
