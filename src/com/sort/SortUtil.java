package com.sort;

import java.util.ArrayList;
import java.util.List;

public class SortUtil {

	/**
	 * √∞≈›≈≈–Ú
	 */

	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	/**
	 * ≤Â»Î≈≈–Ú
	 * 
	 * @param args
	 * 
	 */

	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] > a[i]) {
				int temp = a[i];
				int j = i;
				while (j > 0 && a[j - 1] > temp) {
					a[j] = a[j - 1];
					j--;
				}
				a[j] = temp;
			}

		}

	}
	
	/**
	 * ºÚµ•—°‘Ò≈≈–Ú
	 * @param args
	 */
	public static void selectSort(int[] a){
		for(int i=0;i<a.length;i++){
			int min = a[i];
			int position = i;
			for(int j=i;j<a.length;j++){
				if(a[j]<min){
					min = a[j];
					position = j;
				}
			}
			int temp = a[i];
			a[i] = min;
			a[position] = temp;
		}
		
	}
	
	/**
	 * øÏÀŸ≈≈–Ú
	 * @param args
	 */
	public static void quickSort(int[] a){
		int pivotkey = a[0];
		int i = 1;
		int j = a.length-1;
		while(i!=j){
			while(a[i]<=pivotkey && i<j){
				i++;
			}
			while(a[j]>=pivotkey && i<j){
				j--;
			}
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		a[0] = a[i];
		a[i] = pivotkey;
	}
	
	
	

	public static void main(String[] args) {
		int[] a = { 6, 1,  2, 7,  9,  3,  4,  5, 10,  8 };
		// bubbleSort(a);
		//insertSort(a);
		//selectSort(a);
		quickSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		
		List<String> list = new ArrayList<String>();

	}

}
