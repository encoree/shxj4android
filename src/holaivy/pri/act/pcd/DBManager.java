package holaivy.pri.act.pcd;

import holaivy.pri.shop.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

public class DBManager {
	private final int BUFFER_SIZE = 1024;
	public static final String DB_NAME = "city_cn.s3db";
	private SQLiteDatabase database;
	private Context context;
	private File file = null;

	DBManager(Context context) {
		this.context = context;
	}

	public void openDatabase() {
		String databasePath = new StringBuilder().append("data")
				.append(Environment.getDataDirectory().getAbsolutePath())
				.append("/").append(context.getPackageName()).append("/")
				.append(DB_NAME).toString();
		this.database = this.openDatabase(databasePath);
	}

	public SQLiteDatabase getDatabase() {
		return this.database;
	}

	private SQLiteDatabase openDatabase(String dbfile) {
		try {
			file = new File(dbfile);
			if (!file.exists()) {
				InputStream is = context.getResources().openRawResource(
						R.raw.city);
				if (is != null) {
				} else {
				}
				FileOutputStream fos = new FileOutputStream(dbfile);
				if (is != null) {
				} else {
				}
				byte[] buffer = new byte[BUFFER_SIZE];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
					fos.flush();
				}
				fos.close();
				is.close();
			}
			database = SQLiteDatabase.openOrCreateDatabase(dbfile, null);
			return database;
		} catch (FileNotFoundException e) {
			Log.e("cc", "File not found");
		} catch (IOException e) {
			Log.e("cc", "IO exception");
		} catch (Exception e) {
			Log.e("cc", "exception " + e.toString());
		}
		return null;
	}

	public void closeDatabase() {
		if (this.database != null)
			this.database.close();
	}
}