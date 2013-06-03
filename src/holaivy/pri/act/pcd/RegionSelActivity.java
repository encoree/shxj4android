package holaivy.pri.act.pcd;

import holaivy.pri.shop.R;
import ivy.core.tool.Str;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class RegionSelActivity extends Activity {

	public static final String CHARSET = "gbk";
	public static final String INIT_REGION = "init.region";
	public static final String RESULT_REGION = "return.region";

	/** Called when the activity is first created. */
	private DBManager dbm;
	private SQLiteDatabase db;
	private Spinner spinnerP = null;
	private Spinner spinnerC = null;
	private Spinner spinnerD = null;
	private String province = null;
	private String city = null;
	private String district = null;
	private RegionData data = new RegionData();
	private View buttonOK;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pcd);
		initView();
		initInfo();
		initData();
		initEvent();
	}

	private void initEvent() {
		buttonOK.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				returnData();
			}
		});
		spinnerD.setOnItemSelectedListener(new SpinnerOnSelectedListener3());
		spinnerP.setOnItemSelectedListener(new SpinnerOnSelectedListener1());
		spinnerC.setOnItemSelectedListener(new SpinnerOnSelectedListener2());
	}

	private boolean buildRegtionData() {
		if (data == null) {
			data = new RegionData();
		}
		return data.fine();
	}

	private void returnData() {
		if (buildRegtionData()) {
			Intent intent = new Intent();
			intent.putExtra(RESULT_REGION, data);
			setResult(RESULT_OK, intent);
			finish();
		} else {
			Toast.makeText(this, "请完成所有选择.", Toast.LENGTH_SHORT).show();
		}
	}

	private void initData() {
		initSpinner3(initSpinner2(initSpinner1()));
	}

	private void initInfo() {
		Object obj = getIntent().getSerializableExtra(INIT_REGION);
		if (obj instanceof RegionData) {
			data = (RegionData) obj;
		}
	}

	private void initView() {
		spinnerP = (Spinner) findViewById(R.id.spinner1);
		spinnerC = (Spinner) findViewById(R.id.spinner2);
		spinnerD = (Spinner) findViewById(R.id.spinner3);
		spinnerP.setPrompt("省份");
		spinnerC.setPrompt("城市");
		spinnerD.setPrompt("地区");
		buttonOK = findViewById(R.id.buttonOK);
	}

	public String initSpinner1() {
		dbm = new DBManager(this);
		dbm.openDatabase();
		db = dbm.getDatabase();
		List<AddrListItem> list = new ArrayList<AddrListItem>();
		int selIndex = -1;
		int valIndex = 0;
		boolean find = data != null && Str.isNotEmpty(data.getPcode());
		String initCode = data.getPcode();
		try {
			String sql = "select * from province";
			Cursor cursor = db.rawQuery(sql, null);
			cursor.moveToFirst();
			while (!cursor.isLast()) {
				String code = cursor.getString(cursor.getColumnIndex("code"));
				byte bytes[] = cursor.getBlob(2);
				String name = new String(bytes, CHARSET);
				AddrListItem myListItem = new AddrListItem();
				myListItem.setName(name);
				myListItem.setPcode(code);
				list.add(myListItem);
				cursor.moveToNext();
				if (find) {
					if (initCode.equals(code)) {
						selIndex = valIndex;
					}
					valIndex++;
				}
			}
			String code = cursor.getString(cursor.getColumnIndex("code"));
			byte bytes[] = cursor.getBlob(2);
			String name = new String(bytes, CHARSET);
			AddrListItem myListItem = new AddrListItem();
			myListItem.setName(name);
			myListItem.setPcode(code);
			list.add(myListItem);

		} catch (Exception e) {
		} finally {
			if (db != null) {
				db.close();
			}
			if (dbm != null)
				dbm.closeDatabase();

		}
		AddrListAdapter listAdapter = new AddrListAdapter(this, list);
		spinnerP.setAdapter(listAdapter);
		if (find && selIndex >= 0) {
			spinnerP.setSelection(selIndex);
			return initCode;
		}
		return ((AddrListItem) spinnerP.getSelectedItem()).getPcode();
	}

	public String initSpinner2(String pcode) {
		dbm = new DBManager(this);
		dbm.openDatabase();
		db = dbm.getDatabase();
		List<AddrListItem> list = new ArrayList<AddrListItem>();
		int selIndex = -1;
		int valIndex = 0;
		boolean find = data != null && Str.isNotEmpty(data.getCcode());
		String initCode = data.getCcode();
		try {
			String sql = "select * from city where pcode='" + pcode + "'";
			Cursor cursor = db.rawQuery(sql, null);
			cursor.moveToFirst();
			while (!cursor.isLast()) {
				String code = cursor.getString(cursor.getColumnIndex("code"));
				byte bytes[] = cursor.getBlob(2);
				String name = new String(bytes, CHARSET);
				AddrListItem myListItem = new AddrListItem();
				myListItem.setName(name);
				myListItem.setPcode(code);
				list.add(myListItem);
				cursor.moveToNext();
				if (find) {
					if (initCode.equals(code)) {
						selIndex = valIndex;
					}
					valIndex++;
				}
			}
			String code = cursor.getString(cursor.getColumnIndex("code"));
			byte bytes[] = cursor.getBlob(2);
			String name = new String(bytes, CHARSET);
			AddrListItem myListItem = new AddrListItem();
			myListItem.setName(name);
			myListItem.setPcode(code);
			list.add(myListItem);

		} catch (Exception e) {
		} finally {
			if (db != null) {
				db.close();
			}
			if (dbm != null)
				dbm.closeDatabase();

		}

		AddrListAdapter myAdapter = new AddrListAdapter(this, list);
		spinnerC.setAdapter(myAdapter);
		if (find && selIndex >= 0) {
			spinnerC.setSelection(selIndex);
			return initCode;
		}
		return ((AddrListItem) spinnerC.getSelectedItem()).getPcode();
	}

	public String initSpinner3(String pcode) {
		dbm = new DBManager(this);
		dbm.openDatabase();
		db = dbm.getDatabase();
		List<AddrListItem> list = new ArrayList<AddrListItem>();
		int selIndex = -1;
		int valIndex = 0;
		boolean find = data != null && Str.isNotEmpty(data.getAcode());
		String initCode = data.getAcode();
		try {
			String sql = "select * from district where pcode='" + pcode + "'";
			Cursor cursor = db.rawQuery(sql, null);
			cursor.moveToFirst();
			while (!cursor.isLast()) {
				String code = cursor.getString(cursor.getColumnIndex("code"));
				byte bytes[] = cursor.getBlob(2);
				String name = new String(bytes, CHARSET);
				AddrListItem myListItem = new AddrListItem();
				myListItem.setName(name);
				myListItem.setPcode(code);
				list.add(myListItem);
				cursor.moveToNext();
				if (find) {
					if (initCode.equals(code)) {
						selIndex = valIndex;
					}
					valIndex++;
				}
			}
			String code = cursor.getString(cursor.getColumnIndex("code"));
			byte bytes[] = cursor.getBlob(2);
			String name = new String(bytes, CHARSET);
			AddrListItem myListItem = new AddrListItem();
			myListItem.setName(name);
			myListItem.setPcode(code);
			list.add(myListItem);

		} catch (Exception e) {
		} finally {
			if (db != null) {
				db.close();
			}
			if (dbm != null)
				dbm.closeDatabase();

		}

		AddrListAdapter myAdapter = new AddrListAdapter(this, list);
		spinnerD.setAdapter(myAdapter);
		if (find && selIndex >= 0) {
			spinnerD.setSelection(selIndex);
			return initCode;
		}

		Object obj = spinnerD.getSelectedItem();
		if (obj instanceof AddrListItem) {
			return ((AddrListItem) obj).getPcode();
		}
		return "";
	}

	class SpinnerOnSelectedListener1 implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> adapterView, View view,
				int position, long id) {
			province = ((AddrListItem) adapterView.getItemAtPosition(position))
					.getName();
			String pcode = ((AddrListItem) adapterView
					.getItemAtPosition(position)).getPcode();
			data.putProvince(pcode, province);
			initSpinner2(pcode);
			initSpinner3(pcode);
		}

		public void onNothingSelected(AdapterView<?> adapterView) {
		}
	}

	class SpinnerOnSelectedListener2 implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> adapterView, View view,
				int position, long id) {
			city = ((AddrListItem) adapterView.getItemAtPosition(position))
					.getName();
			String pcode = ((AddrListItem) adapterView
					.getItemAtPosition(position)).getPcode();
			data.putCity(pcode, city);
			initSpinner3(pcode);
		}

		public void onNothingSelected(AdapterView<?> adapterView) {
		}
	}

	class SpinnerOnSelectedListener3 implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> adapterView, View view,
				int position, long id) {
			district = ((AddrListItem) adapterView.getItemAtPosition(position))
					.getName();
			String code = ((AddrListItem) adapterView
					.getItemAtPosition(position)).getPcode();
			data.putAddr(code, district);
		}

		public void onNothingSelected(AdapterView<?> adapterView) {
		}
	}
}