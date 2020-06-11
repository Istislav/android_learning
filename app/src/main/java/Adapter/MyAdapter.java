package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import Model.ListItem;
import ru.istislav.quotes.MainActivity;
import ru.istislav.quotes.R;
import ru.istislav.quotes.SecondActivity;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<ListItem> listItems;

    public MyAdapter(Context context, List listitem) {
        this.context = context;
        this.listItems = listitem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        ListItem item = listItems.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
       return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.list_item_title);
            description = (TextView) itemView.findViewById(R.id.list_item_description);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ListItem item = listItems.get(position);

            Toast.makeText(context, item.getName(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, SecondActivity.class);
            intent.putExtra("messageData1", item.getDescription());
            context.startActivity(intent);

        }
    }
}
