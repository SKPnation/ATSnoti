package com.example.ayomide.atsnoti.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ayomide.atsnoti.Model.PupilData;
import com.example.ayomide.atsnoti.Model.PupilGroup;
import com.example.ayomide.atsnoti.R;

import java.util.List;

public class PupilGroupAdapter extends RecyclerView.Adapter<PupilGroupAdapter.ViewHolder> {

    Context context;
    List<PupilGroup> dataList;

    public PupilGroupAdapter(Context context, List<PupilGroup> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from( context ).inflate( R.layout.layout_group, viewGroup,false );
        return new ViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.groupTitle.setText( dataList.get( i ).getHeaderTitle() );
        List<PupilData> pupilData = dataList.get( i ).getListPupil();

        PupilAdapter pupilListAdapter = new PupilAdapter( context, pupilData );
        viewHolder.recyclerView_item_list.setHasFixedSize( true );
        viewHolder.recyclerView_item_list.setLayoutManager( new LinearLayoutManager( context, LinearLayoutManager.HORIZONTAL, false ) );
        viewHolder.recyclerView_item_list.setAdapter( pupilListAdapter );

        viewHolder.recyclerView_item_list.setNestedScrollingEnabled( false ); //Important

        //Add new pupil button
        viewHolder.btnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //...
            }
        } );
    }

    @Override
    public int getItemCount() {
        return (dataList != null ? dataList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView groupTitle;
        public Button btnAdd;
        public RecyclerView recyclerView_item_list;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            groupTitle = itemView.findViewById( R.id.groupTitle );
            btnAdd = itemView.findViewById( R.id.btn_add );
            recyclerView_item_list = itemView.findViewById( R.id.recycler_view_list );
        }
    }
}
