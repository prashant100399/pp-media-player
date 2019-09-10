
package javafxdemo;
import javafx.application.Platform; 
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.events.JFXDialogEvent;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
//import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.*;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
//import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.util.Duration;
import javafx.stage.Stage;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.AWTKeyStroke;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


public class MediaController implements Initializable
{
    JavaFXdemo fx=new JavaFXdemo();
    Stage stage=new Stage();
    Scene scene;
    private Double f;
    private boolean  fullscreen=false;
    private boolean check=false;
   // private Tooltip tooltip=new Tooltip();
    private Duration duration;
    public String filepath;
    private Media media;
    private MediaPlayer mediaplayer;
    @FXML
    private MaterialDesignIconView icon_valume;
    @FXML
    private JFXButton playbtn;

    @FXML
    private MaterialDesignIconView play_icon;

    @FXML
    private JFXButton stopbtn;


    @FXML
    public Slider seekslider;
    @FXML
    public VBox vbox1;
    @FXML
    private JFXSlider valummeslider;
    @FXML
    private MediaView mediaview;
    @FXML
    private ImageView imagefirst;

    @FXML 
    private StackPane sp;
    @FXML
    private Label starttime;
    @FXML
    private Label lasttime;
    @FXML
    private ImageView imageview;
    @FXML
    private CheckMenuItem alwaysfitwindow_menuitem;
    @FXML
    private MenuItem open_menuitem;
    @FXML
    private Text textname;

    @FXML
    private MenuItem openfile_menuitem;
    
    @FXML
    private MenuItem opendisk_menuitem;

    @FXML
    private MenuItem quit_menuitem;

    @FXML
    private Menu playback_menu;

    @FXML
    private Menu speed_menu;

    @FXML
    private MenuItem faster_menuitem;

    @FXML
    private MenuItem fast_menuitem;

    @FXML
    private MenuItem normal_menuitem;

    @FXML
    private MenuItem slow_menuitem;

    @FXML
    private MenuItem slower_menuitem;

    @FXML
    private Menu jumpping_menu;

    @FXML
    private MenuItem forword_menuitem;

    @FXML
    private MenuItem backword_menuitem;

    @FXML
    private MenuItem play_menuitem;

    @FXML
    private MenuItem pause_menuitem;

    @FXML
    private MenuItem resume_menuitem;

    @FXML
    private MenuItem stop_menuitem;
    
    @FXML
    private MenuItem openNewWindow_menuitem;

    @FXML
    private Menu audio_menu;

    @FXML
    private MenuItem increasevolume_menuitem;

    @FXML
    private MenuItem decreasevolume_menuitem;

    @FXML
    private MenuItem mute_menuitem;

    @FXML
    private MenuItem unmute_menuitem;

    @FXML
    private Menu video_menu;

    @FXML
    private MenuItem fullscreen_menuitem;

    @FXML
    private MenuItem background_menuitem;

    
    @FXML
    private Menu help_menu;

    @FXML
    private MenuItem help_menuitem;

    @FXML
    private MenuItem about_menuitem;
         
        
       @FXML
     public void handleButtonAction(ActionEvent event)
     {
         
      
        
         FileChooser filechooser=new FileChooser();
         FileChooser.ExtensionFilter extentionfilter=new FileChooser.ExtensionFilter("select a file(*.mp4)(*.mp3)","*.mp4","*.mp3");
         filechooser.getExtensionFilters().add(extentionfilter);
          
         File  file=filechooser.showOpenDialog(null);
         
         try
         {
        mediaplayer.dispose();
         }
         catch(Exception e)
         {
            
         }
         filepath=file.toURI().toString();
       String r=file.getName();//it show the selected file name
       // System.out.println(r);
      // textname.setFont(Font.font("Arial"));
       
       textname.setText(r);
       String s[]=filepath.split(".",2);
       String d=s[0];
       String m=s[1];
       System.out.println(m);
         getFile(filepath);
        
         //mediaplayer.dispose();
        
     }
     
