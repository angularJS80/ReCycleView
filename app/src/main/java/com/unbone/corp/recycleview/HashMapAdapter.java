package com.unbone.corp.recycleview;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yongbeom on 2018. 7. 16..
 */

class HashMapAdapter  extends BaseAdapter{
    private ArrayList<HashMap> mListItems;
    private LayoutInflater mLayoutInflater;
    //private Gson gson = new Gson();



    public HashMapAdapter(Context context, ArrayList<HashMap> arrayList){
        mListItems = arrayList;
        //get the layout inflater
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //getCount() represents how many items are in the list
        return mListItems.size();
    }
    @Override
    //get the data of an item from a specific position
    //i represents the position of the item in the list
    public Object getItem(int i) {

        return mListItems.get(i);
    }
    @Override
    //get the position id of the item from the list
    public long getItemId(int i) {
        return 0;
    }




    /*어뎁터 기본 상속 메소드 중 getView 는 화면에 행단위로 호출 된다.*/
    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        TextView textView; // 표현될 text 형태로 선언

        HashMapAdapter.ViewHolder holder = null; // 뷰홀더는 일단 통과 이단 뷰홀더는 모델(행의 하나당 클래스)  과 같다.
        if (itemView == null) { // 아이템 뷰는 행에 표현될 뷰객체로 최초 정의된것이 없음 정의 하여 사용 한다
            holder = new HashMapAdapter.ViewHolder();
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            holder.nameText = (TextView) itemView.findViewById(R.id.name_text); // 뷰홀더 모델에 메핑
            holder.tableText = (TextView) itemView.findViewById(R.id.table_text); // 뷰홀더 모델에 메핑
            
            itemView.setTag(holder); // 모델 자체를 행에 넣어 버린다 ? 

            textView = itemView.findViewById(R.id.name_text);
        } else {
            holder = (HashMapAdapter.ViewHolder) itemView.getTag(); // 홀더를 빼서 쓴다 ?
            textView = itemView.findViewById(R.id.name_text);
        }


        HashMap map=mListItems.get(position); // 실데이터는 어래이 리스트에 있으며, 인덱스로 뽑아 사용한다


        textView.setText(map.get("name").toString()); // 해당 멥에서 표현될 데이터의 키로 데이터를 뽑아 사용 한다


        holder.nameText.setText(map.get("name").toString()); // 홀더 내용만 바꿔준다.
        holder.tableText.setText(map.get("tableNo").toString()); // 홀더 내용만 바꿔준다.

        return  itemView;

    }

    static class ViewHolder {
        TextView nameText;
        TextView tableText;

    }

    @Override
    public void notifyDataSetChanged(){
        super.notifyDataSetChanged();
    }


}