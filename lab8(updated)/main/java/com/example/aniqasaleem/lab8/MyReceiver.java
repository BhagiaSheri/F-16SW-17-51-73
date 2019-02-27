package com.example.aniqasaleem.lab8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        try{
            Bundle bundle=intent.getExtras();

            if (bundle!=null){
                final Object[] obj = (Object[])bundle.get("pdus");
                for (Object object: obj){
                    SmsMessage currentMsg = SmsMessage.createFromPdu((byte[])object);
                   String  message = currentMsg.getDisplayMessageBody();
                    if (message.contains("HELLO")||message.contains("Hello")){
                        Toast.makeText(context,"Greetings received",Toast.LENGTH_LONG).show();

                }
                else {
                        Toast.makeText(context,"you have received a SMS ",Toast.LENGTH_SHORT).show();
                    }

               }
            }
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }
//    private String getSMSContent(Intent intent){
//        Bundle data = intent.getExtras();
//        final Object[] objects= (Object[]) data.get("msg");
//        for (Object obj : objects){
//            SmsMessage currentmsg = SmsMessage.createFromPdu((byte[])obj);
//            String smsContent = currentmsg.getDisplayMessageBody();
//            if ( smsContent.contains("hello")||smsContent.contains("Hello")||smsContent.contains("HELLO")){
//                Toast.makeText("Greeting Received",Toast.LENGTH_LONG).show();
//            }
//        }
//
//    }
}
