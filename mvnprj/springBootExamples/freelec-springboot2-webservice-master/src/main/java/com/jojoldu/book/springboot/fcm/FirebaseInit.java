package com.jojoldu.book.springboot.fcm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class FirebaseInit {

    private static final String path = "/fcm/serviceAccountKey.json";

    @PostConstruct
    public void init(){
        try{
            System.out.println("init");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(path).getInputStream())).build();
            System.out.println("init2");
            if(FirebaseApp.getApps().isEmpty()){
                FirebaseApp.initializeApp(options);
                System.out.println("init3");
            }
            System.out.println("init4");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}