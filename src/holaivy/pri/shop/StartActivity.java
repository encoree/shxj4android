package holaivy.pri.shop;

import holaivy.pri.shop.data.ShopItemBuilder;
import holaivy.pri.shop.data.ShopItemData;
import ivy.android.view.adapter.DefaultListAdapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class StartActivity extends Activity {

	private ListView listView;
	private ShopAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		initView();
		initData();
		initList();
	}

	private void initList() {
		adapter = new ShopAdapter(getLayoutInflater(), R.layout.shop_list_item,
				this, ShopItemBuilder.builder());
		listView.setAdapter(adapter);
	}

	private void initData() {

	}

	private void initView() {
		listView = (ListView) findViewById(R.id.listView1);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

	public class ShopAdapter extends DefaultListAdapter<ShopItemData> {

		public ShopAdapter(LayoutInflater inf, int layoutid,
				Context viewContext, List<ShopItemData> list) {
			super(inf, layoutid, viewContext, list);

		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			view = super.getView(position, view, parent);
			ShopItemData data = list.get(position);
			if (view != null) {
				TextView tvLabel = (TextView) view
						.findViewById(R.id.textViewLabel);
				TextView tvPrice = (TextView) view
						.findViewById(R.id.textViewPrice);
				TextView tvComments = (TextView) view
						.findViewById(R.id.textViewComments);
				tvLabel.setText(data.getL());
				tvPrice.setText(data.getP());
				tvComments.setText(data.getC());

			}
			return view;
		}

	}

}
