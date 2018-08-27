package Controle;

import com.pubnub.api.*;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.callbacks.SubscribeCallback;
import com.pubnub.api.enums.PNStatusCategory;
import com.pubnub.api.models.consumer.PNPublishResult;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.presence.PNSetStateResult;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult;
import java.util.Arrays;

public class Configurador {
    final String PubKey = "pub-c-3701cc0b-3e9b-4f08-aad4-fb2c0a7de660";
    final String SubKey = "sub-c-bdb4e6fa-a701-11e8-b082-12b6fee23487";
    final String UserId = "User de Subscriber";
    final String kChannel = "Teste";
    PubNub pubnub;
    
    class complexData {
    String fieldA;
    int fieldB;}
    
    public Configurador(){
        PNConfiguration pnConfiguration = new PNConfiguration();
        pnConfiguration.setPublishKey(PubKey);
        pnConfiguration.setSubscribeKey(SubKey);
        pnConfiguration.setUuid(UserId);
        pubnub= new PubNub(pnConfiguration);}

    public void subscribe() {
                // Populate the data elements.
	try {
                   pubnub.addListener(new SubscribeCallback() {
    @Override
    public void status(PubNub pubnub, PNStatus status) {
        if (status.getCategory() == PNStatusCategory.PNConnectedCategory){
            complexData data = new complexData();
            data.fieldA = "Awesome";
            data.fieldB = 10;
            pubnub.setPresenceState()
                .channels(Arrays.asList(kChannel)) // subscribe to channels
                .state(data).async(new PNCallback<PNSetStateResult>() {
                   
                    @Override
                    public void onResponse(PNSetStateResult result, PNStatus status) {
  
                    }
                });
        }
    }
 
    @Override
    public void message(PubNub pubnub, PNMessageResult message) {
        System.out.println(message);
    }
 
    @Override
    public void presence(PubNub pubnub, PNPresenceEventResult presence) {
 
    }
});
              pubnub.subscribe()
                      .channels(Arrays.asList(kChannel))
                      .execute();
              } catch (Exception e) {
			System.out.println("Error in subscribe");
		}
	}
}