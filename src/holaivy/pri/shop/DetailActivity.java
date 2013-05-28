package holaivy.pri.shop;

import com.ly.global.InfoShip;

import holaivy.pri.shop.constant.ShopConstant;
import holaivy.pri.shop.data.ShopItemData;
import holaivy.pri.shop.data.ShopOrderData;
import holaivy.pri.shop.data.ShoppingPackType;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
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

	private void save(ShopOrderData data) {
		if (data != null) {
			data.setSid(iData.getId());
			data.setSl(iData.getL());
			data.setSp(iData.getP());
			data.setOid(InfoShip.uuidNoLine());
			putStoreData(data);
			Intent intent = new Intent();
			intent.setClass(this, ShoppingCartActivity.class);
			startActivity(intent);
		}
	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id, Bundle args) {
		switch (id) {
		case BUY_DIALOG:
			LayoutInflater inflater = getLayoutInflater();
			final View view = inflater.inflate(R.layout.view_buy_dialog, null);
			AlertDialog dialog = new AlertDialog.Builder(this)
					.setView(view)
					.setTitle(getString(R.string.text_buy_info))
					.setPositiveButton(getString(R.string.text_ok),
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									EditText et = (EditText) view
											.findViewById(R.id.editTextNum);
									int buynum = Integer.valueOf(et.getText()
											.toString());
									RadioGroup radioGroup = (RadioGroup) view
											.findViewById(R.id.radiogroupPack);
									ShopOrderData odata = new ShopOrderData();
									odata.setNum(buynum);
									odata.setType(radioGroup
											.getCheckedRadioButtonId() == R.id.radioButton1 ? ShoppingPackType.Jin
											: ShoppingPackType.KG);
									save(odata);

								}
							}).show();
			return dialog;

		default:
			break;
		}
		return super.onCreateDialog(id, args);

	}

}
