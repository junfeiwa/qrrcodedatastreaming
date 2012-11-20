package com.example.qrrcodedatastreaming;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.qrrcodedatastreaming.R.id;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class MainActivity extends Activity {
	public CameraPreview mPreview;
	public Camera c;
	private QRCodeWriter qw=new QRCodeWriter();
	public static final int MEDIA_TYPE_IMAGE = 1;
	private static final int MEDIA_TYPE_VIDEO = 2;
	private static final int WHITE = 0xFFFFFFFF;
	  private static final int BLACK = 0xFF000000;
	  public String[] s=new String[10];
	  public Bitmap[] b=new Bitmap[10];
	  public ImageView iv;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		c = null;
        
        try {
            c = Camera.open(1); // attempt to get a Camera instance
            
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        Camera.Size csize = c.getParameters().getPreviewSize();
        int mPreviewHeight = csize.height; //
        int mPreviewWidth = csize.width;
        Camera.Parameters parameters = c.getParameters();
        parameters.setPictureSize(800, 800);
       // parameters.setPreviewSize(700, 700);
        parameters.set("orientation", "portrait");
        c.setDisplayOrientation(90);
        c.setParameters(parameters);
        mPreview = new CameraPreview(this, c);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        
        preview.addView(mPreview);
        final PreviewCallback mPicture = new PreviewCallback() {

        	public void onPreviewFrame(byte[] data, Camera camera)  
            { 
                    try 
                    { 
                            BitmapFactory.Options opts = new BitmapFactory.Options(); 
                            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);//,opts); 
                            Log.i("file","Bitmap captured");
                    } 
                    catch(Exception e) 
                    {
                    	Log.i("file","not captured");
                    } 
            } 

        };
        Log.i("file","good1");
        c.setPreviewCallbackWithBuffer(mPicture);
        Log.i("file","good2");
        s = new String[10];
        //s[0]="12345678";
         s[0]="Money causes teenagers to feel stress. It makes them feel bad about themselves and envy other people. My friend, for instance, lives with her family and has to share a room with her sister, who is very cute and intelligent. This girl wishes she could have her own room and have a lot of stuff, but she can’t have these things because her family doesn’t have much money. Her family’s income is pretty low because her father is old and doesn’t go to work. Her sister is the only one who works. Because her family can’t buy her the things she wants, she feels a lot of stress and gets angry sometimes. Once, she wanted a beautiful dress to wear to a sweetheart dance. She asked her sister for some money to buy the dress. She was disappointed because her sister didn’t have money to give her. She sat in silence for a little while and then started yelling out loud. She said her friends got anything they wanted but she didn’t. Then she felt sorry for herself and asked why she was born into a poor family. Not having money has caused this girl to think negatively about herself and her family. It has caused a lot of stress in her life.";
        
        s[1]="Note how the first sentence, My hometown, Wheaton, is famous for several amazing geographical features,is the most general statement. This sentence is different from the two sentences that follow it, since the second and third sentences mention specific details about the town's geography, and are not general statements.Money causes teenagers to feel stress. It makes them feel bad about themselves and envy other people. My friend, for instance, lives with her family and has to share a room with her sister, who is very cute and intelligent. This girl wishes she could have her own room and have a lot of stuff, but she can’t have these things because her family doesn’t have much money. Her family’s income is pretty low because her father is old and doesn’t go to work. Her sister is the only one who works. Because her family can’t buy her the things she wants, she feels a lot of stress and gets angry sometimes. Once, she wanted a beautiful dress to wear to a sweetheart dance. She asked her sister for some money to buy the dress. She was disappointed because her sister didn’t have money to give her. She sat in silence for a little while and then started yelling out loud. She said her friendsMoney causes teenagers to feel stress. It makes them feel bad about themselves and envy other people. My friend, for instance, lives with her family and has to share a room with her sister, who is very cute and intelligent. This girl wishes she could have her own room and have a lot of stuff, but she can’t have these things because her family doesn’t have much money. Her family’s income is pretty low because her father is old and doesn’t go to work. Her sister is the only one who works. Because her family can’t buy her the things she wants, she feels a lot of stress and gets angry sometimes. Once, she wanted a beautiful dress to wear to a sweetheart dance. She asked her sister for some money to buy the dress. She was disappointed because her sister didn’t have money to give her. She sat in silence for a little while and then started yelling out loud. She said her friends";
        
        s[2]="Newspapers in India are classified into two categories according to the amount and completeness of information in them. Newspapers in the first category have more information and truth. Those in the second category do not have much information and sometimes they hide the truth. Newspapers in the first category have news collected from different parts of the country and also from different countries. They also have a lot of sports and business news and classified ads. The information they give is clear and complete and it is supported by showing pictures. The best know example of this category is the Indian Express. Important news goes on the first page with big headlines, photographs from different angles, and complete information. For example, in 1989-90, the Indian prime minister, Rajive Ghandi, was killed by a terrorist using a bomb. This newspaper investigated the situation and gave information that helped the CBI to get more support. They also showed diagrams of the area where the prime minister was killed and the positions of the bodies after the attack. This helped the reader understand what happened. Unlike newspaper in the first category, newspapers in the second category do not give as much information. They do not have international news, sports, or business news and they do not have classified ads. Also, the news they give is not complete. For example, the newspaper Hindi gave news on the death of the prime minister, but the news was not complete. The newspaper didn’t investigate the terrorist group or try to find out why this happened. Also, it did not show any pictures from the attack or give any news the next day. It just gave the news when it happened, but it didn’t follow up. Therefore, newspapers in the first group are more popular than those in the second group.";
        
        s[3]="Most students like the freedom they have in college. Usually college students live on their own, in the dormitory or in an apartment. This means they are free to come and go as they like. Their parents can’t tell them when to get up, when to go to school, and when to come home. It also means that they are free to wear what they want. There are no parents to comment about their hair styles or their dirty jeans. Finally, they are free to listen to their favorite music without interference from parents.";
        s[4]=" California is the most wonderful place to visit because of its variety of weather and its beautiful nature. (subject development) Visitors to California can find any weather they like. They can find cool temperatures in the summer; also they can find warm weather in the winter. They can find places that are difficult for humans to live in the summer because they are so hot. Or they can find places closed in the winter because of the snow. On the other hand, visitors can find the nature they like. They can find high mountains and low valleys. Visitors can find a huge forest, a dead desert, and a beautiful coast.(summary sentence) So California is the most wonderful place to visit because of its weather and natureOn the other hand, visitors can find the nature they like. They can find high mountains and low valleys. Visitors can find a huge forest, a dead desert, and a beautiful coast.(summary sentence) So California is the most wonderful place to visit because of its weather and natur.";
        s[5]="The first thing we did as soon as we came to the U.S.A. about two years ago was to search for an apartment in order not to live with one of our relatives. After looking for one month to find a suitable apartment, I finally found the apartment where we have been living. It includes a living room three bedrooms, and a kitchen. Probably the living room is my favorite room of all because we often gather together there after we come home from work or school. It is a comfortable room for our family. Entering the living room from the front door, we can we a new piano in the corner, with a vase of colorful flowers on it. In the opposite corner stands a Sony television, which I bought for my children to watch cartoons and for us to see films and get the daily news. Besides, there is a sofa next to the piano, a loveseat beside the TV, and also a low table between them. This is a comfortable place to sit while we watch TV or talk. On one of the light blue walls is a tranquil picture of the sea. The floor is covered with a dark red carpet, which my children like to play on. They also like to sit on it when they watch TV. The large window is shaded by a light colored curtain, giving the room a soft, bright feeling. A ceiling fan with small lights is hanging from the ceiling, whenever the fan and lights are on, we can see dangling images, which are reflected from the furniture in the room. Generally, our living room is a place where we receive our guest, gather together to discuss any topic and enjoy our leisure time.";
        s[6]="Three important Swiss customs for tourists to know deal with religion, greeting, and punctuality. (subject development) The Swiss people are very religious, and Sunday is their holy day. On Sunday, people rarely work in the garden, in the house, or even on the car. Foreign tourists should know that the most drugstores, supermarkets, and banks are closed on Sunday. The Swiss are also a formal people. For example, they seldom call acquaintances by their first names; the German “Herr” and French “Monsieur” are much more frequently used in Switzerland than the English “Mister” is used in the United States. A tourist should therefore say either “Herr” or “Monsieur” when greeting an acquaintance, and only use the person’s first name if he is a close friend. In addition, Switzerland is the land of watches and exactness. It is important to be on time to parties, business, meetings, and churches because Swiss hosts, factory bosses, and ministers all love punctuality. It is especially important for tourists to be on time for trains: Swiss train conductors never wait for late arrivers. (summary sentence) In summary, Swiss customs are very easy to follow and very important to remember!Money causes teenagers to feel stress. It makes them feel bad about themselves and envy other people. My friend, for instance, lives with her family and has to share a room with her sister, who is very cute and intelligent. This girl wishes she could have her own room and have a lot of stuff, but she can’t have these things because her family doesn’t have much money. Her family’s income is pretty low because her father is old and doesn’t go to work. Her sister is the only one who works. Because her family can’t buy her the things she wants, she feels a lot of stress and gets angry sometimes. Once, she wanted a beautiful dress to wear to a sweetheart dance. She asked her sister for some money to buy the dress. She was disappointed because her sister didn’t have money to give her. She sat in silence for a little while and then started yelling out loud. She said her friends";
        s[7]="The battles of Marathon and Tours are examples of how war has often determined the development of Western civilization. (subject development) The basis of Western civilization was probably decided at the Battle of Marathon about 2,500 years ago. In this battle, a small number of Greek soldiers led by a famous Greek general defeated 100,000 invading Persians under the Persian king. Because the Greeks won, Greek ideas about many subjects matured and became the foundation of Western society. Whereas Marathon laid the basis of Western civilization, its structure remained the same as a result of the Battle of Tours in A.D. 732. Before this battle, Muslim armies had taken control of a large number of countries, but they were stopped by a group of soldiers led by Charles Martel in France. If the Muslims had won at Tours, Islam might have become the major religion of Western societyMoney causes teenagers to feel stress. It makes them feel bad about themselves and envy other people. My friend, for instance, lives with her family and has to share a room with her sister, who is very cute and intelligent. This girl wishes she could have her own room and have a lot of stuff, but she can’t have these things because her family doesn’t have much money. Her family’s income is pretty low because her father is old and doesn’t go to work. Her sister is the only one who works. Because her family can’t buy her the things she wants, she feels a lot of stress and gets angry sometimes. Once, she wanted a beautiful dress to wear to a sweetheart dance. She asked her sister for some money to buy the dress. She was disappointed because her sister didn’t have money to give her. She sat in silence for a little while and then started yelling out loud. She said her friends.";
        s[8]="The battles of Marathon and Tours are examples of how war has often determined the development of Western civilization. (subject development) The basis of Western civilization was probably decided in Greece at the Battle of Marathon in 490 B.C. In this battle, 10,000 Greek soldiers led by Miltiades defeated 100,000 invading Persians under Darius I. Because the Greeks won, Greek ideas about philosophy, science, literature, and politics (such as democracy) matured and became the foundation of Western society. Whereas Marathon laid the basis of Western civilization, its structure remained the same as a result of the Battle of Tours in A.D. 732. Before this battle, Muslim armies had taken control of countries from India to the Atlantic Ocean, but they were stopped by a European army under Charles Martel at this battle in southwest France. If the Muslims had won at Tours, Islam might have become the major religion of Western society.";
        s[9]="A topic sentence usually comes at the beginning of a paragraph; that is, it is usually the first sentence in a formal academic paragraph.  (Sometimes this is not true, but as you practice writing with this online lesson site, please keep to this rule unless you are instructed otherwise.)  Not only is a topic sentence the first sentence of a paragraph, but, more importantly, it is the most general sentence in a paragraph.  What does most general mean?  It means that there are not many details in the sentence, but that the sentence introduces an overall idea that you want to discuss later in the paragraph.";
        for(int i=0;i<=9;i++){
     	   s[i]=s[i].substring(0, 200);}
        for(int a=0;a<=9;a++)
         b[a]= encode(s[a]);
        iv=(ImageView) this.findViewById(id.qrcode_image);
        boolean a=iv.post(new Runnable() {  
     	   
     	   int j = 0;      
     	   @Override   
     	   public void run() {
     		  if(j<=999999)
     	      iv.setImageBitmap(b[j%10]);
     	      if(j++ <= 999999){
     	         iv.postDelayed(this, 100);
     	      }
     	   }
     	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	 private static File getOutputMediaFile(int type){
	        // To be safe, you should check that the SDCard is mounted
	        // using Environment.getExternalStorageState() before doing this.

	        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	                  Environment.DIRECTORY_PICTURES), "MyCameraApp");
	        // This location works best if you want the created images to be shared
	        // between applications and persist after your app has been uninstalled.

	        // Create the storage directory if it does not exist
	        if (! mediaStorageDir.exists()){
	            if (! mediaStorageDir.mkdirs()){
	                Log.d("MyCameraApp", "failed to create directory");
	                return null;
	            }
	        }

	        // Create a media file name
	        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        File mediaFile;
	        if (type == MEDIA_TYPE_IMAGE){
	            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	            "IMG_123.jpg");
	        } else if(type == MEDIA_TYPE_VIDEO) {
	            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	            "VID_"+ timeStamp + ".mp4");
	        } else {
	            return null;
	        }

	        return mediaFile;
	    }
	 public Bitmap encode(String s){
	    	
         BitMatrix result=null;
         
         try {
           try {
  			result = qw.encode(s, BarcodeFormat.QR_CODE, 800, 800);
  		} catch (WriterException e) {
  			// TODO Auto-generated catch block
  			//e.printStackTrace();
  		}
         } catch (IllegalArgumentException iae) {
           // Unsupported format
           
         }
         Log.i("123","good5");
         int width = result.getWidth();
         int height = result.getHeight();
         int[] pixels = new int[width * height];
         for (int y = 0; y < height; y++) {
           int offset = y * width;
           for (int x = 0; x < width; x++) {
             pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
           }
         }
         
         Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
         bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
         Log.i("123","should change image");
         return bitmap;
        // ImageView newiv=new ImageView(this);
         //newiv.setImageBitmap(bitmap);
         //this.setContentView(newiv);
    }
}
