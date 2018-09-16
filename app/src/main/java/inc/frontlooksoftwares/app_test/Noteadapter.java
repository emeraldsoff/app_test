package inc.frontlooksoftwares.app_test;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class Noteadapter extends FirestoreRecyclerAdapter<Note,Noteadapter.NoteHolder> {

    public Noteadapter(@NonNull FirestoreRecyclerOptions<Note> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull Note model) {
        holder.title1.setText(model.getClient_name());
        holder.Description1.setText(model.getId());
        holder.id1.setText(model.getPhno());
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cid_card,parent,false);
        return new NoteHolder(v);
    }

    class NoteHolder extends RecyclerView.ViewHolder{

        TextView title1;
        TextView Description1;
        TextView id1;

        public NoteHolder(View itemView) {
            super(itemView);

            title1=itemView.findViewById(R.id.title);
            Description1=itemView.findViewById(R.id.desc);
            id1=itemView.findViewById(R.id.id);

        }
    }
}
