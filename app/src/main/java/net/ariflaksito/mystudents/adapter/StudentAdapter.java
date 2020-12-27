package net.ariflaksito.mystudents.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.ariflaksito.mystudents.R;
import net.ariflaksito.mystudents.db.DbHelper;
import net.ariflaksito.mystudents.model.Student;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private ArrayList<Student> listStudents = new ArrayList<>();
    private Activity activity;
    private DbHelper dbHelper;

    public StudentAdapter(Activity activity) {
        this.activity = activity;
        dbHelper = new DbHelper(activity);
    }

    public ArrayList<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<Student> listNotes) {
        if (listNotes.size() > 0) {
            this.listStudents.clear();
        }
        this.listStudents.addAll(listNotes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.tvNim.setText(listStudents.get(position).getNim());
        holder.tvName.setText(listStudents.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return listStudents.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        final TextView tvNim, tvName;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.tv_item_nim);
            tvName = itemView.findViewById(R.id.tv_item_name);

        }
    }
}