      public void aboutAuther()
      {
          BorderPane b=new BorderPane();
          GridPane gpane=new GridPane();
           BoxBlur bb=new BoxBlur(7,7,9);
              JFXDialogLayout content=new JFXDialogLayout();
              content.setHeading(new Text("About Author"));
              Text txt=new Text("PP media player");
              txt.setFill(Color.BLACK);
              txt.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
              txt.setTextAlignment(TextAlignment.RIGHT);
              Image m=new Image("images/vlc.png");
              ImageView m2=new ImageView(m);
              //content.setBody(txt);
               Text t=new Text("Created By Avi");
              t.setTextAlignment(TextAlignment.CENTER);
              gpane.addRow(0,txt);
              gpane.addRow(1,  t);
              
              b.setLeft(m2);
              b.setRight(gpane);
             
             // b.getChildren().add(t);
              content.setBody(b);
              JFXDialog dialog=new JFXDialog(sp, content, JFXDialog.DialogTransition.TOP);
              JFXButton btn=new JFXButton("Close");
              btn.setOnAction(new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent event) 
                  {
                      dialog.close();
                      
                  }
              });
              content.setActions(btn);
              mediaview.setEffect(bb);
              dialog.show();
              dialog.setOnDialogClosed(new EventHandler<JFXDialogEvent>()
              {
                  @Override
                  public void handle(JFXDialogEvent event) {
                      mediaview.setEffect(null);
                  }
              });
              
        
      }
     private void getFile(String filename)
     {
          if(filename != null)
        {
            
            imagefirst.setVisible(false);//flase the starting image vlc.png
            imageview.setVisible(true);//false the image when you select any file(vedio)
             media=new Media(filename);
             mediaplayer=new MediaPlayer(media);
             mediaview.setMediaPlayer(mediaplayer);
                         
             DoubleProperty width=mediaview.fitWidthProperty();
             DoubleProperty hight=mediaview.fitHeightProperty();
             
             width.bind(Bindings.selectDouble(mediaview.sceneProperty(),"width"));
             hight.bind(Bindings.selectDouble(mediaview.sceneProperty(), "hight"));
            
             mediaplayer.setOnEndOfMedia(new Runnable() {//repeat vedio playing
                  @Override
                      public void run() {
//                            resumeVideo();
//                            duration = mediaplayer.getMedia().getDuration();
//                            updateValues();

                               getFile(filepath);
                            }
                            });
             
             mediaplayer.setOnReady(new Runnable() {
                          @Override
                            public void run() 
                            {
                              mediaplayer.dispose();
                            }
                        });
            
             mediaplayer.setOnReady(() -> //set the time to the label
             {
              duration = mediaplayer.getMedia().getDuration();
              updateValues();
              
             });
           
                valummeslider.setValue(mediaplayer.getVolume() * 100);
                valummeslider.valueProperty().addListener(new InvalidationListener() 
                { //to set the value of valumme slider
                @Override
                public void invalidated(Observable observable) {
                    
                    mediaplayer.setVolume(valummeslider.getValue() / 100);
                }
                });
                
                
                //seekslider.setValue(0);
                mediaplayer.setOnReady(() -> //ready to mediaplayer to playing
                {
                seekslider.setMax(mediaplayer.getTotalDuration().toSeconds());//set the Total time to the seekslider 
                mediaplayer.currentTimeProperty().addListener(new ChangeListener<Duration>()
                { //get the cuurent time of vedio and set the seekslider
                @Override
                public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) 
                {
                   seekslider.setValue(newValue.toSeconds());
                   
                   duration=mediaplayer.getMedia().getDuration();//set the time to the label
                   updateValues();
                }
                });
                });
                
                
                seekslider.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                @Override
                public void handle(MouseEvent event) 
                {//when you clicking the seekslider then vedio continew from 
                    int n=event.getClickCount();
                   if(n==1)
                   {
                        mediaplayer.seek(Duration.seconds(seekslider.getValue()));
                        //System.out.println(n);
                   }
                   else if(n==2)
                   {
                        mediaplayer.seek(Duration.seconds(seekslider.getValue()));
                       //System.out.println(n);
                   }
                    
                }
                });
                
//                seekslider.setOnDragExited(new EventHandler<DragEvent>() 
//                {
//                @Override
//                public void handle(DragEvent ev) 
//                {
//                    //seekslider.getValue();
//                   mediaplayer.seek(Duration.seconds(seekslider.getValue()));
//                }
//                });

