package Controle;

import com.pubnub.api.*;
import java.util.Arrays;

public class Configurador {
    final String PubKey = "pub-c-3701cc0b-3e9b-4f08-aad4-fb2c0a7de660";
    final String SubKey = "sub-c-bdb4e6fa-a701-11e8-b082-12b6fee23487";
    final String kChannel = "Teste";
    PubNub pubnub;
        
    public Configurador(){
        PNConfiguration pnConfiguration = new PNConfiguration();
        pnConfiguration.setPublishKey(PubKey);
        pnConfiguration.setSubscribeKey(SubKey);
        pubnub= new PubNub(pnConfiguration);}
    
    public void subscribe() {

		// Populate the data elements.
		try {
			pubnub.subscribe()
                        .channels(Arrays.asList(kChannel)) // subscribe to channels
                        .execute();
		} catch (Exception e) {
			System.out.println("Error in subscribe");
		}
	}
}