package app;

import java.util.*;

public class Graph implements SortedIF{


	private HashMap<String, LinkedList<String>> tt = new HashMap<>();
	private HashMap<Integer, LinkedList<String>> list = new HashMap<>();

	Graph(String[][] array) {
		generation(array);
	}

	private void generation(String[][] array) {

		List<String> temp = new ArrayList<String>();
		for (String[] it : array) {
			for (String tmp : it) {
				if (!temp.contains(tmp)) {
					temp.add(tmp);
					tt.put(tmp, new LinkedList<String>());
				}
			}
			if (it.length == 2)
				tt.get(it[it.length - 1]).add(it[0]);
		}

		int index = 0;
		LinkedList<String> tmp = new LinkedList<String>();
		while (!tt.isEmpty()) {
			tmp = new LinkedList<String>();
			list.put(index++, tmp);
			for (Map.Entry<String, LinkedList<String>> it : tt.entrySet()) {
				if (it.getValue().size() == 0) {

					tmp.add(it.getKey());
				}
			}
			for (Map.Entry<String, LinkedList<String>> it : tt.entrySet()) {

				for (int i = 0; i < it.getValue().size(); i++) {

					if (tmp.contains(it.getValue().get(i))) {

						tt.get(it.getKey()).remove(it.getValue().get(i));

						i = -1;
					}
				}
			}
			for (int i = 0; i < tmp.size(); i++) {
				tt.remove(tmp.get(i));
			}

		}

	}

	private int compare(String a, String b) {
		int ia = -1, ib = -1;
		int index = 0;
		for (Map.Entry<Integer, LinkedList<String>> it : list.entrySet()) {

			if (it.getValue().contains(a)) {
				ia = index;
			}
			if (it.getValue().contains(b)) {
				ib = index;
			}
			index++;
		}
		if (ia == -1 | ib == -1) {
			return 0;
		}
		if (ia == ib) {
			return 0;
		} else if (ia < ib) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public boolean isWellSorted(String[] arr) {
		List<String> x = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			x.add(arr[i]);
		}

		String temp = "";
		while (!x.isEmpty()) {
			temp = x.remove(x.size() - 1);
			for (int i = 0; i < x.size(); i++) {
				if (compare(temp, x.get(i)) < 0) {
					return false;
				}
			}
		}
		return true;
	}


}