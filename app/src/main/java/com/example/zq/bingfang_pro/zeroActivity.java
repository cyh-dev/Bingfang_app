package com.example.zq.bingfang_pro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.yuhao.packet.DataPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;



public class zeroActivity extends AppCompatActivity {
    private ViewPager vpager_zero;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;

    private static  EditText Jspo2;

    private static EditText Spm;
    private static EditText Sspo2;

    private static EditText Ben;
    private static EditText Bpm;
    private static EditText Bspo2;

    public static Context sContext;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sContext = getApplicationContext();
        setContentView(R.layout.cg);
        vpager_zero = (ViewPager) findViewById(R.id.vpager_zero);
        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();

       // aList.add(li.inflate(R.layout.cg,null,false));
        aList.add(li.inflate(R.layout.activity_bingfang,null,false));
        aList.add(li.inflate(R.layout.activity_jiating, null, false));
        aList.add(li.inflate(R.layout.activity_main, null, false));

        mAdapter = new MyPagerAdapter(aList);
        vpager_zero.setAdapter(mAdapter);


        Jspo2= (EditText) aList.get(1).findViewById(R.id.j_spo2);

        Spm= (EditText) aList.get(2).findViewById(R.id.s_pm);
        Sspo2= (EditText) aList.get(2).findViewById(R.id.s_spo2);

