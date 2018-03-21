package printershare.dynamixsoftware.com.unittesttools;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    TextView lanTextView;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    private static String KEY_EXTRA_MESSAGE = "KEY_EXTRA_MESSAGE";

    public static String[] subjects = {"ANDROID", "PHP", "BLOGGER", "WORDPRESS", "JOOMLA", "ASP.NET", "JAVA",
            "C++", "MATHS", "HINDI", "ENGLISH", "BANGLA", "BIOLOGY", "C#", "JSP", "MIMO", "ANJAN",
            "SUDIPTA", "AZIM", "AZIZ", "MONIR", "TARIQ", "ARIF"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_main);

        lanTextView = findViewById(R.id.selected_language);

        context = getApplicationContext();

        Intent intent = getIntent();
        String message = intent.getStringExtra(KEY_EXTRA_MESSAGE);

        List<String> languages = new ArrayList<>();

        for (String language : subjects) {
            languages.add(language);
        }

        lanTextView.setText(message);

        languages.add(20, message);

        relativeLayout = findViewById(R.id.relativelayout1);
        recyclerView = findViewById(R.id.recyclerview);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(context, languages, this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    static protected Intent newStartIntent(Context context, String message) {
        Intent newIntent = new Intent(context, MainActivity.class);
        newIntent.putExtra(KEY_EXTRA_MESSAGE, message);
        return newIntent;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.subject_textview:
                String language = view.getTag().toString();
                Toast.makeText(this, "" + language, Toast.LENGTH_SHORT).show();
                lanTextView.setText(language);
                break;
        }
    }
}