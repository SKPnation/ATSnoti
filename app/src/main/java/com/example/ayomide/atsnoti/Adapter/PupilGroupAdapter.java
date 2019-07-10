package com.example.ayomide.atsnoti.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ayomide.atsnoti.Model.PupilData;
import com.example.ayomide.atsnoti.Model.PupilGroup;
import com.example.ayomide.atsnoti.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.List;

public class PupilGroupAdapter extends RecyclerView.Adapter<PupilGroupAdapter.ViewHolder> {

    EditText etName, etAge, etGrade, etHomeAddress, etPhone, etGuardianName, etGuradianEmail, etOfficeAddress;
    Button btnSelect, btnUpload;

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

            //Add new pupil button
            btnAdd.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showNewPupilDialog();
                }
            } );
        }

        private void showNewPupilDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder( context );
            builder.setTitle("Add New Pupil");
            builder.setMessage("Fill in all information");
            builder.setIcon(R.drawable.ic_person_add_black_24dp);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            final View view = inflater.inflate( R.layout.add_new_pupil_layout, null );

            etName = view.findViewById(R.id.etName);
            etAge = view.findViewById(R.id.etAge);
            etGrade = view.findViewById(R.id.etGrade);
            etHomeAddress = view.findViewById(R.id.etHomeAddress);
            etPhone = view.findViewById(R.id.etPhone);
            etGuardianName = view.findViewById(R.id.etGuardianName);
            etGuradianEmail = view.findViewById(R.id.etGuardianEmail);
            etOfficeAddress = view.findViewById(R.id.etOfficeAddress);

            btnSelect = view.findViewById(R.id.btnSelect);
            btnUpload = view.findViewById(R.id.btnUpload);

            builder.setView(view);

            builder.setPositiveButton( "YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //...
                }
            } );

            builder.setNegativeButton( "NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //...
                }
            } );

            builder.show();
        }
    }
}
