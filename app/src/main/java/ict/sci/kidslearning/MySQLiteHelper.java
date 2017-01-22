
package ict.sci.kidslearning;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MySQLiteHelper extends SQLiteOpenHelper {

	public static final String TABLE_COMMENTS = "comments";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_SCHOOL = "school";

	public static final String COLUMN_student = "student";
	public static final String COLUMN_CLASS = "class";
	public static final String COLUMN_ROLL = "roll";

	private static final String DATABASE_NAME = "commments.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_COMMENTS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_SCHOOL
			+ " text not null, " + COLUMN_student
			+ " text not null, " + COLUMN_CLASS
			+ " text not null, " + COLUMN_ROLL
			+ " text not null);";

	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_COMMENTS);
		onCreate(db);
	}
}
