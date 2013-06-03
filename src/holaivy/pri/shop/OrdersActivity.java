package holaivy.pri.shop;

import holaivy.pri.act.pcd.RegionData;
import holaivy.pri.act.pcd.RegionSelActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OrdersActivity extends Activity {

	public static final int SEL_REGION = 1;

	private Button buttonCommit;
	private EditText editTextTel;
	private EditText editTextRegion;
	private EditText editTextName;
	private EditText editTextAddr;
	private RegionData rData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_orders);
		initView();
		initEvent();
		initInfo();
	}

	private void initView() {
		editTextTel = (EditText) findViewById(R.id.editTextTel);
		buttonCommit = (Button) findViewById(R.id.button1);
		editTextAddr = (EditText) findViewById(R.id.editTextAddr);
		editTextName = (EditText) findViewById(R.id.editTextName);
		editTextRegion = (EditText) findViewById(R.id.editTextRegion);
	}

	private void initInfo() {
		TelephonyManager tm = (TelephonyManager) this
				.getSystemService(Context.TELEPHONY_SERVICE);
		String tel = tm.getLine1Number();
		editTextTel.setText(tel);

	}

	private void initEvent() {
		buttonCommit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		editTextRegion.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editRegion();
			}
		});
	}

	private void editRegion() {
		Intent intent = new Intent();
		intent.setClass(this, RegionSelActivity.class);
		intent.putExtra(RegionSelActivity.INIT_REGION, rData);
		startActivityForResult(intent, SEL_REGION);
	}

	protected void fillRegionData(RegionData d) {
		this.rData = d;
		if (rData.fine()) {
			editTextRegion.setText(rData.warp2String());
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == SEL_REGION) {
			if (resultCode == Activity.RESULT_OK) {
				Object obj = data
						.getSerializableExtra(RegionSelActivity.RESULT_REGION);
				if (obj instanceof RegionData) {
					fillRegionData((RegionData) obj);
				}
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.orders, menu);
		return true;
	}

}
