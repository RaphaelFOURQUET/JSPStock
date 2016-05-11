/**
 * 
 */
package fr.adaming.panier;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author INTI-0332
 *
 */
public class PanierID {
	
	private final Map<Integer, Integer> productIdQuantities = new HashMap<>();

	public Map<Integer, Integer> getProductIdQuantities() {
		return Collections.unmodifiableMap( productIdQuantities );
	}

	public void addProduit(int i) {
		if(productIdQuantities.containsKey(i)) {
			productIdQuantities.put(i, productIdQuantities.get(i)+1);
		} else {
			productIdQuantities.put(i, 1);
		}
	}

	public void deleteProduit(int i) {
		Integer qtite = productIdQuantities.get(i);
		if(qtite == null)
			return;
		if(qtite <= 1) {
			//remove
			productIdQuantities.remove(i);
		} else {
			//-1
			productIdQuantities.put(i, qtite - 1);
		}
		
	}

}
