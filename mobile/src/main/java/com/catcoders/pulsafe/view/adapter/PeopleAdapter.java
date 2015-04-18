package com.catcoders.pulsafe.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.catcoders.pulsafe.R;
import com.catcoders.pulsafe.helper.CircleTransform;
import com.catcoders.pulsafe.helper.ResourceHelper;
import com.catcoders.pulsafe.model.entity.Log;
import com.catcoders.pulsafe.view.listener.RecyclerViewClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;


public class PeopleAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context mContext;
    private List<Log> mLogList;
    private RecyclerViewClickListener mRecyclerClickListener;
    private static final Integer LIMIT_RATE = 90;

    public PeopleAdapter(List<Log> mLogList) {
        this.mLogList = mLogList;
    }

    public List<Log> getLogList() {
        return this.mLogList;
    }

    public void setRecyclerListListener(RecyclerViewClickListener mRecyclerClickListener) {
        this.mRecyclerClickListener = mRecyclerClickListener;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View rowView = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.adapter_item_person_log, viewGroup, false);

        this.mContext = viewGroup.getContext();

        return new UserViewHolder(rowView, this.mRecyclerClickListener);
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, final int position) {

        Log selectedLog = mLogList.get(position);

        holder.mNameTextView.setText(selectedLog.getUser());

        int photo = ResourceHelper.getDrawableInt("user_" + selectedLog.getUser());

        Picasso.with(mContext)
                .load(photo != 0 ? photo : R.drawable.user_default)
                .transform(new CircleTransform())
                .into(holder.mPersonImageView);

        holder.mLogValueTextView
                .setText(selectedLog.getValue());

        setColor(holder, new Integer(selectedLog.getValue()).compareTo(LIMIT_RATE) > 0 ?
                R.color.primary_dark :
                android.R.color.holo_green_dark);
    }

    @Override
    public int getItemCount() {

        return mLogList.size();
    }

    public void addPerson(Log user) {

        Log log = searchPerson(user);
        if(log==null) {
            mLogList.add(log);
        }
        notifyDataSetChanged();
    }

    private Log searchPerson(Log user) {
        for(Log l: mLogList) {
            if(l.getUser() == user.getUser()) {
                return l;
            }
        }
        return null;
    }

    public void setColor(final UserViewHolder holder, int color) {
        holder.mLogUnitTextView.setTextColor(mContext.getResources().getColor(color));
        holder.mLogValueTextView.setTextColor(mContext.getResources().getColor(color));
    }
}

class UserViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener{

    private final RecyclerViewClickListener onClickListener;

    ImageView mPersonImageView;
    TextView mNameTextView;
    TextView mLogValueTextView;
    TextView mLogUnitTextView;

    public UserViewHolder(View itemView, RecyclerViewClickListener onClickListener) {

        super(itemView);

        mNameTextView = (TextView) itemView.findViewById(R.id.name_person);
        mPersonImageView = (ImageView) itemView.findViewById(R.id.photo_person);
        mLogValueTextView = (TextView) itemView.findViewById(R.id.log_value);
        mLogUnitTextView = (TextView) itemView.findViewById(R.id.log_unit);

        this.onClickListener = onClickListener;

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP && event.getAction() != MotionEvent.ACTION_MOVE) {
            onClickListener.onClick(v, getPosition(), event.getX(), event.getY());
        }
        return true;
    }
}



