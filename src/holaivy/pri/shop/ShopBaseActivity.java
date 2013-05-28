package holaivy.pri.shop;

import java.util.ArrayList;
import java.util.List;

import holaivy.pri.shop.constant.ShopConstant;
import holaivy.pri.shop.data.ShopCartData;
import holaivy.pri.shop.data.ShopOrderData;
import ivy.android.acitivy.core.NetWorkActivity;
import ivy.basic.ViException;
import ivy.core.tool.Str;
import ivy.json.Json;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

/**
 * @author xubch@neusoft.com
 * 
 */
public class ShopBaseActivity extends NetWorkActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		fetchSotreData();
	}

	protected ShopCartData cartData;

	protected void fetchSotreData() {
		SharedPreferences spf = getSharedPreferences(
				ShopConstant.ShopCartSharedPreferences, MODE_PRIVATE);
		String value = spf.getString(ShopConstant.ShopCart, "");
		if (Str.isNotEmpty(value)) {
			try {
				cartData = Json.decode(value, ShopCartData.class);
				return;
			} catch (ViException e) {
			}
		}
		if (cartData == null) {
			cartData = new ShopCartData();
		}
	}

	protected void putSotreData() {
		SharedPreferences spf = getSharedPreferences(
				ShopConstant.ShopCartSharedPreferences, MODE_PRIVATE);
		Editor editor = spf.edit();
		editor.clear();
		try {
			editor.putString(ShopConstant.ShopCart, Json.encode(cartData));
		} catch (ViException e) {
		}
		editor.commit();
	}

	protected void putStoreData(ShopOrderData data) {
		if (data != null && Str.isNotEmpty(data.getSid())) {
			cartData.getMap().put(data.getSid(), data);
			putSotreData();
		}
	}

	protected List<ShopOrderData> fetchOrderAsList() {
		List<ShopOrderData> list = new ArrayList<ShopOrderData>(cartData
				.getMap().values());
		return list;
	}
}
