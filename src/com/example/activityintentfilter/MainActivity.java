package com.example.activityintentfilter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	public static final String ACTION = "android.intent.action.Activity2";
	public static final String CATEGORY = "android.intent.category.DEFAULT";
	public static final String CATEGORY1 = "android.intent.category.DEFAULT1";
	public static final String CATEGORY2 = "android.intent.category.DEFAULT2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.bt_multi_matched:
			intent = new Intent();
			intent.setAction(ACTION);
			intent.addCategory(CATEGORY1);
			intent.addCategory(CATEGORY2);
			intent.setDataAndType(Uri.parse("https://baidu.com:8080/index"),
					"image/jpeg");
			break;
		case R.id.bt_single_matched:
			intent = new Intent();
			intent.setAction(ACTION);
			intent.addCategory(CATEGORY1);
			intent.setDataAndType(Uri.parse("https://baidu.com:8080/index"),
					"image/jpeg");
			break;
		case R.id.bt_no_action:
			intent = new Intent();
			intent.addCategory(CATEGORY1);
			intent.addCategory(CATEGORY2);
			intent.setDataAndType(Uri.parse("https://baidu.com:8080/index"),
					"image/jpeg");
			break;
		case R.id.bt_no_category:
			intent = new Intent();
			intent.setDataAndType(Uri.parse("https://baidu.com:8080/index"),
					"image/jpeg");
			break;
		case R.id.bt_no_data:
			intent = new Intent();
			intent.setAction(ACTION);
			intent.addCategory(CATEGORY1);
			intent.addCategory(CATEGORY2);
			break;
		case R.id.bt_no_type:
			intent = new Intent();
			intent.setAction(ACTION);
			intent.addCategory(CATEGORY1);
			intent.addCategory(CATEGORY2);
			intent.setData(Uri.parse("https://baidu.com:8080/index"));
			break;

		case R.id.bt_browser:
			//没有 action 也能启动浏览器，只是浏览器不能获取 intent 中的 data 中的数据
			intent = new Intent();
			intent.setAction("android.intent.action.VIEW");
			intent.addCategory("android.intent.category.BROWSABLE");
			intent.setData(Uri.parse("http://www.baidu.com"));
			break;

		default:
			break;
		}
		startActivity(intent);
	}
}
