package com.example.oliviamurphy.MakeMePretty;

/**
 * Created by oliviamurphy on 4/17/16.
 */
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_NAME = "makeMePretty";

    private static final String TABLE_QUEST = "quiz";

    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWERA = "answerA";
    private static final String KEY_ANSWERB = "answerB";
    private static final String KEY_ANSWERC = "answerC";
    private static final String KEY_ANSWERD = "answerD";
    private static final String KEY_OPTA= "optA";
    private static final String KEY_OPTB= "optB";
    private static final String KEY_OPTC= "optC";
    private static final String KEY_OPTD= "optD";
    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        db=sqLiteDatabase;

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWERA + " TEXT, " + KEY_ANSWERB + " TEXT, " + KEY_ANSWERC + " TEXT, " +
                KEY_ANSWERD + " TEXT, " + KEY_OPTA +" TEXT, " + KEY_OPTB +" TEXT, "+ KEY_OPTC+" TEXT, " + KEY_OPTD + "TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("What is your hair color?","", "", "", "", "Brown", "Black", "Blonde", "Red");
        this.addQuestion(q1);
        Question q2=new Question("How long is your hair?", "", "", "", "", "Chin length (or shorter)", "Shoulder length", "Mid-back length", "Waist length (or longer");
        this.addQuestion(q2);
        Question q3=new Question("What is your eye color?","", "","", "", "Brown", "Blue", "Hazel", "Green");
        this.addQuestion(q3);
        Question q4=new Question("What is your eye shape?", "", "", "","", "Almond", "Wide-set","Close-set","Mono-lid");
        this.addQuestion(q4);
        Question q5=new Question("What is your skin tone?","","","","", "Fair", "Medium","Tan","Dark");
        this.addQuestion(q5);
        Question q6=new Question("What is your skin undertone?","", "","", "", "Cool tone", "Warm tone", "Neutral tone", "");
        this.addQuestion(q6);
        Question q7=new Question("What is your skin type?", "", "", "","", "Oily", "Dry", "Combination", "Normal");
        this.addQuestion(q7);
        Question q8=new Question("What is your face shape?","","","","","Oval", "Heart","Square","Round");
        this.addQuestion(q8);
        Question q9=new Question("What is your height?","", "","", "", "Shorter than 5'0", "5'0 - 5'4", "5'5 - 5'9", "5'10 or taller");
        this.addQuestion(q9);
        Question q10=new Question("What is your body type?", "", "", "","", "Pear", "Round","Hour glass", "Straight");
        this.addQuestion(q10);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);

        onCreate(db);
    }

    public void addQuestion(Question quest) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWERA, quest.getANSWERA());
        values.put(KEY_ANSWERB, quest.getANSWERB());
        values.put(KEY_ANSWERC, quest.getANSWERC());
        values.put(KEY_ANSWERD, quest.getANSWERD());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());

        db.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<Question>();

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setID(cursor.getInt(0));
                question.setQUESTION(cursor.getString(1));
                question.setANSWERA(cursor.getString(2));
                question.setANSWERB(cursor.getString(3));
                question.setANSWERC(cursor.getString(4));
                question.setANSWERD(cursor.getString(4));
                question.setOPTA(cursor.getString(6));
                question.setOPTB(cursor.getString(7));
                question.setOPTC(cursor.getString(8));
                question.setOPTD(cursor.getString(9));
                questionList.add(question);
            } while (cursor.moveToNext());
        }

        return questionList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}