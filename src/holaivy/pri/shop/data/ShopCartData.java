package holaivy.pri.shop.data;

import java.util.HashMap;
import java.util.Map;

public class ShopCartData {

	private int tot;

	private Map<String, ShopOrderData> map = new HashMap<String, ShopOrderData>();

	public Map<String, ShopOrderData> getMap() {
		return map;
	}

	public void setMap(Map<String, ShopOrderData> map) {
		this.map = map;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

}
