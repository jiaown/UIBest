package com.jiaown.adapter;

import java.util.List;

import com.jiaown.uibest.Msg;
import com.jiaown.uibest.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg> {

	private int resourceId;
	
	public MsgAdapter(Context context, int textViewResourceId,
			List<Msg> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		
		Msg msg = getItem(position);
		View view;
		ViewHolder viewHolder;
		if(convertView == null){
			view = LayoutInflater.from(getContext()).inflate(resourceId, null); 
			viewHolder = new ViewHolder();
			
			viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
			
		}else{
			view = convertView;  //convertView将加载好的进行缓存
			viewHolder = (ViewHolder) view.getTag();  //重新获取viewHolder
		}
		
		return view;
		
	} 
	
	class ViewHolder {
		
		LinearLayout leftLayout;
		
		LinearLayout rightLayout;
		
		TextView leftMsg;
		
		TextView rightMsg;
	}

}
