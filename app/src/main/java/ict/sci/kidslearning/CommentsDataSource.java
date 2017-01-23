
package ict.sci.kidslearning;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class CommentsDataSource  {
	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_SCHOOL,MySQLiteHelper.COLUMN_student,MySQLiteHelper.COLUMN_CLASS,
			""+MySQLiteHelper.COLUMN_SCORE, MySQLiteHelper.COLUMN_ROLL };

	public CommentsDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Comment createComment(String school,String student,String clas,int score,String roll) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_SCHOOL, school);
		values.put(MySQLiteHelper.COLUMN_student, student);
		values.put(MySQLiteHelper.COLUMN_CLASS, clas);
		values.put(MySQLiteHelper.COLUMN_ROLL, score);
		values.put(MySQLiteHelper.COLUMN_ROLL, roll);

		long insertId = database.insert(MySQLiteHelper.TABLE_COMMENTS, null,
				values);
		// To show how to query
		Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
				allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		return cursorToComment(cursor);
	}


	public void updateOrderItems(String orderId, String score) {
		Cursor cursor = database.rawQuery("SELECT COUNT(1) FROM comments WHERE _id = "
				+ orderId , null);
		cursor.moveToFirst();
		String count = cursor.getString(0);
		Log.d("...//update...."+score+"..", "..."+count);
		if (Integer.valueOf(count) > 0) {
			Log.d("...//update....", "..."+count);
			ContentValues values = new ContentValues();
			values.put(MySQLiteHelper.COLUMN_SCORE, score);

			database.update(MySQLiteHelper.TABLE_COMMENTS, values, MySQLiteHelper.COLUMN_ID + " = " + orderId, null);
		} else {
			ContentValues values = new ContentValues();
			values.put(MySQLiteHelper.COLUMN_SCORE, score);

			long insertId = database.insert(MySQLiteHelper.TABLE_COMMENTS, null,
					values);
			Log.d("...//....", "..."+values);

			database.update(MySQLiteHelper.TABLE_COMMENTS, values, MySQLiteHelper.COLUMN_ID + " = " + orderId, null);
			// To show how to query
			cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
					allColumns, MySQLiteHelper.COLUMN_ID + " = " + orderId, null,
					null, null, null);
			cursor.moveToFirst();
			//database.insert(MySQLiteHelper.TABLE_COMMENTS, null, values);
		}

	}

	public void deleteComment(Comment comment) {
		long id = comment.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(MySQLiteHelper.TABLE_COMMENTS, MySQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Comment> getAllComments() {
		List<Comment> comments = new ArrayList<Comment>();
		Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
				allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Comment comment = cursorToComment(cursor);
			comments.add(comment);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return comments;
	}

	private Comment cursorToComment(Cursor cursor) {
		Comment comment = new Comment();
		comment.setId(cursor.getLong(0));
		comment.setSchool(cursor.getString(1));
		comment.setStudent(cursor.getString(2));
		comment.setClas(cursor.getString(3));
		comment.setScore(cursor.getInt(4));
		comment.setRoll(cursor.getString(5));
		return comment;
	}
}
