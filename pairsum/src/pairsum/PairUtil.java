package pairsum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairUtil {

	public static void pairPrinter(List<Pair> pairs) {

		if (pairs.size() == 0) {
			return;
		}

		System.out.println("Sum = " + (pairs.get(0).getOne().getData() + pairs.get(0).getTwo().getData()));
		
		if(pairs.size() == 1) {
			System.out.print("Pair is ");
		}else {
			System.out.print("Pairs are ");
		}

		for (Pair pair : pairs) {
			System.out.print("(" + pair.getOne().getData() + "," + pair.getTwo().getData() + ") ");
			
			if(pairs.size() == 1 || pairs.get(pairs.size()-1) == pair  ) {
				break;
			}
			
			System.out.print(", ");
		}

	}
	
	public static List<Pair> removeDublicatePairs(List<Pair> pairs) {
				
		List<Pair> pairsFiltered = new ArrayList<>();
		Collections.reverse(pairs);
		pairs.forEach(x -> {
			if (!pairsFiltered.contains(x)) {
				pairsFiltered.add(x);
			}
		});
		
		return pairsFiltered;
	}

	
}