//  
              

           
              mediaplayer.setAutoPlay(true);
                       
        }
     
     }
     
      @FXML
      private void openNewWindow()
      {
          try
          {
        Stage Stage1=new Stage();
         fx.start(Stage1);
        
         mediaplayer.dispose();
          }
          
          catch(Exception e)
          {
              
          }
          
          
      }
      
    
      @FXML 
     public void playVedio(ActionEvent e)
     {
         //mediaplayer.play();
         //mediaplayer.setRate(1);
         if(fullscreen==false)
         {
             mediaplayer.play();
             mediaplayer.setRate(1);
             play_icon.setIcon(MaterialDesignIcon.PAUSE);
             Tooltip tooltip=new Tooltip();
             tooltip.setText("pause");
             playbtn.setTooltip(tooltip);
             fullscreen=true;

        
         }
         else
         {
              mediaplayer.pause();
              Tooltip t=new Tooltip();
             t.setText("play");
             playbtn.setTooltip(t);
             play_icon.setIcon(MaterialDesignIcon.PLAY);
            fullscreen=false;
         }
     }
     
      @FXML
      private void pauseVedio(ActionEvent e)
     {
         mediaplayer.pause();
         play_icon.setIcon(MaterialDesignIcon.PLAY);
     }
      
      
       @FXML
      private void stopVedio(ActionEvent e)
     {
         mediaplayer.stop();
         Tooltip tooltip=new Tooltip();
        tooltip.setText("stop");
        stopbtn.setTooltip(tooltip); 
        Tooltip tooltip1=new Tooltip();
        tooltip1.setText("play");
        playbtn.setTooltip(tooltip1); 
        play_icon.setIcon(MaterialDesignIcon.PLAY);
     }
      
      
       @FXML
      private void fastVedio(ActionEvent e)
     {
         mediaplayer.setRate(1.5);
     }
      
      
       @FXML  
      private void fasterVedio(ActionEvent e)
     {
         mediaplayer.setRate(2);
     }
      
       @FXML
      private void normal()
      {
          mediaplayer.setRate(1);
      
      }
       @FXML   
      private void slowVedio(ActionEvent e)
     {
         mediaplayer.setRate(0.75);
     }
      
      
       @FXML    
      private void slowerVedio(ActionEvent e)
     {
         mediaplayer.setRate(0.5);
     }
      
       @FXML    
      private void exitVedio(ActionEvent e)
     {
         System.exit(4245);
     }
      
      @FXML
      private void forwordVideo()
      {
          Double s=seekslider.getValue();
          if(s!=0)
          {
              s=s+15;
              seekslider.setValue(s);
             mediaplayer.seek(Duration.seconds(seekslider.getValue()));
          }
      
      }
      
      @FXML
      private void backwordVideo()
      {
           Double s=seekslider.getValue();
          if(s!=0)
          {
              s=s-15;
              seekslider.setValue(s);
             mediaplayer.seek(Duration.seconds(seekslider.getValue()));
          }
      
      }
      
      @FXML
      private void resumeVideo()
      {
          mediaplayer.stop();
          mediaplayer.play();
          
      }
      
       @FXML
      private void increaseValue()
      {
          Double volume=valummeslider.getValue();
          if(volume!=100)
          {
             volume=volume+10;
             valummeslider.setValue(volume);
             icon_valume.setIcon(MaterialDesignIcon.VOLUME_HIGH);
          }
         /* else if(volume==100)
          {
              BoxBlur bb=new BoxBlur(7, 7, 9);
              JFXDialogLayout content=new JFXDialogLayout();
              content.setHeading(new Text("Increase Volume"));
              content.setBody(new Text("You have already increase full volume"));
              //StackPane sp = null;
              
              JFXDialog dialog=new JFXDialog(sp, content, JFXDialog.DialogTransition.TOP);
              JFXButton btn=new JFXButton("Close");
              btn.setAlignment(Pos.BOTTOM_LEFT);
               btn.setOnAction(new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent event) 
                  {
                      dialog.close();
                      
                  }
              });
              content.setActions(btn);
             // content.set
              dialog.show();
               mediaview.setEffect(bb);
              //dialog.show();
              dialog.setOnDialogClosed(new EventHandler<JFXDialogEvent>()
              {
                  @Override
                  public void handle(JFXDialogEvent event) {
                      mediaview.setEffect(null);
                  }
              });
                      
              
              
          }*/
      }
      
       @FXML
      private void decreaseValue()
      {
          Double volume=valummeslider.getValue();
          if(volume!=0)
          {
             volume=volume-10;
             valummeslider.setValue(volume);
          }
          else
          {
              icon_valume.setIcon(MaterialDesignIcon.VOLUME_OFF);
          }
         /* else if(volume==0)
          { 
              BoxBlur bb=new BoxBlur(7,7,9);
              JFXDialogLayout content=new JFXDialogLayout();
              content.setHeading(new Text("Decrease Volume"));
              content.setBody(new Text("You have already decrease all volume"));
              JFXDialog dialog=new JFXDialog(sp, content, JFXDialog.DialogTransition.TOP);
              JFXButton btn=new JFXButton("Close");
              btn.setOnAction(new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent event) 
                  {
                      dialog.close();
                      
                  }
              });
              content.setActions(btn);
              mediaview.setEffect(bb);
              dialog.show();
              dialog.setOnDialogClosed(new EventHandler<JFXDialogEvent>()
              {
                  @Override
                  public void handle(JFXDialogEvent event) {
                      mediaview.setEffect(null);
                  }
              });
              
//              dialog.setOnDialogOpened(new EventHandler<JFXDialogEvent>()
//              {
//                   @Override
//                  public void handle(JFXDialogEvent event) {
//                      mediaview.setEffect(null);
//                  }
//              });
             
              
          }*/
      }
       @FXML
      private void muteVolume()//mute the video
      {
          f=valummeslider.getValue();
          mediaplayer.setVolume(0);
          valummeslider.setValue(0);
          icon_valume.setIcon(MaterialDesignIcon.VOLUME_OFF);
      }
      
       @FXML
      private void unmuteVolume()//unmute the video by increasing value 10
      {
          
         valummeslider.setValue(f);
         icon_valume.setIcon(MaterialDesignIcon.VOLUME_HIGH);
      }
     
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Image mg=new Image("images/avi.png");
        imageview.setImage(mg);
        imageview.setFitHeight(200);
        imageview.setFitWidth(200);
        Image mg1=new Image("images/vlc.png");
        imagefirst.setImage(mg1);
        //imageview.setPreserveRatio(true);
        //imageview.setFitHeight(447);
        //imageview.setFitWidth(782);
        //Text txt=new Text("created by P.G");
        
       alwaysfitwindow_menuitem.setSelected(Boolean.TRUE);
       Tooltip t1=new  Tooltip();
       t1.setText("pause");
       playbtn.setTooltip(t1);
       Tooltip tooltip1=new Tooltip();
       tooltip1.setText("stop");
         stopbtn.setTooltip(tooltip1);
       //play_icon.setIcon(MaterialDesignIcon.DISK_ALERT);
       textname.setText("");
        //KeyStroke k=KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK);
        
        open_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.O,KeyCombination.CONTROL_DOWN));
        quit_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        openfile_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.F,KeyCombination.CONTROL_DOWN));
        opendisk_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.D,KeyCombination.CONTROL_DOWN));
        forword_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.RIGHT,KeyCombination.CONTROL_DOWN));
        backword_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.LEFT,KeyCombination.CONTROL_DOWN));
        play_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.P,KeyCombination.CONTROL_DOWN));
        pause_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.P,KeyCombination.ALT_DOWN));
        resume_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.R,KeyCombination.CONTROL_DOWN));
        stop_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.S,KeyCombination.CONTROL_DOWN));
        increasevolume_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.UP,KeyCombination.CONTROL_DOWN));
        decreasevolume_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.DOWN,KeyCombination.CONTROL_DOWN));
        mute_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.M,KeyCombination.CONTROL_DOWN));
        unmute_menuitem.setAccelerator(new KeyCodeCombination(KeyCode.U,KeyCombination.CONTROL_DOWN));
        openNewWindow_menuitem.setAccelerator( new KeyCodeCombination(KeyCode.N,KeyCombination.CONTROL_DOWN));
        faster_menuitem.setAccelerator( new KeyCodeCombination(KeyCode.F,KeyCombination.ALT_DOWN));
        slow_menuitem.setAccelerator( new KeyCodeCombination(KeyCode.S,KeyCombination.ALT_DOWN));
        normal_menuitem.setAccelerator( new KeyCodeCombination(KeyCode.N,KeyCombination.ALT_DOWN));
    
       
    }    
    
    
     private String formatTime(Duration elapsed, Duration duration)//to set the specific time format to the seek slider
    {

        int intElapsed = (int) Math.floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        if (elapsedHours > 0) 
        {
            intElapsed -= elapsedHours * 60 * 60;
        }
        int elapsedMinutes = intElapsed / 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60 - elapsedMinutes
                * 60;

        if (duration.greaterThan(Duration.ZERO)) 
        {
            int intDuration = (int) Math.floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            if (durationHours > 0)
            {
                intDuration -= durationHours * 60 * 60;
            }
            int durationMinutes = intDuration / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60
                    - durationMinutes * 60;

            if (durationHours > 0) 
            {
                return String.format("%d:%02d:%02d/%d:%02d:%02d", elapsedHours,
                        elapsedMinutes, elapsedSeconds, durationHours, durationMinutes,
                        durationSeconds);
            }
            else 
            {
                return String.format("%02d:%02d/%02d:%02d", elapsedMinutes,
                        elapsedSeconds, durationMinutes, durationSeconds);
            }
        }
        else 
        {
            if (elapsedHours > 0) 
            {
                return String.format("%d:%02d:%02d", elapsedHours, elapsedMinutes,
                        elapsedSeconds);
            } 
            else
            {
                return String.format("%02d:%02d", elapsedMinutes, elapsedSeconds);
            }
        }

    }

     
     
      private void updateValues()
    {
        if (starttime != null && seekslider != null && valummeslider != null) 
        {
           
            Platform.runLater(new Runnable() 
            {
                @Override
                public void run() 
                {
                    Duration currentTime=mediaplayer.getCurrentTime();
                    String s1 = formatTime(currentTime, duration);
                    String[] parts = s1.split("/",2);
                    String part1 = parts[0]; 
                    String part2 = parts[1];   
                    starttime.setText(part1);
                    lasttime.setText(part2);
                }
            });
        }
    }
    
}
