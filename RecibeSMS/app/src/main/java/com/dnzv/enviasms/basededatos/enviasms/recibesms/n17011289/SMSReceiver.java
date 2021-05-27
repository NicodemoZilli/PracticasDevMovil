package com.dnzv.enviasms.basededatos.enviasms.recibesms.n17011289;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle b = intent.getExtras();

        SmsMessage[] smsm =null;
        if(b != null){
            String info = "SMS recibido desde: ";
            Object [] pdus = (Object []) b.get("pdus");
            smsm = new SmsMessage[pdus.length];
            for(int i=0; i<smsm.length; i++){
                smsm[i] = SmsMessage.createFromPdu((byte [])pdus[i]);
                info = info + smsm[i].getOriginatingAddress()+"\n";
                info = info + ">>>>> MENSAJE <<<<<\n";
                info = info + smsm[i].getMessageBody().toString();
            }
            Toast.makeText(context,info,Toast.LENGTH_LONG).show();
        }

    }
}
