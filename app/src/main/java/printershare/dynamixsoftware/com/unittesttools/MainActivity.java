package printershare.dynamixsoftware.com.unittesttools;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    public static String[] subjects = {"ANDROID", "PHP", "BLOGGER", "WORDPRESS", "JOOMLA", "ASP.NET", "JAVA",
            "C++", "MATHS", "HINDI", "ENGLISH", "BANGLA", "BIOLOGY", "C#", "JSP", "MIMO", "ANJAN",
            "SUDIPTA", "AZIM", "AZIZ", "MONIR", "TARIQ", "ARIF"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        relativeLayout = findViewById(R.id.relativelayout1);
        recyclerView = findViewById(R.id.recyclerview);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(context, subjects);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}