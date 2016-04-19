package com.example.oliviamurphy.MakeMePretty;

/**
 * Created by oliviamurphy on 4/17/16.
 */
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 8;

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

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("pie", "Hello there young padawan");
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWERA + " TEXT, " + KEY_ANSWERB + " TEXT, " + KEY_ANSWERC + " TEXT, " +
                KEY_ANSWERD + " TEXT, " + KEY_OPTA +" TEXT, " + KEY_OPTB +" TEXT, "+ KEY_OPTC+" TEXT, " + KEY_OPTD + " TEXT)";
        db.execSQL(sql);
    }

    public void addQuestions()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int numRows = (int)DatabaseUtils.queryNumEntries(db, TABLE_QUEST);

        if (numRows == 0) {
            Question q1 = new Question("What is your hair color?", "Brown", "Black", "Blonde", "Red",
                    "Bold colors will look good on you! Try wearing bright colors such as hot pink or red. Earth tones such as olive or golds will complement you well.",
                    "Bold vivid primary colors will look great on you! Avoid soft mauves or pale colors.",
                    "Neutrals will look great on you! Try wearing white, black or grey. Also reds and pastels will complement you well.",
                    "Greens, purples, and blues will look best on you!");
            this.addQuestion(q1);
            Question q2 = new Question("How long is your hair?", "Chin length (or shorter)", "Shoulder length", "Mid-back length", "Waist length (or longer)",
                    "Drapey, open clothes work best with really short hair.  Shoulderless shirts work best but having open back shirts work well too!",
                    "People with shoulder length hair should wear strapless and shoulderless shirts. If you’re going to wear things with shoulders make them well defined and don’t have sleeves with them. Open backs will be your best friend.",
                    "Pull your hair up into a high ponytail and throw on some jeans and a plain top! You have the ability to wear your hair in a multitude of ways (braids, messy bun, curl)",
                    "Try curling your hair to have loose waves. This will give you the natural beach look that you are going for!");
            this.addQuestion(q2);
            Question q3 = new Question("What is your eye color?", "Brown", "Blue", "Hazel", "Green",
                    "Use a mix of rich purples and lilacs to make your eyes pop!",
                    "Try using golden brown eyeshadows, or a light subtle green. Try to avoid neon colors!",
                    "Gold eye shadow can bring out that pop of gold in your eyes! You can make this work for day or evening!",
                    "Neutrals will make your eyes pop! Also try wearing a mix of purples.");
            this.addQuestion(q3);
            Question q4 = new Question("What is your eye shape?", "Almond", "Wide-set", "Close-set", "Mono-lid",
                    "About every eye shadow style will look good on you, you’re lucky! Bronze and smokey eyes will complement your eyes.",
                    "Open your eyes up by applying  white/nude/light brown eyeliner to your waterline.",
                    "Concentrate light colors on the inside part of the eyelid and darker colors on the outside.",
                    "You have a natural cat-eye shape. Try a layered trio of eyeshadows with a simple black eyeliner.");
            this.addQuestion(q4);
            Question q5 = new Question("What is your skin tone?", "Fair", "Medium", "Tan", "Dark",
                    "Light skinned ladies can wear makeup shades that range from barely there to bright and bold! When shopping for the perfect nude, look for shades that have a slight pink or peach tone so that you don’t look washed out.",
                    "Medium skinned ladies should go for a rosy blush. Lavender and gray eyeshadows will really stand out by flattering your warm undertones.",
                    "Choose a blush that is a darker pink or even brown. This will bring out your entire face and really make your skin stand out in just the right way! For eyeshadow, go for the deeper browns, blues, and even some greens.",
                    "Try going for deeper brown reds for blushes. You should be able to wear almost any eyeshadow, but try several different colors out until you find what best complements you!");
            this.addQuestion(q5);
            Question q6 = new Question("What is your skin undertone?", "Cool tone", "Warm tone", "Neutral tone", "",
                    "Since you have a cool undertone, you will look best in greens, blues, purples!",
                    "Since you have a warm undertone, you will look best in reds, golds, and yellows!",
                    "You can pull of almost any color! Most neutral skin tones can wear just about any color!", "");
            this.addQuestion(q6);
            Question q7 = new Question("What is your skin type?", "Oily", "Dry", "Acne-Prone", "Normal",
                    "Try wearing a medium to full coverage foundation to reduce any shine!",
                    "Try wearing a light coverage, hydrating foundation to relieve your dry skin throughout the day. ",
                    "Try wearing a medium to full coverage foundation to cover any blemishes! ",
                    "You’re lucky to have normal skin! The level of coverage will be up to your personal preference.");
            this.addQuestion(q7);
            Question q8 = new Question("What is your face shape?", "Oval", "Heart", "Square", "Round",
                    "You are referred to as the the ideal face type because of balanced proportions. You can wear about any haircut, lucky you!",
                    "Try a soft curly or wavy style that frames the face. Pixie cuts and shoulder length hair with layers. Long bangs will also look great. Avoid styles that do not frame the face and styles that do not frame your face.",
                    "Long hairstyles that soften and frame the edge of the face will look great on you. Also look for a hairstyle that adds height to the crown. Avoid short haircuts - it makes the face look squarer in shape.",
                    "Having a round face can make a person look younger than they are! Try a hairstyle that adds more length to the face and is face framing. Bangs and layers will slim the face. Avoid short bobs, or blunt straight haircuts.");
            this.addQuestion(q8);
            Question q9 = new Question("What is your height?", "Shorter than 5'0", "5'0 - 5'4", "5'5 - 5'9", "5'10 or taller",
                    "Try to avoid tunic tops, oversized layering, and shirt dresses. Pointy heels will accentuate your legs. Opt for a smaller sized bag.",
                    "You want to stick to clothes with few color variations. Try wearing a simple shift dress with little color accents. Oversized accessories may overwhelm you, so opt for simple jewelry to keep the focus on you!",
                    "You are the average height, so you won’t have trouble finding clothes that fit and complement you well.",
                    "Maxi dresses are your friend. Skinny jeans will be your BFF, they will show off those gems! Bright patterns will take attention from the bottom half.");
            this.addQuestion(q9);
            Question q10 = new Question("What is your body type?", "Pear", "Round", "Hour glass", "Straight",
                    "For tops: Think layers. Balance your upper half to your lower. A Cardigan is your best friend, as are cropped jackets. For bottoms: Boot cut is best. The slight flare helps balance out your body. Go for dark or medium rise jeans with simple stitching. For skirts, try classic A-line cuts. Avoid high waisted and pleated skirts. Colors: Go for bright colors and embellished tops. Horizontal strips are helpful. Dark colors are better suited for your bottoms.",
                    "For tops: Your goal is to add structure especially on the top. Structured jackets like blazers are helpful. Wrap dresses or asymmetrical hemlines help draw angles and lines across your body. For bottoms: Show those legs off! Slim, straight leg or boot cuts are perfect for you. Wearing heels also helps show them legs off. Colors: Prints and patterns look great on you especially on the upper body. Go for large floral or geometric prints. Stick to weighty fabrics like cotton and wool.",
                    "For tops: Simplicity. Clean and simple tops with scoop necklines and three-quarter sleeves. Avoid layering. For bottoms: Skirts that stop at or below the knees.  Bootlegs pants and skinny jeans. Colors: keep it simple with solid colors.",
                    "For tops: Avoid square or straight lines. Go for asymmetrical or rounded hemlines and ruffle details. Halters and tank tops with thin straps look great on you. For bottoms: High waist pants and wide leg trousers add curves and volume to the lower body. Wrap dresses loops good because they draw angles and lines across the body. Color: Opt for lace, silk or lightweight fabrics. Anything that naturally drapes.");
            this.addQuestion(q10);
        }
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
        long ref = db.insert(TABLE_QUEST, null, values);
        db.close();
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db=this.getReadableDatabase();
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
}