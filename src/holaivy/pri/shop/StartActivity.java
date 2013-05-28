package holaivy.pri.shop;

import holaivy.pri.shop.constant.ShopConstant;
import holaivy.pri.shop.data.ShopItemBuilder;
import holaivy.pri.shop.data.ShopItemData;
import ivy.android.view.adapter.DefaultListAdapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class StartActivity extends ShopBaseActivity {

	private ListView listView;
	private ShopAdapter adapter;
	private Button button1;
	private Button button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		initView();
		initData();
		initList();
		initEvent();
	}

	private void initEvent() {
		button1.setOnClickListener(onClickView);
		button2.setOnClickListener(onClickView);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long arg3) {
				Intent intent = new Intent();
				intent.setClass(StartActivity.this, DetailActivity.class);
				intent.putExtra(ShopConstant.ShopItem,
						adapter.getList().get(position));
				startActivity(intent);
			}
		});
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
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
	}

	private View.OnClickListener onClickView = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == button1) {
				// 查看 购物车
				Intent intent = new Intent();
				intent.setClass(StartActivity.this, ShoppingCartActivity.class);
				startActivity(intent);
			} else if (v == button2) {
				// 管理我的基本信息

			}
		}
	};

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
				TextView tvPriceUnit = (TextView) view
						.findViewById(R.id.textViewPriceUnit);
				tvPriceUnit.setText(data.getPunit());
				tvLabel.setText(data.getL());
				tvPrice.setText(data.getP());
				tvComments.setText(data.getC());
				TextView tvYou = (TextView) view.findViewById(R.id.textViewYou);
				if (data.isY()) {
					tvYou.setText(StartActivity.this
							.getString(R.string.text_you));
				} else
					tvYou.setText("");
			}
			return view;
		}

	}

}
