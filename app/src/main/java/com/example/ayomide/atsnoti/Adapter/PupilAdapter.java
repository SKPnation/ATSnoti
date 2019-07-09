package com.example.ayomide.atsnoti.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ayomide.atsnoti.Interface.ItemClickListener;
import com.example.ayomide.atsnoti.Model.PupilData;
import com.example.ayomide.atsnoti.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PupilAdapter extends RecyclerView.Adapter<PupilAdapter.ViewHolder> {

    Context context;
    List<PupilData> pupilDataList;

    public PupilAdapter(Context context, List<PupilData> pupilDataList) {
        this.context = context;
        this.pupilDataList = pupilDataList;
    }

    @NonNull
    @Override
    public PupilAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from( context ).inflate( R.layout.pupil_item, viewGroup,false );
        return new ViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull PupilAdapter.ViewHolder viewHolder, int i) {
        Picasso.with( context ).load( pupilDataList.get( i ).getImage() ).into( viewHolder.profile_image );
        viewHolder.tvPupilName.setText( pupilDataList.get( i ).getName() );
        viewHolder.tvPupilGrade.setText( pupilDataList.get( i ).getGrade() );

        viewHolder.profile_image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //...
            }
        } );
    }

    @Override
    public int getItemCount() {
        return (pupilDataList != null ? pupilDataList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profile_image;
        TextView tvPupilName, tvPupilGrade;
        Button btnDelete, btnDetails;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            tvPupilName = itemView.findViewById(R.id.pupil_name);
            tvPupilGrade = itemView.findViewById(R.id.pupil_grade);
            profile_image = itemView.findViewById( R.id.pupil_image );

        }
    }

}
