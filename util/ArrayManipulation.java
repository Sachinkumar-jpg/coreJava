package util;

import java.util.ArrayList;
import java.util.List;

public class ArrayManipulation {
	public static void reverseArray(int[] x) {
		for(int i=0;i<x.length/2;i++) {
			int temp=x[i];
			x[i]=x[x.length-1-i];
			x[x.length-1-i]=temp;
			}
	}
	public static List<String> listRevers(List<String> dataList) {
		List<String> temp = new ArrayList<>();
		for(int i=dataList.size()-1;i>=0;i--) {
			temp.add(dataList.get(i));
			}
		return temp;
	}
}
