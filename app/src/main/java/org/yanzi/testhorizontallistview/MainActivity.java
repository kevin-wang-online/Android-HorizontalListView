package org.yanzi.testhorizontallistview;

import org.yanzi.ui.HorizontalListView;
import org.yanzi.ui.HorizontalListViewAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
	HorizontalListView hListView;
	HorizontalListViewAdapter hListViewAdapter;
	ImageView previewImg;
	View olderSelectView = null;

	//图片数组
	List<Integer> imageList;
	//图片名称集合
	List<String> imageTitleList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void initUI(){

		hListView = (HorizontalListView)findViewById(R.id.horizon_listview);

		previewImg = (ImageView)findViewById(R.id.image_preview);


		//初始化图片标题集合
		imageTitleList = new ArrayList<String>();

		imageTitleList.add("1");
		imageTitleList.add("2");
		imageTitleList.add("3");
		imageTitleList.add("4");
		imageTitleList.add("5");
		imageTitleList.add("6");

		//初始化图片集合
		imageList = new ArrayList<Integer>();

		imageList.add(R.drawable.nanhuaijin_miss);
		imageList.add(R.drawable.nanhuaijin_school);
		imageList.add(R.drawable.nanhuaijin_biguan);
		imageList.add(R.drawable.nanhuaijin);
		imageList.add(R.drawable.nanhuaijin_zhuangyan);
		imageList.add(R.drawable.nanhuaijin_faxiang);

		hListViewAdapter = new HorizontalListViewAdapter(getApplicationContext(),imageTitleList,imageList);

		hListView.setAdapter(hListViewAdapter);
		hListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {

				hListViewAdapter.deleteSelectIndex(position);
				hListViewAdapter.notifyDataSetChanged();

			}

		});

	}

	public void addButtonClicked(View v){

		hListViewAdapter.addNewImageView(R.drawable.nanhuaijin_miss,"7");
		hListViewAdapter.notifyDataSetChanged();

	}

}
