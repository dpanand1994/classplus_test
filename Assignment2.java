package com.org.classplus.assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javafx.util.Pair;

public class Assignment2 {
	Scanner s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Pair<Integer,Integer>> map = new HashMap();
		map.put(0, new Pair<Integer,Integer>(1,2));
		map.put(1, new Pair<Integer,Integer>(2,3));
		map.put(2, new Pair<Integer,Integer>(2,4));
		map.put(3, new Pair<Integer,Integer>(4,5));
		
		ArrayList<Integer> h = new ArrayList<Integer>();
		h.add(2);
		h.add(5);
		
		System.out.println(getEpicentres(map, h, 2));

	}
	
	public static int getEpicentres(HashMap<Integer,Pair<Integer,Integer>> map, ArrayList<Integer> h, int x) {
		int u=-1;
		int v=-1;
		int ctr=0;
		List<Integer> epicentreList = new ArrayList<Integer>();
		
		for(int i=0;i<map.size();i++) {
			Pair<Integer,Integer> p = map.get(i);
			int key=p.getKey();
			int val=p.getValue();
			System.out.println("key="+key);
			System.out.println("val="+val+"\n");
			if(i==0) {
				u=key;
				v=val;
			}			
			if(h.contains(key) || h.contains(val)) {
				if(key==v || val==u) {
					ctr++;
					if(h.contains(u) && h.contains(val)) {
						ctr++;
					}
				}/*else {
					ctr--;
				}*/
				
				if(ctr==x) {
					epicentreList.add(key);
				}
			}
			
			u=key;
			v=val;
		}
		
		return h.size()+epicentreList.size();
	}

}
