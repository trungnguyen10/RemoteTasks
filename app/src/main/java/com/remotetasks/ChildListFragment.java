package com.remotetasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.animation.ChildrenAlphaProperty;

import java.util.List;

public class ChildListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ChildAdapter mChildAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_list, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_child_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        Parent parent = DemoParent.getInstance().getParent();
        List<Child> children = parent.getChildren();
        mChildAdapter = new ChildAdapter(children);
        mRecyclerView.setAdapter(mChildAdapter);

    }

    private class ChildViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Child mChild;
        private TextView mChildName;
        private TextView mNumberOfTask;

        public ChildViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_child, parent, false));

            itemView.setOnClickListener(this);

            mChildName = (TextView) itemView.findViewById(R.id.child_name);
            mNumberOfTask = (TextView) itemView.findViewById(R.id.number_of_task);
        }

        public void bind(Child child) {
            mChild = child;
            mChildName.setText(mChild.getName());
            mNumberOfTask.setText("Number of Tasks: " + String.valueOf(mChild.countTask()));
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "test click!", Toast.LENGTH_SHORT).show();
        }
    }

    private class ChildAdapter extends RecyclerView.Adapter<ChildViewHolder> {
        private List<Child> mChildren;

        public ChildAdapter(List<Child> children) {
            mChildren = children;
        }

        @NonNull
        @Override
        public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ChildViewHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
            Child child = mChildren.get(position);
            holder.bind(child);
        }

        @Override
        public int getItemCount() {
            return mChildren.size();
        }
    }
}
