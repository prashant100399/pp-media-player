/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdemo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.Image;


/**
 *
 * @author Avi
 */
public class JavaFXdemo extends Application 
{
    Stage stage=new Stage();
    boolean fullscreen=false;
    @Override
    public void start(Stage stage) throws Exception 
    {
        MediaController m=new MediaController();
     
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMediaPlayer.fxml"));
        
        Scene scene = new Scene(root);
       scene.setOnMouseClicked(new EventHandler<MouseEvent>() 
       {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount()==2)
                {
                    if(fullscreen==false)
                    {
                       
                        stage.setFullScreen(true);
                        fullscreen=true;
                         
                   
                    }
                    else if(fullscreen==true)
                    {
                        stage.setFullScreen(false);
                        fullscreen=false;
                        
                    }
                    
                }}
        });
        
       
        //String str=m.filepath;
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/vlc.png"));
        stage.setTitle("PP Media Player");
        stage.show();
        
        stage.setResizable(false);
    }

    public static void main(String[] avi) {
        launch(avi);
    }
    
}
