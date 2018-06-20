package com.example.zq.bingfang_pro;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import com.yuhao.packet.DataPacket;

/**
 * MyHandler
 *
 * @author CYH
 * @date 2018/6/19
 */
public class MyHandler extends Handler{



    @Override
    public void handleMessage(Message msg) {

        handleData((DataPacket) msg.obj);

    }

    private void handleData(DataPacket dataPacket){

        switch (dataPacket.getCode()){
            case 1:
                zeroActivity.setJspo2(dataPacket.getContent());
                break;
            case 2:
                zeroActivity.setSspo2(dataPacket.getContent());
                break;
            case 3:
                zeroActivity.setSpm(dataPacket.getContent());
                break;
            case 4:
                zeroActivity.setBspo2(dataPacket.getContent());
                break;
            case 5:
                zeroActivity.setBpm(dataPacket.getContent());
                break;
            case 6:
                zeroActivity.setBen(dataPacket.getContent());
                break;
            default:
                break;
        }

    }

}
