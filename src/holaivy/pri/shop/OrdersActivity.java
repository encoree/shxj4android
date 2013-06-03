package holaivy.pri.shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OrdersActivity extends Activity {

	private Button buttonCommit;
	private EditText editTextTel;
	private EditText editTextRegion;
	private EditText editTextName;
	private EditText editTextAddr;

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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.orders, menu);
		return true;
	}

}
