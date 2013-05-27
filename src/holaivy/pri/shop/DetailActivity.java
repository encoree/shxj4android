package holaivy.pri.shop;

import holaivy.pri.shop.constant.ShopConstant;
import holaivy.pri.shop.data.ShopItemData;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends ShopBaseActivity {

	public static final int BUY_DIALOG = 1;
	private ShopItemData iData;
	private TextView textViewLabel;
	private Button buyButton;

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
		buyButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(BUY_DIALOG);
			}
		});
	}

	private void initView() {
		textViewLabel = (TextView) findViewById(R.id.textViewLabel);
		buyButton = (Button) findViewById(R.id.buttonBuy);
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
		switch (id) {
		case BUY_DIALOG:
			LayoutInflater inflater = getLayoutInflater();
			View view = inflater.inflate(R.layout.view_buy_dialog, null);
			AlertDialog dialog = new AlertDialog.Builder(this)
					.setView(view)
					.setTitle(getString(R.string.text_buy_info))
					.setPositiveButton(getString(R.string.text_ok),
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {

								}
							}).show();
			return dialog;

		default:
			break;
		}
		return super.onCreateDialog(id, args);

	}

}
