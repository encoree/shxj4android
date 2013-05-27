package holaivy.pri.shop;

import holaivy.pri.shop.constant.ShopConstant;
import holaivy.pri.shop.data.ShopItemData;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class DetailActivity extends ShopBaseActivity {
	private ShopItemData iData;
	private TextView textViewLabel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		Object obj = getIntent().getSerializableExtra(ShopConstant.ShopItem);
		if (obj instanceof ShopItemData) {
			iData = (ShopItemData) obj;
			initView();
			initEvent();
			initData();
		}
	}

	private void initEvent() {

	}

	private void initView() {
		textViewLabel = (TextView) findViewById(R.id.textViewLabel);
	}

	private void initData() {
		new Thread() {

			@Override
			public void run() {
				super.run();
				textViewLabel.setText(iData.getL());
			}

		}.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id, Bundle args) {
		
		
		
		return super.onCreateDialog(id, args);
		
	}

}
