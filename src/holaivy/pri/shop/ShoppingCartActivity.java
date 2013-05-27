package holaivy.pri.shop;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class ShoppingCartActivity extends ShopBaseActivity {

	private ListView listView;

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
		
	}

	private void initList() {
		
	}

	private void initView() {
		listView = (ListView) findViewById(R.id.listView1);
	}

	private void initEvent() {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.shopping_cart, menu);
		return true;
	}

}