        Ben= (EditText) aList.get(0).findViewById(R.id.b_en);
        Bpm= (EditText) aList.get(0).findViewById(R.id.b_pm);
        Bspo2= (EditText) aList.get(0).findViewById(R.id.b_spo2);


    }

    public static void setJspo2(String data){
        try{
            int c = Integer.parseInt(data.toString());
            if(c<90||c>100)
            {
                Toast.makeText(zeroActivity.sContext, "血氧浓度异常！请注意！", Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
            return;

        }


        Jspo2.setText(data);

    }

    public static void setSpm(String data){

        try{
            int c = Integer.parseInt(data.toString());
            if(c>=20||c<=0)
            {
                Toast.makeText(zeroActivity.sContext, "PM2.5异常！请注意！", Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
            return;

        }
        Spm.setText(data);

    }

    public static void setSspo2(String data){
        try{
            int c = Integer.parseInt(data.toString());
            if(c<90||c>100)
            {
                Toast.makeText(zeroActivity.sContext, "血氧浓度异常！请注意！", Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
            return;

        }
        Sspo2.setText(data);

    }

    public static void setBen(String data){
        try{
            int c = Integer.parseInt(data.toString());
            if(c>23||c<18)
            {
                Toast.makeText(zeroActivity.sContext, "气温异常！请注意！", Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
            return;

        }
        Ben.setText(data);

    }
    public static void setBpm(String data){
        try{
            int c = Integer.parseInt(data.toString());
            if(c>=20||c<=0)
            {
                Toast.makeText(zeroActivity.sContext, "PM2.5异常！请注意！", Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
            return;

        }
        Bpm.setText(data);

    }

    public static void setBspo2(String data){
        try{
            int c = Integer.parseInt(data.toString());
            if(c<90||c>100)
            {
                Toast.makeText(zeroActivity.sContext, "血氧浓度异常！请注意！", Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
            return;

        }
        Bspo2.setText(data);

    }




    public void onClick1(View view) {
        try{
            int c = Integer.parseInt(Ben.getText().toString());
            if(c<=18||c>=23)
            {
                Toast.makeText(getApplicationContext(), "正常气温的范围是18°-23°！", Toast.LENGTH_SHORT).show();
                return;
            }
            c = Integer.parseInt(Bspo2.getText().toString());
            if(c<90||c>100)
            {
                Toast.makeText(getApplicationContext(), "正常血氧浓度的范围是90%-100%！", Toast.LENGTH_SHORT).show();
                return;
            }
            c = Integer.parseInt(Bpm.getText().toString());
            if(c<=0||c>20)
            {
                Toast.makeText(getApplicationContext(), "pm2.5正常范围是0-20！", Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "格式输入错误！", Toast.LENGTH_SHORT).show();
            return;
        }


        if (!"".equals(Ben.getText().toString())){
            DataPacket data=new DataPacket();
            data.setContent(Ben.getText().toString());
            data.setCode(16);
            data.setSendTime(new Date());
            sendData(data);
        }

        try {
            Thread.sleep(100);//等待数据处理时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!"".equals(Bspo2.getText().toString())){
            DataPacket data=new DataPacket();
            data.setContent(Bspo2.getText().toString());
            data.setCode(14);
            data.setSendTime(new Date());
            sendData(data);
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!"".equals(Bpm.getText().toString())){
            DataPacket data=new DataPacket();//发送的内容，发送的时间，code数据类型码
            data.setContent(Bpm.getText().toString());
            data.setCode(15);
            data.setSendTime(new Date());
            sendData(data);
        }


    }
    public void onClick2(View view) {
        try{
            int c = Integer.parseInt(Jspo2.getText().toString());
            if(c<=0||c>20)
            {
                Toast.makeText(getApplicationContext(), "pm2.5正常范围是0-20！", Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "格式输入错误！", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!"".equals(Jspo2.getText().toString())){
            DataPacket data=new DataPacket();
            data.setContent(Jspo2.getText().toString());
            data.setCode(11);
            data.setSendTime(new Date());
            sendData(data);
        }

    }

    public void onClick3(View view) {
        try{
            int c = Integer.parseInt(Spm.getText().toString());
            if(c<90||c>100)
            {
                Toast.makeText(getApplicationContext(), "正常血氧浓度的范围是90%-100%！", Toast.LENGTH_SHORT).show();
                return;
            }
            c = Integer.parseInt(Sspo2.getText().toString());
            if(c<=0||c>20)
            {
                Toast.makeText(getApplicationContext(), "pm2.5正常范围是0-20！", Toast.LENGTH_SHORT).show();
                return;
            }
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "格式输入错误！", Toast.LENGTH_SHORT).show();
            return;
        }


        if (!"".equals(Spm.getText().toString())){
            DataPacket data=new DataPacket();
            data.setContent(Spm.getText().toString());
            data.setCode(13);
            data.setSendTime(new Date());
            sendData(data);
        }

        if (!"".equals(Sspo2.getText().toString())){
            DataPacket data=new DataPacket();
            data.setContent(Sspo2.getText().toString());
            data.setCode(12);
            data.setSendTime(new Date());
            sendData(data);
        }

    }

    private void sendData(final DataPacket dataPacket){
        new Thread(){

            @Override
            public void run(){
                ByteBuffer buffer=ByteBuffer.allocate(1024);
                buffer.clear();
                ByteArrayOutputStream bytesOut=new ByteArrayOutputStream();
                ObjectOutputStream ojbOut= null;
                try {
                    ojbOut = new ObjectOutputStream(bytesOut);
                    ojbOut.writeObject(dataPacket);
                    ojbOut.close();

                    buffer.put(bytesOut.toByteArray());
                    bytesOut.close();
                    buffer.flip();
                    Connection.client.write(buffer);
                    buffer.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }.start();

    }



    @Override
    public void onBackPressed() {

        new Thread(){
            @Override
            public void run(){
                ByteBuffer buffer=ByteBuffer.allocate(1024);
                buffer.clear();
                DataPacket dataPacket=new DataPacket();
                dataPacket.setContent("disconnect");
                dataPacket.setCode(10);
                dataPacket.setSendTime(new Date());
                ByteArrayOutputStream bytesOut=new ByteArrayOutputStream();
                ObjectOutputStream ojbOut= null;
                try {
                    ojbOut = new ObjectOutputStream(bytesOut);
                    ojbOut.writeObject(dataPacket);
                    ojbOut.close();

                    buffer.put(bytesOut.toByteArray());
                    bytesOut.close();
                    buffer.flip();
                    Connection.client.write(buffer);
                    buffer.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Connection.client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }.start();



        super.onBackPressed();//注销该方法，相当于重写父类这个方法

    }


}