package com.jiaown.uibest;

import java.util.ArrayList;
import java.util.List;

import com.jiaown.adapter.MsgAdapter;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.os.Build;

public class MainActivity extends Activity {
	
	private ListView msgListView;
	
	private EditText inputText;
	
	private Button send;
	
	private MsgAdapter adapter;
	
	private List<Msg> myList = new ArrayList<Msg>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initMsgs();
        adapter = new MsgAdapter(this, R.layout.msg_item, myList);
        msgListView = (ListView) findViewById(R.id.msg_list_view);
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String content = inputText.getText().toString();
				if(!"".equals(content)){
					Msg msg = new Msg(content,Msg.TYPE_SENT);
					myList.add(msg);
					adapter.notifyDataSetChanged();  //当有新消息，刷新myList
					msgListView.setSelection(myList.size()); //将ListView定位到最后一行
					inputText.setText("");
				}
				
			}
		});
        
    }

	private void initMsgs() {
		Msg msg1 = new Msg("hello guy",Msg.TYPE_RECEIVED);
		myList.add(msg1);
		Msg msg2 = new Msg("hello ,who is that",Msg.TYPE_SENT);
		myList.add(msg2);
		Msg msg3 = new Msg("this is tom ,nice to meet you",Msg.TYPE_RECEIVED);
		myList.add(msg3);
	}
}
