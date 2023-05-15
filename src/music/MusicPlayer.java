/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package music;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileNotFoundException;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author DJR
 */
public class MusicPlayer extends javax.swing.JFrame {
Timer t,ts;
Image d,m,di,dim,din,dis,dimg,ding,dimgs,dimgse,dimgses;
Clip sound;
String pau,song,son,song1,sufe,songn,folder,path,panes;
String contents[];
long clipTime,length,curr;
int count,ac,co,fun,tims,cm,cs,num,cus;
File directoryPath;
StringBuilder sb;
    /**
     * Creates new form MusicPlayer
     */
    public MusicPlayer() {
        initComponents();
        runicons();
        lists();
        players.requestFocusInWindow();
        //search.setPromptText("Search Music");
    }
    public final void change(JPanel pane){
        Main.removeAll();
        Main.repaint();
        Main.revalidate();
        Main.add(pane);
        Main.repaint();
    }
    public final void lists(){
        //Creating a File object for directory
        path = "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\song";
        directoryPath = new File(path);
        //List of all files and directories
        contents = directoryPath.list();
        if (contents == null){ 
        }
        else {
            songs.setListData(contents);
            songs.setVisibleRowCount(contents.length - 1);
        }           
    }
    public final void time(){
        t = new Timer(1000, (ActionEvent e) -> {
            ac++;
            if (ac==10){
                count = 0;
                ac = 0;
                fun = 0;
                t.stop();
                //songs.setSelectedIndex(cus);
            }
        });
        t.setInitialDelay(0);
        t.start();
    }
    public final void times(){
        ts = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                co++;
                tims++;
                if (co==1){
                    co=0;
                    curr = sound.getMicrosecondPosition();
                    if (length == curr){
                        tims = 0;
                        if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\shuffle.png")){
                            if (songn != null){
                                song = songn;
                                runplays();
                            }
                            else {
                                shuffle();
                            }

                        }
                        else if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop song.png")){
                            if (songn != null){
                                song = songn;
                                runplays();
                            }
                            else {
                                song =songs.getSelectedValue();
                                runplays();
                            }
                        }
                        else if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop all.png")){
                            if (songn != null){
                                song = songn;
                                runplays();
                            }
                            else {
                                num = songs.getSelectedIndex();
                                int last = contents.length - 1;
                                if (num == last){
                                    num = 0;
                                    songs.setSelectedIndex(num);
                                    runplays();
                                }
                                else{
                                    num = songs.getSelectedIndex() + 1;
                                    songs.setSelectedIndex(num);
                                    runplays();
                                }
                            }
                        }
                    }
                }

                leng.setMaximum((int) length);
                leng.setValue((int) curr);
                lengs.setMaximum((int) length);
                lengs.setValue((int) curr);
                int lengt = (int) length;
                int cur = (int) curr;
                mus.setText(Integer.toString(cur));
                mis.setText(Integer.toString(lengt));
                musc.setText(Integer.toString(cur));
                misc.setText(Integer.toString(lengt));
            }
                });
                ts.setInitialDelay(0);
                ts.start();
    }
    public final void runicons(){
        try {
            icons();
        } catch (IOException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    public final void icons() throws IOException{
        //Home Screen Achievemenbt Button 
        String Exp ="C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\images.png";
        BufferedImage i = null;
        File f = new File(Exp);
        if(f.exists() && !f.isDirectory()) { 
            try {
                i = ImageIO.read(f);
            } 
            catch (IOException e){}
            //Label Name - Gback
            d = i.getScaledInstance(Expand.getWidth(), Expand.getHeight(),i.SCALE_SMOOTH);
            ImageIcon p = new ImageIcon(d);
            Expand.setIcon(p);
        }
        String rew ="C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\back.png";
        BufferedImage im = null;
        File fe = new File(rew);
        if(f.exists() && !fe.isDirectory()) { 
            try {
                im = ImageIO.read(fe);
            } 
            catch (IOException e){}
            //Label Name - Gback
            di = im.getScaledInstance(back.getWidth(), back.getHeight(),im.SCALE_SMOOTH);
            ImageIcon pi = new ImageIcon(di);
            back.setIcon(pi);
            di = im.getScaledInstance(backs.getWidth(), backs.getHeight(),im.SCALE_SMOOTH);
            ImageIcon pis = new ImageIcon(di);
            backs.setIcon(pis);
        }
        pau ="C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\play.png";
        BufferedImage img = null;
        File fr = new File(pau);
        if(fr.exists() && !fr.isDirectory()) { 
            try {
                img = ImageIO.read(fr);
            } 
            catch (IOException e){}
            //Label Name - Gback
            dim = img.getScaledInstance(Pause.getWidth(), Pause.getHeight(),img.SCALE_SMOOTH);
            ImageIcon pic = new ImageIcon(dim);
            Pause.setIcon(pic);
        }
        pau ="C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\play.png";
        BufferedImage w = null;
        File fq = new File(pau);
        if(fq.exists() && !fq.isDirectory()) { 
            try {
                w = ImageIO.read(fq);
            } 
            catch (IOException e){}
            //Label Name - Gback
            m = w.getScaledInstance(pause2.getWidth(), pause2.getHeight(),w.SCALE_SMOOTH);
            ImageIcon pic = new ImageIcon(m);
            pause2.setIcon(pic);
        }
        String fast ="C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\fast.png";
        BufferedImage imge = null;
        File fw = new File(fast);
        if(fw.exists() && !fw.isDirectory()) { 
            try {
                img = ImageIO.read(fw);
            } 
            catch (IOException e){}
            //Label Name - Gback
            dimg = img.getScaledInstance(Forward.getWidth(), Forward.getHeight(),img.SCALE_SMOOTH);
            ImageIcon pic = new ImageIcon(dimg);
            Forward.setIcon(pic);
            dimg = img.getScaledInstance(fasts.getWidth(), fasts.getHeight(),img.SCALE_SMOOTH);
            ImageIcon pics = new ImageIcon(dimg);
            fasts.setIcon(pics);
        }
        String suf = "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\shuffle.png";
        BufferedImage imges = null;
        File fws = new File(suf);
        if(fws.exists() && !fws.isDirectory()) { 
            try {
                imges = ImageIO.read(fws);
            } 
            catch (IOException e){}
            //Label Name - Gback
            dimgs = imges.getScaledInstance(shuf.getWidth(), shuf.getHeight(),imges.SCALE_SMOOTH);
            ImageIcon pics = new ImageIcon(dimgs);
            shuf.setIcon(pics);
            dimgs = imges.getScaledInstance(shuff.getWidth(), shuff.getHeight(),imges.SCALE_SMOOTH);
            ImageIcon picer = new ImageIcon(dimgs);
            shuff.setIcon(picer);
        }
        sufe = "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop all.png";
        BufferedImage imgese = null;
        File fwse = new File(sufe);
        if(fwse.exists() && !fwse.isDirectory()) { 
            try {
                imgese = ImageIO.read(fwse);
            } 
            catch (IOException e){}
            //Label Name - Gback
            dimgse = imgese.getScaledInstance(lopps.getWidth(), lopps.getHeight(),imgese.SCALE_SMOOTH);
            ImageIcon pics = new ImageIcon(dimgse);
            lopps.setIcon(pics);
            dimgse = imgese.getScaledInstance(loops.getWidth(), loops.getHeight(),imgese.SCALE_SMOOTH);
            ImageIcon pic = new ImageIcon(dimgse);
            loops.setIcon(pic);
        }
        String sufes = "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\scan.jpg";
        BufferedImage ii = null;
        File ff = new File(sufes);
        if(ff.exists() && !ff.isDirectory()) { 
            try {
                ii = ImageIO.read(ff);
            } 
            catch (IOException e){}
            //Label Name - Gback
            dimgses = ii.getScaledInstance(scan.getWidth(), scan.getHeight(),ii.SCALE_SMOOTH);
            ImageIcon pics = new ImageIcon(dimgses);
            scan.setIcon(pics);
        }
        String su = "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\mini.png";
        BufferedImage iy = null;
        File fy = new File(su);
        if(fy.exists() && !fy.isDirectory()) { 
            try {
                iy = ImageIO.read(fy);
            } 
            catch (IOException e){}
            //Label Name - Gback
            din = iy.getScaledInstance(mins.getWidth(), mins.getHeight(),iy.SCALE_SMOOTH);
            ImageIcon pics = new ImageIcon(din);
            mins.setIcon(pics);
        }
        String sud = "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\normmal.png";
        BufferedImage iyd = null;
        File fyd = new File(sud);
        if(fyd.exists() && !fyd.isDirectory()) { 
            try {
                iyd = ImageIO.read(fyd);
            } 
            catch (IOException e){}
            //Label Name - Gback
            ding = iyd.getScaledInstance(playes.getWidth(), playes.getHeight(),iyd.SCALE_SMOOTH);
            ImageIcon pics = new ImageIcon(ding);
            playes.setIcon(pics);
        }
        String suds= "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\stop.png";
        BufferedImage iyds = null;
        File fyds = new File(suds);
        if(fyds.exists() && !fyds.isDirectory()) { 
            try {
                iyds = ImageIO.read(fyds);
            } 
            catch (IOException e){}
            //Label Name - Gback
            dis = iyds.getScaledInstance(stop.getWidth(), stop.getHeight(),iyds.SCALE_SMOOTH);
            ImageIcon pics = new ImageIcon(dis);
            stop.setIcon(pics);
            dis = iyds.getScaledInstance(stops.getWidth(), stops.getHeight(),iyds.SCALE_SMOOTH);
            ImageIcon picss = new ImageIcon(dis);
            stops.setIcon(picss);
        }
    }
    public final void runplay(){
        play();
    }
    public final void playing(){
        pau =  "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\pause.png";
        BufferedImage img = null;
        File fr = new File(pau);
        if(fr.exists() && !fr.isDirectory()) { 
            try {
                img = ImageIO.read(fr);
            }
            catch (IOException e){}
            //Label Name - Gback
            dim = img.getScaledInstance(Pause.getWidth(), Pause.getHeight(),img.SCALE_SMOOTH);
            ImageIcon pic = new ImageIcon(dim);
            Pause.setIcon(pic);
            dim = img.getScaledInstance(pause2.getWidth(), pause2.getHeight(),img.SCALE_SMOOTH);
            ImageIcon pisc = new ImageIcon(dim);
            pause2.setIcon(pisc);
        }
    }
    public final void nplaying(){
        pau =  "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\play.png";
        BufferedImage img = null;
        File fr = new File(pau);
        if(fr.exists() && !fr.isDirectory()) { 
            try {
                img = ImageIO.read(fr);
            }
            catch (IOException e){}
            //Label Name - Gback
            dim = img.getScaledInstance(Pause.getWidth(), Pause.getHeight(),img.SCALE_SMOOTH);
            ImageIcon pic = new ImageIcon(dim);
            Pause.setIcon(pic);
        }
    }
    public final void play(){
        if ("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\play.png".equals(pau)){
            pau =  "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\pause.png";
            BufferedImage img = null;
            File fr = new File(pau);
            if(fr.exists() && !fr.isDirectory()) { 
                try {
                    img = ImageIO.read(fr);
                }
                catch (IOException e){}
                //Label Name - Gback
                dim = img.getScaledInstance(Pause.getWidth(), Pause.getHeight(),img.SCALE_SMOOTH);
                ImageIcon pic = new ImageIcon(dim);
                Pause.setIcon(pic);
            }
            pau ="C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\pause.png";
            BufferedImage w = null;
            File fq = new File(pau);
            if(fq.exists() && !fq.isDirectory()) { 
                try {
                    w = ImageIO.read(fq);
                } 
                catch (IOException e){}
                //Label Name - Gback
                m = w.getScaledInstance(pause2.getWidth(), pause2.getHeight(),w.SCALE_SMOOTH);
                ImageIcon pic = new ImageIcon(m);
                pause2.setIcon(pic);
            }
        }
        else if ("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\pause.png".equals(pau)){
            pau =  "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\play.png";
            BufferedImage img = null;
            File fr = new File(pau);
            if(fr.exists() && !fr.isDirectory()) { 
                try {
                    img = ImageIO.read(fr);
                } 
                catch (IOException e){}
                //Label Name - Gback
                dim = img.getScaledInstance(Pause.getWidth(), Pause.getHeight(),img.SCALE_SMOOTH);
                ImageIcon pic = new ImageIcon(dim);
                Pause.setIcon(pic);
            }
            pau =  "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\play.png";
            BufferedImage imgw = null;
            File fw = new File(pau);
            if(fw.exists() && !fw.isDirectory()) { 
                try {
                    imgw = ImageIO.read(fw);
                } 
                catch (IOException e){}
                //Label Name - Gback
                m = img.getScaledInstance(pause2.getWidth(), pause2.getHeight(),imgw.SCALE_SMOOTH);
                ImageIcon pic = new ImageIcon(m);
                pause2.setIcon(pic);
            }
        }
     }
    public final void pp(){
        if ("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\play.png".equals(pau)){
            if (song1 == null){
                if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\shuffle.png")){
                    shuffle();
                    play();
                }
                else if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop song.png")){
                    songs.setSelectedIndex(0);
                    runplays();
                    play();
                }
                else if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop all.png")){
                    songs.setSelectedIndex(0);
                    runplays();
                    play();
                }
            }
            else if(song1 != null){
                runplays();
                play();
            }
            
        }
        else if ("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\pause.png".equals(pau)){
            pause();
            play();
        }
    }
    public final void runplays(){
        try {
            plays();
        } catch (IOException | UnsupportedAudioFileException  ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public final void plays() throws FileNotFoundException, IOException, UnsupportedAudioFileException{
        // Open an input stream  to the audio file.
        song = songs.getSelectedValue();
        son = path + "\\"+ song;
        try {
            sound = AudioSystem.getClip();
            sound.open(AudioSystem.getAudioInputStream(new File(son)));
            cus = songs.getSelectedIndex();
            String[] parts = song.split(".wav");
            String part1 = parts[0]; // 004
            if (part1.contains("ft.")){
                String[] part = part1.split(" - ");
                String h[] = part[1].split(" ft. ");
                Mname.setText(h[0]);
                Mart.setText(part[0] + "," + h[1]);
                Name.setText(h[0]);
                Art.setText(part[0] + "," + h[1]);
            }
            else{
                String[] part = part1.split(" - ");
                Name.setText(part[1]);
                Art.setText(part[0]);
                Mname.setText(part[1]);
                Mart.setText(part[0]);
            }
            if (song1 == null){
                sound.start();
            }
            else if (song1.equals(son)){
                sound.setMicrosecondPosition(clipTime);
                sound.start();
            }
            else{
                sound.start();
            }
            length = sound.getMicrosecondLength();
            times();
            

        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Whatever" + e);
        }
    }
    public final void pause(){
        clipTime = sound.getMicrosecondPosition();
        sound.stop();
        song1 = "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\song\\" + song;
        
    }
    public final void clicksong(){
        if (this.sound == null){
            song = songs.getSelectedValue();
            runplays();
        }
        else{
            sound.stop();
            song = songs.getSelectedValue();
            runplays();
        }
        pau =  "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\pause.png";
        BufferedImage img = null;
        File fr = new File(pau);
        if(fr.exists() && !fr.isDirectory()) { 
            try {
                img = ImageIO.read(fr);
            }
            catch (IOException e){}
            //Label Name - Gback
            dim = img.getScaledInstance(Pause.getWidth(), Pause.getHeight(),img.SCALE_SMOOTH);
            ImageIcon pic = new ImageIcon(dim);
            Pause.setIcon(pic);
        } 
        
    }
    public final void shuffle(){
        Random r = new Random();
        int o = r.nextInt(contents.length);
        if (song == null){
            songs.setSelectedIndex(o);
            song =songs.getSelectedValue();
            runplays();
        }
        else{
            int y = songs.getSelectedIndex();
            if (o == y){
                o = r.nextInt(contents.length); 
                sound.stop();
                songs.setSelectedIndex(o);
                song =songs.getSelectedValue();
                runplays();
            }
            else{
                sound.stop();
                songs.setSelectedIndex(o);
                song =songs.getSelectedValue();
                runplays();
            }
        }
          
    }
    public final void shuffledo(){
        shuffle(); 
        sufe = "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\shuffle.png";
        BufferedImage imgese = null;
        File fwse = new File(sufe);
        if(fwse.exists() && !fwse.isDirectory()) { 
            try {
                imgese = ImageIO.read(fwse);
            } 
            catch (IOException e){}
            //Label Name - Gback
            dimgse = imgese.getScaledInstance(lopps.getWidth(), lopps.getHeight(),imgese.SCALE_SMOOTH);
            ImageIcon pics = new ImageIcon(dimgse);
            lopps.setIcon(pics);
            dimgse = imgese.getScaledInstance(loops.getWidth(), loops.getHeight(),imgese.SCALE_SMOOTH);
            ImageIcon picso = new ImageIcon(dimgse);
            loops.setIcon(picso);
            
        }
        playing();
    }
    public final void mix(){
        if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\shuffle.png")){
            sufe = "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop song.png";
            BufferedImage imgese = null;
            File fwse = new File(sufe);
            if(fwse.exists() && !fwse.isDirectory()) { 
                try {
                    imgese = ImageIO.read(fwse);
                } 
                catch (IOException e){}
                //Label Name - Gback
                dimgse = imgese.getScaledInstance(lopps.getWidth(), lopps.getHeight(),imgese.SCALE_SMOOTH);
                ImageIcon pics = new ImageIcon(dimgse);
                lopps.setIcon(pics);
                dimgse = imgese.getScaledInstance(loops.getWidth(), loops.getHeight(),imgese.SCALE_SMOOTH);
                ImageIcon pic = new ImageIcon(dimgse);
                loops.setIcon(pic);
            }
        }
        else if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop song.png")){
            sufe = "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop all.png";
            BufferedImage imgese = null;
            File fwse = new File(sufe);
            if(fwse.exists() && !fwse.isDirectory()) { 
                try {
                    imgese = ImageIO.read(fwse);
                } 
                catch (IOException e){}
                //Label Name - Gback
                dimgse = imgese.getScaledInstance(lopps.getWidth(), lopps.getHeight(),imgese.SCALE_SMOOTH);
                ImageIcon pics = new ImageIcon(dimgse);
                lopps.setIcon(pics);
                dimgse = imgese.getScaledInstance(loops.getWidth(), loops.getHeight(),imgese.SCALE_SMOOTH);
                ImageIcon pic = new ImageIcon(dimgse);
                loops.setIcon(pic);
            }
        }
        else if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop all.png")){
            sufe = "C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\shuffle.png";
            BufferedImage imgese = null;
            File fwse = new File(sufe);
            if(fwse.exists() && !fwse.isDirectory()) { 
                try {
                    imgese = ImageIO.read(fwse);
                } 
                catch (IOException e){}
                //Label Name - Gback
                dimgse = imgese.getScaledInstance(lopps.getWidth(), lopps.getHeight(),imgese.SCALE_SMOOTH);
                ImageIcon pics = new ImageIcon(dimgse);
                lopps.setIcon(pics);
                dimgse = imgese.getScaledInstance(loops.getWidth(), loops.getHeight(),imgese.SCALE_SMOOTH);
                ImageIcon pic = new ImageIcon(dimgse);
                loops.setIcon(pic);
            }
        }
    }
    public final void back(){
        if (this.sound == null){
            num = contents.length - 1;
            songs.setSelectedIndex(num);
            clicksong();
        }
        else{
            num = songs.getSelectedIndex();
            count++;
            time();
            if (count == 2){
                if (num == 0){
                    num = contents.length - 1;
                    songs.setSelectedIndex(num);
                    clicksong();
                }
                else{
                    count = 0;
                    num = songs.getSelectedIndex() - 1;
                    songs.setSelectedIndex(num);
                    clicksong();
                }

            }
            else{
                sound.stop();
                sound.setMicrosecondPosition(0);
                sound.start();
            }
        }
        
    }
    public final void forward(){
        if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\shuffle.png")){
            shuffle();
        }
        else if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop song.png")){
            num = songs.getSelectedIndex();
            int last = contents.length - 1;
            if (num == last){
                num = 0;
                songs.setSelectedIndex(num);
                clicksong();
            }
            else{
                num = songs.getSelectedIndex() + 1;
                songs.setSelectedIndex(num);
                clicksong();
            }
        }
        else if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop all.png")){
            num = songs.getSelectedIndex();
            int last = contents.length - 1;
            if (num == last){
                num = 0;
                songs.setSelectedIndex(num);
                clicksong();
            }
            else{
                num = songs.getSelectedIndex() + 1;
                songs.setSelectedIndex(num);
                clicksong();
            }
        }
    }
    public final void select(){
        fun++;
        if (fun == 1){
            if (song == null){
                clicksong();
                songn = null;
                fun = 0;
                this.requestFocusInWindow();
            }
            else{
                songn = songs.getSelectedValue();
                time();
                this.requestFocusInWindow();
            }
        }
        else if (fun == 2){
            clicksong();
            songn = null;
            fun = 0;
            this.requestFocusInWindow();
        }
    }
    public final void addfold(){
         String[] options = new String[] {"Type File","Use File Picker","Close"};
        int response = JOptionPane.showOptionDialog(null, "Folder", "Chosse file picking method",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, options[0]);
        if (response == 1){
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: "
                        + chooser.getSelectedFile().getName());
                File file = chooser.getSelectedFile();
                path = file.toString();
                //Creating a File object for directory
                directoryPath = new File(path);
                //List of all files and directories
                contents = directoryPath.list();
                songs.setListData(contents);
            }
        }
        else if(response == 0){
            path = JOptionPane.showInputDialog(null,"Enter File Here","Copy and Past file URL", JOptionPane.INFORMATION_MESSAGE);
            path = path.replace("/", "//");
            //Creating a File object for directory
            directoryPath = new File(path);
            //List of all files and directories
            contents = directoryPath.list();
            songs.setListData(contents);
        }
        else{
            
        }
        
    }
    public final void filepick(){
        if (songs.getSelectedIndex() == -1){
             addfold();
        }
        else{
            select();
        }
    }
    public final void resize(){
        if ("mini".equals(panes)){
            this.setSize(418,191);
            this.setAlwaysOnTop(true);
            // Without this, the window is draggable from any non transparent
            // point, including points  inside textboxes.
            this.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
        }
        else if("play".equals(panes)){ 
            this.setSize(892, 643);
            this.setAlwaysOnTop(false);
            // Without this, the window is draggable from any non transparent
            // point, including points  inside textboxes.
            this.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", true);
        }
        
    }
    public final void defualtview(){
        panes = "play";
        change(players);
        resize();
    }
    public final void miniview(){
        panes = "mini";
        change(mini);
        resize();
    }
    public final void stop(){
        sound.stop();
        nplaying();
        int yum = songs.getSelectedIndex();
        if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\shuffle.png")){
            Random r = new Random();
            int o = r.nextInt(contents.length);
            songs.setSelectedIndex(o);
            song1 = songs.getSelectedValue();
            
        }
        else if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop song.png")){
            songs.setSelectedIndex(yum);
            song1 = songs.getSelectedValue();
            
        }
        else if (sufe.equals("C:\\Users\\Deowin J Rhode\\Documents\\NetBeansProjects\\Music\\src\\music\\loop all.png")){
            songs.setSelectedIndex(yum);
            song1 = songs.getSelectedValue();
        }
    }
    

        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        players = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Pause = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Forward = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        leng = new javax.swing.JProgressBar();
        Name = new javax.swing.JLabel();
        Art = new javax.swing.JLabel();
        mus = new javax.swing.JLabel();
        mis = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lopps = new javax.swing.JLabel();
        ghh = new javax.swing.JPanel();
        mins = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        stop = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        Expand = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        shuf = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        scan = new javax.swing.JLabel();
        expand = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        songs = new javax.swing.JList<>();
        mini = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Mname = new javax.swing.JLabel();
        Mart = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pause2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        shuff = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        fasts = new javax.swing.JLabel();
        qwerty = new javax.swing.JPanel();
        backs = new javax.swing.JLabel();
        qwsedfrtgh = new javax.swing.JPanel();
        loops = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        playes = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        stops = new javax.swing.JLabel();
        musc = new javax.swing.JLabel();
        misc = new javax.swing.JLabel();
        lengs = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Main.setLayout(new java.awt.CardLayout());

        players.setBackground(new java.awt.Color(0, 0, 204));
        players.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Pause.setToolTipText("");
        Pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PauseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pause, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Forward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ForwardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Forward, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Forward, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        leng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lengMouseClicked(evt);
            }
        });

        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setText("Name");

        Art.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Art.setText("Artist");

        mus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mus.setText("0");

        mis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mis.setText("0");

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lopps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loppsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lopps, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lopps, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        ghh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ghhLayout = new javax.swing.GroupLayout(ghh);
        ghh.setLayout(ghhLayout);
        ghhLayout.setHorizontalGroup(
            ghhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mins, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );
        ghhLayout.setVerticalGroup(
            ghhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stop, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stop, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(mus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(leng, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mis, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Name, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(Art, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(ghh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Art, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ghh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mis)
                    .addComponent(leng, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(mus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        Expand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/music/images.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(418, 418, 418)
                .addComponent(Expand, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(Expand, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        search.setText("Search");
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        shuf.setText("jLabel2");
        shuf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shufMouseClicked(evt);
            }
        });

        scan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        songs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                songsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(songs);

        javax.swing.GroupLayout expandLayout = new javax.swing.GroupLayout(expand);
        expand.setLayout(expandLayout);
        expandLayout.setHorizontalGroup(
            expandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        expandLayout.setVerticalGroup(
            expandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout playersLayout = new javax.swing.GroupLayout(players);
        players.setLayout(playersLayout);
        playersLayout.setHorizontalGroup(
            playersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(playersLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(shuf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(expand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        playersLayout.setVerticalGroup(
            playersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playersLayout.createSequentialGroup()
                .addGroup(playersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(shuf, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(expand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Main.add(players, "card2");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Mname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mname.setText("Name");
        Mname.setToolTipText("edrfgh");

        Mart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mart.setText("Artist");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pause2.setToolTipText("");
        pause2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pause2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pause2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pause2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        shuff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shuffMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(shuff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shuff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel13.setBorder(new javax.swing.border.MatteBorder(null));

        fasts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fastsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fasts, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fasts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        qwerty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        backs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout qwertyLayout = new javax.swing.GroupLayout(qwerty);
        qwerty.setLayout(qwertyLayout);
        qwertyLayout.setHorizontalGroup(
            qwertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backs, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );
        qwertyLayout.setVerticalGroup(
            qwertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backs, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        qwsedfrtgh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        qwsedfrtgh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qwsedfrtghMouseClicked(evt);
            }
        });

        loops.setToolTipText("");
        loops.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loopsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout qwsedfrtghLayout = new javax.swing.GroupLayout(qwsedfrtgh);
        qwsedfrtgh.setLayout(qwsedfrtghLayout);
        qwsedfrtghLayout.setHorizontalGroup(
            qwsedfrtghLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loops, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        qwsedfrtghLayout.setVerticalGroup(
            qwsedfrtghLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loops, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        playes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(playes, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel11.setBorder(new javax.swing.border.MatteBorder(null));

        stops.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stops, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stops, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        musc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musc.setText("0");
        musc.setToolTipText("");

        misc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        misc.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(qwsedfrtgh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(musc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(qwerty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(misc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lengs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(Mart, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Mname, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Mname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(Mart, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qwsedfrtgh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qwerty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(musc, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(misc))))
                .addComponent(lengs, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout miniLayout = new javax.swing.GroupLayout(mini);
        mini.setLayout(miniLayout);
        miniLayout.setHorizontalGroup(
            miniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miniLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(475, Short.MAX_VALUE))
        );
        miniLayout.setVerticalGroup(
            miniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miniLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(455, Short.MAX_VALUE))
        );

        Main.add(mini, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here
        songs.setListData(contents);     
        songs.setSelectedIndex(num);
    }//GEN-LAST:event_searchActionPerformed

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
        search.setText("");
        num = songs.getSelectedIndex();
        
    }//GEN-LAST:event_searchMouseClicked

    private void PauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PauseMouseClicked
        // TODO add your handling code here:
        pp();
    }//GEN-LAST:event_PauseMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        back();
    }//GEN-LAST:event_backMouseClicked

    private void loppsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loppsMouseClicked
        // TODO add your handling code here:
        mix();
    }//GEN-LAST:event_loppsMouseClicked

    private void shufMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shufMouseClicked
        // TODO add your handling code here:
        shuffledo();
    }//GEN-LAST:event_shufMouseClicked

    private void scanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scanMouseClicked
        // TODO add your handling code here:
        lists();
    }//GEN-LAST:event_scanMouseClicked

    private void songsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_songsMouseClicked
        // TODO add your handling code here:
        //select() ; 
        filepick();
    }//GEN-LAST:event_songsMouseClicked

    private void ForwardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForwardMouseClicked
        // TODO add your handling code here:
        forward();
    }//GEN-LAST:event_ForwardMouseClicked

    private void pause2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pause2MouseClicked
        // TODO add your handling code here:
        pp();
    }//GEN-LAST:event_pause2MouseClicked

    private void shuffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shuffMouseClicked
        // TODO add your handling code here:
        shuffledo();
    }//GEN-LAST:event_shuffMouseClicked

    private void qwsedfrtghMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qwsedfrtghMouseClicked
        // TODO add your handling code here:
        mix();
    }//GEN-LAST:event_qwsedfrtghMouseClicked

    private void fastsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fastsMouseClicked
        // TODO add your handling code here:
        forward();
    }//GEN-LAST:event_fastsMouseClicked

    private void backsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backsMouseClicked
        // TODO add your handling code here:
        back();
    }//GEN-LAST:event_backsMouseClicked

    private void playesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playesMouseClicked
        // TODO add your handling code here:
        defualtview();
    }//GEN-LAST:event_playesMouseClicked

    private void loopsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loopsMouseClicked
        // TODO add your handling code here:
        mix();
    }//GEN-LAST:event_loopsMouseClicked

    private void stopsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopsMouseClicked
        // TODO add your handling code here:
        stop();
    }//GEN-LAST:event_stopsMouseClicked

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
        // TODO add your handling code here:
        stop();
    }//GEN-LAST:event_stopMouseClicked

    private void lengMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lengMouseClicked
        // TODO add your handling code here:
//        int nums = leng.getValue();
//        jLabel1.setText(Integer.toString(nums));
    }//GEN-LAST:event_lengMouseClicked

    private void minsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minsMouseClicked
        // TODO add your handling code here:
        miniview();
    }//GEN-LAST:event_minsMouseClicked

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_searchKeyPressed

     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusicPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Art;
    private javax.swing.JLabel Expand;
    private javax.swing.JLabel Forward;
    private javax.swing.JPanel Main;
    private javax.swing.JLabel Mart;
    private javax.swing.JLabel Mname;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Pause;
    private javax.swing.JLabel back;
    private javax.swing.JLabel backs;
    private javax.swing.JPanel expand;
    private javax.swing.JLabel fasts;
    private javax.swing.JPanel ghh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar leng;
    private javax.swing.JProgressBar lengs;
    private javax.swing.JLabel loops;
    private javax.swing.JLabel lopps;
    private javax.swing.JPanel mini;
    private javax.swing.JLabel mins;
    private javax.swing.JLabel mis;
    private javax.swing.JLabel misc;
    private javax.swing.JLabel mus;
    private javax.swing.JLabel musc;
    private javax.swing.JLabel pause2;
    private javax.swing.JPanel players;
    private javax.swing.JLabel playes;
    private javax.swing.JPanel qwerty;
    private javax.swing.JPanel qwsedfrtgh;
    private javax.swing.JLabel scan;
    private javax.swing.JTextField search;
    private javax.swing.JLabel shuf;
    private javax.swing.JLabel shuff;
    private javax.swing.JList<String> songs;
    private javax.swing.JLabel stop;
    private javax.swing.JLabel stops;
    // End of variables declaration//GEN-END:variables
}
