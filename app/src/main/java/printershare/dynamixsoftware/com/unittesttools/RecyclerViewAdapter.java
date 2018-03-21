package printershare.dynamixsoftware.com.unittesttools;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by JUNED on 6/10/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<String> subjects;
    Context context;
    View view1;
    ViewHolder viewHolder1;
    View.OnClickListener onClickListener;

    public RecyclerViewAdapter(Context context1, List<String> subjects, View.OnClickListener onClickListener) {

        this.subjects = subjects;
        this.onClickListener = onClickListener;
        context = context1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(View v) {

            super(v);

            textView = v.findViewById(R.id.subject_textview);
            textView.setOnClickListener(onClickListener);
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view1 = LayoutInflater.from(context).inflate(R.layout.recyclerview_items, parent, false);

        viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(subjects.get(position));
        holder.textView.setTag(subjects.get(position));
    }

    @Override
    public int getItemCount() {

        return subjects.size();
    }
}