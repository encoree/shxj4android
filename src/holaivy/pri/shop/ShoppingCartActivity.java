package holaivy.pri.shop;

import holaivy.pri.shop.data.ShopOrderData;
import holaivy.pri.shop.data.ShoppingPackType;
import ivy.android.view.adapter.DefaultListAdapter;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ShoppingCartActivity extends ShopBaseActivity {

	private ListView listView;
	private ShopCartAdapter adapter = null;
	private SimpleDateFormat sdf;
	private Button buttonPay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_cart);
		initView();
		initData();
		initList();
		initEvent();
	}

	private void initData() {
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
	}

	private void initList() {
		adapter = new ShopCartAdapter(getLayoutInflater(),
				R.layout.shopcart_item, this, fetchOrderAsList());
		listView.setAdapter(adapter);
	}

	private void initView() {
		listView = (ListView) findViewById(R.id.listView1);
		buttonPay = (Button) findViewById(R.id.buttonPay);
	}

	private void initEvent() {
		buttonPay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), OrdersActivity.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.shopping_cart, menu);
		return true;
	}

	public class ShopCartAdapter extends DefaultListAdapter<ShopOrderData> {

		public ShopCartAdapter(LayoutInflater inf, int layoutid,
				Context viewContext, List<ShopOrderData> list) {
			super(inf, layoutid, viewContext, list);
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			view = super.getView(position, view, parent);
			if (view != null) {
				ShopOrderData od = list.get(position);
				if (od != null) {
					TextView tvLabel = (TextView) view
							.findViewById(R.id.textViewLabel);
					tvLabel.setText(od.getSl());
					TextView tvPrice = (TextView) view
							.findViewById(R.id.textViewPrice);
					tvPrice.setText(od.getSp());
					TextView tvTime = (TextView) view
							.findViewById(R.id.textViewTime);
					tvTime.setText(sdf.format(od.getTi()));
					TextView tvNum = (TextView) view
							.findViewById(R.id.textViewNum);
					tvNum.setText(String.valueOf(od.getNum()));
					int tot = od.getNum() * Integer.valueOf(od.getSp());
					TextView tvPay = (TextView) view
							.findViewById(R.id.textViewPay);
					tvPay.setText(String.valueOf(tot));
					TextView tvPack = (TextView) view
							.findViewById(R.id.textViewPack);
					tvPack.setText(od.getType() == ShoppingPackType.Jin ? getString(R.string.text_jin_pack)
							: getString(R.string.text_kg_pack));
				}
			}
			return view;
		}

	}

}
