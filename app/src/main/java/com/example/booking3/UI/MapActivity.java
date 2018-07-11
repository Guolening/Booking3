package com.example.booking3.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.booking3.R;

/**
 * Created by t520win764zy on 2018/7/8.
 */

public class MapActivity extends AppCompatActivity {
    private String name;
    private double lat;
    private double lon;

    public LocationClient mLocationClient = null;
    public MyLocationListener myLocationListener = null;

    public Button button_request;
    public TextView text_location;
    private MapView mapView;
    private BaiduMap baiduMap;//BaiduMap是地图的总控制器
    private boolean isFirstLocate = true;//该变量为了防止对此定位，因为定位我的位置一次就够

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());//显示地图画面的初始化  注意：该操作一定在setContentView方法前调用，不然会出错
        setContentView(R.layout.court_result_item_map);

        Bundle bundle=getIntent().getExtras();//获取bundle中的build值，下面会根据这个值对经纬度赋不同的值
        name = bundle.getString("name");
        switch(name){//在地图中的搜索关键字重新更新
            case "工大球场":
                name="北京工业大学-篮球场";
                break;
            case "人大球场":
                name="中国人民大学-篮球场";
                break;
            case "东单球场":
                name="北京东单篮球场";
                break;
            case "五棵松球场":
                name="北京HIPARK篮球公园";
                break;
            case "首经贸球场":
                name="首都经济贸易大学-塑胶篮球场";
                break;
        }

        button_request = (Button) findViewById(R.id.request_map);//各控件的定义
        text_location = (TextView) findViewById(R.id.position_text_view);
        mapView = (MapView) findViewById(R.id.bmapView);

        mLocationClient = new LocationClient(MapActivity.this);//初始化百度地图定位功能,之后可直接使用
        LocationClientOption option = new LocationClientOption();//利用option对象设置一些参数
        option.setIsNeedAddress(true);//设置是否需要地址信息
        option.setCoorType("bd09ll");//setCoorType设置坐标类型  百度坐标(bd0911 注意是字母l而不是数字1)互转火星坐标(gcj02)和国测局坐标(GPS)
        option.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);//设置定位模式  Battery_Saving为低功耗定位模式
        option.setScanSpan(5 * 60000);//setCoorType 设置发起定位请求的间隔 自己设置时间 毫秒单位
        mLocationClient.setLocOption(option);//将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);

        myLocationListener = new MyLocationListener();//百度地图定位功能
        mLocationClient.registerLocationListener(myLocationListener);//注册定位监听器
        mLocationClient.start();//开始定位

        button_request.setOnClickListener(new View.OnClickListener() {//点击按钮 开始定位
            @Override
            public void onClick(View view) {
                if(name.equals("北京工业大学-篮球场")){
                    lat=39.879523;
                    lon=116.490296;
                }else if(name.equals("中国人民大学-篮球场")){
                    lat=39.975514;
                    lon=116.316841;
                }else if(name.equals("北京东单篮球场")){
                    lat=39.912725;
                    lon=116.422906;
                }else if(name.equals("北京HIPARK篮球公园")){
                    lat=39.915052;
                    lon=116.285965;
                }else if(name.equals("首都经济贸易大学-塑胶篮球场")){
                    lat=39.849529;
                    lon=116.325855;
                }
                navigateTo(lat,lon);
            }
        });
    }
    /*
    函数名：navigateTo
    函数功能：根据location移动到我的位置的函数  以及设置地图样式，eg缩放级别等
    变量说明：经纬度值
    返回值说明：无
     */
    private void navigateTo(double lat,double lon) {
        if (isFirstLocate) {
            LatLng ll = new LatLng(lat, lon);//设置对应的经纬度数值
            ll = pianyi(lat,lon);//计算解决部分偏移
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
            baiduMap.animateMapStatus(update);//将返回的对象update传进animateMapStatus即可完成update中的操作
            update = MapStatusUpdateFactory.zoomTo(12f);//显示缩放级别 数值越大，显示的越精细
            baiduMap.animateMapStatus(update);
            isFirstLocate = false;//该变量为了防止对此定位，因为定位我的位置一次就够
        }
        MyLocationData.Builder locationBuilder = new MyLocationData.Builder();
        locationBuilder.latitude(lat);
        locationBuilder.longitude(lon);
        MyLocationData locationData = locationBuilder.build();
        baiduMap.setMyLocationData(locationData);//利用百度地图封装好的函数setMyLocationData将包含经纬度信息的数据locationData绑定到我们画面中的地图上
    }

    /*
    函数名：pianyi
    函数功能：设置位置偏移问题，对百度地图的定位进行纠偏操作
    变量说明：经纬度值
    返回值说明：经纬度坐标点
     */
    private LatLng pianyi(double lon, double lat){
        double x = lon; double y = lat;
        double z = Math.sqrt(x*x+y*y) + 0.00002 *Math.sin(y*Math.PI) ;
        double temp =Math.atan2(y, x)  + 0.000003 * Math.cos(x*Math.PI);
        double bdLon = z * Math.cos(temp) + 0.0065;
        double bdLat = z * Math.sin(temp) + 0.006;
        LatLng newcenpt = new LatLng(bdLat, bdLon);
        return newcenpt;
    }

    /*
    类名：MyLocationListener
    类功能：监听器，用来监听定位
    变量说明：回调函数，用于接收地址信息
    返回值说明：无
    */
    public class MyLocationListener implements BDLocationListener {//回调 监听器，类似于按钮点击事件的监听器 等 作用，这里用来监听定位
        @Override
        public void onReceiveLocation(BDLocation location) {//回调函数 用于接收地址信息
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(location));
            text_location.setText("\n①您当前的位置是:"+location.getCountry()+location.getProvince()+location.getCity()+location.getDistrict()+location.getStreet()+
                    "\n②点击下方按钮可以获得 * "+name+" * 的定位:");
        }
    }

    @Override
    protected void onResume(){//在onResume之后调用
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause(){//周期的暂停
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {//周期的销毁
        super.onDestroy();
        mLocationClient.stop();
        mapView.onDestroy();
        baiduMap.setMyLocationEnabled(false);
    }

}
