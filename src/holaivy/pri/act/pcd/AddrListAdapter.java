package holaivy.pri.act.pcd;

import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddrListAdapter extends BaseAdapter {

	private Context context;
	private List<AddrListItem> myList;

	public AddrListAdapter(Context context, List<AddrListItem> myList) {
		this.context = context;
		this.myList = myList;
	}

	public int getCount() {
		return myList.size();
	}

	public Object getItem(int position) {
		return myList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		AddrListItem myListItem = myList.get(position);
		return new AddrListAdapterView(this.context, myListItem);
	}

	class AddrListAdapterView extends LinearLayout {
		public static final String LOG_TAG = "AdapterView";

		public AddrListAdapterView(Context context, AddrListItem listitem) {
			super(context);
			this.setOrientation(HORIZONTAL);

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					200, LayoutParams.WRAP_CONTENT);
			params.setMargins(10, 1, 1, 1);

			TextView name = new TextView(context);
			
			name.setText(listitem.getName());
			addView(name, params);

			LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
					200, LayoutParams.WRAP_CONTENT);
			params2.setMargins(1, 1, 1, 1);

			TextView pcode = new TextView(context);
			pcode.setText(listitem.getPcode());
			addView(pcode, params2);
			pcode.setVisibility(GONE);

		}

	}

}