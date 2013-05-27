package holaivy.pri.shop.data;

import holaivy.pri.shop.R;

import java.util.ArrayList;
import java.util.List;

public class ShopItemBuilder {

	public static List<ShopItemData> builder() {
		List<ShopItemData> list = new ArrayList<ShopItemData>();
		ShopItemData d1 = new ShopItemData();
		d1.setL("椒盐味新疆巴旦木");
		d1.setP("25元/500g");
		d1.setC("手剥即开 营养丰富");
		d1.setI(R.drawable.example1);
		list.add(d1);
		d1 = new ShopItemData();
		d1.setL("原味新疆巴旦木");
		d1.setP("25元/500g");
		d1.setC("手剥即开 营养丰富");
		d1.setI(R.drawable.example1);
		list.add(d1);
		d1 = new ShopItemData();
		d1.setL("红香妃新疆葡萄干");
		d1.setP("75元/500g");
		d1.setC("粒大无核，香甜可口");
		d1.setI(R.drawable.example1);
		list.add(d1);
		d1 = new ShopItemData();
		d1.setL("新疆鲍鱼果");
		d1.setP("55元/500g");
		d1.setC("清香浓郁，松脆香酥");
		d1.setI(R.drawable.example1);
		list.add(d1);
		return list;
	}
}
